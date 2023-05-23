@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.async

import com.openai.api.core.RequestOptions
import com.openai.api.models.Completion
import com.openai.api.models.CompletionCreateParams
import java.util.concurrent.CompletableFuture

interface CompletionServiceAsync {

    /** Creates a completion for the provided prompt and parameters */
    @JvmOverloads
    fun create(
        params: CompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Completion>
}
