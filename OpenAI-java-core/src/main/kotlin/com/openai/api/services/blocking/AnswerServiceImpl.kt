package com.openai.api.services.blocking

import com.openai.api.core.ClientOptions
import com.openai.api.core.RequestOptions
import com.openai.api.core.http.HttpMethod
import com.openai.api.core.http.HttpRequest
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.models.AnswerCreateParams
import com.openai.api.models.AnswerCreateResponse
import com.openai.api.services.errorHandler
import com.openai.api.services.json
import com.openai.api.services.jsonHandler
import com.openai.api.services.withErrorHandler

class AnswerServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : AnswerService {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<AnswerCreateResponse> =
        jsonHandler<AnswerCreateResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Answers the specified question using the provided documents and examples.
     *
     * The endpoint first [searches](/docs/api-reference/searches) over provided documents or files
     * to find relevant context. The relevant context is combined with the provided examples and
     * question to create the prompt for [completion](/docs/api-reference/completions).
     */
    override fun create(
        params: AnswerCreateParams,
        requestOptions: RequestOptions
    ): AnswerCreateResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("answers")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
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
