@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.async

import com.openai.api.services.async.audio.TranscriptionServiceAsync
import com.openai.api.services.async.audio.TranslationServiceAsync

interface AudioServiceAsync {

    fun transcriptions(): TranscriptionServiceAsync

    fun translations(): TranslationServiceAsync
}
