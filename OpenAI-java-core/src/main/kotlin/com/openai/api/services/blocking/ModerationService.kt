@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.blocking

import com.openai.api.core.RequestOptions
import com.openai.api.models.ModerationCreateParams
import com.openai.api.models.ModerationCreateResponse

interface ModerationService {

    /** Classifies if text violates OpenAI's Content Policy */
    @JvmOverloads
    fun create(
        params: ModerationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ModerationCreateResponse
}
