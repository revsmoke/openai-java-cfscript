package com.openai.api.client

import com.openai.api.core.ClientOptions
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.models.*
import com.openai.api.services.async.*
import com.openai.api.services.errorHandler

class OpenAiClientAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : OpenAiClientAsync {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val sync: OpenAiClient by lazy { OpenAiClientImpl(clientOptions) }

    private val completions: CompletionServiceAsync by lazy {
        CompletionServiceAsyncImpl(clientOptions)
    }

    private val chat: ChatServiceAsync by lazy { ChatServiceAsyncImpl(clientOptions) }

    private val edits: EditServiceAsync by lazy { EditServiceAsyncImpl(clientOptions) }

    private val embeddings: EmbeddingServiceAsync by lazy {
        EmbeddingServiceAsyncImpl(clientOptions)
    }

    private val files: FileServiceAsync by lazy { FileServiceAsyncImpl(clientOptions) }

    private val images: ImageServiceAsync by lazy { ImageServiceAsyncImpl(clientOptions) }

    private val audio: AudioServiceAsync by lazy { AudioServiceAsyncImpl(clientOptions) }

    private val answers: AnswerServiceAsync by lazy { AnswerServiceAsyncImpl(clientOptions) }

    private val classifications: ClassificationServiceAsync by lazy {
        ClassificationServiceAsyncImpl(clientOptions)
    }

    private val moderations: ModerationServiceAsync by lazy {
        ModerationServiceAsyncImpl(clientOptions)
    }

    private val models: ModelServiceAsync by lazy { ModelServiceAsyncImpl(clientOptions) }

    private val fineTunes: FineTuneServiceAsync by lazy { FineTuneServiceAsyncImpl(clientOptions) }

    override fun sync(): OpenAiClient = sync

    override fun completions(): CompletionServiceAsync = completions

    override fun chat(): ChatServiceAsync = chat

    override fun edits(): EditServiceAsync = edits

    override fun embeddings(): EmbeddingServiceAsync = embeddings

    override fun files(): FileServiceAsync = files

    override fun images(): ImageServiceAsync = images

    override fun audio(): AudioServiceAsync = audio

    override fun answers(): AnswerServiceAsync = answers

    override fun classifications(): ClassificationServiceAsync = classifications

    override fun moderations(): ModerationServiceAsync = moderations

    override fun models(): ModelServiceAsync = models

    override fun fineTunes(): FineTuneServiceAsync = fineTunes
}
