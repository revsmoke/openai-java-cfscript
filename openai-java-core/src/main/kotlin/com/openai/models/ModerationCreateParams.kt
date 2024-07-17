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

class ModerationCreateParams
constructor(
    private val input: Input,
    private val model: Model?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun input(): Input = input

    fun model(): Optional<Model> = Optional.ofNullable(model)

    @JvmSynthetic
    internal fun getBody(): ModerationCreateBody {
        return ModerationCreateBody(
            input,
            model,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = ModerationCreateBody.Builder::class)
    @NoAutoDetect
    class ModerationCreateBody
    internal constructor(
        private val input: Input?,
        private val model: Model?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The input text to classify */
        @JsonProperty("input") fun input(): Input? = input

        /**
         * Two content moderations models are available: `text-moderation-stable` and
         * `text-moderation-latest`.
         *
         * The default is `text-moderation-latest` which will be automatically upgraded over time.
         * This ensures you are always using our most accurate model. If you use
         * `text-moderation-stable`, we will provide advanced notice before updating the model.
         * Accuracy of `text-moderation-stable` may be slightly lower than for
         * `text-moderation-latest`.
         */
        @JsonProperty("model") fun model(): Model? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ModerationCreateBody &&
                this.input == other.input &&
                this.model == other.model &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        input,
                        model,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ModerationCreateBody{input=$input, model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var input: Input? = null
            private var model: Model? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(moderationCreateBody: ModerationCreateBody) = apply {
                this.input = moderationCreateBody.input
                this.model = moderationCreateBody.model
                additionalProperties(moderationCreateBody.additionalProperties)
            }

            /** The input text to classify */
            @JsonProperty("input") fun input(input: Input) = apply { this.input = input }

            /**
             * Two content moderations models are available: `text-moderation-stable` and
             * `text-moderation-latest`.
             *
             * The default is `text-moderation-latest` which will be automatically upgraded over
             * time. This ensures you are always using our most accurate model. If you use
             * `text-moderation-stable`, we will provide advanced notice before updating the model.
             * Accuracy of `text-moderation-stable` may be slightly lower than for
             * `text-moderation-latest`.
             */
            @JsonProperty("model") fun model(model: Model) = apply { this.model = model }

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

            fun build(): ModerationCreateBody =
                ModerationCreateBody(
                    checkNotNull(input) { "`input` is required but was not set" },
                    model,
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

        return other is ModerationCreateParams &&
            this.input == other.input &&
            this.model == other.model &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            input,
            model,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "ModerationCreateParams{input=$input, model=$model, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var input: Input? = null
        private var model: Model? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(moderationCreateParams: ModerationCreateParams) = apply {
            this.input = moderationCreateParams.input
            this.model = moderationCreateParams.model
            additionalQueryParams(moderationCreateParams.additionalQueryParams)
            additionalHeaders(moderationCreateParams.additionalHeaders)
            additionalBodyProperties(moderationCreateParams.additionalBodyProperties)
        }

        /** The input text to classify */
        fun input(input: Input) = apply { this.input = input }

        /** The input text to classify */
        fun input(string: String) = apply { this.input = Input.ofString(string) }

        /** The input text to classify */
        fun input(strings: List<String>) = apply { this.input = Input.ofStrings(strings) }

        /**
         * Two content moderations models are available: `text-moderation-stable` and
         * `text-moderation-latest`.
         *
         * The default is `text-moderation-latest` which will be automatically upgraded over time.
         * This ensures you are always using our most accurate model. If you use
         * `text-moderation-stable`, we will provide advanced notice before updating the model.
         * Accuracy of `text-moderation-stable` may be slightly lower than for
         * `text-moderation-latest`.
         */
        fun model(model: Model) = apply { this.model = model }

        /**
         * Two content moderations models are available: `text-moderation-stable` and
         * `text-moderation-latest`.
         *
         * The default is `text-moderation-latest` which will be automatically upgraded over time.
         * This ensures you are always using our most accurate model. If you use
         * `text-moderation-stable`, we will provide advanced notice before updating the model.
         * Accuracy of `text-moderation-stable` may be slightly lower than for
         * `text-moderation-latest`.
         */
        fun model(string: String) = apply { this.model = Model.ofString(string) }

        /**
         * Two content moderations models are available: `text-moderation-stable` and
         * `text-moderation-latest`.
         *
         * The default is `text-moderation-latest` which will be automatically upgraded over time.
         * This ensures you are always using our most accurate model. If you use
         * `text-moderation-stable`, we will provide advanced notice before updating the model.
         * Accuracy of `text-moderation-stable` may be slightly lower than for
         * `text-moderation-latest`.
         */
        fun model(unionMember1: Model.UnionMember1) = apply {
            this.model = Model.ofUnionMember1(unionMember1)
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

        fun build(): ModerationCreateParams =
            ModerationCreateParams(
                checkNotNull(input) { "`input` is required but was not set" },
                model,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(using = Input.Deserializer::class)
    @JsonSerialize(using = Input.Serializer::class)
    class Input
    private constructor(
        private val string: String? = null,
        private val strings: List<String>? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

        fun isString(): Boolean = string != null

        fun isStrings(): Boolean = strings != null

        fun asString(): String = string.getOrThrow("string")

        fun asStrings(): List<String> = strings.getOrThrow("strings")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                strings != null -> visitor.visitStrings(strings)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Input = apply {
            if (!validated) {
                if (string == null && strings == null) {
                    throw OpenAIInvalidDataException("Unknown Input: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Input && this.string == other.string && this.strings == other.strings
        }

        override fun hashCode(): Int {
            return Objects.hash(string, strings)
        }

        override fun toString(): String {
            return when {
                string != null -> "Input{string=$string}"
                strings != null -> "Input{strings=$strings}"
                _json != null -> "Input{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Input")
            }
        }

        companion object {

            @JvmStatic fun ofString(string: String) = Input(string = string)

            @JvmStatic fun ofStrings(strings: List<String>) = Input(strings = strings)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<String>): T

            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Input: $json")
            }
        }

        class Deserializer : BaseDeserializer<Input>(Input::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Input {
                val json = JsonValue.fromJsonNode(node)
                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Input(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                    return Input(strings = it, _json = json)
                }

                return Input(_json = json)
            }
        }

        class Serializer : BaseSerializer<Input>(Input::class) {

            override fun serialize(
                value: Input,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.strings != null -> generator.writeObject(value.strings)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Input")
                }
            }
        }
    }

    @JsonDeserialize(using = Model.Deserializer::class)
    @JsonSerialize(using = Model.Serializer::class)
    class Model
    private constructor(
        private val string: String? = null,
        private val unionMember1: UnionMember1? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun unionMember1(): Optional<UnionMember1> = Optional.ofNullable(unionMember1)

        fun isString(): Boolean = string != null

        fun isUnionMember1(): Boolean = unionMember1 != null

        fun asString(): String = string.getOrThrow("string")

        fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Model = apply {
            if (!validated) {
                if (string == null && unionMember1 == null) {
                    throw OpenAIInvalidDataException("Unknown Model: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Model &&
                this.string == other.string &&
                this.unionMember1 == other.unionMember1
        }

        override fun hashCode(): Int {
            return Objects.hash(string, unionMember1)
        }

        override fun toString(): String {
            return when {
                string != null -> "Model{string=$string}"
                unionMember1 != null -> "Model{unionMember1=$unionMember1}"
                _json != null -> "Model{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Model")
            }
        }

        companion object {

            @JvmStatic fun ofString(string: String) = Model(string = string)

            @JvmStatic
            fun ofUnionMember1(unionMember1: UnionMember1) = Model(unionMember1 = unionMember1)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitUnionMember1(unionMember1: UnionMember1): T

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
                tryDeserialize(node, jacksonTypeRef<UnionMember1>())?.let {
                    return Model(unionMember1 = it, _json = json)
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
                    value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Model")
                }
            }
        }

        class UnionMember1
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is UnionMember1 && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField
                val TEXT_MODERATION_LATEST = UnionMember1(JsonField.of("text-moderation-latest"))

                @JvmField
                val TEXT_MODERATION_STABLE = UnionMember1(JsonField.of("text-moderation-stable"))

                @JvmStatic fun of(value: String) = UnionMember1(JsonField.of(value))
            }

            enum class Known {
                TEXT_MODERATION_LATEST,
                TEXT_MODERATION_STABLE,
            }

            enum class Value {
                TEXT_MODERATION_LATEST,
                TEXT_MODERATION_STABLE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    TEXT_MODERATION_LATEST -> Value.TEXT_MODERATION_LATEST
                    TEXT_MODERATION_STABLE -> Value.TEXT_MODERATION_STABLE
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    TEXT_MODERATION_LATEST -> Known.TEXT_MODERATION_LATEST
                    TEXT_MODERATION_STABLE -> Known.TEXT_MODERATION_STABLE
                    else -> throw OpenAIInvalidDataException("Unknown UnionMember1: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }
}
