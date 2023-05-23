package com.openai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.api.core.ExcludeMissing
import com.openai.api.core.JsonField
import com.openai.api.core.JsonValue
import com.openai.api.core.NoAutoDetect
import com.openai.api.core.toUnmodifiable
import com.openai.api.errors.OpenAiInvalidDataException
import com.openai.api.models.*
import java.util.Objects
import java.util.Optional

class ImageCreateVariationParams
constructor(
    private val image: String,
    private val n: Long?,
    private val size: Size?,
    private val responseFormat: ResponseFormat?,
    private val user: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun image(): String = image

    fun n(): Optional<Long> = Optional.ofNullable(n)

    fun size(): Optional<Size> = Optional.ofNullable(size)

    fun responseFormat(): Optional<ResponseFormat> = Optional.ofNullable(responseFormat)

    fun user(): Optional<String> = Optional.ofNullable(user)

    @JvmSynthetic
    internal fun getBody(): ImageCreateVariationBody {
        return ImageCreateVariationBody(
            image,
            n,
            size,
            responseFormat,
            user,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = ImageCreateVariationBody.Builder::class)
    @NoAutoDetect
    class ImageCreateVariationBody
    internal constructor(
        private val image: String?,
        private val n: Long?,
        private val size: Size?,
        private val responseFormat: ResponseFormat?,
        private val user: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * The image to use as the basis for the variation(s). Must be a valid PNG file, less than
         * 4MB, and square.
         */
        @JsonProperty("image") fun image(): String? = image

        /** The number of images to generate. Must be between 1 and 10. */
        @JsonProperty("n") fun n(): Long? = n

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`.
         */
        @JsonProperty("size") fun size(): Size? = size

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`.
         */
        @JsonProperty("response_format") fun responseFormat(): ResponseFormat? = responseFormat

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse. [Learn more](/docs/guides/safety-best-practices/end-user-ids).
         */
        @JsonProperty("user") fun user(): String? = user

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ImageCreateVariationBody &&
                this.image == other.image &&
                this.n == other.n &&
                this.size == other.size &&
                this.responseFormat == other.responseFormat &&
                this.user == other.user &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        image,
                        n,
                        size,
                        responseFormat,
                        user,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ImageCreateVariationBody{image=$image, n=$n, size=$size, responseFormat=$responseFormat, user=$user, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var image: String? = null
            private var n: Long? = null
            private var size: Size? = null
            private var responseFormat: ResponseFormat? = null
            private var user: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(imageCreateVariationBody: ImageCreateVariationBody) = apply {
                this.image = imageCreateVariationBody.image
                this.n = imageCreateVariationBody.n
                this.size = imageCreateVariationBody.size
                this.responseFormat = imageCreateVariationBody.responseFormat
                this.user = imageCreateVariationBody.user
                additionalProperties(imageCreateVariationBody.additionalProperties)
            }

            /**
             * The image to use as the basis for the variation(s). Must be a valid PNG file, less
             * than 4MB, and square.
             */
            @JsonProperty("image") fun image(image: String) = apply { this.image = image }

            /** The number of images to generate. Must be between 1 and 10. */
            @JsonProperty("n") fun n(n: Long) = apply { this.n = n }

            /**
             * The size of the generated images. Must be one of `256x256`, `512x512`, or
             * `1024x1024`.
             */
            @JsonProperty("size") fun size(size: Size) = apply { this.size = size }

            /**
             * The format in which the generated images are returned. Must be one of `url` or
             * `b64_json`.
             */
            @JsonProperty("response_format")
            fun responseFormat(responseFormat: ResponseFormat) = apply {
                this.responseFormat = responseFormat
            }

            /**
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse. [Learn more](/docs/guides/safety-best-practices/end-user-ids).
             */
            @JsonProperty("user") fun user(user: String) = apply { this.user = user }

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

            fun build(): ImageCreateVariationBody =
                ImageCreateVariationBody(
                    checkNotNull(image) { "`image` is required but was not set" },
                    n,
                    size,
                    responseFormat,
                    user,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ImageCreateVariationParams &&
            this.image == other.image &&
            this.n == other.n &&
            this.size == other.size &&
            this.responseFormat == other.responseFormat &&
            this.user == other.user &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            image,
            n,
            size,
            responseFormat,
            user,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "ImageCreateVariationParams{image=$image, n=$n, size=$size, responseFormat=$responseFormat, user=$user, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var image: String? = null
        private var n: Long? = null
        private var size: Size? = null
        private var responseFormat: ResponseFormat? = null
        private var user: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imageCreateVariationParams: ImageCreateVariationParams) = apply {
            this.image = imageCreateVariationParams.image
            this.n = imageCreateVariationParams.n
            this.size = imageCreateVariationParams.size
            this.responseFormat = imageCreateVariationParams.responseFormat
            this.user = imageCreateVariationParams.user
            additionalQueryParams(imageCreateVariationParams.additionalQueryParams)
            additionalHeaders(imageCreateVariationParams.additionalHeaders)
            additionalBodyProperties(imageCreateVariationParams.additionalBodyProperties)
        }

        /**
         * The image to use as the basis for the variation(s). Must be a valid PNG file, less than
         * 4MB, and square.
         */
        fun image(image: String) = apply { this.image = image }

        /** The number of images to generate. Must be between 1 and 10. */
        fun n(n: Long) = apply { this.n = n }

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`.
         */
        fun size(size: Size) = apply { this.size = size }

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`.
         */
        fun responseFormat(responseFormat: ResponseFormat) = apply {
            this.responseFormat = responseFormat
        }

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse. [Learn more](/docs/guides/safety-best-practices/end-user-ids).
         */
        fun user(user: String) = apply { this.user = user }

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

        fun build(): ImageCreateVariationParams =
            ImageCreateVariationParams(
                checkNotNull(image) { "`image` is required but was not set" },
                n,
                size,
                responseFormat,
                user,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    class Size
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Size && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val _256X256 = Size(JsonField.of("256x256"))

            @JvmField val _512X512 = Size(JsonField.of("512x512"))

            @JvmField val _1024X1024 = Size(JsonField.of("1024x1024"))

            @JvmStatic fun of(value: String) = Size(JsonField.of(value))
        }

        enum class Known {
            _256X256,
            _512X512,
            _1024X1024,
        }

        enum class Value {
            _256X256,
            _512X512,
            _1024X1024,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                _256X256 -> Value._256X256
                _512X512 -> Value._512X512
                _1024X1024 -> Value._1024X1024
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                _256X256 -> Known._256X256
                _512X512 -> Known._512X512
                _1024X1024 -> Known._1024X1024
                else -> throw OpenAiInvalidDataException("Unknown Size: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class ResponseFormat
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponseFormat && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val URL = ResponseFormat(JsonField.of("url"))

            @JvmField val B64_JSON = ResponseFormat(JsonField.of("b64_json"))

            @JvmStatic fun of(value: String) = ResponseFormat(JsonField.of(value))
        }

        enum class Known {
            URL,
            B64_JSON,
        }

        enum class Value {
            URL,
            B64_JSON,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                URL -> Value.URL
                B64_JSON -> Value.B64_JSON
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                URL -> Known.URL
                B64_JSON -> Known.B64_JSON
                else -> throw OpenAiInvalidDataException("Unknown ResponseFormat: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
