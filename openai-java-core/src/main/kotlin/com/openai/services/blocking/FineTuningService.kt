// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.services.blocking.fineTuning.JobService

interface FineTuningService {

    fun jobs(): JobService
}
