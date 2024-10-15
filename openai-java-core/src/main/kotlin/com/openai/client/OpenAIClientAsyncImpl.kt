// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.core.ClientOptions
import com.openai.core.errorHandler
import com.openai.core.http.HttpResponse.Handler
import com.openai.errors.OpenAIError
import com.openai.models.*
import com.openai.services.async.*

class OpenAIClientAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : OpenAIClientAsync {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val sync: OpenAIClient by lazy { OpenAIClientImpl(clientOptions) }

    private val chat: ChatServiceAsync by lazy { ChatServiceAsyncImpl(clientOptions) }

    private val files: FileServiceAsync by lazy { FileServiceAsyncImpl(clientOptions) }

    private val models: ModelServiceAsync by lazy { ModelServiceAsyncImpl(clientOptions) }

    private val fineTuning: FineTuningServiceAsync by lazy {
        FineTuningServiceAsyncImpl(clientOptions)
    }

    private val batches: BatchServiceAsync by lazy { BatchServiceAsyncImpl(clientOptions) }

    override fun sync(): OpenAIClient = sync

    override fun chat(): ChatServiceAsync = chat

    override fun files(): FileServiceAsync = files

    override fun models(): ModelServiceAsync = models

    override fun fineTuning(): FineTuningServiceAsync = fineTuning

    override fun batches(): BatchServiceAsync = batches
}
