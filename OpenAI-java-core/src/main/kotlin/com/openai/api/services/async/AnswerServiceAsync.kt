@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.async

import com.openai.api.core.RequestOptions
import com.openai.api.models.AnswerCreateParams
import com.openai.api.models.AnswerCreateResponse
import java.util.concurrent.CompletableFuture

interface AnswerServiceAsync {

    /**
     * Answers the specified question using the provided documents and examples.
     *
     * The endpoint first [searches](/docs/api-reference/searches) over provided documents or files
     * to find relevant context. The relevant context is combined with the provided examples and
     * question to create the prompt for [completion](/docs/api-reference/completions).
     */
    @JvmOverloads
    fun create(
        params: AnswerCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AnswerCreateResponse>
}
