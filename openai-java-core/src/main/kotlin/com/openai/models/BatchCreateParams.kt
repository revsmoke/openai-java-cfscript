// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.*
import java.util.Objects
import java.util.Optional

class BatchCreateParams
constructor(
    private val completionWindow: CompletionWindow,
    private val endpoint: Endpoint,
    private val inputFileId: String,
    private val metadata: Metadata?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun completionWindow(): CompletionWindow = completionWindow

    fun endpoint(): Endpoint = endpoint

    fun inputFileId(): String = inputFileId

    fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata)

    @JvmSynthetic
    internal fun getBody(): BatchCreateBody {
        return BatchCreateBody(
            completionWindow,
            endpoint,
            inputFileId,
            metadata,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = BatchCreateBody.Builder::class)
    @NoAutoDetect
    class BatchCreateBody
    internal constructor(
        private val completionWindow: CompletionWindow?,
        private val endpoint: Endpoint?,
        private val inputFileId: String?,
        private val metadata: Metadata?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        /**
         * The time frame within which the batch should be processed. Currently only `24h` is
         * supported.
         */
        @JsonProperty("completion_window")
        fun completionWindow(): CompletionWindow? = completionWindow

        /**
         * The endpoint to be used for all requests in the batch. Currently `/v1/chat/completions`,
         * `/v1/embeddings`, and `/v1/completions` are supported. Note that `/v1/embeddings` batches
         * are also restricted to a maximum of 50,000 embedding inputs across all requests in the
         * batch.
         */
        @JsonProperty("endpoint") fun endpoint(): Endpoint? = endpoint

        /**
         * The ID of an uploaded file that contains requests for the new batch.
         *
         * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for how to
         * upload a file.
         *
         * Your input file must be formatted as a
         * [JSONL file](https://platform.openai.com/docs/api-reference/batch/request-input), and
         * must be uploaded with the purpose `batch`. The file can contain up to 50,000 requests,
         * and can be up to 100 MB in size.
         */
        @JsonProperty("input_file_id") fun inputFileId(): String? = inputFileId

        /** Optional custom metadata for the batch. */
        @JsonProperty("metadata") fun metadata(): Metadata? = metadata

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var completionWindow: CompletionWindow? = null
            private var endpoint: Endpoint? = null
            private var inputFileId: String? = null
            private var metadata: Metadata? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(batchCreateBody: BatchCreateBody) = apply {
                this.completionWindow = batchCreateBody.completionWindow
                this.endpoint = batchCreateBody.endpoint
                this.inputFileId = batchCreateBody.inputFileId
                this.metadata = batchCreateBody.metadata
                additionalProperties(batchCreateBody.additionalProperties)
            }

            /**
             * The time frame within which the batch should be processed. Currently only `24h` is
             * supported.
             */
            @JsonProperty("completion_window")
            fun completionWindow(completionWindow: CompletionWindow) = apply {
                this.completionWindow = completionWindow
            }

            /**
             * The endpoint to be used for all requests in the batch. Currently
             * `/v1/chat/completions`, `/v1/embeddings`, and `/v1/completions` are supported. Note
             * that `/v1/embeddings` batches are also restricted to a maximum of 50,000 embedding
             * inputs across all requests in the batch.
             */
            @JsonProperty("endpoint")
            fun endpoint(endpoint: Endpoint) = apply { this.endpoint = endpoint }

            /**
             * The ID of an uploaded file that contains requests for the new batch.
             *
             * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for
             * how to upload a file.
             *
             * Your input file must be formatted as a
             * [JSONL file](https://platform.openai.com/docs/api-reference/batch/request-input), and
             * must be uploaded with the purpose `batch`. The file can contain up to 50,000
             * requests, and can be up to 100 MB in size.
             */
            @JsonProperty("input_file_id")
            fun inputFileId(inputFileId: String) = apply { this.inputFileId = inputFileId }

            /** Optional custom metadata for the batch. */
            @JsonProperty("metadata")
            fun metadata(metadata: Metadata) = apply { this.metadata = metadata }

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

            fun build(): BatchCreateBody =
                BatchCreateBody(
                    checkNotNull(completionWindow) {
                        "`completionWindow` is required but was not set"
                    },
                    checkNotNull(endpoint) { "`endpoint` is required but was not set" },
                    checkNotNull(inputFileId) { "`inputFileId` is required but was not set" },
                    metadata,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is BatchCreateBody && this.completionWindow == other.completionWindow && this.endpoint == other.endpoint && this.inputFileId == other.inputFileId && this.metadata == other.metadata && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(completionWindow, endpoint, inputFileId, metadata, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "BatchCreateBody{completionWindow=$completionWindow, endpoint=$endpoint, inputFileId=$inputFileId, metadata=$metadata, additionalProperties=$additionalProperties}"
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BatchCreateParams && this.completionWindow == other.completionWindow && this.endpoint == other.endpoint && this.inputFileId == other.inputFileId && this.metadata == other.metadata && this.additionalQueryParams == other.additionalQueryParams && this.additionalHeaders == other.additionalHeaders && this.additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(completionWindow, endpoint, inputFileId, metadata, additionalQueryParams, additionalHeaders, additionalBodyProperties) /* spotless:on */
    }

    override fun toString() =
        "BatchCreateParams{completionWindow=$completionWindow, endpoint=$endpoint, inputFileId=$inputFileId, metadata=$metadata, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var completionWindow: CompletionWindow? = null
        private var endpoint: Endpoint? = null
        private var inputFileId: String? = null
        private var metadata: Metadata? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(batchCreateParams: BatchCreateParams) = apply {
            this.completionWindow = batchCreateParams.completionWindow
            this.endpoint = batchCreateParams.endpoint
            this.inputFileId = batchCreateParams.inputFileId
            this.metadata = batchCreateParams.metadata
            additionalQueryParams(batchCreateParams.additionalQueryParams)
            additionalHeaders(batchCreateParams.additionalHeaders)
            additionalBodyProperties(batchCreateParams.additionalBodyProperties)
        }

        /**
         * The time frame within which the batch should be processed. Currently only `24h` is
         * supported.
         */
        fun completionWindow(completionWindow: CompletionWindow) = apply {
            this.completionWindow = completionWindow
        }

        /**
         * The endpoint to be used for all requests in the batch. Currently `/v1/chat/completions`,
         * `/v1/embeddings`, and `/v1/completions` are supported. Note that `/v1/embeddings` batches
         * are also restricted to a maximum of 50,000 embedding inputs across all requests in the
         * batch.
         */
        fun endpoint(endpoint: Endpoint) = apply { this.endpoint = endpoint }

        /**
         * The ID of an uploaded file that contains requests for the new batch.
         *
         * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for how to
         * upload a file.
         *
         * Your input file must be formatted as a
         * [JSONL file](https://platform.openai.com/docs/api-reference/batch/request-input), and
         * must be uploaded with the purpose `batch`. The file can contain up to 50,000 requests,
         * and can be up to 100 MB in size.
         */
        fun inputFileId(inputFileId: String) = apply { this.inputFileId = inputFileId }

        /** Optional custom metadata for the batch. */
        fun metadata(metadata: Metadata) = apply { this.metadata = metadata }

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

        fun build(): BatchCreateParams =
            BatchCreateParams(
                checkNotNull(completionWindow) { "`completionWindow` is required but was not set" },
                checkNotNull(endpoint) { "`endpoint` is required but was not set" },
                checkNotNull(inputFileId) { "`inputFileId` is required but was not set" },
                metadata,
                additionalQueryParams.mapValues { it.value.toImmutable() }.toImmutable(),
                additionalHeaders.mapValues { it.value.toImmutable() }.toImmutable(),
                additionalBodyProperties.toImmutable(),
            )
    }

    class CompletionWindow
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is CompletionWindow && this.value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val _24H = CompletionWindow(JsonField.of("24h"))

            @JvmStatic fun of(value: String) = CompletionWindow(JsonField.of(value))
        }

        enum class Known {
            _24H,
        }

        enum class Value {
            _24H,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                _24H -> Value._24H
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                _24H -> Known._24H
                else -> throw OpenAIInvalidDataException("Unknown CompletionWindow: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Endpoint
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Endpoint && this.value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val V1_CHAT_COMPLETIONS = Endpoint(JsonField.of("/v1/chat/completions"))

            @JvmField val V1_EMBEDDINGS = Endpoint(JsonField.of("/v1/embeddings"))

            @JvmField val V1_COMPLETIONS = Endpoint(JsonField.of("/v1/completions"))

            @JvmStatic fun of(value: String) = Endpoint(JsonField.of(value))
        }

        enum class Known {
            V1_CHAT_COMPLETIONS,
            V1_EMBEDDINGS,
            V1_COMPLETIONS,
        }

        enum class Value {
            V1_CHAT_COMPLETIONS,
            V1_EMBEDDINGS,
            V1_COMPLETIONS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                V1_CHAT_COMPLETIONS -> Value.V1_CHAT_COMPLETIONS
                V1_EMBEDDINGS -> Value.V1_EMBEDDINGS
                V1_COMPLETIONS -> Value.V1_COMPLETIONS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                V1_CHAT_COMPLETIONS -> Known.V1_CHAT_COMPLETIONS
                V1_EMBEDDINGS -> Known.V1_EMBEDDINGS
                V1_COMPLETIONS -> Known.V1_COMPLETIONS
                else -> throw OpenAIInvalidDataException("Unknown Endpoint: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    /** Optional custom metadata for the batch. */
    @JsonDeserialize(builder = Metadata.Builder::class)
    @NoAutoDetect
    class Metadata
    private constructor(
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metadata: Metadata) = apply {
                additionalProperties(metadata.additionalProperties)
            }

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

            fun build(): Metadata = Metadata(additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Metadata && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }
}
