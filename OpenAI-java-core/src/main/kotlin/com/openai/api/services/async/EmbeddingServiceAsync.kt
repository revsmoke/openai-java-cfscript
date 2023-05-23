@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.async

import com.openai.api.core.RequestOptions
import com.openai.api.models.Embedding
import com.openai.api.models.EmbeddingCreateParams
import java.util.concurrent.CompletableFuture

interface EmbeddingServiceAsync {

    /** Creates an embedding vector representing the input text. */
    @JvmOverloads
    fun create(
        params: EmbeddingCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Embedding>
}
