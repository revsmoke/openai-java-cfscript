// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.chat

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.errorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.json
import com.openai.core.jsonHandler
import com.openai.core.withErrorHandler
import com.openai.errors.OpenAIError
import com.openai.models.ChatCompletion
import com.openai.models.ChatCompletionCreateParams
import java.util.concurrent.CompletableFuture

class CompletionServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : CompletionServiceAsync {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<ChatCompletion> =
        jsonHandler<ChatCompletion>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a model response for the given chat conversation. */
    override fun create(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ChatCompletion> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("chat", "completions")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
