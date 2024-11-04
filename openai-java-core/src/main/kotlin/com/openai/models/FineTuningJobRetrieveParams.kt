// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.ListMultimap
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import com.openai.models.*
import java.util.Objects

class FineTuningJobRetrieveParams
constructor(
    private val fineTuningJobId: String,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalQueryParams: Map<String, List<String>>,
) {

    fun fineTuningJobId(): String = fineTuningJobId

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> fineTuningJobId
            else -> ""
        }
    }

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FineTuningJobRetrieveParams && this.fineTuningJobId == other.fineTuningJobId && this.additionalHeaders == other.additionalHeaders && this.additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(fineTuningJobId, additionalHeaders, additionalQueryParams) /* spotless:on */
    }

    override fun toString() =
        "FineTuningJobRetrieveParams{fineTuningJobId=$fineTuningJobId, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var fineTuningJobId: String? = null
        private var additionalHeaders: ListMultimap<String, String> = ArrayListMultimap.create()
        private var additionalQueryParams: ListMultimap<String, String> = ArrayListMultimap.create()

        @JvmSynthetic
        internal fun from(fineTuningJobRetrieveParams: FineTuningJobRetrieveParams) = apply {
            this.fineTuningJobId = fineTuningJobRetrieveParams.fineTuningJobId
            additionalHeaders(fineTuningJobRetrieveParams.additionalHeaders)
            additionalQueryParams(fineTuningJobRetrieveParams.additionalQueryParams)
        }

        fun fineTuningJobId(fineTuningJobId: String) = apply {
            this.fineTuningJobId = fineTuningJobId
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.putAll(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(::putAdditionalHeaders)
        }

        fun removeAdditionalHeader(name: String) = apply { additionalHeaders.removeAll(name) }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.putAll(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                additionalQueryParams.forEach(::putAdditionalQueryParams)
            }

        fun removeAdditionalQueryParam(key: String) = apply { additionalQueryParams.removeAll(key) }

        fun build(): FineTuningJobRetrieveParams =
            FineTuningJobRetrieveParams(
                checkNotNull(fineTuningJobId) { "`fineTuningJobId` is required but was not set" },
                additionalHeaders
                    .asMap()
                    .mapValues { it.value.toList().toImmutable() }
                    .toImmutable(),
                additionalQueryParams
                    .asMap()
                    .mapValues { it.value.toList().toImmutable() }
                    .toImmutable(),
            )
    }
}
