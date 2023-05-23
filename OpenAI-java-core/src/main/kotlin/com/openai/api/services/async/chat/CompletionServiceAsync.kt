@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.async.chat

import com.openai.api.core.RequestOptions
import com.openai.api.models.ChatCompletion
import com.openai.api.models.ChatCompletionCreateParams
import java.util.concurrent.CompletableFuture

interface CompletionServiceAsync {

    /** Creates a completion for the chat message */
    @JvmOverloads
    fun create(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ChatCompletion>
}
