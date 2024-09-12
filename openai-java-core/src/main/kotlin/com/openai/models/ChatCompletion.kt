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
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toUnmodifiable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Represents a chat completion response returned by model, based on the provided input. */
@JsonDeserialize(builder = ChatCompletion.Builder::class)
@NoAutoDetect
class ChatCompletion
private constructor(
    private val id: JsonField<String>,
    private val choices: JsonField<List<Choice>>,
    private val created: JsonField<Long>,
    private val model: JsonField<String>,
    private val serviceTier: JsonField<ServiceTier>,
    private val systemFingerprint: JsonField<String>,
    private val object_: JsonField<Object>,
    private val usage: JsonField<Usage>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** A unique identifier for the chat completion. */
    fun id(): String = id.getRequired("id")

    /** A list of chat completion choices. Can be more than one if `n` is greater than 1. */
    fun choices(): List<Choice> = choices.getRequired("choices")

    /** The Unix timestamp (in seconds) of when the chat completion was created. */
    fun created(): Long = created.getRequired("created")

    /** The model used for the chat completion. */
    fun model(): String = model.getRequired("model")

    /**
     * The service tier used for processing the request. This field is only included if the
     * `service_tier` parameter is specified in the request.
     */
    fun serviceTier(): Optional<ServiceTier> =
        Optional.ofNullable(serviceTier.getNullable("service_tier"))

    /**
     * This fingerprint represents the backend configuration that the model runs with.
     *
     * Can be used in conjunction with the `seed` request parameter to understand when backend
     * changes have been made that might impact determinism.
     */
    fun systemFingerprint(): Optional<String> =
        Optional.ofNullable(systemFingerprint.getNullable("system_fingerprint"))

    /** The object type, which is always `chat.completion`. */
    fun object_(): Object = object_.getRequired("object")

    /** Usage statistics for the completion request. */
    fun usage(): Optional<Usage> = Optional.ofNullable(usage.getNullable("usage"))

    /** A unique identifier for the chat completion. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** A list of chat completion choices. Can be more than one if `n` is greater than 1. */
    @JsonProperty("choices") @ExcludeMissing fun _choices() = choices

    /** The Unix timestamp (in seconds) of when the chat completion was created. */
    @JsonProperty("created") @ExcludeMissing fun _created() = created

    /** The model used for the chat completion. */
    @JsonProperty("model") @ExcludeMissing fun _model() = model

    /**
     * The service tier used for processing the request. This field is only included if the
     * `service_tier` parameter is specified in the request.
     */
    @JsonProperty("service_tier") @ExcludeMissing fun _serviceTier() = serviceTier

    /**
     * This fingerprint represents the backend configuration that the model runs with.
     *
     * Can be used in conjunction with the `seed` request parameter to understand when backend
     * changes have been made that might impact determinism.
     */
    @JsonProperty("system_fingerprint") @ExcludeMissing fun _systemFingerprint() = systemFingerprint

    /** The object type, which is always `chat.completion`. */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /** Usage statistics for the completion request. */
    @JsonProperty("usage") @ExcludeMissing fun _usage() = usage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletion = apply {
        if (!validated) {
            id()
            choices().forEach { it.validate() }
            created()
            model()
            serviceTier()
            systemFingerprint()
            object_()
            usage().map { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatCompletion &&
            this.id == other.id &&
            this.choices == other.choices &&
            this.created == other.created &&
            this.model == other.model &&
            this.serviceTier == other.serviceTier &&
            this.systemFingerprint == other.systemFingerprint &&
            this.object_ == other.object_ &&
            this.usage == other.usage &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    choices,
                    created,
                    model,
                    serviceTier,
                    systemFingerprint,
                    object_,
                    usage,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "ChatCompletion{id=$id, choices=$choices, created=$created, model=$model, serviceTier=$serviceTier, systemFingerprint=$systemFingerprint, object_=$object_, usage=$usage, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var choices: JsonField<List<Choice>> = JsonMissing.of()
        private var created: JsonField<Long> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var serviceTier: JsonField<ServiceTier> = JsonMissing.of()
        private var systemFingerprint: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var usage: JsonField<Usage> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletion: ChatCompletion) = apply {
            this.id = chatCompletion.id
            this.choices = chatCompletion.choices
            this.created = chatCompletion.created
            this.model = chatCompletion.model
            this.serviceTier = chatCompletion.serviceTier
            this.systemFingerprint = chatCompletion.systemFingerprint
            this.object_ = chatCompletion.object_
            this.usage = chatCompletion.usage
            additionalProperties(chatCompletion.additionalProperties)
        }

        /** A unique identifier for the chat completion. */
        fun id(id: String) = id(JsonField.of(id))

        /** A unique identifier for the chat completion. */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** A list of chat completion choices. Can be more than one if `n` is greater than 1. */
        fun choices(choices: List<Choice>) = choices(JsonField.of(choices))

        /** A list of chat completion choices. Can be more than one if `n` is greater than 1. */
        @JsonProperty("choices")
        @ExcludeMissing
        fun choices(choices: JsonField<List<Choice>>) = apply { this.choices = choices }

        /** The Unix timestamp (in seconds) of when the chat completion was created. */
        fun created(created: Long) = created(JsonField.of(created))

        /** The Unix timestamp (in seconds) of when the chat completion was created. */
        @JsonProperty("created")
        @ExcludeMissing
        fun created(created: JsonField<Long>) = apply { this.created = created }

        /** The model used for the chat completion. */
        fun model(model: String) = model(JsonField.of(model))

        /** The model used for the chat completion. */
        @JsonProperty("model")
        @ExcludeMissing
        fun model(model: JsonField<String>) = apply { this.model = model }

        /**
         * The service tier used for processing the request. This field is only included if the
         * `service_tier` parameter is specified in the request.
         */
        fun serviceTier(serviceTier: ServiceTier) = serviceTier(JsonField.of(serviceTier))

        /**
         * The service tier used for processing the request. This field is only included if the
         * `service_tier` parameter is specified in the request.
         */
        @JsonProperty("service_tier")
        @ExcludeMissing
        fun serviceTier(serviceTier: JsonField<ServiceTier>) = apply {
            this.serviceTier = serviceTier
        }

        /**
         * This fingerprint represents the backend configuration that the model runs with.
         *
         * Can be used in conjunction with the `seed` request parameter to understand when backend
         * changes have been made that might impact determinism.
         */
        fun systemFingerprint(systemFingerprint: String) =
            systemFingerprint(JsonField.of(systemFingerprint))

        /**
         * This fingerprint represents the backend configuration that the model runs with.
         *
         * Can be used in conjunction with the `seed` request parameter to understand when backend
         * changes have been made that might impact determinism.
         */
        @JsonProperty("system_fingerprint")
        @ExcludeMissing
        fun systemFingerprint(systemFingerprint: JsonField<String>) = apply {
            this.systemFingerprint = systemFingerprint
        }

        /** The object type, which is always `chat.completion`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always `chat.completion`. */
        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** Usage statistics for the completion request. */
        fun usage(usage: Usage) = usage(JsonField.of(usage))

        /** Usage statistics for the completion request. */
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

        fun build(): ChatCompletion =
            ChatCompletion(
                id,
                choices.map { it.toUnmodifiable() },
                created,
                model,
                serviceTier,
                systemFingerprint,
                object_,
                usage,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = Choice.Builder::class)
    @NoAutoDetect
    class Choice
    private constructor(
        private val finishReason: JsonField<FinishReason>,
        private val index: JsonField<Long>,
        private val message: JsonField<ChatCompletionMessage>,
        private val logprobs: JsonField<Logprobs>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, `content_filter` if content was omitted due to a
         * flag from our content filters, `tool_calls` if the model called a tool, or
         * `function_call` (deprecated) if the model called a function.
         */
        fun finishReason(): FinishReason = finishReason.getRequired("finish_reason")

        /** The index of the choice in the list of choices. */
        fun index(): Long = index.getRequired("index")

        /** A chat completion message generated by the model. */
        fun message(): ChatCompletionMessage = message.getRequired("message")

        /** Log probability information for the choice. */
        fun logprobs(): Optional<Logprobs> = Optional.ofNullable(logprobs.getNullable("logprobs"))

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, `content_filter` if content was omitted due to a
         * flag from our content filters, `tool_calls` if the model called a tool, or
         * `function_call` (deprecated) if the model called a function.
         */
        @JsonProperty("finish_reason") @ExcludeMissing fun _finishReason() = finishReason

        /** The index of the choice in the list of choices. */
        @JsonProperty("index") @ExcludeMissing fun _index() = index

        /** A chat completion message generated by the model. */
        @JsonProperty("message") @ExcludeMissing fun _message() = message

        /** Log probability information for the choice. */
        @JsonProperty("logprobs") @ExcludeMissing fun _logprobs() = logprobs

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Choice = apply {
            if (!validated) {
                finishReason()
                index()
                message().validate()
                logprobs().map { it.validate() }
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Choice &&
                this.finishReason == other.finishReason &&
                this.index == other.index &&
                this.message == other.message &&
                this.logprobs == other.logprobs &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        finishReason,
                        index,
                        message,
                        logprobs,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Choice{finishReason=$finishReason, index=$index, message=$message, logprobs=$logprobs, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var finishReason: JsonField<FinishReason> = JsonMissing.of()
            private var index: JsonField<Long> = JsonMissing.of()
            private var message: JsonField<ChatCompletionMessage> = JsonMissing.of()
            private var logprobs: JsonField<Logprobs> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(choice: Choice) = apply {
                this.finishReason = choice.finishReason
                this.index = choice.index
                this.message = choice.message
                this.logprobs = choice.logprobs
                additionalProperties(choice.additionalProperties)
            }

            /**
             * The reason the model stopped generating tokens. This will be `stop` if the model hit
             * a natural stop point or a provided stop sequence, `length` if the maximum number of
             * tokens specified in the request was reached, `content_filter` if content was omitted
             * due to a flag from our content filters, `tool_calls` if the model called a tool, or
             * `function_call` (deprecated) if the model called a function.
             */
            fun finishReason(finishReason: FinishReason) = finishReason(JsonField.of(finishReason))

            /**
             * The reason the model stopped generating tokens. This will be `stop` if the model hit
             * a natural stop point or a provided stop sequence, `length` if the maximum number of
             * tokens specified in the request was reached, `content_filter` if content was omitted
             * due to a flag from our content filters, `tool_calls` if the model called a tool, or
             * `function_call` (deprecated) if the model called a function.
             */
            @JsonProperty("finish_reason")
            @ExcludeMissing
            fun finishReason(finishReason: JsonField<FinishReason>) = apply {
                this.finishReason = finishReason
            }

            /** The index of the choice in the list of choices. */
            fun index(index: Long) = index(JsonField.of(index))

            /** The index of the choice in the list of choices. */
            @JsonProperty("index")
            @ExcludeMissing
            fun index(index: JsonField<Long>) = apply { this.index = index }

            /** A chat completion message generated by the model. */
            fun message(message: ChatCompletionMessage) = message(JsonField.of(message))

            /** A chat completion message generated by the model. */
            @JsonProperty("message")
            @ExcludeMissing
            fun message(message: JsonField<ChatCompletionMessage>) = apply {
                this.message = message
            }

            /** Log probability information for the choice. */
            fun logprobs(logprobs: Logprobs) = logprobs(JsonField.of(logprobs))

            /** Log probability information for the choice. */
            @JsonProperty("logprobs")
            @ExcludeMissing
            fun logprobs(logprobs: JsonField<Logprobs>) = apply { this.logprobs = logprobs }

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
                    finishReason,
                    index,
                    message,
                    logprobs,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class FinishReason
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is FinishReason && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val STOP = FinishReason(JsonField.of("stop"))

                @JvmField val LENGTH = FinishReason(JsonField.of("length"))

                @JvmField val TOOL_CALLS = FinishReason(JsonField.of("tool_calls"))

                @JvmField val CONTENT_FILTER = FinishReason(JsonField.of("content_filter"))

                @JvmField val FUNCTION_CALL = FinishReason(JsonField.of("function_call"))

                @JvmStatic fun of(value: String) = FinishReason(JsonField.of(value))
            }

            enum class Known {
                STOP,
                LENGTH,
                TOOL_CALLS,
                CONTENT_FILTER,
                FUNCTION_CALL,
            }

            enum class Value {
                STOP,
                LENGTH,
                TOOL_CALLS,
                CONTENT_FILTER,
                FUNCTION_CALL,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    STOP -> Value.STOP
                    LENGTH -> Value.LENGTH
                    TOOL_CALLS -> Value.TOOL_CALLS
                    CONTENT_FILTER -> Value.CONTENT_FILTER
                    FUNCTION_CALL -> Value.FUNCTION_CALL
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    STOP -> Known.STOP
                    LENGTH -> Known.LENGTH
                    TOOL_CALLS -> Known.TOOL_CALLS
                    CONTENT_FILTER -> Known.CONTENT_FILTER
                    FUNCTION_CALL -> Known.FUNCTION_CALL
                    else -> throw OpenAIInvalidDataException("Unknown FinishReason: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }

        /** Log probability information for the choice. */
        @JsonDeserialize(builder = Logprobs.Builder::class)
        @NoAutoDetect
        class Logprobs
        private constructor(
            private val content: JsonField<List<ChatCompletionTokenLogprob>>,
            private val refusal: JsonField<List<ChatCompletionTokenLogprob>>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            /** A list of message content tokens with log probability information. */
            fun content(): Optional<List<ChatCompletionTokenLogprob>> =
                Optional.ofNullable(content.getNullable("content"))

            /** A list of message refusal tokens with log probability information. */
            fun refusal(): Optional<List<ChatCompletionTokenLogprob>> =
                Optional.ofNullable(refusal.getNullable("refusal"))

            /** A list of message content tokens with log probability information. */
            @JsonProperty("content") @ExcludeMissing fun _content() = content

            /** A list of message refusal tokens with log probability information. */
            @JsonProperty("refusal") @ExcludeMissing fun _refusal() = refusal

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): Logprobs = apply {
                if (!validated) {
                    content().map { it.forEach { it.validate() } }
                    refusal().map { it.forEach { it.validate() } }
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Logprobs &&
                    this.content == other.content &&
                    this.refusal == other.refusal &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            content,
                            refusal,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "Logprobs{content=$content, refusal=$refusal, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var content: JsonField<List<ChatCompletionTokenLogprob>> = JsonMissing.of()
                private var refusal: JsonField<List<ChatCompletionTokenLogprob>> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(logprobs: Logprobs) = apply {
                    this.content = logprobs.content
                    this.refusal = logprobs.refusal
                    additionalProperties(logprobs.additionalProperties)
                }

                /** A list of message content tokens with log probability information. */
                fun content(content: List<ChatCompletionTokenLogprob>) =
                    content(JsonField.of(content))

                /** A list of message content tokens with log probability information. */
                @JsonProperty("content")
                @ExcludeMissing
                fun content(content: JsonField<List<ChatCompletionTokenLogprob>>) = apply {
                    this.content = content
                }

                /** A list of message refusal tokens with log probability information. */
                fun refusal(refusal: List<ChatCompletionTokenLogprob>) =
                    refusal(JsonField.of(refusal))

                /** A list of message refusal tokens with log probability information. */
                @JsonProperty("refusal")
                @ExcludeMissing
                fun refusal(refusal: JsonField<List<ChatCompletionTokenLogprob>>) = apply {
                    this.refusal = refusal
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
                        content.map { it.toUnmodifiable() },
                        refusal.map { it.toUnmodifiable() },
                        additionalProperties.toUnmodifiable(),
                    )
            }
        }
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Object && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val CHAT_COMPLETION = Object(JsonField.of("chat.completion"))

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            CHAT_COMPLETION,
        }

        enum class Value {
            CHAT_COMPLETION,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                CHAT_COMPLETION -> Value.CHAT_COMPLETION
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                CHAT_COMPLETION -> Known.CHAT_COMPLETION
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class ServiceTier
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ServiceTier && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val SCALE = ServiceTier(JsonField.of("scale"))

            @JvmField val DEFAULT = ServiceTier(JsonField.of("default"))

            @JvmStatic fun of(value: String) = ServiceTier(JsonField.of(value))
        }

        enum class Known {
            SCALE,
            DEFAULT,
        }

        enum class Value {
            SCALE,
            DEFAULT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                SCALE -> Value.SCALE
                DEFAULT -> Value.DEFAULT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                SCALE -> Known.SCALE
                DEFAULT -> Known.DEFAULT
                else -> throw OpenAIInvalidDataException("Unknown ServiceTier: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    /** Usage statistics for the completion request. */
    @JsonDeserialize(builder = Usage.Builder::class)
    @NoAutoDetect
    class Usage
    private constructor(
        private val completionTokens: JsonField<Long>,
        private val promptTokens: JsonField<Long>,
        private val totalTokens: JsonField<Long>,
        private val completionTokensDetails: JsonField<CompletionTokensDetails>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /** Number of tokens in the generated completion. */
        fun completionTokens(): Long = completionTokens.getRequired("completion_tokens")

        /** Number of tokens in the prompt. */
        fun promptTokens(): Long = promptTokens.getRequired("prompt_tokens")

        /** Total number of tokens used in the request (prompt + completion). */
        fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

        /** Breakdown of tokens used in a completion. */
        fun completionTokensDetails(): Optional<CompletionTokensDetails> =
            Optional.ofNullable(completionTokensDetails.getNullable("completion_tokens_details"))

        /** Number of tokens in the generated completion. */
        @JsonProperty("completion_tokens")
        @ExcludeMissing
        fun _completionTokens() = completionTokens

        /** Number of tokens in the prompt. */
        @JsonProperty("prompt_tokens") @ExcludeMissing fun _promptTokens() = promptTokens

        /** Total number of tokens used in the request (prompt + completion). */
        @JsonProperty("total_tokens") @ExcludeMissing fun _totalTokens() = totalTokens

        /** Breakdown of tokens used in a completion. */
        @JsonProperty("completion_tokens_details")
        @ExcludeMissing
        fun _completionTokensDetails() = completionTokensDetails

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Usage = apply {
            if (!validated) {
                completionTokens()
                promptTokens()
                totalTokens()
                completionTokensDetails().map { it.validate() }
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Usage &&
                this.completionTokens == other.completionTokens &&
                this.promptTokens == other.promptTokens &&
                this.totalTokens == other.totalTokens &&
                this.completionTokensDetails == other.completionTokensDetails &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        completionTokens,
                        promptTokens,
                        totalTokens,
                        completionTokensDetails,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Usage{completionTokens=$completionTokens, promptTokens=$promptTokens, totalTokens=$totalTokens, completionTokensDetails=$completionTokensDetails, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var completionTokens: JsonField<Long> = JsonMissing.of()
            private var promptTokens: JsonField<Long> = JsonMissing.of()
            private var totalTokens: JsonField<Long> = JsonMissing.of()
            private var completionTokensDetails: JsonField<CompletionTokensDetails> =
                JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(usage: Usage) = apply {
                this.completionTokens = usage.completionTokens
                this.promptTokens = usage.promptTokens
                this.totalTokens = usage.totalTokens
                this.completionTokensDetails = usage.completionTokensDetails
                additionalProperties(usage.additionalProperties)
            }

            /** Number of tokens in the generated completion. */
            fun completionTokens(completionTokens: Long) =
                completionTokens(JsonField.of(completionTokens))

            /** Number of tokens in the generated completion. */
            @JsonProperty("completion_tokens")
            @ExcludeMissing
            fun completionTokens(completionTokens: JsonField<Long>) = apply {
                this.completionTokens = completionTokens
            }

            /** Number of tokens in the prompt. */
            fun promptTokens(promptTokens: Long) = promptTokens(JsonField.of(promptTokens))

            /** Number of tokens in the prompt. */
            @JsonProperty("prompt_tokens")
            @ExcludeMissing
            fun promptTokens(promptTokens: JsonField<Long>) = apply {
                this.promptTokens = promptTokens
            }

            /** Total number of tokens used in the request (prompt + completion). */
            fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

            /** Total number of tokens used in the request (prompt + completion). */
            @JsonProperty("total_tokens")
            @ExcludeMissing
            fun totalTokens(totalTokens: JsonField<Long>) = apply { this.totalTokens = totalTokens }

            /** Breakdown of tokens used in a completion. */
            fun completionTokensDetails(completionTokensDetails: CompletionTokensDetails) =
                completionTokensDetails(JsonField.of(completionTokensDetails))

            /** Breakdown of tokens used in a completion. */
            @JsonProperty("completion_tokens_details")
            @ExcludeMissing
            fun completionTokensDetails(
                completionTokensDetails: JsonField<CompletionTokensDetails>
            ) = apply { this.completionTokensDetails = completionTokensDetails }

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
                    completionTokens,
                    promptTokens,
                    totalTokens,
                    completionTokensDetails,
                    additionalProperties.toUnmodifiable(),
                )
        }

        /** Breakdown of tokens used in a completion. */
        @JsonDeserialize(builder = CompletionTokensDetails.Builder::class)
        @NoAutoDetect
        class CompletionTokensDetails
        private constructor(
            private val reasoningTokens: JsonField<Long>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            /** Tokens generated by the model for reasoning. */
            fun reasoningTokens(): Optional<Long> =
                Optional.ofNullable(reasoningTokens.getNullable("reasoning_tokens"))

            /** Tokens generated by the model for reasoning. */
            @JsonProperty("reasoning_tokens")
            @ExcludeMissing
            fun _reasoningTokens() = reasoningTokens

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): CompletionTokensDetails = apply {
                if (!validated) {
                    reasoningTokens()
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is CompletionTokensDetails &&
                    this.reasoningTokens == other.reasoningTokens &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode = Objects.hash(reasoningTokens, additionalProperties)
                }
                return hashCode
            }

            override fun toString() =
                "CompletionTokensDetails{reasoningTokens=$reasoningTokens, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var reasoningTokens: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(completionTokensDetails: CompletionTokensDetails) = apply {
                    this.reasoningTokens = completionTokensDetails.reasoningTokens
                    additionalProperties(completionTokensDetails.additionalProperties)
                }

                /** Tokens generated by the model for reasoning. */
                fun reasoningTokens(reasoningTokens: Long) =
                    reasoningTokens(JsonField.of(reasoningTokens))

                /** Tokens generated by the model for reasoning. */
                @JsonProperty("reasoning_tokens")
                @ExcludeMissing
                fun reasoningTokens(reasoningTokens: JsonField<Long>) = apply {
                    this.reasoningTokens = reasoningTokens
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

                fun build(): CompletionTokensDetails =
                    CompletionTokensDetails(reasoningTokens, additionalProperties.toUnmodifiable())
            }
        }
    }
}
