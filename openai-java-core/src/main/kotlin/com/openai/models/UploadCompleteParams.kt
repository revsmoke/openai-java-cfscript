// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
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
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
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

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

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

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UploadCompleteParams && this.uploadId == other.uploadId && this.partIds == other.partIds && this.md5 == other.md5 && this.additionalQueryParams == other.additionalQueryParams && this.additionalHeaders == other.additionalHeaders && this.additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(uploadId, partIds, md5, additionalQueryParams, additionalHeaders, additionalBodyProperties) /* spotless:on */
    }

    override fun toString() =
        "UploadCompleteParams{uploadId=$uploadId, partIds=$partIds, md5=$md5, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var uploadId: String? = null
        private var partIds: MutableList<String> = mutableListOf()
        private var md5: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(uploadCompleteParams: UploadCompleteParams) = apply {
            this.uploadId = uploadCompleteParams.uploadId
            this.partIds(uploadCompleteParams.partIds)
            this.md5 = uploadCompleteParams.md5
            additionalQueryParams(uploadCompleteParams.additionalQueryParams)
            additionalHeaders(uploadCompleteParams.additionalHeaders)
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

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

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
                additionalQueryParams.mapValues { it.value.toImmutable() }.toImmutable(),
                additionalHeaders.mapValues { it.value.toImmutable() }.toImmutable(),
                additionalBodyProperties.toImmutable(),
            )
    }
}
