@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.async

import com.openai.api.core.RequestOptions
import com.openai.api.models.ModerationCreateParams
import com.openai.api.models.ModerationCreateResponse
import java.util.concurrent.CompletableFuture

interface ModerationServiceAsync {

    /** Classifies if text violates OpenAI's Content Policy */
    @JvmOverloads
    fun create(
        params: ModerationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ModerationCreateResponse>
}
