package com.openai.api.models

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
import com.openai.api.core.BaseDeserializer
import com.openai.api.core.BaseSerializer
import com.openai.api.core.ExcludeMissing
import com.openai.api.core.JsonField
import com.openai.api.core.JsonValue
import com.openai.api.core.NoAutoDetect
import com.openai.api.core.getOrThrow
import com.openai.api.core.toUnmodifiable
import com.openai.api.errors.OpenAiInvalidDataException
import com.openai.api.models.*
import java.util.Objects
import java.util.Optional

class ChatCompletionCreateParams
constructor(
    private val model: String,
    private val messages: List<ChatCompletionRequestMessage>,
    private val temperature: Double?,
    private val topP: Double?,
    private val n: Long?,
    private val stream: Boolean?,
    private val stop: Stop?,
    private val maxTokens: Long?,
    private val presencePenalty: Double?,
    private val frequencyPenalty: Double?,
    private val logitBias: JsonValue?,
    private val user: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): String = model

    fun messages(): List<ChatCompletionRequestMessage> = messages

    fun temperature(): Optional<Double> = Optional.ofNullable(temperature)

    fun topP(): Optional<Double> = Optional.ofNullable(topP)

    fun n(): Optional<Long> = Optional.ofNullable(n)

    fun stream(): Optional<Boolean> = Optional.ofNullable(stream)

    fun stop(): Optional<Stop> = Optional.ofNullable(stop)

    fun maxTokens(): Optional<Long> = Optional.ofNullable(maxTokens)

    fun presencePenalty(): Optional<Double> = Optional.ofNullable(presencePenalty)

    fun frequencyPenalty(): Optional<Double> = Optional.ofNullable(frequencyPenalty)

    fun logitBias(): Optional<JsonValue> = Optional.ofNullable(logitBias)

    fun user(): Optional<String> = Optional.ofNullable(user)

    @JvmSynthetic
    internal fun getBody(): ChatCompletionCreateBody {
        return ChatCompletionCreateBody(
            model,
            messages,
            temperature,
            topP,
            n,
            stream,
            stop,
            maxTokens,
            presencePenalty,
            frequencyPenalty,
            logitBias,
            user,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = ChatCompletionCreateBody.Builder::class)
    @NoAutoDetect
    class ChatCompletionCreateBody
    internal constructor(
        private val model: String?,
        private val messages: List<ChatCompletionRequestMessage>?,
        private val temperature: Double?,
        private val topP: Double?,
        private val n: Long?,
        private val stream: Boolean?,
        private val stop: Stop?,
        private val maxTokens: Long?,
        private val presencePenalty: Double?,
        private val frequencyPenalty: Double?,
        private val logitBias: JsonValue?,
        private val user: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * ID of the model to use. Currently, only `gpt-3.5-turbo` and `gpt-3.5-turbo-0301` are
         * supported.
         */
        @JsonProperty("model") fun model(): String? = model

        /**
         * The messages to generate chat completions for, in the
         * [chat format](/docs/guides/chat/introduction).
         */
        @JsonProperty("messages") fun messages(): List<ChatCompletionRequestMessage>? = messages

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         *
         * We generally recommend altering this or `top_p` but not both.
         */
        @JsonProperty("temperature") fun temperature(): Double? = temperature

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         */
        @JsonProperty("top_p") fun topP(): Double? = topP

        /** How many chat completion choices to generate for each input message. */
        @JsonProperty("n") fun n(): Long? = n

        /**
         * If set, partial message deltas will be sent, like in ChatGPT. Tokens will be sent as
         * data-only
         * [server-sent events](https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events#Event_stream_format)
         * as they become available, with the stream terminated by a `data: [DONE]` message.
         */
        @JsonProperty("stream") fun stream(): Boolean? = stream

        /** Up to 4 sequences where the API will stop generating further tokens. */
        @JsonProperty("stop") fun stop(): Stop? = stop

        /**
         * The maximum number of tokens allowed for the generated answer. By default, the number of
         * tokens the model can return will be (4096 - prompt tokens).
         */
        @JsonProperty("max_tokens") fun maxTokens(): Long? = maxTokens

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they
         * appear in the text so far, increasing the model's likelihood to talk about new topics.
         *
         * [See more information about frequency and presence penalties.](/docs/api-reference/parameter-details)
         */
        @JsonProperty("presence_penalty") fun presencePenalty(): Double? = presencePenalty

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing
         * frequency in the text so far, decreasing the model's likelihood to repeat the same line
         * verbatim.
         *
         * [See more information about frequency and presence penalties.](/docs/api-reference/parameter-details)
         */
        @JsonProperty("frequency_penalty") fun frequencyPenalty(): Double? = frequencyPenalty

        /**
         * Modify the likelihood of specified tokens appearing in the completion.
         *
         * Accepts a json object that maps tokens (specified by their token ID in the tokenizer) to
         * an associated bias value from -100 to 100. Mathematically, the bias is added to the
         * logits generated by the model prior to sampling. The exact effect will vary per model,
         * but values between -1 and 1 should decrease or increase likelihood of selection; values
         * like -100 or 100 should result in a ban or exclusive selection of the relevant token.
         */
        @JsonProperty("logit_bias") fun logitBias(): JsonValue? = logitBias

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

            return other is ChatCompletionCreateBody &&
                this.model == other.model &&
                this.messages == other.messages &&
                this.temperature == other.temperature &&
                this.topP == other.topP &&
                this.n == other.n &&
                this.stream == other.stream &&
                this.stop == other.stop &&
                this.maxTokens == other.maxTokens &&
                this.presencePenalty == other.presencePenalty &&
                this.frequencyPenalty == other.frequencyPenalty &&
                this.logitBias == other.logitBias &&
                this.user == other.user &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        model,
                        messages,
                        temperature,
                        topP,
                        n,
                        stream,
                        stop,
                        maxTokens,
                        presencePenalty,
                        frequencyPenalty,
                        logitBias,
                        user,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ChatCompletionCreateBody{model=$model, messages=$messages, temperature=$temperature, topP=$topP, n=$n, stream=$stream, stop=$stop, maxTokens=$maxTokens, presencePenalty=$presencePenalty, frequencyPenalty=$frequencyPenalty, logitBias=$logitBias, user=$user, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: String? = null
            private var messages: List<ChatCompletionRequestMessage>? = null
            private var temperature: Double? = null
            private var topP: Double? = null
            private var n: Long? = null
            private var stream: Boolean? = null
            private var stop: Stop? = null
            private var maxTokens: Long? = null
            private var presencePenalty: Double? = null
            private var frequencyPenalty: Double? = null
            private var logitBias: JsonValue? = null
            private var user: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(chatCompletionCreateBody: ChatCompletionCreateBody) = apply {
                this.model = chatCompletionCreateBody.model
                this.messages = chatCompletionCreateBody.messages
                this.temperature = chatCompletionCreateBody.temperature
                this.topP = chatCompletionCreateBody.topP
                this.n = chatCompletionCreateBody.n
                this.stream = chatCompletionCreateBody.stream
                this.stop = chatCompletionCreateBody.stop
                this.maxTokens = chatCompletionCreateBody.maxTokens
                this.presencePenalty = chatCompletionCreateBody.presencePenalty
                this.frequencyPenalty = chatCompletionCreateBody.frequencyPenalty
                this.logitBias = chatCompletionCreateBody.logitBias
                this.user = chatCompletionCreateBody.user
                additionalProperties(chatCompletionCreateBody.additionalProperties)
            }

            /**
             * ID of the model to use. Currently, only `gpt-3.5-turbo` and `gpt-3.5-turbo-0301` are
             * supported.
             */
            @JsonProperty("model") fun model(model: String) = apply { this.model = model }

            /**
             * The messages to generate chat completions for, in the
             * [chat format](/docs/guides/chat/introduction).
             */
            @JsonProperty("messages")
            fun messages(messages: List<ChatCompletionRequestMessage>) = apply {
                this.messages = messages
            }

            /**
             * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make
             * the output more random, while lower values like 0.2 will make it more focused and
             * deterministic.
             *
             * We generally recommend altering this or `top_p` but not both.
             */
            @JsonProperty("temperature")
            fun temperature(temperature: Double) = apply { this.temperature = temperature }

            /**
             * An alternative to sampling with temperature, called nucleus sampling, where the model
             * considers the results of the tokens with top_p probability mass. So 0.1 means only
             * the tokens comprising the top 10% probability mass are considered.
             *
             * We generally recommend altering this or `temperature` but not both.
             */
            @JsonProperty("top_p") fun topP(topP: Double) = apply { this.topP = topP }

            /** How many chat completion choices to generate for each input message. */
            @JsonProperty("n") fun n(n: Long) = apply { this.n = n }

            /**
             * If set, partial message deltas will be sent, like in ChatGPT. Tokens will be sent as
             * data-only
             * [server-sent events](https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events#Event_stream_format)
             * as they become available, with the stream terminated by a `data: [DONE]` message.
             */
            @JsonProperty("stream") fun stream(stream: Boolean) = apply { this.stream = stream }

            /** Up to 4 sequences where the API will stop generating further tokens. */
            @JsonProperty("stop") fun stop(stop: Stop) = apply { this.stop = stop }

            /**
             * The maximum number of tokens allowed for the generated answer. By default, the number
             * of tokens the model can return will be (4096 - prompt tokens).
             */
            @JsonProperty("max_tokens")
            fun maxTokens(maxTokens: Long) = apply { this.maxTokens = maxTokens }

            /**
             * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether
             * they appear in the text so far, increasing the model's likelihood to talk about new
             * topics.
             *
             * [See more information about frequency and presence penalties.](/docs/api-reference/parameter-details)
             */
            @JsonProperty("presence_penalty")
            fun presencePenalty(presencePenalty: Double) = apply {
                this.presencePenalty = presencePenalty
            }

            /**
             * Number between -2.0 and 2.0. Positive values penalize new tokens based on their
             * existing frequency in the text so far, decreasing the model's likelihood to repeat
             * the same line verbatim.
             *
             * [See more information about frequency and presence penalties.](/docs/api-reference/parameter-details)
             */
            @JsonProperty("frequency_penalty")
            fun frequencyPenalty(frequencyPenalty: Double) = apply {
                this.frequencyPenalty = frequencyPenalty
            }

            /**
             * Modify the likelihood of specified tokens appearing in the completion.
             *
             * Accepts a json object that maps tokens (specified by their token ID in the tokenizer)
             * to an associated bias value from -100 to 100. Mathematically, the bias is added to
             * the logits generated by the model prior to sampling. The exact effect will vary per
             * model, but values between -1 and 1 should decrease or increase likelihood of
             * selection; values like -100 or 100 should result in a ban or exclusive selection of
             * the relevant token.
             */
            @JsonProperty("logit_bias")
            fun logitBias(logitBias: JsonValue) = apply { this.logitBias = logitBias }

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

            fun build(): ChatCompletionCreateBody =
                ChatCompletionCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    checkNotNull(messages) { "`messages` is required but was not set" }
                        .toUnmodifiable(),
                    temperature,
                    topP,
                    n,
                    stream,
                    stop,
                    maxTokens,
                    presencePenalty,
                    frequencyPenalty,
                    logitBias,
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

        return other is ChatCompletionCreateParams &&
            this.model == other.model &&
            this.messages == other.messages &&
            this.temperature == other.temperature &&
            this.topP == other.topP &&
            this.n == other.n &&
            this.stream == other.stream &&
            this.stop == other.stop &&
            this.maxTokens == other.maxTokens &&
            this.presencePenalty == other.presencePenalty &&
            this.frequencyPenalty == other.frequencyPenalty &&
            this.logitBias == other.logitBias &&
            this.user == other.user &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            model,
            messages,
            temperature,
            topP,
            n,
            stream,
            stop,
            maxTokens,
            presencePenalty,
            frequencyPenalty,
            logitBias,
            user,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "ChatCompletionCreateParams{model=$model, messages=$messages, temperature=$temperature, topP=$topP, n=$n, stream=$stream, stop=$stop, maxTokens=$maxTokens, presencePenalty=$presencePenalty, frequencyPenalty=$frequencyPenalty, logitBias=$logitBias, user=$user, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: String? = null
        private var messages: List<ChatCompletionRequestMessage>? = null
        private var temperature: Double? = null
        private var topP: Double? = null
        private var n: Long? = null
        private var stream: Boolean? = null
        private var stop: Stop? = null
        private var maxTokens: Long? = null
        private var presencePenalty: Double? = null
        private var frequencyPenalty: Double? = null
        private var logitBias: JsonValue? = null
        private var user: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionCreateParams: ChatCompletionCreateParams) = apply {
            this.model = chatCompletionCreateParams.model
            this.messages = chatCompletionCreateParams.messages
            this.temperature = chatCompletionCreateParams.temperature
            this.topP = chatCompletionCreateParams.topP
            this.n = chatCompletionCreateParams.n
            this.stream = chatCompletionCreateParams.stream
            this.stop = chatCompletionCreateParams.stop
            this.maxTokens = chatCompletionCreateParams.maxTokens
            this.presencePenalty = chatCompletionCreateParams.presencePenalty
            this.frequencyPenalty = chatCompletionCreateParams.frequencyPenalty
            this.logitBias = chatCompletionCreateParams.logitBias
            this.user = chatCompletionCreateParams.user
            additionalQueryParams(chatCompletionCreateParams.additionalQueryParams)
            additionalHeaders(chatCompletionCreateParams.additionalHeaders)
            additionalBodyProperties(chatCompletionCreateParams.additionalBodyProperties)
        }

        /**
         * ID of the model to use. Currently, only `gpt-3.5-turbo` and `gpt-3.5-turbo-0301` are
         * supported.
         */
        fun model(model: String) = apply { this.model = model }

        /**
         * The messages to generate chat completions for, in the
         * [chat format](/docs/guides/chat/introduction).
         */
        fun messages(messages: List<ChatCompletionRequestMessage>) = apply {
            this.messages = messages
        }

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         *
         * We generally recommend altering this or `top_p` but not both.
         */
        fun temperature(temperature: Double) = apply { this.temperature = temperature }

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         */
        fun topP(topP: Double) = apply { this.topP = topP }

        /** How many chat completion choices to generate for each input message. */
        fun n(n: Long) = apply { this.n = n }

        /**
         * If set, partial message deltas will be sent, like in ChatGPT. Tokens will be sent as
         * data-only
         * [server-sent events](https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events#Event_stream_format)
         * as they become available, with the stream terminated by a `data: [DONE]` message.
         */
        fun stream(stream: Boolean) = apply { this.stream = stream }

        /** Up to 4 sequences where the API will stop generating further tokens. */
        fun stop(stop: Stop) = apply { this.stop = stop }

        /**
         * The maximum number of tokens allowed for the generated answer. By default, the number of
         * tokens the model can return will be (4096 - prompt tokens).
         */
        fun maxTokens(maxTokens: Long) = apply { this.maxTokens = maxTokens }

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they
         * appear in the text so far, increasing the model's likelihood to talk about new topics.
         *
         * [See more information about frequency and presence penalties.](/docs/api-reference/parameter-details)
         */
        fun presencePenalty(presencePenalty: Double) = apply {
            this.presencePenalty = presencePenalty
        }

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing
         * frequency in the text so far, decreasing the model's likelihood to repeat the same line
         * verbatim.
         *
         * [See more information about frequency and presence penalties.](/docs/api-reference/parameter-details)
         */
        fun frequencyPenalty(frequencyPenalty: Double) = apply {
            this.frequencyPenalty = frequencyPenalty
        }

        /**
         * Modify the likelihood of specified tokens appearing in the completion.
         *
         * Accepts a json object that maps tokens (specified by their token ID in the tokenizer) to
         * an associated bias value from -100 to 100. Mathematically, the bias is added to the
         * logits generated by the model prior to sampling. The exact effect will vary per model,
         * but values between -1 and 1 should decrease or increase likelihood of selection; values
         * like -100 or 100 should result in a ban or exclusive selection of the relevant token.
         */
        fun logitBias(logitBias: JsonValue) = apply { this.logitBias = logitBias }

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

        fun build(): ChatCompletionCreateParams =
            ChatCompletionCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                checkNotNull(messages) { "`messages` is required but was not set" }
                    .toUnmodifiable(),
                temperature,
                topP,
                n,
                stream,
                stop,
                maxTokens,
                presencePenalty,
                frequencyPenalty,
                logitBias,
                user,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = ChatCompletionRequestMessage.Builder::class)
    @NoAutoDetect
    class ChatCompletionRequestMessage
    private constructor(
        private val role: Role?,
        private val content: String?,
        private val name: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The role of the author of this message. */
        @JsonProperty("role") fun role(): Role? = role

        /** The contents of the message */
        @JsonProperty("content") fun content(): String? = content

        /** The name of the user in a multi-user chat */
        @JsonProperty("name") fun name(): String? = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ChatCompletionRequestMessage &&
                this.role == other.role &&
                this.content == other.content &&
                this.name == other.name &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        role,
                        content,
                        name,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ChatCompletionRequestMessage{role=$role, content=$content, name=$name, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var role: Role? = null
            private var content: String? = null
            private var name: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(chatCompletionRequestMessage: ChatCompletionRequestMessage) = apply {
                this.role = chatCompletionRequestMessage.role
                this.content = chatCompletionRequestMessage.content
                this.name = chatCompletionRequestMessage.name
                additionalProperties(chatCompletionRequestMessage.additionalProperties)
            }

            /** The role of the author of this message. */
            @JsonProperty("role") fun role(role: Role) = apply { this.role = role }

            /** The contents of the message */
            @JsonProperty("content") fun content(content: String) = apply { this.content = content }

            /** The name of the user in a multi-user chat */
            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

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

            fun build(): ChatCompletionRequestMessage =
                ChatCompletionRequestMessage(
                    checkNotNull(role) { "`role` is required but was not set" },
                    checkNotNull(content) { "`content` is required but was not set" },
                    name,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class Role
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Role && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val SYSTEM = Role(JsonField.of("system"))

                @JvmField val USER = Role(JsonField.of("user"))

                @JvmField val ASSISTANT = Role(JsonField.of("assistant"))

                @JvmStatic fun of(value: String) = Role(JsonField.of(value))
            }

            enum class Known {
                SYSTEM,
                USER,
                ASSISTANT,
            }

            enum class Value {
                SYSTEM,
                USER,
                ASSISTANT,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    SYSTEM -> Value.SYSTEM
                    USER -> Value.USER
                    ASSISTANT -> Value.ASSISTANT
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    SYSTEM -> Known.SYSTEM
                    USER -> Known.USER
                    ASSISTANT -> Known.ASSISTANT
                    else -> throw OpenAiInvalidDataException("Unknown Role: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }

    @JsonDeserialize(using = Stop.Deserializer::class)
    @JsonSerialize(using = Stop.Serializer::class)
    class Stop
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

        fun validate(): Stop = apply {
            if (!validated) {
                if (string == null && strings == null) {
                    throw OpenAiInvalidDataException("Unknown Stop: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Stop && this.string == other.string && this.strings == other.strings
        }

        override fun hashCode(): Int {
            return Objects.hash(string, strings)
        }

        override fun toString(): String {
            return when {
                string != null -> "Stop{string=$string}"
                strings != null -> "Stop{strings=$strings}"
                _json != null -> "Stop{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Stop")
            }
        }

        companion object {

            @JvmStatic fun ofString(string: String) = Stop(string = string)

            @JvmStatic fun ofStrings(strings: List<String>) = Stop(strings = strings)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<@JvmSuppressWildcards String>): T

            fun unknown(json: JsonValue?): T {
                throw OpenAiInvalidDataException("Unknown Stop: $json")
            }
        }

        class Deserializer : BaseDeserializer<Stop>(Stop::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Stop {
                val json = JsonValue.fromJsonNode(node)
                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Stop(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                    return Stop(strings = it, _json = json)
                }

                return Stop(_json = json)
            }
        }

        class Serializer : BaseSerializer<Stop>(Stop::class) {

            override fun serialize(
                value: Stop,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.strings != null -> generator.writeObject(value.strings)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Stop")
                }
            }
        }
    }
}
