package com.openai.api.services.blocking

import com.openai.api.core.ClientOptions
import com.openai.api.core.RequestOptions
import com.openai.api.core.http.HttpMethod
import com.openai.api.core.http.HttpRequest
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.models.Image
import com.openai.api.models.ImageCreateVariationParams
import com.openai.api.models.ImageEditParams
import com.openai.api.models.ImageGenerateParams
import com.openai.api.services.errorHandler
import com.openai.api.services.json
import com.openai.api.services.jsonHandler
import com.openai.api.services.withErrorHandler

class ImageServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : ImageService {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val createVariationHandler: Handler<Image> =
        jsonHandler<Image>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a variation of a given image. */
    override fun createVariation(
        params: ImageCreateVariationParams,
        requestOptions: RequestOptions
    ): Image {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("images", "variations")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { createVariationHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val editHandler: Handler<Image> =
        jsonHandler<Image>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates an edited or extended image given an original image and a prompt. */
    override fun edit(params: ImageEditParams, requestOptions: RequestOptions): Image {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("images", "edits")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { editHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val generateHandler: Handler<Image> =
        jsonHandler<Image>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates an image given a prompt. */
    override fun generate(params: ImageGenerateParams, requestOptions: RequestOptions): Image {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("images", "generations")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { generateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
