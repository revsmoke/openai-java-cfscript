package com.openai.api.services.blocking

import com.openai.api.core.ClientOptions
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.services.blocking.chat.CompletionService
import com.openai.api.services.blocking.chat.CompletionServiceImpl
import com.openai.api.services.errorHandler

class ChatServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : ChatService {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val completions: CompletionService by lazy { CompletionServiceImpl(clientOptions) }

    override fun completions(): CompletionService = completions
}
