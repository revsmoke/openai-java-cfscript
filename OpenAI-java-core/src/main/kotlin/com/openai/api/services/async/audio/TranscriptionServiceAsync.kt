@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.async.audio

import com.openai.api.core.RequestOptions
import com.openai.api.models.AudioTranscriptionCreateParams
import com.openai.api.models.Transcription
import java.util.concurrent.CompletableFuture

interface TranscriptionServiceAsync {

    /** Transcribes audio into the input language. */
    @JvmOverloads
    fun create(
        params: AudioTranscriptionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Transcription>
}
