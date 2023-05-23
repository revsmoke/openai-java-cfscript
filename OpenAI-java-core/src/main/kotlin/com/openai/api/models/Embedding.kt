package com.openai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.api.core.ExcludeMissing
import com.openai.api.core.JsonField
import com.openai.api.core.JsonMissing
import com.openai.api.core.JsonValue
import com.openai.api.core.NoAutoDetect
import com.openai.api.core.toUnmodifiable
import java.util.Objects

@JsonDeserialize(builder = Embedding.Builder::class)
@NoAutoDetect
class Embedding
private constructor(
    private val object_: JsonField<String>,
    private val model: JsonField<String>,
    private val data: JsonField<List<Data>>,
    private val usage: JsonField<Usage>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun object_(): String = object_.getRequired("object")

    fun model(): String = model.getRequired("model")

    fun data(): List<Data> = data.getRequired("data")

    fun usage(): Usage = usage.getRequired("usage")

    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonProperty("model") @ExcludeMissing fun _model() = model

    @JsonProperty("data") @ExcludeMissing fun _data() = data

    @JsonProperty("usage") @ExcludeMissing fun _usage() = usage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Embedding = apply {
        if (!validated) {
            object_()
            model()
            data().forEach { it.validate() }
            usage().validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Embedding &&
            this.object_ == other.object_ &&
            this.model == other.model &&
            this.data == other.data &&
            this.usage == other.usage &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    object_,
                    model,
                    data,
                    usage,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Embedding{object_=$object_, model=$model, data=$data, usage=$usage, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var object_: JsonField<String> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var data: JsonField<List<Data>> = JsonMissing.of()
        private var usage: JsonField<Usage> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(embedding: Embedding) = apply {
            this.object_ = embedding.object_
            this.model = embedding.model
            this.data = embedding.data
            this.usage = embedding.usage
            additionalProperties(embedding.additionalProperties)
        }

        fun object_(object_: String) = object_(JsonField.of(object_))

        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

        fun model(model: String) = model(JsonField.of(model))

        @JsonProperty("model")
        @ExcludeMissing
        fun model(model: JsonField<String>) = apply { this.model = model }

        fun data(data: List<Data>) = data(JsonField.of(data))

        @JsonProperty("data")
        @ExcludeMissing
        fun data(data: JsonField<List<Data>>) = apply { this.data = data }

        fun usage(usage: Usage) = usage(JsonField.of(usage))

        @JsonProperty("usage")
        @ExcludeMissing
        fun usage(usage: JsonField<Usage>) = apply { this.usage = usage }

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

        fun build(): Embedding =
            Embedding(
                object_,
                model,
                data.map { it.toUnmodifiable() },
                usage,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = Data.Builder::class)
    @NoAutoDetect
    class Data
    private constructor(
        private val index: JsonField<Long>,
        private val object_: JsonField<String>,
        private val embedding: JsonField<List<Double>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun index(): Long = index.getRequired("index")

        fun object_(): String = object_.getRequired("object")

        fun embedding(): List<Double> = embedding.getRequired("embedding")

        @JsonProperty("index") @ExcludeMissing fun _index() = index

        @JsonProperty("object") @ExcludeMissing fun _object_() = object_

        @JsonProperty("embedding") @ExcludeMissing fun _embedding() = embedding

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Data = apply {
            if (!validated) {
                index()
                object_()
                embedding()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                this.index == other.index &&
                this.object_ == other.object_ &&
                this.embedding == other.embedding &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        index,
                        object_,
                        embedding,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Data{index=$index, object_=$object_, embedding=$embedding, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var index: JsonField<Long> = JsonMissing.of()
            private var object_: JsonField<String> = JsonMissing.of()
            private var embedding: JsonField<List<Double>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                this.index = data.index
                this.object_ = data.object_
                this.embedding = data.embedding
                additionalProperties(data.additionalProperties)
            }

            fun index(index: Long) = index(JsonField.of(index))

            @JsonProperty("index")
            @ExcludeMissing
            fun index(index: JsonField<Long>) = apply { this.index = index }

            fun object_(object_: String) = object_(JsonField.of(object_))

            @JsonProperty("object")
            @ExcludeMissing
            fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

            fun embedding(embedding: List<Double>) = embedding(JsonField.of(embedding))

            @JsonProperty("embedding")
            @ExcludeMissing
            fun embedding(embedding: JsonField<List<Double>>) = apply { this.embedding = embedding }

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

            fun build(): Data =
                Data(
                    index,
                    object_,
                    embedding.map { it.toUnmodifiable() },
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    @JsonDeserialize(builder = Usage.Builder::class)
    @NoAutoDetect
    class Usage
    private constructor(
        private val promptTokens: JsonField<Long>,
        private val totalTokens: JsonField<Long>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun promptTokens(): Long = promptTokens.getRequired("prompt_tokens")

        fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

        @JsonProperty("prompt_tokens") @ExcludeMissing fun _promptTokens() = promptTokens

        @JsonProperty("total_tokens") @ExcludeMissing fun _totalTokens() = totalTokens

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Usage = apply {
            if (!validated) {
                promptTokens()
                totalTokens()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Usage &&
                this.promptTokens == other.promptTokens &&
                this.totalTokens == other.totalTokens &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        promptTokens,
                        totalTokens,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Usage{promptTokens=$promptTokens, totalTokens=$totalTokens, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var promptTokens: JsonField<Long> = JsonMissing.of()
            private var totalTokens: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(usage: Usage) = apply {
                this.promptTokens = usage.promptTokens
                this.totalTokens = usage.totalTokens
                additionalProperties(usage.additionalProperties)
            }

            fun promptTokens(promptTokens: Long) = promptTokens(JsonField.of(promptTokens))

            @JsonProperty("prompt_tokens")
            @ExcludeMissing
            fun promptTokens(promptTokens: JsonField<Long>) = apply {
                this.promptTokens = promptTokens
            }

            fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

            @JsonProperty("total_tokens")
            @ExcludeMissing
            fun totalTokens(totalTokens: JsonField<Long>) = apply { this.totalTokens = totalTokens }

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

            fun build(): Usage =
                Usage(
                    promptTokens,
                    totalTokens,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
