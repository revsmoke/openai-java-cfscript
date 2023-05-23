@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.blocking

import com.openai.api.core.RequestOptions
import com.openai.api.models.ClassificationCreateParams
import com.openai.api.models.ClassificationCreateResponse

interface ClassificationService {

    /**
     * Classifies the specified `query` using provided examples.
     *
     * The endpoint first [searches](/docs/api-reference/searches) over the labeled examples to
     * select the ones most relevant for the particular query. Then, the relevant examples are
     * combined with the query to construct a prompt to produce the final label via the
     * [completions](/docs/api-reference/completions) endpoint.
     *
     * Labeled examples can be provided via an uploaded `file`, or explicitly listed in the request
     * using the `examples` parameter for quick tests and small scale use cases.
     */
    @JvmOverloads
    fun create(
        params: ClassificationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ClassificationCreateResponse
}
