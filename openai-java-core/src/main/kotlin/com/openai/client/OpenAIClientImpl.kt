// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.core.ClientOptions
import com.openai.core.http.HttpResponse.Handler
import com.openai.errors.OpenAIError
import com.openai.models.*
import com.openai.services.blocking.*
import com.openai.services.errorHandler

class OpenAIClientImpl
constructor(
    private val clientOptions: ClientOptions,
) : OpenAIClient {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val async: OpenAIClientAsync by lazy { OpenAIClientAsyncImpl(clientOptions) }

    private val chat: ChatService by lazy { ChatServiceImpl(clientOptions) }

    override fun async(): OpenAIClientAsync = async

    override fun chat(): ChatService = chat
}
