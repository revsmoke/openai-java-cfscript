@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.client

import com.openai.api.models.*
import com.openai.api.services.blocking.*

interface OpenAiClient {

    fun async(): OpenAiClientAsync

    fun completions(): CompletionService

    fun chat(): ChatService

    fun edits(): EditService

    fun embeddings(): EmbeddingService

    fun files(): FileService

    fun images(): ImageService

    fun audio(): AudioService

    fun answers(): AnswerService

    fun classifications(): ClassificationService

    fun moderations(): ModerationService

    fun models(): ModelService

    fun fineTunes(): FineTuneService
}
