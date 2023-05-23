package com.openai.api.services.async.audio

import com.openai.api.core.ClientOptions
import com.openai.api.core.RequestOptions
import com.openai.api.core.http.HttpMethod
import com.openai.api.core.http.HttpRequest
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.models.AudioTranscriptionCreateParams
import com.openai.api.models.Transcription
import com.openai.api.services.errorHandler
import com.openai.api.services.json
import com.openai.api.services.jsonHandler
import com.openai.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class TranscriptionServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : TranscriptionServiceAsync {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Transcription> =
        jsonHandler<Transcription>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Transcribes audio into the input language. */
    override fun create(
        params: AudioTranscriptionCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Transcription> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("audio", "transcriptions")
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
