package com.openai.api.services.blocking

import com.openai.api.core.ClientOptions
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.services.blocking.audio.TranscriptionService
import com.openai.api.services.blocking.audio.TranscriptionServiceImpl
import com.openai.api.services.blocking.audio.TranslationService
import com.openai.api.services.blocking.audio.TranslationServiceImpl
import com.openai.api.services.errorHandler

class AudioServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : AudioService {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val transcriptions: TranscriptionService by lazy {
        TranscriptionServiceImpl(clientOptions)
    }

    private val translations: TranslationService by lazy { TranslationServiceImpl(clientOptions) }

    override fun transcriptions(): TranscriptionService = transcriptions

    override fun translations(): TranslationService = translations
}
