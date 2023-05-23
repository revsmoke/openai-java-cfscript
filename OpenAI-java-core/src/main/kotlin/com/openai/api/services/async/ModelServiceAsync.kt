@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.async

import com.openai.api.core.RequestOptions
import com.openai.api.models.DeleteModelResponse
import com.openai.api.models.ListModelsResponse
import com.openai.api.models.Model
import com.openai.api.models.ModelDeleteParams
import com.openai.api.models.ModelListParams
import com.openai.api.models.ModelRetrieveParams
import java.util.concurrent.CompletableFuture

interface ModelServiceAsync {

    /**
     * Retrieves a model instance, providing basic information about the model such as the owner and
     * permissioning.
     */
    @JvmOverloads
    fun retrieve(
        params: ModelRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Model>

    /**
     * Lists the currently available models, and provides basic information about each one such as
     * the owner and availability.
     */
    @JvmOverloads
    fun list(
        params: ModelListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ListModelsResponse>

    /** Delete a fine-tuned model. You must have the Owner role in your organization. */
    @JvmOverloads
    fun delete(
        params: ModelDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<DeleteModelResponse>
}
