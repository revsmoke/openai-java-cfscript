// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.models.*
import com.openai.services.blocking.*

interface OpenAIClient {

    fun async(): OpenAIClientAsync

    fun completions(): CompletionService

    fun chat(): ChatService

    fun embeddings(): EmbeddingService

    fun moderations(): ModerationService

    fun models(): ModelService

    fun fineTuning(): FineTuningService

    fun batches(): BatchService
}
