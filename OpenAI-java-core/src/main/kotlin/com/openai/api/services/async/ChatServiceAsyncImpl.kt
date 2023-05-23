package com.openai.api.services.async

import com.openai.api.core.ClientOptions
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.services.async.chat.CompletionServiceAsync
import com.openai.api.services.async.chat.CompletionServiceAsyncImpl
import com.openai.api.services.errorHandler

class ChatServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ChatServiceAsync {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val completions: CompletionServiceAsync by lazy {
        CompletionServiceAsyncImpl(clientOptions)
    }

    override fun completions(): CompletionServiceAsync = completions
}
