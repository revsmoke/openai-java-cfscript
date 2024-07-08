// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.http.HttpResponse.Handler
import com.openai.errors.OpenAIError
import com.openai.services.async.chat.CompletionServiceAsync
import com.openai.services.async.chat.CompletionServiceAsyncImpl
import com.openai.services.errorHandler

class ChatServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ChatServiceAsync {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val completions: CompletionServiceAsync by lazy {
        CompletionServiceAsyncImpl(clientOptions)
    }

    override fun completions(): CompletionServiceAsync = completions
}
