@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.async

import com.openai.api.core.RequestOptions
import com.openai.api.models.FineTune
import com.openai.api.models.FineTuneCancelParams
import com.openai.api.models.FineTuneCreateParams
import com.openai.api.models.FineTuneListEventsParams
import com.openai.api.models.FineTuneListParams
import com.openai.api.models.FineTuneRetrieveParams
import com.openai.api.models.ListFineTuneEventsResponse
import com.openai.api.models.ListFineTunesResponse
import java.util.concurrent.CompletableFuture

interface FineTuneServiceAsync {

    /**
     * Creates a job that fine-tunes a specified model from a given dataset.
     *
     * Response includes details of the enqueued job including job status and the name of the
     * fine-tuned models once complete.
     *
     * [Learn more about Fine-tuning](/docs/guides/fine-tuning)
     */
    @JvmOverloads
    fun create(
        params: FineTuneCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<FineTune>

    /**
     * Gets info about the fine-tune job.
     *
     * [Learn more about Fine-tuning](/docs/guides/fine-tuning)
     */
    @JvmOverloads
    fun retrieve(
        params: FineTuneRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<FineTune>

    /** List your organization's fine-tuning jobs */
    @JvmOverloads
    fun list(
        params: FineTuneListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ListFineTunesResponse>

    /** Immediately cancel a fine-tune job. */
    @JvmOverloads
    fun cancel(
        params: FineTuneCancelParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<FineTune>

    /** Get fine-grained status updates for a fine-tune job. */
    @JvmOverloads
    fun listEvents(
        params: FineTuneListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ListFineTuneEventsResponse>
}
