// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async

import com.openai.services.async.fineTuning.JobServiceAsync

interface FineTuningServiceAsync {

    fun jobs(): JobServiceAsync
}
