package com.openai.api.client

import com.openai.api.core.ClientOptions
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.models.*
import com.openai.api.services.blocking.*
import com.openai.api.services.errorHandler

class OpenAiClientImpl
constructor(
    private val clientOptions: ClientOptions,
) : OpenAiClient {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val async: OpenAiClientAsync by lazy { OpenAiClientAsyncImpl(clientOptions) }

    private val completions: CompletionService by lazy { CompletionServiceImpl(clientOptions) }

    private val chat: ChatService by lazy { ChatServiceImpl(clientOptions) }

    private val edits: EditService by lazy { EditServiceImpl(clientOptions) }

    private val embeddings: EmbeddingService by lazy { EmbeddingServiceImpl(clientOptions) }

    private val files: FileService by lazy { FileServiceImpl(clientOptions) }

    private val images: ImageService by lazy { ImageServiceImpl(clientOptions) }

    private val audio: AudioService by lazy { AudioServiceImpl(clientOptions) }

    private val answers: AnswerService by lazy { AnswerServiceImpl(clientOptions) }

    private val classifications: ClassificationService by lazy {
        ClassificationServiceImpl(clientOptions)
    }

    private val moderations: ModerationService by lazy { ModerationServiceImpl(clientOptions) }

    private val models: ModelService by lazy { ModelServiceImpl(clientOptions) }

    private val fineTunes: FineTuneService by lazy { FineTuneServiceImpl(clientOptions) }

    override fun async(): OpenAiClientAsync = async

    override fun completions(): CompletionService = completions

    override fun chat(): ChatService = chat

    override fun edits(): EditService = edits

    override fun embeddings(): EmbeddingService = embeddings

    override fun files(): FileService = files

    override fun images(): ImageService = images

    override fun audio(): AudioService = audio

    override fun answers(): AnswerService = answers

    override fun classifications(): ClassificationService = classifications

    override fun moderations(): ModerationService = moderations

    override fun models(): ModelService = models

    override fun fineTunes(): FineTuneService = fineTunes
}
