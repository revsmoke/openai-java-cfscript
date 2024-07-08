// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.core.ClientOptions
import com.openai.core.http.HttpResponse.Handler
import com.openai.errors.OpenAIError
import com.openai.models.*
import com.openai.services.async.*
import com.openai.services.errorHandler

class OpenAIClientAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : OpenAIClientAsync {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val sync: OpenAIClient by lazy { OpenAIClientImpl(clientOptions) }

    private val chat: ChatServiceAsync by lazy { ChatServiceAsyncImpl(clientOptions) }

    override fun sync(): OpenAIClient = sync

    override fun chat(): ChatServiceAsync = chat
}
