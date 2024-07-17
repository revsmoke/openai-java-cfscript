// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.http.HttpResponse.Handler
import com.openai.errors.OpenAIError
import com.openai.services.blocking.fineTuning.JobService
import com.openai.services.blocking.fineTuning.JobServiceImpl
import com.openai.services.errorHandler

class FineTuningServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : FineTuningService {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val jobs: JobService by lazy { JobServiceImpl(clientOptions) }

    override fun jobs(): JobService = jobs
}
