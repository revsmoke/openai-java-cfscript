@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.blocking

import com.openai.api.core.RequestOptions
import com.openai.api.models.Edit
import com.openai.api.models.EditCreateParams

interface EditService {

    /** Creates a new edit for the provided input, instruction, and parameters. */
    @JvmOverloads
    fun create(
        params: EditCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Edit
}
