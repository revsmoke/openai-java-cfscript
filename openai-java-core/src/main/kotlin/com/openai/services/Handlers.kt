@file:JvmName("Handlers")

package com.openai.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.http.BinaryResponseContent
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.errors.BadRequestException
import com.openai.errors.InternalServerException
import com.openai.errors.NotFoundException
import com.openai.errors.OpenAIError
import com.openai.errors.OpenAIException
import com.openai.errors.PermissionDeniedException
import com.openai.errors.RateLimitException
import com.openai.errors.UnauthorizedException
import com.openai.errors.UnexpectedStatusCodeException
import com.openai.errors.UnprocessableEntityException
import java.io.InputStream
import java.io.OutputStream
import java.util.Optional

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandler

private object EmptyHandler : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandler

@JvmSynthetic internal fun binaryHandler(): Handler<BinaryResponseContent> = BinaryHandler

private object StringHandler : Handler<String> {
    override fun handle(response: HttpResponse): String {
        return response.body().readBytes().toString(Charsets.UTF_8)
    }
}

private object BinaryHandler : Handler<BinaryResponseContent> {
    override fun handle(response: HttpResponse): BinaryResponseContent {
        return object : BinaryResponseContent {
            override fun contentType(): Optional<String> =
                Optional.ofNullable(response.headers().get("Content-Type").firstOrNull())

            override fun body(): InputStream = response.body()

            override fun close() = response.close()

            override fun writeTo(outputStream: OutputStream) {
                response.body().copyTo(outputStream)
            }
        }
    }
}

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> {
    return object : Handler<T> {
        override fun handle(response: HttpResponse): T {
            try {
                return jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw OpenAIException("Error reading response", e)
            }
        }
    }
}

@JvmSynthetic
internal fun errorHandler(jsonMapper: JsonMapper): Handler<OpenAIError> {
    val handler = jsonHandler<OpenAIError>(jsonMapper)

    return object : Handler<OpenAIError> {
        override fun handle(response: HttpResponse): OpenAIError {
            try {
                return handler.handle(response)
            } catch (e: Exception) {
                return OpenAIError.builder().build()
            }
        }
    }
}

@JvmSynthetic
internal fun <T> Handler<T>.withErrorHandler(errorHandler: Handler<OpenAIError>): Handler<T> {
    return object : Handler<T> {
        override fun handle(response: HttpResponse): T {
            when (val statusCode = response.statusCode()) {
                in 200..299 -> return this@withErrorHandler.handle(response)
                400 -> throw BadRequestException(response.headers(), errorHandler.handle(response))
                401 ->
                    throw UnauthorizedException(response.headers(), errorHandler.handle(response))
                403 ->
                    throw PermissionDeniedException(
                        response.headers(),
                        errorHandler.handle(response)
                    )
                404 -> throw NotFoundException(response.headers(), errorHandler.handle(response))
                422 ->
                    throw UnprocessableEntityException(
                        response.headers(),
                        errorHandler.handle(response)
                    )
                429 -> throw RateLimitException(response.headers(), errorHandler.handle(response))
                in 500..599 ->
                    throw InternalServerException(
                        statusCode,
                        response.headers(),
                        errorHandler.handle(response)
                    )
                else ->
                    throw UnexpectedStatusCodeException(
                        statusCode,
                        response.headers(),
                        StringHandler.handle(response)
                    )
            }
        }
    }
}
