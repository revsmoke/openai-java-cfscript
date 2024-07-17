// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.ContentTypes
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.MultipartFormValue
import com.openai.core.NoAutoDetect
import com.openai.core.toUnmodifiable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.*
import java.util.Objects
import org.apache.hc.core5.http.ContentType

class FileCreateParams
constructor(
    private val file: MultipartFormValue<ByteArray>,
    private val purpose: MultipartFormValue<Purpose>,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun file(): MultipartFormValue<ByteArray> = file

    fun purpose(): MultipartFormValue<Purpose> = purpose

    @JvmSynthetic
    internal fun getBody(): Array<MultipartFormValue<*>?> {
        return arrayOf(file, purpose)
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = FileCreateBody.Builder::class)
    @NoAutoDetect
    class FileCreateBody
    internal constructor(
        private val file: ByteArray?,
        private val purpose: Purpose?,
    ) {

        private var hashCode: Int = 0

        /** The File object (not file name) to be uploaded. */
        fun file(): ByteArray? = file

        /**
         * The intended purpose of the uploaded file.
         *
         * Use "assistants" for
         * [Assistants](https://platform.openai.com/docs/api-reference/assistants) and
         * [Message](https://platform.openai.com/docs/api-reference/messages) files, "vision" for
         * Assistants image file inputs, "batch" for
         * [Batch API](https://platform.openai.com/docs/guides/batch), and "fine-tune" for
         * [Fine-tuning](https://platform.openai.com/docs/api-reference/fine-tuning).
         */
        fun purpose(): Purpose? = purpose

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FileCreateBody &&
                this.file == other.file &&
                this.purpose == other.purpose
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(file, purpose)
            }
            return hashCode
        }

        override fun toString() = "FileCreateBody{file=$file, purpose=$purpose}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var file: ByteArray? = null
            private var purpose: Purpose? = null

            @JvmSynthetic
            internal fun from(fileCreateBody: FileCreateBody) = apply {
                this.file = fileCreateBody.file
                this.purpose = fileCreateBody.purpose
            }

            /** The File object (not file name) to be uploaded. */
            fun file(file: ByteArray) = apply { this.file = file }

            /**
             * The intended purpose of the uploaded file.
             *
             * Use "assistants" for
             * [Assistants](https://platform.openai.com/docs/api-reference/assistants) and
             * [Message](https://platform.openai.com/docs/api-reference/messages) files, "vision"
             * for Assistants image file inputs, "batch" for
             * [Batch API](https://platform.openai.com/docs/guides/batch), and "fine-tune" for
             * [Fine-tuning](https://platform.openai.com/docs/api-reference/fine-tuning).
             */
            fun purpose(purpose: Purpose) = apply { this.purpose = purpose }
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileCreateParams &&
            this.file == other.file &&
            this.purpose == other.purpose &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            file,
            purpose,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "FileCreateParams{file=$file, purpose=$purpose, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var file: MultipartFormValue<ByteArray>? = null
        private var purpose: MultipartFormValue<Purpose>? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileCreateParams: FileCreateParams) = apply {
            this.file = fileCreateParams.file
            this.purpose = fileCreateParams.purpose
            additionalQueryParams(fileCreateParams.additionalQueryParams)
            additionalHeaders(fileCreateParams.additionalHeaders)
        }

        /** The File object (not file name) to be uploaded. */
        fun file(
            content: ByteArray,
            filename: String? = null,
            contentType: ContentType = ContentTypes.DefaultBinary
        ) = apply {
            this.file = MultipartFormValue.fromByteArray("file", content, contentType, filename)
        }

        /**
         * The intended purpose of the uploaded file.
         *
         * Use "assistants" for
         * [Assistants](https://platform.openai.com/docs/api-reference/assistants) and
         * [Message](https://platform.openai.com/docs/api-reference/messages) files, "vision" for
         * Assistants image file inputs, "batch" for
         * [Batch API](https://platform.openai.com/docs/guides/batch), and "fine-tune" for
         * [Fine-tuning](https://platform.openai.com/docs/api-reference/fine-tuning).
         */
        fun purpose(purpose: Purpose, contentType: ContentType = ContentTypes.DefaultText) = apply {
            this.purpose = MultipartFormValue.fromEnum("purpose", purpose, contentType)
        }

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

        fun build(): FileCreateParams =
            FileCreateParams(
                checkNotNull(file) { "`file` is required but was not set" },
                checkNotNull(purpose) { "`purpose` is required but was not set" },
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            )
    }

    class Purpose
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Purpose && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val ASSISTANTS = Purpose(JsonField.of("assistants"))

            @JvmField val BATCH = Purpose(JsonField.of("batch"))

            @JvmField val FINE_TUNE = Purpose(JsonField.of("fine-tune"))

            @JvmField val VISION = Purpose(JsonField.of("vision"))

            @JvmStatic fun of(value: String) = Purpose(JsonField.of(value))
        }

        enum class Known {
            ASSISTANTS,
            BATCH,
            FINE_TUNE,
            VISION,
        }

        enum class Value {
            ASSISTANTS,
            BATCH,
            FINE_TUNE,
            VISION,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ASSISTANTS -> Value.ASSISTANTS
                BATCH -> Value.BATCH
                FINE_TUNE -> Value.FINE_TUNE
                VISION -> Value.VISION
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ASSISTANTS -> Known.ASSISTANTS
                BATCH -> Known.BATCH
                FINE_TUNE -> Known.FINE_TUNE
                VISION -> Known.VISION
                else -> throw OpenAIInvalidDataException("Unknown Purpose: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
