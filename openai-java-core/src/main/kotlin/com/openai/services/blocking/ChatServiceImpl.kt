// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.errorHandler
import com.openai.core.http.HttpResponse.Handler
import com.openai.errors.OpenAIError
import com.openai.services.blocking.chat.CompletionService
import com.openai.services.blocking.chat.CompletionServiceImpl

class ChatServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : ChatService {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val completions: CompletionService by lazy { CompletionServiceImpl(clientOptions) }

    override fun completions(): CompletionService = completions
}
