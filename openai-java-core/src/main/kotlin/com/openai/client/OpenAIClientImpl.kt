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

    private val files: FileService by lazy { FileServiceImpl(clientOptions) }

    private val moderations: ModerationService by lazy { ModerationServiceImpl(clientOptions) }

    private val models: ModelService by lazy { ModelServiceImpl(clientOptions) }

    private val fineTuning: FineTuningService by lazy { FineTuningServiceImpl(clientOptions) }

    private val batches: BatchService by lazy { BatchServiceImpl(clientOptions) }

    override fun async(): OpenAIClientAsync = async

    override fun chat(): ChatService = chat

    override fun files(): FileService = files

    override fun moderations(): ModerationService = moderations

    override fun models(): ModelService = models

    override fun fineTuning(): FineTuningService = fineTuning

    override fun batches(): BatchService = batches
}
