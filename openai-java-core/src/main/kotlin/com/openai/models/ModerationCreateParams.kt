// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
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
import com.openai.core.ExcludeMissing
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

        /**
         * Input (or inputs) to classify. Can be a single string, an array of strings, or an array
         * of multi-modal input objects similar to other models.
         */
        @JsonProperty("input") fun input(): Input? = input

        /**
         * The content moderation model you would like to use. Learn more in
         * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
         * about available models [here](https://platform.openai.com/docs/models/moderation).
         */
        @JsonProperty("model") fun model(): Model? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

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

            /**
             * Input (or inputs) to classify. Can be a single string, an array of strings, or an
             * array of multi-modal input objects similar to other models.
             */
            @JsonProperty("input") fun input(input: Input) = apply { this.input = input }

            /**
             * The content moderation model you would like to use. Learn more in
             * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
             * about available models [here](https://platform.openai.com/docs/models/moderation).
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ModerationCreateBody && this.input == other.input && this.model == other.model && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(input, model, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "ModerationCreateBody{input=$input, model=$model, additionalProperties=$additionalProperties}"
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ModerationCreateParams && this.input == other.input && this.model == other.model && this.additionalQueryParams == other.additionalQueryParams && this.additionalHeaders == other.additionalHeaders && this.additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(input, model, additionalQueryParams, additionalHeaders, additionalBodyProperties) /* spotless:on */
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

        /**
         * Input (or inputs) to classify. Can be a single string, an array of strings, or an array
         * of multi-modal input objects similar to other models.
         */
        fun input(input: Input) = apply { this.input = input }

        /**
         * Input (or inputs) to classify. Can be a single string, an array of strings, or an array
         * of multi-modal input objects similar to other models.
         */
        fun input(string: String) = apply { this.input = Input.ofString(string) }

        /**
         * Input (or inputs) to classify. Can be a single string, an array of strings, or an array
         * of multi-modal input objects similar to other models.
         */
        fun inputOfStrings(strings: List<String>) = apply { this.input = Input.ofStrings(strings) }

        /**
         * Input (or inputs) to classify. Can be a single string, an array of strings, or an array
         * of multi-modal input objects similar to other models.
         */
        fun inputOfModerationMultiModalArray(
            moderationMultiModalArray: List<ModerationMultiModalInput>
        ) = apply { this.input = Input.ofModerationMultiModalArray(moderationMultiModalArray) }

        /**
         * The content moderation model you would like to use. Learn more in
         * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
         * about available models [here](https://platform.openai.com/docs/models/moderation).
         */
        fun model(model: Model) = apply { this.model = model }

        /**
         * The content moderation model you would like to use. Learn more in
         * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
         * about available models [here](https://platform.openai.com/docs/models/moderation).
         */
        fun model(string: String) = apply { this.model = Model.ofString(string) }

        /**
         * The content moderation model you would like to use. Learn more in
         * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
         * about available models [here](https://platform.openai.com/docs/models/moderation).
         */
        fun model(moderationModel: ModerationModel) = apply {
            this.model = Model.ofModerationModel(moderationModel)
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
        private val moderationMultiModalArray: List<ModerationMultiModalInput>? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        /** A string of text to classify for moderation. */
        fun string(): Optional<String> = Optional.ofNullable(string)
        /** An array of strings to classify for moderation. */
        fun strings(): Optional<List<String>> = Optional.ofNullable(strings)
        /** An array of multi-modal inputs to the moderation model. */
        fun moderationMultiModalArray(): Optional<List<ModerationMultiModalInput>> =
            Optional.ofNullable(moderationMultiModalArray)

        fun isString(): Boolean = string != null

        fun isStrings(): Boolean = strings != null

        fun isModerationMultiModalArray(): Boolean = moderationMultiModalArray != null

        fun asString(): String = string.getOrThrow("string")

        fun asStrings(): List<String> = strings.getOrThrow("strings")

        fun asModerationMultiModalArray(): List<ModerationMultiModalInput> =
            moderationMultiModalArray.getOrThrow("moderationMultiModalArray")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                strings != null -> visitor.visitStrings(strings)
                moderationMultiModalArray != null ->
                    visitor.visitModerationMultiModalArray(moderationMultiModalArray)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Input = apply {
            if (!validated) {
                if (string == null && strings == null && moderationMultiModalArray == null) {
                    throw OpenAIInvalidDataException("Unknown Input: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Input && this.string == other.string && this.strings == other.strings && this.moderationMultiModalArray == other.moderationMultiModalArray /* spotless:on */
        }

        override fun hashCode(): Int {
            return /* spotless:off */ Objects.hash(string, strings, moderationMultiModalArray) /* spotless:on */
        }

        override fun toString(): String {
            return when {
                string != null -> "Input{string=$string}"
                strings != null -> "Input{strings=$strings}"
                moderationMultiModalArray != null ->
                    "Input{moderationMultiModalArray=$moderationMultiModalArray}"
                _json != null -> "Input{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Input")
            }
        }

        companion object {

            @JvmStatic fun ofString(string: String) = Input(string = string)

            @JvmStatic fun ofStrings(strings: List<String>) = Input(strings = strings)

            @JvmStatic
            fun ofModerationMultiModalArray(
                moderationMultiModalArray: List<ModerationMultiModalInput>
            ) = Input(moderationMultiModalArray = moderationMultiModalArray)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<String>): T

            fun visitModerationMultiModalArray(
                moderationMultiModalArray: List<ModerationMultiModalInput>
            ): T

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
                tryDeserialize(node, jacksonTypeRef<List<ModerationMultiModalInput>>())?.let {
                    return Input(moderationMultiModalArray = it, _json = json)
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
                    value.moderationMultiModalArray != null ->
                        generator.writeObject(value.moderationMultiModalArray)
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
        private val moderationModel: ModerationModel? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun moderationModel(): Optional<ModerationModel> = Optional.ofNullable(moderationModel)

        fun isString(): Boolean = string != null

        fun isModerationModel(): Boolean = moderationModel != null

        fun asString(): String = string.getOrThrow("string")

        fun asModerationModel(): ModerationModel = moderationModel.getOrThrow("moderationModel")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                moderationModel != null -> visitor.visitModerationModel(moderationModel)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Model = apply {
            if (!validated) {
                if (string == null && moderationModel == null) {
                    throw OpenAIInvalidDataException("Unknown Model: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Model && this.string == other.string && this.moderationModel == other.moderationModel /* spotless:on */
        }

        override fun hashCode(): Int {
            return /* spotless:off */ Objects.hash(string, moderationModel) /* spotless:on */
        }

        override fun toString(): String {
            return when {
                string != null -> "Model{string=$string}"
                moderationModel != null -> "Model{moderationModel=$moderationModel}"
                _json != null -> "Model{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Model")
            }
        }

        companion object {

            @JvmStatic fun ofString(string: String) = Model(string = string)

            @JvmStatic
            fun ofModerationModel(moderationModel: ModerationModel) =
                Model(moderationModel = moderationModel)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitModerationModel(moderationModel: ModerationModel): T

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
                tryDeserialize(node, jacksonTypeRef<ModerationModel>())?.let {
                    return Model(moderationModel = it, _json = json)
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
                    value.moderationModel != null -> generator.writeObject(value.moderationModel)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Model")
                }
            }
        }
    }
}
