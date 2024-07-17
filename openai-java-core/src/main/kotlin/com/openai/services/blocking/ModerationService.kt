// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking

import com.openai.core.RequestOptions
import com.openai.models.ModerationCreateParams
import com.openai.models.ModerationCreateResponse

interface ModerationService {

    /** Classifies if text is potentially harmful. */
    @JvmOverloads
    fun create(
        params: ModerationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ModerationCreateResponse
}
