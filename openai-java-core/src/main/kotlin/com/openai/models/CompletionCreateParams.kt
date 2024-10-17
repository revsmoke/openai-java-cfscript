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

class CompletionCreateParams
constructor(
    private val model: Model,
    private val prompt: Prompt?,
    private val bestOf: Long?,
    private val echo: Boolean?,
    private val frequencyPenalty: Double?,
    private val logitBias: LogitBias?,
    private val logprobs: Long?,
    private val maxTokens: Long?,
    private val n: Long?,
    private val presencePenalty: Double?,
    private val seed: Long?,
    private val stop: Stop?,
    private val stream: Boolean?,
    private val streamOptions: ChatCompletionStreamOptions?,
    private val suffix: String?,
    private val temperature: Double?,
    private val topP: Double?,
    private val user: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): Model = model

    fun prompt(): Optional<Prompt> = Optional.ofNullable(prompt)

    fun bestOf(): Optional<Long> = Optional.ofNullable(bestOf)

    fun echo(): Optional<Boolean> = Optional.ofNullable(echo)

    fun frequencyPenalty(): Optional<Double> = Optional.ofNullable(frequencyPenalty)

    fun logitBias(): Optional<LogitBias> = Optional.ofNullable(logitBias)

    fun logprobs(): Optional<Long> = Optional.ofNullable(logprobs)

    fun maxTokens(): Optional<Long> = Optional.ofNullable(maxTokens)

    fun n(): Optional<Long> = Optional.ofNullable(n)

    fun presencePenalty(): Optional<Double> = Optional.ofNullable(presencePenalty)

    fun seed(): Optional<Long> = Optional.ofNullable(seed)

    fun stop(): Optional<Stop> = Optional.ofNullable(stop)

    fun stream(): Optional<Boolean> = Optional.ofNullable(stream)

    fun streamOptions(): Optional<ChatCompletionStreamOptions> = Optional.ofNullable(streamOptions)

    fun suffix(): Optional<String> = Optional.ofNullable(suffix)

    fun temperature(): Optional<Double> = Optional.ofNullable(temperature)

    fun topP(): Optional<Double> = Optional.ofNullable(topP)

    fun user(): Optional<String> = Optional.ofNullable(user)

    @JvmSynthetic
    internal fun getBody(): CompletionCreateBody {
        return CompletionCreateBody(
            model,
            prompt,
            bestOf,
            echo,
            frequencyPenalty,
            logitBias,
            logprobs,
            maxTokens,
            n,
            presencePenalty,
            seed,
            stop,
            stream,
            streamOptions,
            suffix,
            temperature,
            topP,
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
        private val model: Model?,
        private val prompt: Prompt?,
        private val bestOf: Long?,
        private val echo: Boolean?,
        private val frequencyPenalty: Double?,
        private val logitBias: LogitBias?,
        private val logprobs: Long?,
        private val maxTokens: Long?,
        private val n: Long?,
        private val presencePenalty: Double?,
        private val seed: Long?,
        private val stop: Stop?,
        private val stream: Boolean?,
        private val streamOptions: ChatCompletionStreamOptions?,
        private val suffix: String?,
        private val temperature: Double?,
        private val topP: Double?,
        private val user: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models/overview) for descriptions of
         * them.
         */
        @JsonProperty("model") fun model(): Model? = model

        /**
         * The prompt(s) to generate completions for, encoded as a string, array of strings, array
         * of tokens, or array of token arrays.
         *
         * Note that <|endoftext|> is the document separator that the model sees during training, so
         * if a prompt is not specified the model will generate as if from the beginning of a new
         * document.
         */
        @JsonProperty("prompt") fun prompt(): Prompt? = prompt

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

        /** Echo back the prompt in addition to the completion */
        @JsonProperty("echo") fun echo(): Boolean? = echo

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing
         * frequency in the text so far, decreasing the model's likelihood to repeat the same line
         * verbatim.
         *
         * [See more information about frequency and presence
         * penalties.](https://platform.openai.com/docs/guides/text-generation/parameter-details)
         */
        @JsonProperty("frequency_penalty") fun frequencyPenalty(): Double? = frequencyPenalty

        /**
         * Modify the likelihood of specified tokens appearing in the completion.
         *
         * Accepts a JSON object that maps tokens (specified by their token ID in the GPT tokenizer)
         * to an associated bias value from -100 to 100. You can use this
         * [tokenizer tool](/tokenizer?view=bpe) to convert text to token IDs. Mathematically, the
         * bias is added to the logits generated by the model prior to sampling. The exact effect
         * will vary per model, but values between -1 and 1 should decrease or increase likelihood
         * of selection; values like -100 or 100 should result in a ban or exclusive selection of
         * the relevant token.
         *
         * As an example, you can pass `{"50256": -100}` to prevent the <|endoftext|> token from
         * being generated.
         */
        @JsonProperty("logit_bias") fun logitBias(): LogitBias? = logitBias

        /**
         * Include the log probabilities on the `logprobs` most likely output tokens, as well the
         * chosen tokens. For example, if `logprobs` is 5, the API will return a list of the 5 most
         * likely tokens. The API will always return the `logprob` of the sampled token, so there
         * may be up to `logprobs+1` elements in the response.
         *
         * The maximum value for `logprobs` is 5.
         */
        @JsonProperty("logprobs") fun logprobs(): Long? = logprobs

        /**
         * The maximum number of [tokens](/tokenizer) that can be generated in the completion.
         *
         * The token count of your prompt plus `max_tokens` cannot exceed the model's context
         * length.
         * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
         * for counting tokens.
         */
        @JsonProperty("max_tokens") fun maxTokens(): Long? = maxTokens

        /**
         * How many completions to generate for each prompt.
         *
         * **Note:** Because this parameter generates many completions, it can quickly consume your
         * token quota. Use carefully and ensure that you have reasonable settings for `max_tokens`
         * and `stop`.
         */
        @JsonProperty("n") fun n(): Long? = n

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they
         * appear in the text so far, increasing the model's likelihood to talk about new topics.
         *
         * [See more information about frequency and presence
         * penalties.](https://platform.openai.com/docs/guides/text-generation/parameter-details)
         */
        @JsonProperty("presence_penalty") fun presencePenalty(): Double? = presencePenalty

        /**
         * If specified, our system will make a best effort to sample deterministically, such that
         * repeated requests with the same `seed` and parameters should return the same result.
         *
         * Determinism is not guaranteed, and you should refer to the `system_fingerprint` response
         * parameter to monitor changes in the backend.
         */
        @JsonProperty("seed") fun seed(): Long? = seed

        /**
         * Up to 4 sequences where the API will stop generating further tokens. The returned text
         * will not contain the stop sequence.
         */
        @JsonProperty("stop") fun stop(): Stop? = stop

        /**
         * Whether to stream back partial progress. If set, tokens will be sent as data-only
         * [server-sent events](https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events#Event_stream_format)
         * as they become available, with the stream terminated by a `data: [DONE]` message.
         * [Example Python code](https://cookbook.openai.com/examples/how_to_stream_completions).
         */
        @JsonProperty("stream") fun stream(): Boolean? = stream

        /** Options for streaming response. Only set this when you set `stream: true`. */
        @JsonProperty("stream_options")
        fun streamOptions(): ChatCompletionStreamOptions? = streamOptions

        /**
         * The suffix that comes after a completion of inserted text.
         *
         * This parameter is only supported for `gpt-3.5-turbo-instruct`.
         */
        @JsonProperty("suffix") fun suffix(): String? = suffix

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

            private var model: Model? = null
            private var prompt: Prompt? = null
            private var bestOf: Long? = null
            private var echo: Boolean? = null
            private var frequencyPenalty: Double? = null
            private var logitBias: LogitBias? = null
            private var logprobs: Long? = null
            private var maxTokens: Long? = null
            private var n: Long? = null
            private var presencePenalty: Double? = null
            private var seed: Long? = null
            private var stop: Stop? = null
            private var stream: Boolean? = null
            private var streamOptions: ChatCompletionStreamOptions? = null
            private var suffix: String? = null
            private var temperature: Double? = null
            private var topP: Double? = null
            private var user: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(completionCreateBody: CompletionCreateBody) = apply {
                this.model = completionCreateBody.model
                this.prompt = completionCreateBody.prompt
                this.bestOf = completionCreateBody.bestOf
                this.echo = completionCreateBody.echo
                this.frequencyPenalty = completionCreateBody.frequencyPenalty
                this.logitBias = completionCreateBody.logitBias
                this.logprobs = completionCreateBody.logprobs
                this.maxTokens = completionCreateBody.maxTokens
                this.n = completionCreateBody.n
                this.presencePenalty = completionCreateBody.presencePenalty
                this.seed = completionCreateBody.seed
                this.stop = completionCreateBody.stop
                this.stream = completionCreateBody.stream
                this.streamOptions = completionCreateBody.streamOptions
                this.suffix = completionCreateBody.suffix
                this.temperature = completionCreateBody.temperature
                this.topP = completionCreateBody.topP
                this.user = completionCreateBody.user
                additionalProperties(completionCreateBody.additionalProperties)
            }

            /**
             * ID of the model to use. You can use the
             * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see
             * all of your available models, or see our
             * [Model overview](https://platform.openai.com/docs/models/overview) for descriptions
             * of them.
             */
            @JsonProperty("model") fun model(model: Model) = apply { this.model = model }

            /**
             * The prompt(s) to generate completions for, encoded as a string, array of strings,
             * array of tokens, or array of token arrays.
             *
             * Note that <|endoftext|> is the document separator that the model sees during
             * training, so if a prompt is not specified the model will generate as if from the
             * beginning of a new document.
             */
            @JsonProperty("prompt") fun prompt(prompt: Prompt) = apply { this.prompt = prompt }

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

            /** Echo back the prompt in addition to the completion */
            @JsonProperty("echo") fun echo(echo: Boolean) = apply { this.echo = echo }

            /**
             * Number between -2.0 and 2.0. Positive values penalize new tokens based on their
             * existing frequency in the text so far, decreasing the model's likelihood to repeat
             * the same line verbatim.
             *
             * [See more information about frequency and presence
             * penalties.](https://platform.openai.com/docs/guides/text-generation/parameter-details)
             */
            @JsonProperty("frequency_penalty")
            fun frequencyPenalty(frequencyPenalty: Double) = apply {
                this.frequencyPenalty = frequencyPenalty
            }

            /**
             * Modify the likelihood of specified tokens appearing in the completion.
             *
             * Accepts a JSON object that maps tokens (specified by their token ID in the GPT
             * tokenizer) to an associated bias value from -100 to 100. You can use this
             * [tokenizer tool](/tokenizer?view=bpe) to convert text to token IDs. Mathematically,
             * the bias is added to the logits generated by the model prior to sampling. The exact
             * effect will vary per model, but values between -1 and 1 should decrease or increase
             * likelihood of selection; values like -100 or 100 should result in a ban or exclusive
             * selection of the relevant token.
             *
             * As an example, you can pass `{"50256": -100}` to prevent the <|endoftext|> token from
             * being generated.
             */
            @JsonProperty("logit_bias")
            fun logitBias(logitBias: LogitBias) = apply { this.logitBias = logitBias }

            /**
             * Include the log probabilities on the `logprobs` most likely output tokens, as well
             * the chosen tokens. For example, if `logprobs` is 5, the API will return a list of the
             * 5 most likely tokens. The API will always return the `logprob` of the sampled token,
             * so there may be up to `logprobs+1` elements in the response.
             *
             * The maximum value for `logprobs` is 5.
             */
            @JsonProperty("logprobs")
            fun logprobs(logprobs: Long) = apply { this.logprobs = logprobs }

            /**
             * The maximum number of [tokens](/tokenizer) that can be generated in the completion.
             *
             * The token count of your prompt plus `max_tokens` cannot exceed the model's context
             * length.
             * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
             * for counting tokens.
             */
            @JsonProperty("max_tokens")
            fun maxTokens(maxTokens: Long) = apply { this.maxTokens = maxTokens }

            /**
             * How many completions to generate for each prompt.
             *
             * **Note:** Because this parameter generates many completions, it can quickly consume
             * your token quota. Use carefully and ensure that you have reasonable settings for
             * `max_tokens` and `stop`.
             */
            @JsonProperty("n") fun n(n: Long) = apply { this.n = n }

            /**
             * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether
             * they appear in the text so far, increasing the model's likelihood to talk about new
             * topics.
             *
             * [See more information about frequency and presence
             * penalties.](https://platform.openai.com/docs/guides/text-generation/parameter-details)
             */
            @JsonProperty("presence_penalty")
            fun presencePenalty(presencePenalty: Double) = apply {
                this.presencePenalty = presencePenalty
            }

            /**
             * If specified, our system will make a best effort to sample deterministically, such
             * that repeated requests with the same `seed` and parameters should return the same
             * result.
             *
             * Determinism is not guaranteed, and you should refer to the `system_fingerprint`
             * response parameter to monitor changes in the backend.
             */
            @JsonProperty("seed") fun seed(seed: Long) = apply { this.seed = seed }

            /**
             * Up to 4 sequences where the API will stop generating further tokens. The returned
             * text will not contain the stop sequence.
             */
            @JsonProperty("stop") fun stop(stop: Stop) = apply { this.stop = stop }

            /**
             * Whether to stream back partial progress. If set, tokens will be sent as data-only
             * [server-sent events](https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events#Event_stream_format)
             * as they become available, with the stream terminated by a `data: [DONE]` message.
             * [Example Python code](https://cookbook.openai.com/examples/how_to_stream_completions).
             */
            @JsonProperty("stream") fun stream(stream: Boolean) = apply { this.stream = stream }

            /** Options for streaming response. Only set this when you set `stream: true`. */
            @JsonProperty("stream_options")
            fun streamOptions(streamOptions: ChatCompletionStreamOptions) = apply {
                this.streamOptions = streamOptions
            }

            /**
             * The suffix that comes after a completion of inserted text.
             *
             * This parameter is only supported for `gpt-3.5-turbo-instruct`.
             */
            @JsonProperty("suffix") fun suffix(suffix: String) = apply { this.suffix = suffix }

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

            fun build(): CompletionCreateBody =
                CompletionCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    prompt,
                    bestOf,
                    echo,
                    frequencyPenalty,
                    logitBias,
                    logprobs,
                    maxTokens,
                    n,
                    presencePenalty,
                    seed,
                    stop,
                    stream,
                    streamOptions,
                    suffix,
                    temperature,
                    topP,
                    user,
                    additionalProperties.toUnmodifiable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is CompletionCreateBody && this.model == other.model && this.prompt == other.prompt && this.bestOf == other.bestOf && this.echo == other.echo && this.frequencyPenalty == other.frequencyPenalty && this.logitBias == other.logitBias && this.logprobs == other.logprobs && this.maxTokens == other.maxTokens && this.n == other.n && this.presencePenalty == other.presencePenalty && this.seed == other.seed && this.stop == other.stop && this.stream == other.stream && this.streamOptions == other.streamOptions && this.suffix == other.suffix && this.temperature == other.temperature && this.topP == other.topP && this.user == other.user && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(model, prompt, bestOf, echo, frequencyPenalty, logitBias, logprobs, maxTokens, n, presencePenalty, seed, stop, stream, streamOptions, suffix, temperature, topP, user, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "CompletionCreateBody{model=$model, prompt=$prompt, bestOf=$bestOf, echo=$echo, frequencyPenalty=$frequencyPenalty, logitBias=$logitBias, logprobs=$logprobs, maxTokens=$maxTokens, n=$n, presencePenalty=$presencePenalty, seed=$seed, stop=$stop, stream=$stream, streamOptions=$streamOptions, suffix=$suffix, temperature=$temperature, topP=$topP, user=$user, additionalProperties=$additionalProperties}"
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CompletionCreateParams && this.model == other.model && this.prompt == other.prompt && this.bestOf == other.bestOf && this.echo == other.echo && this.frequencyPenalty == other.frequencyPenalty && this.logitBias == other.logitBias && this.logprobs == other.logprobs && this.maxTokens == other.maxTokens && this.n == other.n && this.presencePenalty == other.presencePenalty && this.seed == other.seed && this.stop == other.stop && this.stream == other.stream && this.streamOptions == other.streamOptions && this.suffix == other.suffix && this.temperature == other.temperature && this.topP == other.topP && this.user == other.user && this.additionalQueryParams == other.additionalQueryParams && this.additionalHeaders == other.additionalHeaders && this.additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(model, prompt, bestOf, echo, frequencyPenalty, logitBias, logprobs, maxTokens, n, presencePenalty, seed, stop, stream, streamOptions, suffix, temperature, topP, user, additionalQueryParams, additionalHeaders, additionalBodyProperties) /* spotless:on */
    }

    override fun toString() =
        "CompletionCreateParams{model=$model, prompt=$prompt, bestOf=$bestOf, echo=$echo, frequencyPenalty=$frequencyPenalty, logitBias=$logitBias, logprobs=$logprobs, maxTokens=$maxTokens, n=$n, presencePenalty=$presencePenalty, seed=$seed, stop=$stop, stream=$stream, streamOptions=$streamOptions, suffix=$suffix, temperature=$temperature, topP=$topP, user=$user, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: Model? = null
        private var prompt: Prompt? = null
        private var bestOf: Long? = null
        private var echo: Boolean? = null
        private var frequencyPenalty: Double? = null
        private var logitBias: LogitBias? = null
        private var logprobs: Long? = null
        private var maxTokens: Long? = null
        private var n: Long? = null
        private var presencePenalty: Double? = null
        private var seed: Long? = null
        private var stop: Stop? = null
        private var stream: Boolean? = null
        private var streamOptions: ChatCompletionStreamOptions? = null
        private var suffix: String? = null
        private var temperature: Double? = null
        private var topP: Double? = null
        private var user: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(completionCreateParams: CompletionCreateParams) = apply {
            this.model = completionCreateParams.model
            this.prompt = completionCreateParams.prompt
            this.bestOf = completionCreateParams.bestOf
            this.echo = completionCreateParams.echo
            this.frequencyPenalty = completionCreateParams.frequencyPenalty
            this.logitBias = completionCreateParams.logitBias
            this.logprobs = completionCreateParams.logprobs
            this.maxTokens = completionCreateParams.maxTokens
            this.n = completionCreateParams.n
            this.presencePenalty = completionCreateParams.presencePenalty
            this.seed = completionCreateParams.seed
            this.stop = completionCreateParams.stop
            this.stream = completionCreateParams.stream
            this.streamOptions = completionCreateParams.streamOptions
            this.suffix = completionCreateParams.suffix
            this.temperature = completionCreateParams.temperature
            this.topP = completionCreateParams.topP
            this.user = completionCreateParams.user
            additionalQueryParams(completionCreateParams.additionalQueryParams)
            additionalHeaders(completionCreateParams.additionalHeaders)
            additionalBodyProperties(completionCreateParams.additionalBodyProperties)
        }

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models/overview) for descriptions of
         * them.
         */
        fun model(model: Model) = apply { this.model = model }

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models/overview) for descriptions of
         * them.
         */
        fun model(string: String) = apply { this.model = Model.ofString(string) }

        /**
         * ID of the model to use. You can use the
         * [List models](https://platform.openai.com/docs/api-reference/models/list) API to see all
         * of your available models, or see our
         * [Model overview](https://platform.openai.com/docs/models/overview) for descriptions of
         * them.
         */
        fun model(unionMember1: Model.UnionMember1) = apply {
            this.model = Model.ofUnionMember1(unionMember1)
        }

        /**
         * The prompt(s) to generate completions for, encoded as a string, array of strings, array
         * of tokens, or array of token arrays.
         *
         * Note that <|endoftext|> is the document separator that the model sees during training, so
         * if a prompt is not specified the model will generate as if from the beginning of a new
         * document.
         */
        fun prompt(prompt: Prompt) = apply { this.prompt = prompt }

        /**
         * The prompt(s) to generate completions for, encoded as a string, array of strings, array
         * of tokens, or array of token arrays.
         *
         * Note that <|endoftext|> is the document separator that the model sees during training, so
         * if a prompt is not specified the model will generate as if from the beginning of a new
         * document.
         */
        fun prompt(string: String) = apply { this.prompt = Prompt.ofString(string) }

        /**
         * The prompt(s) to generate completions for, encoded as a string, array of strings, array
         * of tokens, or array of token arrays.
         *
         * Note that <|endoftext|> is the document separator that the model sees during training, so
         * if a prompt is not specified the model will generate as if from the beginning of a new
         * document.
         */
        fun promptOfArrayOfStrings(arrayOfStrings: List<String>) = apply {
            this.prompt = Prompt.ofArrayOfStrings(arrayOfStrings)
        }

        /**
         * The prompt(s) to generate completions for, encoded as a string, array of strings, array
         * of tokens, or array of token arrays.
         *
         * Note that <|endoftext|> is the document separator that the model sees during training, so
         * if a prompt is not specified the model will generate as if from the beginning of a new
         * document.
         */
        fun promptOfArrayOfTokens(arrayOfTokens: List<Long>) = apply {
            this.prompt = Prompt.ofArrayOfTokens(arrayOfTokens)
        }

        /**
         * The prompt(s) to generate completions for, encoded as a string, array of strings, array
         * of tokens, or array of token arrays.
         *
         * Note that <|endoftext|> is the document separator that the model sees during training, so
         * if a prompt is not specified the model will generate as if from the beginning of a new
         * document.
         */
        fun promptOfArrayOfTokenArrays(arrayOfTokenArrays: List<List<Long>>) = apply {
            this.prompt = Prompt.ofArrayOfTokenArrays(arrayOfTokenArrays)
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

        /** Echo back the prompt in addition to the completion */
        fun echo(echo: Boolean) = apply { this.echo = echo }

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing
         * frequency in the text so far, decreasing the model's likelihood to repeat the same line
         * verbatim.
         *
         * [See more information about frequency and presence
         * penalties.](https://platform.openai.com/docs/guides/text-generation/parameter-details)
         */
        fun frequencyPenalty(frequencyPenalty: Double) = apply {
            this.frequencyPenalty = frequencyPenalty
        }

        /**
         * Modify the likelihood of specified tokens appearing in the completion.
         *
         * Accepts a JSON object that maps tokens (specified by their token ID in the GPT tokenizer)
         * to an associated bias value from -100 to 100. You can use this
         * [tokenizer tool](/tokenizer?view=bpe) to convert text to token IDs. Mathematically, the
         * bias is added to the logits generated by the model prior to sampling. The exact effect
         * will vary per model, but values between -1 and 1 should decrease or increase likelihood
         * of selection; values like -100 or 100 should result in a ban or exclusive selection of
         * the relevant token.
         *
         * As an example, you can pass `{"50256": -100}` to prevent the <|endoftext|> token from
         * being generated.
         */
        fun logitBias(logitBias: LogitBias) = apply { this.logitBias = logitBias }

        /**
         * Include the log probabilities on the `logprobs` most likely output tokens, as well the
         * chosen tokens. For example, if `logprobs` is 5, the API will return a list of the 5 most
         * likely tokens. The API will always return the `logprob` of the sampled token, so there
         * may be up to `logprobs+1` elements in the response.
         *
         * The maximum value for `logprobs` is 5.
         */
        fun logprobs(logprobs: Long) = apply { this.logprobs = logprobs }

        /**
         * The maximum number of [tokens](/tokenizer) that can be generated in the completion.
         *
         * The token count of your prompt plus `max_tokens` cannot exceed the model's context
         * length.
         * [Example Python code](https://cookbook.openai.com/examples/how_to_count_tokens_with_tiktoken)
         * for counting tokens.
         */
        fun maxTokens(maxTokens: Long) = apply { this.maxTokens = maxTokens }

        /**
         * How many completions to generate for each prompt.
         *
         * **Note:** Because this parameter generates many completions, it can quickly consume your
         * token quota. Use carefully and ensure that you have reasonable settings for `max_tokens`
         * and `stop`.
         */
        fun n(n: Long) = apply { this.n = n }

        /**
         * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they
         * appear in the text so far, increasing the model's likelihood to talk about new topics.
         *
         * [See more information about frequency and presence
         * penalties.](https://platform.openai.com/docs/guides/text-generation/parameter-details)
         */
        fun presencePenalty(presencePenalty: Double) = apply {
            this.presencePenalty = presencePenalty
        }

        /**
         * If specified, our system will make a best effort to sample deterministically, such that
         * repeated requests with the same `seed` and parameters should return the same result.
         *
         * Determinism is not guaranteed, and you should refer to the `system_fingerprint` response
         * parameter to monitor changes in the backend.
         */
        fun seed(seed: Long) = apply { this.seed = seed }

        /**
         * Up to 4 sequences where the API will stop generating further tokens. The returned text
         * will not contain the stop sequence.
         */
        fun stop(stop: Stop) = apply { this.stop = stop }

        /**
         * Up to 4 sequences where the API will stop generating further tokens. The returned text
         * will not contain the stop sequence.
         */
        fun stop(string: String) = apply { this.stop = Stop.ofString(string) }

        /**
         * Up to 4 sequences where the API will stop generating further tokens. The returned text
         * will not contain the stop sequence.
         */
        fun stopOfStrings(strings: List<String>) = apply { this.stop = Stop.ofStrings(strings) }

        /**
         * Whether to stream back partial progress. If set, tokens will be sent as data-only
         * [server-sent events](https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events#Event_stream_format)
         * as they become available, with the stream terminated by a `data: [DONE]` message.
         * [Example Python code](https://cookbook.openai.com/examples/how_to_stream_completions).
         */
        fun stream(stream: Boolean) = apply { this.stream = stream }

        /** Options for streaming response. Only set this when you set `stream: true`. */
        fun streamOptions(streamOptions: ChatCompletionStreamOptions) = apply {
            this.streamOptions = streamOptions
        }

        /**
         * The suffix that comes after a completion of inserted text.
         *
         * This parameter is only supported for `gpt-3.5-turbo-instruct`.
         */
        fun suffix(suffix: String) = apply { this.suffix = suffix }

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

        fun build(): CompletionCreateParams =
            CompletionCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                prompt,
                bestOf,
                echo,
                frequencyPenalty,
                logitBias,
                logprobs,
                maxTokens,
                n,
                presencePenalty,
                seed,
                stop,
                stream,
                streamOptions,
                suffix,
                temperature,
                topP,
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

            return /* spotless:off */ other is Model && this.string == other.string && this.unionMember1 == other.unionMember1 /* spotless:on */
        }

        override fun hashCode(): Int {
            return /* spotless:off */ Objects.hash(string, unionMember1) /* spotless:on */
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

                return /* spotless:off */ other is UnionMember1 && this.value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField
                val GPT_3_5_TURBO_INSTRUCT = UnionMember1(JsonField.of("gpt-3.5-turbo-instruct"))

                @JvmField val DAVINCI_002 = UnionMember1(JsonField.of("davinci-002"))

                @JvmField val BABBAGE_002 = UnionMember1(JsonField.of("babbage-002"))

                @JvmStatic fun of(value: String) = UnionMember1(JsonField.of(value))
            }

            enum class Known {
                GPT_3_5_TURBO_INSTRUCT,
                DAVINCI_002,
                BABBAGE_002,
            }

            enum class Value {
                GPT_3_5_TURBO_INSTRUCT,
                DAVINCI_002,
                BABBAGE_002,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    GPT_3_5_TURBO_INSTRUCT -> Value.GPT_3_5_TURBO_INSTRUCT
                    DAVINCI_002 -> Value.DAVINCI_002
                    BABBAGE_002 -> Value.BABBAGE_002
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    GPT_3_5_TURBO_INSTRUCT -> Known.GPT_3_5_TURBO_INSTRUCT
                    DAVINCI_002 -> Known.DAVINCI_002
                    BABBAGE_002 -> Known.BABBAGE_002
                    else -> throw OpenAIInvalidDataException("Unknown UnionMember1: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }

    @JsonDeserialize(using = Prompt.Deserializer::class)
    @JsonSerialize(using = Prompt.Serializer::class)
    class Prompt
    private constructor(
        private val string: String? = null,
        private val arrayOfStrings: List<String>? = null,
        private val arrayOfTokens: List<Long>? = null,
        private val arrayOfTokenArrays: List<List<Long>>? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun arrayOfStrings(): Optional<List<String>> = Optional.ofNullable(arrayOfStrings)

        fun arrayOfTokens(): Optional<List<Long>> = Optional.ofNullable(arrayOfTokens)

        fun arrayOfTokenArrays(): Optional<List<List<Long>>> =
            Optional.ofNullable(arrayOfTokenArrays)

        fun isString(): Boolean = string != null

        fun isArrayOfStrings(): Boolean = arrayOfStrings != null

        fun isArrayOfTokens(): Boolean = arrayOfTokens != null

        fun isArrayOfTokenArrays(): Boolean = arrayOfTokenArrays != null

        fun asString(): String = string.getOrThrow("string")

        fun asArrayOfStrings(): List<String> = arrayOfStrings.getOrThrow("arrayOfStrings")

        fun asArrayOfTokens(): List<Long> = arrayOfTokens.getOrThrow("arrayOfTokens")

        fun asArrayOfTokenArrays(): List<List<Long>> =
            arrayOfTokenArrays.getOrThrow("arrayOfTokenArrays")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                arrayOfStrings != null -> visitor.visitArrayOfStrings(arrayOfStrings)
                arrayOfTokens != null -> visitor.visitArrayOfTokens(arrayOfTokens)
                arrayOfTokenArrays != null -> visitor.visitArrayOfTokenArrays(arrayOfTokenArrays)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Prompt = apply {
            if (!validated) {
                if (
                    string == null &&
                        arrayOfStrings == null &&
                        arrayOfTokens == null &&
                        arrayOfTokenArrays == null
                ) {
                    throw OpenAIInvalidDataException("Unknown Prompt: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Prompt && this.string == other.string && this.arrayOfStrings == other.arrayOfStrings && this.arrayOfTokens == other.arrayOfTokens && this.arrayOfTokenArrays == other.arrayOfTokenArrays /* spotless:on */
        }

        override fun hashCode(): Int {
            return /* spotless:off */ Objects.hash(string, arrayOfStrings, arrayOfTokens, arrayOfTokenArrays) /* spotless:on */
        }

        override fun toString(): String {
            return when {
                string != null -> "Prompt{string=$string}"
                arrayOfStrings != null -> "Prompt{arrayOfStrings=$arrayOfStrings}"
                arrayOfTokens != null -> "Prompt{arrayOfTokens=$arrayOfTokens}"
                arrayOfTokenArrays != null -> "Prompt{arrayOfTokenArrays=$arrayOfTokenArrays}"
                _json != null -> "Prompt{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Prompt")
            }
        }

        companion object {

            @JvmStatic fun ofString(string: String) = Prompt(string = string)

            @JvmStatic
            fun ofArrayOfStrings(arrayOfStrings: List<String>) =
                Prompt(arrayOfStrings = arrayOfStrings)

            @JvmStatic
            fun ofArrayOfTokens(arrayOfTokens: List<Long>) = Prompt(arrayOfTokens = arrayOfTokens)

            @JvmStatic
            fun ofArrayOfTokenArrays(arrayOfTokenArrays: List<List<Long>>) =
                Prompt(arrayOfTokenArrays = arrayOfTokenArrays)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitArrayOfStrings(arrayOfStrings: List<String>): T

            fun visitArrayOfTokens(arrayOfTokens: List<Long>): T

            fun visitArrayOfTokenArrays(arrayOfTokenArrays: List<List<Long>>): T

            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Prompt: $json")
            }
        }

        class Deserializer : BaseDeserializer<Prompt>(Prompt::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Prompt {
                val json = JsonValue.fromJsonNode(node)
                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Prompt(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                    return Prompt(arrayOfStrings = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<Long>>())?.let {
                    return Prompt(arrayOfTokens = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<List<Long>>>())?.let {
                    return Prompt(arrayOfTokenArrays = it, _json = json)
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
                    value.arrayOfStrings != null -> generator.writeObject(value.arrayOfStrings)
                    value.arrayOfTokens != null -> generator.writeObject(value.arrayOfTokens)
                    value.arrayOfTokenArrays != null ->
                        generator.writeObject(value.arrayOfTokenArrays)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Prompt")
                }
            }
        }
    }

    /**
     * Modify the likelihood of specified tokens appearing in the completion.
     *
     * Accepts a JSON object that maps tokens (specified by their token ID in the GPT tokenizer) to
     * an associated bias value from -100 to 100. You can use this
     * [tokenizer tool](/tokenizer?view=bpe) to convert text to token IDs. Mathematically, the bias
     * is added to the logits generated by the model prior to sampling. The exact effect will vary
     * per model, but values between -1 and 1 should decrease or increase likelihood of selection;
     * values like -100 or 100 should result in a ban or exclusive selection of the relevant token.
     *
     * As an example, you can pass `{"50256": -100}` to prevent the <|endoftext|> token from being
     * generated.
     */
    @JsonDeserialize(builder = LogitBias.Builder::class)
    @NoAutoDetect
    class LogitBias
    private constructor(
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(logitBias: LogitBias) = apply {
                additionalProperties(logitBias.additionalProperties)
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

            fun build(): LogitBias = LogitBias(additionalProperties.toUnmodifiable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is LogitBias && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() = "LogitBias{additionalProperties=$additionalProperties}"
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
                    throw OpenAIInvalidDataException("Unknown Stop: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Stop && this.string == other.string && this.strings == other.strings /* spotless:on */
        }

        override fun hashCode(): Int {
            return /* spotless:off */ Objects.hash(string, strings) /* spotless:on */
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

            fun visitStrings(strings: List<String>): T

            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Stop: $json")
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
