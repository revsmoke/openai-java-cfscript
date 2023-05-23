package com.openai.api.services.async

import com.openai.api.core.ClientOptions
import com.openai.api.core.RequestOptions
import com.openai.api.core.http.HttpMethod
import com.openai.api.core.http.HttpRequest
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.models.ClassificationCreateParams
import com.openai.api.models.ClassificationCreateResponse
import com.openai.api.services.errorHandler
import com.openai.api.services.json
import com.openai.api.services.jsonHandler
import com.openai.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class ClassificationServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ClassificationServiceAsync {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<ClassificationCreateResponse> =
        jsonHandler<ClassificationCreateResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /**
     * Classifies the specified `query` using provided examples.
     *
     * The endpoint first [searches](/docs/api-reference/searches) over the labeled examples to
     * select the ones most relevant for the particular query. Then, the relevant examples are
     * combined with the query to construct a prompt to produce the final label via the
     * [completions](/docs/api-reference/completions) endpoint.
     *
     * Labeled examples can be provided via an uploaded `file`, or explicitly listed in the request
     * using the `examples` parameter for quick tests and small scale use cases.
     */
    override fun create(
        params: ClassificationCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ClassificationCreateResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("classifications")
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
