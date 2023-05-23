package com.openai.api.models

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
import com.openai.api.core.BaseDeserializer
import com.openai.api.core.BaseSerializer
import com.openai.api.core.ExcludeMissing
import com.openai.api.core.JsonValue
import com.openai.api.core.NoAutoDetect
import com.openai.api.core.getOrThrow
import com.openai.api.core.toUnmodifiable
import com.openai.api.errors.OpenAiInvalidDataException
import com.openai.api.models.*
import java.util.Objects
import java.util.Optional

class EmbeddingCreateParams
constructor(
    private val model: String,
    private val input: Input,
    private val user: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): String = model

    fun input(): Input = input

    fun user(): Optional<String> = Optional.ofNullable(user)

    @JvmSynthetic
    internal fun getBody(): EmbeddingCreateBody {
        return EmbeddingCreateBody(
            model,
            input,
            user,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = EmbeddingCreateBody.Builder::class)
    @NoAutoDetect
    class EmbeddingCreateBody
    internal constructor(
        private val model: String?,
        private val input: Input?,
        private val user: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * ID of the model to use. You can use the [List models](/docs/api-reference/models/list)
         * API to see all of your available models, or see our
         * [Model overview](/docs/models/overview) for descriptions of them.
         */
        @JsonProperty("model") fun model(): String? = model

        /**
         * Input text to get embeddings for, encoded as a string or array of tokens. To get
         * embeddings for multiple inputs in a single request, pass an array of strings or array of
         * token arrays. Each input must not exceed 8192 tokens in length.
         */
        @JsonProperty("input") fun input(): Input? = input

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

            return other is EmbeddingCreateBody &&
                this.model == other.model &&
                this.input == other.input &&
                this.user == other.user &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        model,
                        input,
                        user,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "EmbeddingCreateBody{model=$model, input=$input, user=$user, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: String? = null
            private var input: Input? = null
            private var user: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(embeddingCreateBody: EmbeddingCreateBody) = apply {
                this.model = embeddingCreateBody.model
                this.input = embeddingCreateBody.input
                this.user = embeddingCreateBody.user
                additionalProperties(embeddingCreateBody.additionalProperties)
            }

            /**
             * ID of the model to use. You can use the
             * [List models](/docs/api-reference/models/list) API to see all of your available
             * models, or see our [Model overview](/docs/models/overview) for descriptions of them.
             */
            @JsonProperty("model") fun model(model: String) = apply { this.model = model }

            /**
             * Input text to get embeddings for, encoded as a string or array of tokens. To get
             * embeddings for multiple inputs in a single request, pass an array of strings or array
             * of token arrays. Each input must not exceed 8192 tokens in length.
             */
            @JsonProperty("input") fun input(input: Input) = apply { this.input = input }

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

            fun build(): EmbeddingCreateBody =
                EmbeddingCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    checkNotNull(input) { "`input` is required but was not set" },
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

        return other is EmbeddingCreateParams &&
            this.model == other.model &&
            this.input == other.input &&
            this.user == other.user &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            model,
            input,
            user,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "EmbeddingCreateParams{model=$model, input=$input, user=$user, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: String? = null
        private var input: Input? = null
        private var user: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(embeddingCreateParams: EmbeddingCreateParams) = apply {
            this.model = embeddingCreateParams.model
            this.input = embeddingCreateParams.input
            this.user = embeddingCreateParams.user
            additionalQueryParams(embeddingCreateParams.additionalQueryParams)
            additionalHeaders(embeddingCreateParams.additionalHeaders)
            additionalBodyProperties(embeddingCreateParams.additionalBodyProperties)
        }

        /**
         * ID of the model to use. You can use the [List models](/docs/api-reference/models/list)
         * API to see all of your available models, or see our
         * [Model overview](/docs/models/overview) for descriptions of them.
         */
        fun model(model: String) = apply { this.model = model }

        /**
         * Input text to get embeddings for, encoded as a string or array of tokens. To get
         * embeddings for multiple inputs in a single request, pass an array of strings or array of
         * token arrays. Each input must not exceed 8192 tokens in length.
         */
        fun input(input: Input) = apply { this.input = input }

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

        fun build(): EmbeddingCreateParams =
            EmbeddingCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                checkNotNull(input) { "`input` is required but was not set" },
                user,
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
        private val longs: List<Long>? = null,
        private val listLongS: List<List<Long>>? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        fun string(): Optional<String> = Optional.ofNullable(string)
        fun strings(): Optional<List<String>> = Optional.ofNullable(strings)
        fun longs(): Optional<List<Long>> = Optional.ofNullable(longs)
        fun listLongS(): Optional<List<List<Long>>> = Optional.ofNullable(listLongS)

        fun isString(): Boolean = string != null
        fun isStrings(): Boolean = strings != null
        fun isLongs(): Boolean = longs != null
        fun isListLongS(): Boolean = listLongS != null

        fun asString(): String = string.getOrThrow("string")
        fun asStrings(): List<String> = strings.getOrThrow("strings")
        fun asLongs(): List<Long> = longs.getOrThrow("longs")
        fun asListLongS(): List<List<Long>> = listLongS.getOrThrow("listLongS")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                strings != null -> visitor.visitStrings(strings)
                longs != null -> visitor.visitLongs(longs)
                listLongS != null -> visitor.visitListLongS(listLongS)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Input = apply {
            if (!validated) {
                if (string == null && strings == null && longs == null && listLongS == null) {
                    throw OpenAiInvalidDataException("Unknown Input: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Input &&
                this.string == other.string &&
                this.strings == other.strings &&
                this.longs == other.longs &&
                this.listLongS == other.listLongS
        }

        override fun hashCode(): Int {
            return Objects.hash(
                string,
                strings,
                longs,
                listLongS,
            )
        }

        override fun toString(): String {
            return when {
                string != null -> "Input{string=$string}"
                strings != null -> "Input{strings=$strings}"
                longs != null -> "Input{longs=$longs}"
                listLongS != null -> "Input{listLongS=$listLongS}"
                _json != null -> "Input{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Input")
            }
        }

        companion object {

            @JvmStatic fun ofString(string: String) = Input(string = string)

            @JvmStatic fun ofStrings(strings: List<String>) = Input(strings = strings)

            @JvmStatic fun ofLongs(longs: List<Long>) = Input(longs = longs)

            @JvmStatic fun ofListLongS(listLongS: List<List<Long>>) = Input(listLongS = listLongS)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<@JvmSuppressWildcards String>): T

            fun visitLongs(longs: List<@JvmSuppressWildcards Long>): T

            fun visitListLongS(listLongS: List<@JvmSuppressWildcards List<Long>>): T

            fun unknown(json: JsonValue?): T {
                throw OpenAiInvalidDataException("Unknown Input: $json")
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
                tryDeserialize(node, jacksonTypeRef<List<Long>>())?.let {
                    return Input(longs = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<List<Long>>>())?.let {
                    return Input(listLongS = it, _json = json)
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
                    value.longs != null -> generator.writeObject(value.longs)
                    value.listLongS != null -> generator.writeObject(value.listLongS)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Input")
                }
            }
        }
    }
}
