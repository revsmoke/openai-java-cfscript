package com.openai.api.services.async

import com.openai.api.core.ClientOptions
import com.openai.api.core.RequestOptions
import com.openai.api.core.http.HttpMethod
import com.openai.api.core.http.HttpRequest
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.models.Embedding
import com.openai.api.models.EmbeddingCreateParams
import com.openai.api.services.errorHandler
import com.openai.api.services.json
import com.openai.api.services.jsonHandler
import com.openai.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class EmbeddingServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : EmbeddingServiceAsync {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Embedding> =
        jsonHandler<Embedding>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates an embedding vector representing the input text. */
    override fun create(
        params: EmbeddingCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Embedding> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("embeddings")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
