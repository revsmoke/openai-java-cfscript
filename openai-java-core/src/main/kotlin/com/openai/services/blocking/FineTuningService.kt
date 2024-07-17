// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking

import com.openai.services.blocking.fineTuning.JobService

interface FineTuningService {

    fun jobs(): JobService
}
