package com.openai.api.services.async

import com.openai.api.core.ClientOptions
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.services.async.audio.TranscriptionServiceAsync
import com.openai.api.services.async.audio.TranscriptionServiceAsyncImpl
import com.openai.api.services.async.audio.TranslationServiceAsync
import com.openai.api.services.async.audio.TranslationServiceAsyncImpl
import com.openai.api.services.errorHandler

class AudioServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : AudioServiceAsync {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val transcriptions: TranscriptionServiceAsync by lazy {
        TranscriptionServiceAsyncImpl(clientOptions)
    }

    private val translations: TranslationServiceAsync by lazy {
        TranslationServiceAsyncImpl(clientOptions)
    }

    override fun transcriptions(): TranscriptionServiceAsync = transcriptions

    override fun translations(): TranslationServiceAsync = translations
}
