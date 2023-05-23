package com.openai.api.services.async

import com.openai.api.core.ClientOptions
import com.openai.api.core.RequestOptions
import com.openai.api.core.http.HttpMethod
import com.openai.api.core.http.HttpRequest
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.models.DeleteModelResponse
import com.openai.api.models.ListModelsResponse
import com.openai.api.models.Model
import com.openai.api.models.ModelDeleteParams
import com.openai.api.models.ModelListParams
import com.openai.api.models.ModelRetrieveParams
import com.openai.api.services.errorHandler
import com.openai.api.services.json
import com.openai.api.services.jsonHandler
import com.openai.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class ModelServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ModelServiceAsync {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Model> =
        jsonHandler<Model>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Retrieves a model instance, providing basic information about the model such as the owner and
     * permissioning.
     */
    override fun retrieve(
        params: ModelRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Model> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("models", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<ListModelsResponse> =
        jsonHandler<ListModelsResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Lists the currently available models, and provides basic information about each one such as
     * the owner and availability.
     */
    override fun list(
        params: ModelListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ListModelsResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("models")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val deleteHandler: Handler<DeleteModelResponse> =
        jsonHandler<DeleteModelResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Delete a fine-tuned model. You must have the Owner role in your organization. */
    override fun delete(
        params: ModelDeleteParams,
        requestOptions: RequestOptions
    ): CompletableFuture<DeleteModelResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("models", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { deleteHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
