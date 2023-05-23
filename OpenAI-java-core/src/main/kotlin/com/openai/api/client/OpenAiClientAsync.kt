@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.client

import com.openai.api.models.*
import com.openai.api.services.async.*

interface OpenAiClientAsync {

    fun sync(): OpenAiClient

    fun completions(): CompletionServiceAsync

    fun chat(): ChatServiceAsync

    fun edits(): EditServiceAsync

    fun embeddings(): EmbeddingServiceAsync

    fun files(): FileServiceAsync

    fun images(): ImageServiceAsync

    fun audio(): AudioServiceAsync

    fun answers(): AnswerServiceAsync

    fun classifications(): ClassificationServiceAsync

    fun moderations(): ModerationServiceAsync

    fun models(): ModelServiceAsync

    fun fineTunes(): FineTuneServiceAsync
}
