// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.getOrThrow
import com.openai.core.toUnmodifiable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.*
import java.util.Objects
import java.util.Optional

class ImageGenerateParams
constructor(
    private val prompt: String,
    private val model: Model?,
    private val n: Long?,
    private val quality: Quality?,
    private val responseFormat: ResponseFormat?,
    private val size: Size?,
    private val style: Style?,
    private val user: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun prompt(): String = prompt

    fun model(): Optional<Model> = Optional.ofNullable(model)

    fun n(): Optional<Long> = Optional.ofNullable(n)

    fun quality(): Optional<Quality> = Optional.ofNullable(quality)

    fun responseFormat(): Optional<ResponseFormat> = Optional.ofNullable(responseFormat)

    fun size(): Optional<Size> = Optional.ofNullable(size)

    fun style(): Optional<Style> = Optional.ofNullable(style)

    fun user(): Optional<String> = Optional.ofNullable(user)

    @JvmSynthetic
    internal fun getBody(): ImageGenerateBody {
        return ImageGenerateBody(
            prompt,
            model,
            n,
            quality,
            responseFormat,
            size,
            style,
            user,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = ImageGenerateBody.Builder::class)
    @NoAutoDetect
    class ImageGenerateBody
    internal constructor(
        private val prompt: String?,
        private val model: Model?,
        private val n: Long?,
        private val quality: Quality?,
        private val responseFormat: ResponseFormat?,
        private val size: Size?,
        private val style: Style?,
        private val user: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        /**
         * A text description of the desired image(s). The maximum length is 1000 characters for
         * `dall-e-2` and 4000 characters for `dall-e-3`.
         */
        @JsonProperty("prompt") fun prompt(): String? = prompt

        /** The model to use for image generation. */
        @JsonProperty("model") fun model(): Model? = model

        /**
         * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
         * supported.
         */
        @JsonProperty("n") fun n(): Long? = n

        /**
         * The quality of the image that will be generated. `hd` creates images with finer details
         * and greater consistency across the image. This param is only supported for `dall-e-3`.
         */
        @JsonProperty("quality") fun quality(): Quality? = quality

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
         */
        @JsonProperty("response_format") fun responseFormat(): ResponseFormat? = responseFormat

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024` for
         * `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for `dall-e-3`
         * models.
         */
        @JsonProperty("size") fun size(): Size? = size

        /**
         * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes the
         * model to lean towards generating hyper-real and dramatic images. Natural causes the model
         * to produce more natural, less hyper-real looking images. This param is only supported for
         * `dall-e-3`.
         */
        @JsonProperty("style") fun style(): Style? = style

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices/end-user-ids).
         */
        @JsonProperty("user") fun user(): String? = user

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var prompt: String? = null
            private var model: Model? = null
            private var n: Long? = null
            private var quality: Quality? = null
            private var responseFormat: ResponseFormat? = null
            private var size: Size? = null
            private var style: Style? = null
            private var user: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(imageGenerateBody: ImageGenerateBody) = apply {
                this.prompt = imageGenerateBody.prompt
                this.model = imageGenerateBody.model
                this.n = imageGenerateBody.n
                this.quality = imageGenerateBody.quality
                this.responseFormat = imageGenerateBody.responseFormat
                this.size = imageGenerateBody.size
                this.style = imageGenerateBody.style
                this.user = imageGenerateBody.user
                additionalProperties(imageGenerateBody.additionalProperties)
            }

            /**
             * A text description of the desired image(s). The maximum length is 1000 characters for
             * `dall-e-2` and 4000 characters for `dall-e-3`.
             */
            @JsonProperty("prompt") fun prompt(prompt: String) = apply { this.prompt = prompt }

            /** The model to use for image generation. */
            @JsonProperty("model") fun model(model: Model) = apply { this.model = model }

            /**
             * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only
             * `n=1` is supported.
             */
            @JsonProperty("n") fun n(n: Long) = apply { this.n = n }

            /**
             * The quality of the image that will be generated. `hd` creates images with finer
             * details and greater consistency across the image. This param is only supported for
             * `dall-e-3`.
             */
            @JsonProperty("quality")
            fun quality(quality: Quality) = apply { this.quality = quality }

            /**
             * The format in which the generated images are returned. Must be one of `url` or
             * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
             */
            @JsonProperty("response_format")
            fun responseFormat(responseFormat: ResponseFormat) = apply {
                this.responseFormat = responseFormat
            }

            /**
             * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`
             * for `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for
             * `dall-e-3` models.
             */
            @JsonProperty("size") fun size(size: Size) = apply { this.size = size }

            /**
             * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes
             * the model to lean towards generating hyper-real and dramatic images. Natural causes
             * the model to produce more natural, less hyper-real looking images. This param is only
             * supported for `dall-e-3`.
             */
            @JsonProperty("style") fun style(style: Style) = apply { this.style = style }

            /**
             * A unique identifier representing your end-user, which can help OpenAI to monitor and
             * detect abuse.
             * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices/end-user-ids).
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

            fun build(): ImageGenerateBody =
                ImageGenerateBody(
                    checkNotNull(prompt) { "`prompt` is required but was not set" },
                    model,
                    n,
                    quality,
                    responseFormat,
                    size,
                    style,
                    user,
                    additionalProperties.toUnmodifiable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ImageGenerateBody && this.prompt == other.prompt && this.model == other.model && this.n == other.n && this.quality == other.quality && this.responseFormat == other.responseFormat && this.size == other.size && this.style == other.style && this.user == other.user && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(prompt, model, n, quality, responseFormat, size, style, user, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "ImageGenerateBody{prompt=$prompt, model=$model, n=$n, quality=$quality, responseFormat=$responseFormat, size=$size, style=$style, user=$user, additionalProperties=$additionalProperties}"
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ImageGenerateParams && this.prompt == other.prompt && this.model == other.model && this.n == other.n && this.quality == other.quality && this.responseFormat == other.responseFormat && this.size == other.size && this.style == other.style && this.user == other.user && this.additionalQueryParams == other.additionalQueryParams && this.additionalHeaders == other.additionalHeaders && this.additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(prompt, model, n, quality, responseFormat, size, style, user, additionalQueryParams, additionalHeaders, additionalBodyProperties) /* spotless:on */
    }

    override fun toString() =
        "ImageGenerateParams{prompt=$prompt, model=$model, n=$n, quality=$quality, responseFormat=$responseFormat, size=$size, style=$style, user=$user, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var prompt: String? = null
        private var model: Model? = null
        private var n: Long? = null
        private var quality: Quality? = null
        private var responseFormat: ResponseFormat? = null
        private var size: Size? = null
        private var style: Style? = null
        private var user: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imageGenerateParams: ImageGenerateParams) = apply {
            this.prompt = imageGenerateParams.prompt
            this.model = imageGenerateParams.model
            this.n = imageGenerateParams.n
            this.quality = imageGenerateParams.quality
            this.responseFormat = imageGenerateParams.responseFormat
            this.size = imageGenerateParams.size
            this.style = imageGenerateParams.style
            this.user = imageGenerateParams.user
            additionalQueryParams(imageGenerateParams.additionalQueryParams)
            additionalHeaders(imageGenerateParams.additionalHeaders)
            additionalBodyProperties(imageGenerateParams.additionalBodyProperties)
        }

        /**
         * A text description of the desired image(s). The maximum length is 1000 characters for
         * `dall-e-2` and 4000 characters for `dall-e-3`.
         */
        fun prompt(prompt: String) = apply { this.prompt = prompt }

        /** The model to use for image generation. */
        fun model(model: Model) = apply { this.model = model }

        /** The model to use for image generation. */
        fun model(string: String) = apply { this.model = Model.ofString(string) }

        /** The model to use for image generation. */
        fun model(imageModel: ImageModel) = apply { this.model = Model.ofImageModel(imageModel) }

        /**
         * The number of images to generate. Must be between 1 and 10. For `dall-e-3`, only `n=1` is
         * supported.
         */
        fun n(n: Long) = apply { this.n = n }

        /**
         * The quality of the image that will be generated. `hd` creates images with finer details
         * and greater consistency across the image. This param is only supported for `dall-e-3`.
         */
        fun quality(quality: Quality) = apply { this.quality = quality }

        /**
         * The format in which the generated images are returned. Must be one of `url` or
         * `b64_json`. URLs are only valid for 60 minutes after the image has been generated.
         */
        fun responseFormat(responseFormat: ResponseFormat) = apply {
            this.responseFormat = responseFormat
        }

        /**
         * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024` for
         * `dall-e-2`. Must be one of `1024x1024`, `1792x1024`, or `1024x1792` for `dall-e-3`
         * models.
         */
        fun size(size: Size) = apply { this.size = size }

        /**
         * The style of the generated images. Must be one of `vivid` or `natural`. Vivid causes the
         * model to lean towards generating hyper-real and dramatic images. Natural causes the model
         * to produce more natural, less hyper-real looking images. This param is only supported for
         * `dall-e-3`.
         */
        fun style(style: Style) = apply { this.style = style }

        /**
         * A unique identifier representing your end-user, which can help OpenAI to monitor and
         * detect abuse.
         * [Learn more](https://platform.openai.com/docs/guides/safety-best-practices/end-user-ids).
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

        fun build(): ImageGenerateParams =
            ImageGenerateParams(
                checkNotNull(prompt) { "`prompt` is required but was not set" },
                model,
                n,
                quality,
                responseFormat,
                size,
                style,
                user,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(using = Model.Deserializer::class)
    @JsonSerialize(using = Model.Serializer::class)
    class Model
    private constructor(
        private val string: String? = null,
        private val imageModel: ImageModel? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun imageModel(): Optional<ImageModel> = Optional.ofNullable(imageModel)

        fun isString(): Boolean = string != null

        fun isImageModel(): Boolean = imageModel != null

        fun asString(): String = string.getOrThrow("string")

        fun asImageModel(): ImageModel = imageModel.getOrThrow("imageModel")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                imageModel != null -> visitor.visitImageModel(imageModel)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Model = apply {
            if (!validated) {
                if (string == null && imageModel == null) {
                    throw OpenAIInvalidDataException("Unknown Model: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Model && this.string == other.string && this.imageModel == other.imageModel /* spotless:on */
        }

        override fun hashCode(): Int {
            return /* spotless:off */ Objects.hash(string, imageModel) /* spotless:on */
        }

        override fun toString(): String {
            return when {
                string != null -> "Model{string=$string}"
                imageModel != null -> "Model{imageModel=$imageModel}"
                _json != null -> "Model{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Model")
            }
        }

        companion object {

            @JvmStatic fun ofString(string: String) = Model(string = string)

            @JvmStatic fun ofImageModel(imageModel: ImageModel) = Model(imageModel = imageModel)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitImageModel(imageModel: ImageModel): T

            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Model: $json")
            }
        }

        class Deserializer : BaseDeserializer<Model>(Model::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Model {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Model(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<ImageModel>())?.let {
                    return Model(imageModel = it, _json = json)
                }

                return Model(_json = json)
            }
        }

        class Serializer : BaseSerializer<Model>(Model::class) {

            override fun serialize(
                value: Model,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.imageModel != null -> generator.writeObject(value.imageModel)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Model")
                }
            }
        }
    }

    class Quality
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Quality && this.value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val STANDARD = Quality(JsonField.of("standard"))

            @JvmField val HD = Quality(JsonField.of("hd"))

            @JvmStatic fun of(value: String) = Quality(JsonField.of(value))
        }

        enum class Known {
            STANDARD,
            HD,
        }

        enum class Value {
            STANDARD,
            HD,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                STANDARD -> Value.STANDARD
                HD -> Value.HD
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                STANDARD -> Known.STANDARD
                HD -> Known.HD
                else -> throw OpenAIInvalidDataException("Unknown Quality: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class ResponseFormat
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ResponseFormat && this.value == other.value /* spotless:on */
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
                else -> throw OpenAIInvalidDataException("Unknown ResponseFormat: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Size
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Size && this.value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val _256X256 = Size(JsonField.of("256x256"))

            @JvmField val _512X512 = Size(JsonField.of("512x512"))

            @JvmField val _1024X1024 = Size(JsonField.of("1024x1024"))

            @JvmField val _1792X1024 = Size(JsonField.of("1792x1024"))

            @JvmField val _1024X1792 = Size(JsonField.of("1024x1792"))

            @JvmStatic fun of(value: String) = Size(JsonField.of(value))
        }

        enum class Known {
            _256X256,
            _512X512,
            _1024X1024,
            _1792X1024,
            _1024X1792,
        }

        enum class Value {
            _256X256,
            _512X512,
            _1024X1024,
            _1792X1024,
            _1024X1792,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                _256X256 -> Value._256X256
                _512X512 -> Value._512X512
                _1024X1024 -> Value._1024X1024
                _1792X1024 -> Value._1792X1024
                _1024X1792 -> Value._1024X1792
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                _256X256 -> Known._256X256
                _512X512 -> Known._512X512
                _1024X1024 -> Known._1024X1024
                _1792X1024 -> Known._1792X1024
                _1024X1792 -> Known._1024X1792
                else -> throw OpenAIInvalidDataException("Unknown Size: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Style
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Style && this.value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val VIVID = Style(JsonField.of("vivid"))

            @JvmField val NATURAL = Style(JsonField.of("natural"))

            @JvmStatic fun of(value: String) = Style(JsonField.of(value))
        }

        enum class Known {
            VIVID,
            NATURAL,
        }

        enum class Value {
            VIVID,
            NATURAL,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                VIVID -> Value.VIVID
                NATURAL -> Value.NATURAL
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                VIVID -> Known.VIVID
                NATURAL -> Known.NATURAL
                else -> throw OpenAIInvalidDataException("Unknown Style: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
