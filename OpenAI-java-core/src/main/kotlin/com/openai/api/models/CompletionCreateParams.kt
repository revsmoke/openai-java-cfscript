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

class CompletionCreateParams
constructor(
    private val model: String,
    private val prompt: Prompt?,
    private val suffix: String?,
    private val maxTokens: Long?,
    private val temperature: Double?,
    private val topP: Double?,
    private val n: Long?,
    private val stream: Boolean?,
    private val logprobs: Long?,
    private val echo: Boolean?,
    private val stop: Stop?,
    private val presencePenalty: Double?,
    private val frequencyPenalty: Double?,
    private val bestOf: Long?,
    private val logitBias: JsonValue?,
    private val user: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): String = model

    fun prompt(): Optional<Prompt> = Optional.ofNullable(prompt)

    fun suffix(): Optional<String> = Optional.ofNullable(suffix)

    fun maxTokens(): Optional<Long> = Optional.ofNullable(maxTokens)

    fun temperature(): Optional<Double> = Optional.ofNullable(temperature)

    fun topP(): Optional<Double> = Optional.ofNullable(topP)

    fun n(): Optional<Long> = Optional.ofNullable(n)

    fun stream(): Optional<Boolean> = Optional.ofNullable(stream)

    fun logprobs(): Optional<Long> = Optional.ofNullable(logprobs)

    fun echo(): Optional<Boolean> = Optional.ofNullable(echo)

    fun stop(): Optional<Stop> = Optional.ofNullable(stop)

    fun presencePenalty(): Optional<Double> = Optional.ofNullable(presencePenalty)

    fun frequencyPenalty(): Optional<Double> = Optional.ofNullable(frequencyPenalty)

    fun bestOf(): Optional<Long> = Optional.ofNullable(bestOf)

    fun logitBias(): Optional<JsonValue> = Optional.ofNullable(logitBias)

    fun user(): Optional<String> = Optional.ofNullable(user)

    @JvmSynthetic
    internal fun getBody(): CompletionCreateBody {
        return CompletionCreateBody(
            model,
            prompt,
            suffix,
            maxTokens,
            temperature,
            topP,
            n,
            stream,
            logprobs,
            echo,
            stop,
            presencePenalty,
            frequencyPenalty,
            bestOf,
            logitBias,
            user,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = CompletionCreateBody.Builder::class)
    @NoAutoDetect
    class CompletionCreateBody
    internal constructor(
        private val model: String?,
        private val prompt: Prompt?,
        private val suffix: String?,
        private val maxTokens: Long?,
        private val temperature: Double?,
        private val topP: Double?,
        private val n: Long?,
        private val stream: Boolean?,
        private val logprobs: Long?,
        private val echo: Boolean?,
        private val stop: Stop?,
        private val presencePenalty: Double?,
        private val frequencyPenalty: Double?,
        private val bestOf: Long?,
        private val logitBias: JsonValue?,
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
         * The prompt(s) to generate completions for, encoded as a string, array of strings, array
         * of tokens, or array of token arrays.
         *
         * Note that <|endoftext|> is the document separator that the model sees during training, so
         * if a prompt is not specified the model will generate as if from the beginning of a new
         * document.
         */
        @JsonProperty("prompt") fun prompt(): Prompt? = prompt

        /** The suffix that comes after a completion of inserted text. */
        @JsonProperty("suffix") fun suffix(): String? = suffix

        /**
         * The maximum number of [tokens](/tokenizer) to generate in the completion.
         *
         * The token count of your prompt plus `max_tokens` cannot exceed the model's context
         * length. Most models have a context length of 2048 tokens (except for the newest models,
         * which support 4096).
         */
        @JsonProperty("max_tokens") fun maxTokens(): Long? = maxTokens

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

        /**
         * How many completions to generate for each prompt.
         *
         * **Note:** Because this parameter generates many completions, it can quickly consume your
         * token quota. Use carefully and ensure that you have reasonable settings for `max_tokens`
         * and `stop`.
         */
        @JsonProperty("n") fun n(): Long? = n

        /**
         * Whether to stream back partial progress. If set, tokens will be sent as data-only
         * [server-sent events](https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events#Event_stream_format)
         * as they become available, with the stream terminated by a `data: [DONE]` message.
         */
        @JsonProperty("stream") fun stream(): Boolean? = stream

        /**
         * Include the log probabilities on the `logprobs` most likely tokens, as well the chosen
         * tokens. For example, if `logprobs` is 5, the API will return a list of the 5 most likely
         * tokens. The API will always return the `logprob` of the sampled token, so there may be up
         * to `logprobs+1` elements in the response.
         *
         * The maximum value for `logprobs` is 5. If you need more than this, please contact us
         * through our [Help center](https://help.openai.com) and describe your use case.
         */
        @JsonProperty("logprobs") fun logprobs(): Long? = logprobs

        /** Echo back the prompt in addition to the completion */
        @JsonProperty("echo") fun echo(): Boolean? = echo

        /**
         * Up to 4 sequences where the API will stop generating further tokens. The returned text
         * will not contain the stop sequence.
         */
        @JsonProperty("stop") fun stop(): Stop? = stop

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
         * Generates `best_of` completions server-side and returns the "best" (the one with the
         * highest log probability per token). Results cannot be streamed.
         *
         * When used with `n`, `best_of` controls the number of candidate completions and `n`
         * specifies how many to return – `best_of` must be greater than `n`.
         *
         * **Note:** Because this parameter generates many completions, it can quickly consume your
         * token quota. Use carefully and ensure that you have reasonable settings for `max_tokens`
         * and `stop`.
         */
        @JsonProperty("best_of") fun bestOf(): Long? = bestOf

        /**
         * Modify the likelihood of specified tokens appearing in the completion.
         *
         * Accepts a json object that maps tokens (specified by their token ID in the GPT tokenizer)
         * to an associated bias value from -100 to 100. You can use this
         * [tokenizer tool](/tokenizer?view=bpe) (which works for both GPT-2 and GPT-3) to convert
         * text to token IDs. Mathematically, the bias is added to the logits generated by the model
         * prior to sampling. The exact effect will vary per model, but values between -1 and 1
         * should decrease or increase likelihood of selection; values like -100 or 100 should
         * result in a ban or exclusive selection of the relevant token.
         *
         * As an example, you can pass `{"50256": -100}` to prevent the <|endoftext|> token from
         * being generated.
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

            return other is CompletionCreateBody &&
                this.model == other.model &&
                this.prompt == other.prompt &&
                this.suffix == other.suffix &&
                this.maxTokens == other.maxTokens &&
                this.temperature == other.temperature &&
                this.topP == other.topP &&
                this.n == other.n &&
                this.stream == other.stream &&
                this.logprobs == other.logprobs &&
                this.echo == other.echo &&
                this.stop == other.stop &&
                this.presencePenalty == other.presencePenalty &&
                this.frequencyPenalty == other.frequencyPenalty &&
                this.bestOf == other.bestOf &&
                this.logitBias == other.logitBias &&
                this.user == other.user &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        model,
                        prompt,
                        suffix,
                        maxTokens,
                        temperature,
                        topP,
                        n,
                        stream,
                        logprobs,
                        echo,
                        stop,
                        presencePenalty,
                        frequencyPenalty,
                        bestOf,
                        logitBias,
                        user,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CompletionCreateBody{model=$model, prompt=$prompt, suffix=$suffix, maxTokens=$maxTokens, temperature=$temperature, topP=$topP, n=$n, stream=$stream, logprobs=$logprobs, echo=$echo, stop=$stop, presencePenalty=$presencePenalty, frequencyPenalty=$frequencyPenalty, bestOf=$bestOf, logitBias=$logitBias, user=$user, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: String? = null
            private var prompt: Prompt? = null
            private var suffix: String? = null
            private var maxTokens: Long? = null
            private var temperature: Double? = null
            private var topP: Double? = null
            private var n: Long? = null
            private var stream: Boolean? = null
            private var logprobs: Long? = null
            private var echo: Boolean? = null
            private var stop: Stop? = null
            private var presencePenalty: Double? = null
            private var frequencyPenalty: Double? = null
            private var bestOf: Long? = null
            private var logitBias: JsonValue? = null
            private var user: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(completionCreateBody: CompletionCreateBody) = apply {
                this.model = completionCreateBody.model
                this.prompt = completionCreateBody.prompt
                this.suffix = completionCreateBody.suffix
                this.maxTokens = completionCreateBody.maxTokens
                this.temperature = completionCreateBody.temperature
                this.topP = completionCreateBody.topP
                this.n = completionCreateBody.n
                this.stream = completionCreateBody.stream
                this.logprobs = completionCreateBody.logprobs
                this.echo = completionCreateBody.echo
                this.stop = completionCreateBody.stop
                this.presencePenalty = completionCreateBody.presencePenalty
                this.frequencyPenalty = completionCreateBody.frequencyPenalty
                this.bestOf = completionCreateBody.bestOf
                this.logitBias = completionCreateBody.logitBias
                this.user = completionCreateBody.user
                additionalProperties(completionCreateBody.additionalProperties)
            }

            /**
             * ID of the model to use. You can use the
             * [List models](/docs/api-reference/models/list) API to see all of your available
             * models, or see our [Model overview](/docs/models/overview) for descriptions of them.
             */
            @JsonProperty("model") fun model(model: String) = apply { this.model = model }

            /**
             * The prompt(s) to generate completions for, encoded as a string, array of strings,
             * array of tokens, or array of token arrays.
             *
             * Note that <|endoftext|> is the document separator that the model sees during
             * training, so if a prompt is not specified the model will generate as if from the
             * beginning of a new document.
             */
            @JsonProperty("prompt") fun prompt(prompt: Prompt) = apply { this.prompt = prompt }

            /** The suffix that comes after a completion of inserted text. */
            @JsonProperty("suffix") fun suffix(suffix: String) = apply { this.suffix = suffix }

            /**
             * The maximum number of [tokens](/tokenizer) to generate in the completion.
             *
             * The token count of your prompt plus `max_tokens` cannot exceed the model's context
             * length. Most models have a context length of 2048 tokens (except for the newest
             * models, which support 4096).
             */
            @JsonProperty("max_tokens")
            fun maxTokens(maxTokens: Long) = apply { this.maxTokens = maxTokens }

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

            /**
             * How many completions to generate for each prompt.
             *
             * **Note:** Because this parameter generates many completions, it can quickly consume
             * your token quota. Use carefully and ensure that you have reasonable settings for
             * `max_tokens` and `stop`.
             */
            @JsonProperty("n") fun n(n: Long) = apply { this.n = n }

            /**
             * Whether to stream back partial progress. If set, tokens will be sent as data-only
             * [server-sent events](https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events#Event_stream_format)
             * as they become available, with the stream terminated by a `data: [DONE]` message.
             */
            @JsonProperty("stream") fun stream(stream: Boolean) = apply { this.stream = stream }

            /**
             * Include the log probabilities on the `logprobs` most likely tokens, as well the
             * chosen tokens. For example, if `logprobs` is 5, the API will return a list of the 5
             * most likely tokens. The API will always return the `logprob` of the sampled token, so
             * there may be up to `logprobs+1` elements in the response.
             *
             * The maximum value for `logprobs` is 5. If you need more than this, please contact us
             * through our [Help center](https://help.openai.com) and describe your use case.
             */
            @JsonProperty("logprobs")
            fun logprobs(logprobs: Long) = apply { this.logprobs = logprobs }

            /** Echo back the prompt in addition to the completion */
            @JsonProperty("echo") fun echo(echo: Boolean) = apply { this.echo = echo }

            /**
             * Up to 4 sequences where the API will stop generating further tokens. The returned
             * text will not contain the stop sequence.
             */
            @JsonProperty("stop") fun stop(stop: Stop) = apply { this.stop = stop }

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
             * Generates `best_of` completions server-side and returns the "best" (the one with the
             * highest log probability per token). Results cannot be streamed.
             *
             * When used with `n`, `best_of` controls the number of candidate completions and `n`
             * specifies how many to return – `best_of` must be greater than `n`.
             *
             * **Note:** Because this parameter generates many completions, it can quickly consume
             * your token quota. Use carefully and ensure that you have reasonable settings for
             * `max_tokens` and `stop`.
             */
            @JsonProperty("best_of") fun bestOf(bestOf: Long) = apply { this.bestOf = bestOf }

            /**
             * Modify the likelihood of specified tokens appearing in the completion.
             *
             * Accepts a json object that maps tokens (specified by their token ID in the GPT
             * tokenizer) to an associated bias value from -100 to 100. You can use this
             * [tokenizer tool](/tokenizer?view=bpe) (which works for both GPT-2 and GPT-3) to
             * convert text to token IDs. Mathematically, the bias is added to the logits generated
             * by the model prior to sampling. The exact effect will vary per model, but values
             * between -1 and 1 should decrease or increase likelihood of selection; values like
             * -100 or 100 should result in a ban or exclusive selection of the relevant token.
             *
             * As an example, you can pass `{"50256": -100}` to prevent the <|endoftext|> token from
             * being generated.
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

            fun build(): CompletionCreateBody =
                CompletionCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    prompt,
                    suffix,
                    maxTokens,
                    temperature,
                    topP,
                    n,
                    stream,
                    logprobs,
                    echo,
                    stop,
                    presencePenalty,
                    frequencyPenalty,
                    bestOf,
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

        return other is CompletionCreateParams &&
            this.model == other.model &&
            this.prompt == other.prompt &&
            this.suffix == other.suffix &&
            this.maxTokens == other.maxTokens &&
            this.temperature == other.temperature &&
            this.topP == other.topP &&
            this.n == other.n &&
            this.stream == other.stream &&
            this.logprobs == other.logprobs &&
            this.echo == other.echo &&
            this.stop == other.stop &&
            this.presencePenalty == other.presencePenalty &&
            this.frequencyPenalty == other.frequencyPenalty &&
            this.bestOf == other.bestOf &&
            this.logitBias == other.logitBias &&
            this.user == other.user &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            model,
            prompt,
            suffix,
            maxTokens,
            temperature,
            topP,
            n,
            stream,
            logprobs,
            echo,
            stop,
            presencePenalty,
            frequencyPenalty,
            bestOf,
            logitBias,
            user,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "CompletionCreateParams{model=$model, prompt=$prompt, suffix=$suffix, maxTokens=$maxTokens, temperature=$temperature, topP=$topP, n=$n, stream=$stream, logprobs=$logprobs, echo=$echo, stop=$stop, presencePenalty=$presencePenalty, frequencyPenalty=$frequencyPenalty, bestOf=$bestOf, logitBias=$logitBias, user=$user, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: String? = null
        private var prompt: Prompt? = null
        private var suffix: String? = null
        private var maxTokens: Long? = null
        private var temperature: Double? = null
        private var topP: Double? = null
        private var n: Long? = null
        private var stream: Boolean? = null
        private var logprobs: Long? = null
        private var echo: Boolean? = null
        private var stop: Stop? = null
        private var presencePenalty: Double? = null
        private var frequencyPenalty: Double? = null
        private var bestOf: Long? = null
        private var logitBias: JsonValue? = null
        private var user: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(completionCreateParams: CompletionCreateParams) = apply {
            this.model = completionCreateParams.model
            this.prompt = completionCreateParams.prompt
            this.suffix = completionCreateParams.suffix
            this.maxTokens = completionCreateParams.maxTokens
            this.temperature = completionCreateParams.temperature
            this.topP = completionCreateParams.topP
            this.n = completionCreateParams.n
            this.stream = completionCreateParams.stream
            this.logprobs = completionCreateParams.logprobs
            this.echo = completionCreateParams.echo
            this.stop = completionCreateParams.stop
            this.presencePenalty = completionCreateParams.presencePenalty
            this.frequencyPenalty = completionCreateParams.frequencyPenalty
            this.bestOf = completionCreateParams.bestOf
            this.logitBias = completionCreateParams.logitBias
            this.user = completionCreateParams.user
            additionalQueryParams(completionCreateParams.additionalQueryParams)
            additionalHeaders(completionCreateParams.additionalHeaders)
            additionalBodyProperties(completionCreateParams.additionalBodyProperties)
        }

        /**
         * ID of the model to use. You can use the [List models](/docs/api-reference/models/list)
         * API to see all of your available models, or see our
         * [Model overview](/docs/models/overview) for descriptions of them.
         */
        fun model(model: String) = apply { this.model = model }

        /**
         * The prompt(s) to generate completions for, encoded as a string, array of strings, array
         * of tokens, or array of token arrays.
         *
         * Note that <|endoftext|> is the document separator that the model sees during training, so
         * if a prompt is not specified the model will generate as if from the beginning of a new
         * document.
         */
        fun prompt(prompt: Prompt) = apply { this.prompt = prompt }

        /** The suffix that comes after a completion of inserted text. */
        fun suffix(suffix: String) = apply { this.suffix = suffix }

        /**
         * The maximum number of [tokens](/tokenizer) to generate in the completion.
         *
         * The token count of your prompt plus `max_tokens` cannot exceed the model's context
         * length. Most models have a context length of 2048 tokens (except for the newest models,
         * which support 4096).
         */
        fun maxTokens(maxTokens: Long) = apply { this.maxTokens = maxTokens }

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

        /**
         * How many completions to generate for each prompt.
         *
         * **Note:** Because this parameter generates many completions, it can quickly consume your
         * token quota. Use carefully and ensure that you have reasonable settings for `max_tokens`
         * and `stop`.
         */
        fun n(n: Long) = apply { this.n = n }

        /**
         * Whether to stream back partial progress. If set, tokens will be sent as data-only
         * [server-sent events](https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events#Event_stream_format)
         * as they become available, with the stream terminated by a `data: [DONE]` message.
         */
        fun stream(stream: Boolean) = apply { this.stream = stream }

        /**
         * Include the log probabilities on the `logprobs` most likely tokens, as well the chosen
         * tokens. For example, if `logprobs` is 5, the API will return a list of the 5 most likely
         * tokens. The API will always return the `logprob` of the sampled token, so there may be up
         * to `logprobs+1` elements in the response.
         *
         * The maximum value for `logprobs` is 5. If you need more than this, please contact us
         * through our [Help center](https://help.openai.com) and describe your use case.
         */
        fun logprobs(logprobs: Long) = apply { this.logprobs = logprobs }

        /** Echo back the prompt in addition to the completion */
        fun echo(echo: Boolean) = apply { this.echo = echo }

        /**
         * Up to 4 sequences where the API will stop generating further tokens. The returned text
         * will not contain the stop sequence.
         */
        fun stop(stop: Stop) = apply { this.stop = stop }

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
         * Generates `best_of` completions server-side and returns the "best" (the one with the
         * highest log probability per token). Results cannot be streamed.
         *
         * When used with `n`, `best_of` controls the number of candidate completions and `n`
         * specifies how many to return – `best_of` must be greater than `n`.
         *
         * **Note:** Because this parameter generates many completions, it can quickly consume your
         * token quota. Use carefully and ensure that you have reasonable settings for `max_tokens`
         * and `stop`.
         */
        fun bestOf(bestOf: Long) = apply { this.bestOf = bestOf }

        /**
         * Modify the likelihood of specified tokens appearing in the completion.
         *
         * Accepts a json object that maps tokens (specified by their token ID in the GPT tokenizer)
         * to an associated bias value from -100 to 100. You can use this
         * [tokenizer tool](/tokenizer?view=bpe) (which works for both GPT-2 and GPT-3) to convert
         * text to token IDs. Mathematically, the bias is added to the logits generated by the model
         * prior to sampling. The exact effect will vary per model, but values between -1 and 1
         * should decrease or increase likelihood of selection; values like -100 or 100 should
         * result in a ban or exclusive selection of the relevant token.
         *
         * As an example, you can pass `{"50256": -100}` to prevent the <|endoftext|> token from
         * being generated.
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

        fun build(): CompletionCreateParams =
            CompletionCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                prompt,
                suffix,
                maxTokens,
                temperature,
                topP,
                n,
                stream,
                logprobs,
                echo,
                stop,
                presencePenalty,
                frequencyPenalty,
                bestOf,
                logitBias,
                user,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(using = Prompt.Deserializer::class)
    @JsonSerialize(using = Prompt.Serializer::class)
    class Prompt
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

        fun validate(): Prompt = apply {
            if (!validated) {
                if (string == null && strings == null && longs == null && listLongS == null) {
                    throw OpenAiInvalidDataException("Unknown Prompt: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Prompt &&
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
                string != null -> "Prompt{string=$string}"
                strings != null -> "Prompt{strings=$strings}"
                longs != null -> "Prompt{longs=$longs}"
                listLongS != null -> "Prompt{listLongS=$listLongS}"
                _json != null -> "Prompt{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Prompt")
            }
        }

        companion object {

            @JvmStatic fun ofString(string: String) = Prompt(string = string)

            @JvmStatic fun ofStrings(strings: List<String>) = Prompt(strings = strings)

            @JvmStatic fun ofLongs(longs: List<Long>) = Prompt(longs = longs)

            @JvmStatic fun ofListLongS(listLongS: List<List<Long>>) = Prompt(listLongS = listLongS)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<@JvmSuppressWildcards String>): T

            fun visitLongs(longs: List<@JvmSuppressWildcards Long>): T

            fun visitListLongS(listLongS: List<@JvmSuppressWildcards List<Long>>): T

            fun unknown(json: JsonValue?): T {
                throw OpenAiInvalidDataException("Unknown Prompt: $json")
            }
        }

        class Deserializer : BaseDeserializer<Prompt>(Prompt::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Prompt {
                val json = JsonValue.fromJsonNode(node)
                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Prompt(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                    return Prompt(strings = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<Long>>())?.let {
                    return Prompt(longs = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<List<Long>>>())?.let {
                    return Prompt(listLongS = it, _json = json)
                }

                return Prompt(_json = json)
            }
        }

        class Serializer : BaseSerializer<Prompt>(Prompt::class) {

            override fun serialize(
                value: Prompt,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.strings != null -> generator.writeObject(value.strings)
                    value.longs != null -> generator.writeObject(value.longs)
                    value.listLongS != null -> generator.writeObject(value.listLongS)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Prompt")
                }
            }
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
