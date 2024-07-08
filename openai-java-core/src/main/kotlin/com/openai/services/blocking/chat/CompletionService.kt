// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking.chat

import com.openai.core.RequestOptions
import com.openai.models.ChatCompletion
import com.openai.models.ChatCompletionCreateParams

interface CompletionService {

    /** Creates a model response for the given chat conversation. */
    @JvmOverloads
    fun create(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ChatCompletion
}
