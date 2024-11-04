// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.ListMultimap
import com.openai.core.ExcludeMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import com.openai.models.*
import java.util.Objects
import java.util.Optional

class UploadCompleteParams
constructor(
    private val uploadId: String,
    private val partIds: List<String>,
    private val md5: String?,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun uploadId(): String = uploadId

    fun partIds(): List<String> = partIds

    fun md5(): Optional<String> = Optional.ofNullable(md5)

    @JvmSynthetic
    internal fun getBody(): UploadCompleteBody {
        return UploadCompleteBody(
            partIds,
            md5,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> uploadId
            else -> ""
        }
    }

    @JsonDeserialize(builder = UploadCompleteBody.Builder::class)
    @NoAutoDetect
    class UploadCompleteBody
    internal constructor(
        private val partIds: List<String>?,
        private val md5: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        /** The ordered list of Part IDs. */
        @JsonProperty("part_ids") fun partIds(): List<String>? = partIds

        /**
         * The optional md5 checksum for the file contents to verify if the bytes uploaded matches
         * what you expect.
         */
        @JsonProperty("md5") fun md5(): String? = md5

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var partIds: List<String>? = null
            private var md5: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(uploadCompleteBody: UploadCompleteBody) = apply {
                this.partIds = uploadCompleteBody.partIds
                this.md5 = uploadCompleteBody.md5
                additionalProperties(uploadCompleteBody.additionalProperties)
            }

            /** The ordered list of Part IDs. */
            @JsonProperty("part_ids")
            fun partIds(partIds: List<String>) = apply { this.partIds = partIds }

            /**
             * The optional md5 checksum for the file contents to verify if the bytes uploaded
             * matches what you expect.
             */
            @JsonProperty("md5") fun md5(md5: String) = apply { this.md5 = md5 }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): UploadCompleteBody =
                UploadCompleteBody(
                    checkNotNull(partIds) { "`partIds` is required but was not set" }.toImmutable(),
                    md5,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is UploadCompleteBody && this.partIds == other.partIds && this.md5 == other.md5 && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(partIds, md5, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "UploadCompleteBody{partIds=$partIds, md5=$md5, additionalProperties=$additionalProperties}"
    }

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UploadCompleteParams && this.uploadId == other.uploadId && this.partIds == other.partIds && this.md5 == other.md5 && this.additionalHeaders == other.additionalHeaders && this.additionalQueryParams == other.additionalQueryParams && this.additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(uploadId, partIds, md5, additionalHeaders, additionalQueryParams, additionalBodyProperties) /* spotless:on */
    }

    override fun toString() =
        "UploadCompleteParams{uploadId=$uploadId, partIds=$partIds, md5=$md5, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var uploadId: String? = null
        private var partIds: MutableList<String> = mutableListOf()
        private var md5: String? = null
        private var additionalHeaders: ListMultimap<String, String> = ArrayListMultimap.create()
        private var additionalQueryParams: ListMultimap<String, String> = ArrayListMultimap.create()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(uploadCompleteParams: UploadCompleteParams) = apply {
            this.uploadId = uploadCompleteParams.uploadId
            this.partIds(uploadCompleteParams.partIds)
            this.md5 = uploadCompleteParams.md5
            additionalHeaders(uploadCompleteParams.additionalHeaders)
            additionalQueryParams(uploadCompleteParams.additionalQueryParams)
            additionalBodyProperties(uploadCompleteParams.additionalBodyProperties)
        }

        fun uploadId(uploadId: String) = apply { this.uploadId = uploadId }

        /** The ordered list of Part IDs. */
        fun partIds(partIds: List<String>) = apply {
            this.partIds.clear()
            this.partIds.addAll(partIds)
        }

        /** The ordered list of Part IDs. */
        fun addPartId(partId: String) = apply { this.partIds.add(partId) }

        /**
         * The optional md5 checksum for the file contents to verify if the bytes uploaded matches
         * what you expect.
         */
        fun md5(md5: String) = apply { this.md5 = md5 }

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

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): UploadCompleteParams =
            UploadCompleteParams(
                checkNotNull(uploadId) { "`uploadId` is required but was not set" },
                checkNotNull(partIds) { "`partIds` is required but was not set" }.toImmutable(),
                md5,
                additionalHeaders
                    .asMap()
                    .mapValues { it.value.toList().toImmutable() }
                    .toImmutable(),
                additionalQueryParams
                    .asMap()
                    .mapValues { it.value.toList().toImmutable() }
                    .toImmutable(),
                additionalBodyProperties.toImmutable(),
            )
    }
}
