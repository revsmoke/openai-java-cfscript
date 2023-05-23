package com.openai.api.services.async

import com.openai.api.core.ClientOptions
import com.openai.api.core.RequestOptions
import com.openai.api.core.http.HttpMethod
import com.openai.api.core.http.HttpRequest
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.models.FineTune
import com.openai.api.models.FineTuneCancelParams
import com.openai.api.models.FineTuneCreateParams
import com.openai.api.models.FineTuneListEventsParams
import com.openai.api.models.FineTuneListParams
import com.openai.api.models.FineTuneRetrieveParams
import com.openai.api.models.ListFineTuneEventsResponse
import com.openai.api.models.ListFineTunesResponse
import com.openai.api.services.errorHandler
import com.openai.api.services.json
import com.openai.api.services.jsonHandler
import com.openai.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class FineTuneServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : FineTuneServiceAsync {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<FineTune> =
        jsonHandler<FineTune>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Creates a job that fine-tunes a specified model from a given dataset.
     *
     * Response includes details of the enqueued job including job status and the name of the
     * fine-tuned models once complete.
     *
     * [Learn more about Fine-tuning](/docs/guides/fine-tuning)
     */
    override fun create(
        params: FineTuneCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<FineTune> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("fine-tunes")
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

    private val retrieveHandler: Handler<FineTune> =
        jsonHandler<FineTune>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Gets info about the fine-tune job.
     *
     * [Learn more about Fine-tuning](/docs/guides/fine-tuning)
     */
    override fun retrieve(
        params: FineTuneRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<FineTune> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("fine-tunes", params.getPathParam(0))
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

    private val listHandler: Handler<ListFineTunesResponse> =
        jsonHandler<ListFineTunesResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** List your organization's fine-tuning jobs */
    override fun list(
        params: FineTuneListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ListFineTunesResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("fine-tunes")
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

    private val cancelHandler: Handler<FineTune> =
        jsonHandler<FineTune>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Immediately cancel a fine-tune job. */
    override fun cancel(
        params: FineTuneCancelParams,
        requestOptions: RequestOptions
    ): CompletableFuture<FineTune> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("fine-tunes", params.getPathParam(0), "cancel")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { cancelHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listEventsHandler: Handler<ListFineTuneEventsResponse> =
        jsonHandler<ListFineTuneEventsResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Get fine-grained status updates for a fine-tune job. */
    override fun listEvents(
        params: FineTuneListEventsParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ListFineTuneEventsResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("fine-tunes", params.getPathParam(0), "events")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { listEventsHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
