@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.async.audio

import com.openai.api.core.RequestOptions
import com.openai.api.models.AudioTranslationCreateParams
import com.openai.api.models.Translation
import java.util.concurrent.CompletableFuture

interface TranslationServiceAsync {

    /** Translates audio into into English. */
    @JvmOverloads
    fun create(
        params: AudioTranslationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Translation>
}
