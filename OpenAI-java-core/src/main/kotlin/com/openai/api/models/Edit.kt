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
import java.util.Optional

@JsonDeserialize(builder = Edit.Builder::class)
@NoAutoDetect
class Edit
private constructor(
    private val object_: JsonField<String>,
    private val created: JsonField<Long>,
    private val choices: JsonField<List<Choice>>,
    private val usage: JsonField<Usage>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun object_(): String = object_.getRequired("object")

    fun created(): Long = created.getRequired("created")

    fun choices(): List<Choice> = choices.getRequired("choices")

    fun usage(): Usage = usage.getRequired("usage")

    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonProperty("created") @ExcludeMissing fun _created() = created

    @JsonProperty("choices") @ExcludeMissing fun _choices() = choices

    @JsonProperty("usage") @ExcludeMissing fun _usage() = usage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Edit = apply {
        if (!validated) {
            object_()
            created()
            choices().forEach { it.validate() }
            usage().validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Edit &&
            this.object_ == other.object_ &&
            this.created == other.created &&
            this.choices == other.choices &&
            this.usage == other.usage &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    object_,
                    created,
                    choices,
                    usage,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Edit{object_=$object_, created=$created, choices=$choices, usage=$usage, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var object_: JsonField<String> = JsonMissing.of()
        private var created: JsonField<Long> = JsonMissing.of()
        private var choices: JsonField<List<Choice>> = JsonMissing.of()
        private var usage: JsonField<Usage> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(edit: Edit) = apply {
            this.object_ = edit.object_
            this.created = edit.created
            this.choices = edit.choices
            this.usage = edit.usage
            additionalProperties(edit.additionalProperties)
        }

        fun object_(object_: String) = object_(JsonField.of(object_))

        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

        fun created(created: Long) = created(JsonField.of(created))

        @JsonProperty("created")
        @ExcludeMissing
        fun created(created: JsonField<Long>) = apply { this.created = created }

        fun choices(choices: List<Choice>) = choices(JsonField.of(choices))

        @JsonProperty("choices")
        @ExcludeMissing
        fun choices(choices: JsonField<List<Choice>>) = apply { this.choices = choices }

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

        fun build(): Edit =
            Edit(
                object_,
                created,
                choices.map { it.toUnmodifiable() },
                usage,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = Choice.Builder::class)
    @NoAutoDetect
    class Choice
    private constructor(
        private val text: JsonField<String>,
        private val index: JsonField<Long>,
        private val logprobs: JsonField<Logprobs>,
        private val finishReason: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun text(): Optional<String> = Optional.ofNullable(text.getNullable("text"))

        fun index(): Optional<Long> = Optional.ofNullable(index.getNullable("index"))

        fun logprobs(): Optional<Logprobs> = Optional.ofNullable(logprobs.getNullable("logprobs"))

        fun finishReason(): Optional<String> =
            Optional.ofNullable(finishReason.getNullable("finish_reason"))

        @JsonProperty("text") @ExcludeMissing fun _text() = text

        @JsonProperty("index") @ExcludeMissing fun _index() = index

        @JsonProperty("logprobs") @ExcludeMissing fun _logprobs() = logprobs

        @JsonProperty("finish_reason") @ExcludeMissing fun _finishReason() = finishReason

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Choice = apply {
            if (!validated) {
                text()
                index()
                logprobs().map { it.validate() }
                finishReason()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Choice &&
                this.text == other.text &&
                this.index == other.index &&
                this.logprobs == other.logprobs &&
                this.finishReason == other.finishReason &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        text,
                        index,
                        logprobs,
                        finishReason,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Choice{text=$text, index=$index, logprobs=$logprobs, finishReason=$finishReason, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var text: JsonField<String> = JsonMissing.of()
            private var index: JsonField<Long> = JsonMissing.of()
            private var logprobs: JsonField<Logprobs> = JsonMissing.of()
            private var finishReason: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(choice: Choice) = apply {
                this.text = choice.text
                this.index = choice.index
                this.logprobs = choice.logprobs
                this.finishReason = choice.finishReason
                additionalProperties(choice.additionalProperties)
            }

            fun text(text: String) = text(JsonField.of(text))

            @JsonProperty("text")
            @ExcludeMissing
            fun text(text: JsonField<String>) = apply { this.text = text }

            fun index(index: Long) = index(JsonField.of(index))

            @JsonProperty("index")
            @ExcludeMissing
            fun index(index: JsonField<Long>) = apply { this.index = index }

            fun logprobs(logprobs: Logprobs) = logprobs(JsonField.of(logprobs))

            @JsonProperty("logprobs")
            @ExcludeMissing
            fun logprobs(logprobs: JsonField<Logprobs>) = apply { this.logprobs = logprobs }

            fun finishReason(finishReason: String) = finishReason(JsonField.of(finishReason))

            @JsonProperty("finish_reason")
            @ExcludeMissing
            fun finishReason(finishReason: JsonField<String>) = apply {
                this.finishReason = finishReason
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

            fun build(): Choice =
                Choice(
                    text,
                    index,
                    logprobs,
                    finishReason,
                    additionalProperties.toUnmodifiable(),
                )
        }

        @JsonDeserialize(builder = Logprobs.Builder::class)
        @NoAutoDetect
        class Logprobs
        private constructor(
            private val tokens: JsonField<List<String>>,
            private val tokenLogprobs: JsonField<List<Double>>,
            private val topLogprobs: JsonField<List<JsonValue>>,
            private val textOffset: JsonField<List<Long>>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            fun tokens(): Optional<List<String>> = Optional.ofNullable(tokens.getNullable("tokens"))

            fun tokenLogprobs(): Optional<List<Double>> =
                Optional.ofNullable(tokenLogprobs.getNullable("token_logprobs"))

            fun topLogprobs(): Optional<List<JsonValue>> =
                Optional.ofNullable(topLogprobs.getNullable("top_logprobs"))

            fun textOffset(): Optional<List<Long>> =
                Optional.ofNullable(textOffset.getNullable("text_offset"))

            @JsonProperty("tokens") @ExcludeMissing fun _tokens() = tokens

            @JsonProperty("token_logprobs") @ExcludeMissing fun _tokenLogprobs() = tokenLogprobs

            @JsonProperty("top_logprobs") @ExcludeMissing fun _topLogprobs() = topLogprobs

            @JsonProperty("text_offset") @ExcludeMissing fun _textOffset() = textOffset

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): Logprobs = apply {
                if (!validated) {
                    tokens()
                    tokenLogprobs()
                    topLogprobs()
                    textOffset()
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Logprobs &&
                    this.tokens == other.tokens &&
                    this.tokenLogprobs == other.tokenLogprobs &&
                    this.topLogprobs == other.topLogprobs &&
                    this.textOffset == other.textOffset &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            tokens,
                            tokenLogprobs,
                            topLogprobs,
                            textOffset,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "Logprobs{tokens=$tokens, tokenLogprobs=$tokenLogprobs, topLogprobs=$topLogprobs, textOffset=$textOffset, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var tokens: JsonField<List<String>> = JsonMissing.of()
                private var tokenLogprobs: JsonField<List<Double>> = JsonMissing.of()
                private var topLogprobs: JsonField<List<JsonValue>> = JsonMissing.of()
                private var textOffset: JsonField<List<Long>> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(logprobs: Logprobs) = apply {
                    this.tokens = logprobs.tokens
                    this.tokenLogprobs = logprobs.tokenLogprobs
                    this.topLogprobs = logprobs.topLogprobs
                    this.textOffset = logprobs.textOffset
                    additionalProperties(logprobs.additionalProperties)
                }

                fun tokens(tokens: List<String>) = tokens(JsonField.of(tokens))

                @JsonProperty("tokens")
                @ExcludeMissing
                fun tokens(tokens: JsonField<List<String>>) = apply { this.tokens = tokens }

                fun tokenLogprobs(tokenLogprobs: List<Double>) =
                    tokenLogprobs(JsonField.of(tokenLogprobs))

                @JsonProperty("token_logprobs")
                @ExcludeMissing
                fun tokenLogprobs(tokenLogprobs: JsonField<List<Double>>) = apply {
                    this.tokenLogprobs = tokenLogprobs
                }

                fun topLogprobs(topLogprobs: List<JsonValue>) =
                    topLogprobs(JsonField.of(topLogprobs))

                @JsonProperty("top_logprobs")
                @ExcludeMissing
                fun topLogprobs(topLogprobs: JsonField<List<JsonValue>>) = apply {
                    this.topLogprobs = topLogprobs
                }

                fun textOffset(textOffset: List<Long>) = textOffset(JsonField.of(textOffset))

                @JsonProperty("text_offset")
                @ExcludeMissing
                fun textOffset(textOffset: JsonField<List<Long>>) = apply {
                    this.textOffset = textOffset
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    this.additionalProperties.putAll(additionalProperties)
                }

                @JsonAnySetter
                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    this.additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun build(): Logprobs =
                    Logprobs(
                        tokens.map { it.toUnmodifiable() },
                        tokenLogprobs.map { it.toUnmodifiable() },
                        topLogprobs.map { it.toUnmodifiable() },
                        textOffset.map { it.toUnmodifiable() },
                        additionalProperties.toUnmodifiable(),
                    )
            }
        }
    }

    @JsonDeserialize(builder = Usage.Builder::class)
    @NoAutoDetect
    class Usage
    private constructor(
        private val promptTokens: JsonField<Long>,
        private val completionTokens: JsonField<Long>,
        private val totalTokens: JsonField<Long>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun promptTokens(): Long = promptTokens.getRequired("prompt_tokens")

        fun completionTokens(): Long = completionTokens.getRequired("completion_tokens")

        fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

        @JsonProperty("prompt_tokens") @ExcludeMissing fun _promptTokens() = promptTokens

        @JsonProperty("completion_tokens")
        @ExcludeMissing
        fun _completionTokens() = completionTokens

        @JsonProperty("total_tokens") @ExcludeMissing fun _totalTokens() = totalTokens

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Usage = apply {
            if (!validated) {
                promptTokens()
                completionTokens()
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
                this.completionTokens == other.completionTokens &&
                this.totalTokens == other.totalTokens &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        promptTokens,
                        completionTokens,
                        totalTokens,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Usage{promptTokens=$promptTokens, completionTokens=$completionTokens, totalTokens=$totalTokens, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var promptTokens: JsonField<Long> = JsonMissing.of()
            private var completionTokens: JsonField<Long> = JsonMissing.of()
            private var totalTokens: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(usage: Usage) = apply {
                this.promptTokens = usage.promptTokens
                this.completionTokens = usage.completionTokens
                this.totalTokens = usage.totalTokens
                additionalProperties(usage.additionalProperties)
            }

            fun promptTokens(promptTokens: Long) = promptTokens(JsonField.of(promptTokens))

            @JsonProperty("prompt_tokens")
            @ExcludeMissing
            fun promptTokens(promptTokens: JsonField<Long>) = apply {
                this.promptTokens = promptTokens
            }

            fun completionTokens(completionTokens: Long) =
                completionTokens(JsonField.of(completionTokens))

            @JsonProperty("completion_tokens")
            @ExcludeMissing
            fun completionTokens(completionTokens: JsonField<Long>) = apply {
                this.completionTokens = completionTokens
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
                    completionTokens,
                    totalTokens,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
