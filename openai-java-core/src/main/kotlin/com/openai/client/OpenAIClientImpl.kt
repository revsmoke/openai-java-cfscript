// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.core.ClientOptions
import com.openai.models.*
import com.openai.services.blocking.*

class OpenAIClientImpl
constructor(
    private val clientOptions: ClientOptions,
) : OpenAIClient {

    private val async: OpenAIClientAsync by lazy { OpenAIClientAsyncImpl(clientOptions) }

    private val completions: CompletionService by lazy { CompletionServiceImpl(clientOptions) }

    private val chat: ChatService by lazy { ChatServiceImpl(clientOptions) }

    private val embeddings: EmbeddingService by lazy { EmbeddingServiceImpl(clientOptions) }

    private val files: FileService by lazy { FileServiceImpl(clientOptions) }

    private val images: ImageService by lazy { ImageServiceImpl(clientOptions) }

    private val moderations: ModerationService by lazy { ModerationServiceImpl(clientOptions) }

    private val models: ModelService by lazy { ModelServiceImpl(clientOptions) }

    private val fineTuning: FineTuningService by lazy { FineTuningServiceImpl(clientOptions) }

    private val batches: BatchService by lazy { BatchServiceImpl(clientOptions) }

    private val uploads: UploadService by lazy { UploadServiceImpl(clientOptions) }

    override fun async(): OpenAIClientAsync = async

    override fun completions(): CompletionService = completions

    override fun chat(): ChatService = chat

    override fun embeddings(): EmbeddingService = embeddings

    override fun files(): FileService = files

    override fun images(): ImageService = images

    override fun moderations(): ModerationService = moderations

    override fun models(): ModelService = models

    override fun fineTuning(): FineTuningService = fineTuning

    override fun batches(): BatchService = batches

    override fun uploads(): UploadService = uploads
}
