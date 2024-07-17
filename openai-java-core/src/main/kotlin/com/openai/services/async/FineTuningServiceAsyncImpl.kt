// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.http.HttpResponse.Handler
import com.openai.errors.OpenAIError
import com.openai.services.async.fineTuning.JobServiceAsync
import com.openai.services.async.fineTuning.JobServiceAsyncImpl
import com.openai.services.errorHandler

class FineTuningServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : FineTuningServiceAsync {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val jobs: JobServiceAsync by lazy { JobServiceAsyncImpl(clientOptions) }

    override fun jobs(): JobServiceAsync = jobs
}
