@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.blocking

import com.openai.api.services.blocking.audio.TranscriptionService
import com.openai.api.services.blocking.audio.TranslationService

interface AudioService {

    fun transcriptions(): TranscriptionService

    fun translations(): TranslationService
}
