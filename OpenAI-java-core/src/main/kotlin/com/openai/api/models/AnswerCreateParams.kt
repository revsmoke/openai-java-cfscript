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

class AnswerCreateParams
constructor(
    private val model: String,
    private val question: String,
    private val examples: List<List<String>>,
    private val examplesContext: String,
    private val documents: List<String>?,
    private val file: String?,
    private val searchModel: String?,
    private val maxRerank: Long?,
    private val temperature: Double?,
    private val logprobs: Long?,
    private val maxTokens: Long?,
    private val stop: Stop?,
    private val n: Long?,
    private val logitBias: JsonValue?,
    private val returnMetadata: Boolean?,
    private val returnPrompt: Boolean?,
    private val expand: List<JsonValue>?,
    private val user: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): String = model

    fun question(): String = question

    fun examples(): List<List<String>> = examples

    fun examplesContext(): String = examplesContext

    fun documents(): Optional<List<String>> = Optional.ofNullable(documents)

    fun file(): Optional<String> = Optional.ofNullable(file)

    fun searchModel(): Optional<String> = Optional.ofNullable(searchModel)

    fun maxRerank(): Optional<Long> = Optional.ofNullable(maxRerank)

    fun temperature(): Optional<Double> = Optional.ofNullable(temperature)

    fun logprobs(): Optional<Long> = Optional.ofNullable(logprobs)

    fun maxTokens(): Optional<Long> = Optional.ofNullable(maxTokens)

    fun stop(): Optional<Stop> = Optional.ofNullable(stop)

    fun n(): Optional<Long> = Optional.ofNullable(n)

    fun logitBias(): Optional<JsonValue> = Optional.ofNullable(logitBias)

    fun returnMetadata(): Optional<Boolean> = Optional.ofNullable(returnMetadata)

    fun returnPrompt(): Optional<Boolean> = Optional.ofNullable(returnPrompt)

    fun expand(): Optional<List<JsonValue>> = Optional.ofNullable(expand)

    fun user(): Optional<String> = Optional.ofNullable(user)

    @JvmSynthetic
    internal fun getBody(): AnswerCreateBody {
        return AnswerCreateBody(
            model,
            question,
            examples,
            examplesContext,
            documents,
            file,
            searchModel,
            maxRerank,
            temperature,
            logprobs,
            maxTokens,
            stop,
            n,
            logitBias,
            returnMetadata,
            returnPrompt,
            expand,
            user,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = AnswerCreateBody.Builder::class)
    @NoAutoDetect
    class AnswerCreateBody
    internal constructor(
        private val model: String?,
        private val question: String?,
        private val examples: List<List<String>>?,
        private val examplesContext: String?,
        private val documents: List<String>?,
        private val file: String?,
        private val searchModel: String?,
        private val maxRerank: Long?,
        private val temperature: Double?,
        private val logprobs: Long?,
        private val maxTokens: Long?,
        private val stop: Stop?,
        private val n: Long?,
        private val logitBias: JsonValue?,
        private val returnMetadata: Boolean?,
        private val returnPrompt: Boolean?,
        private val expand: List<JsonValue>?,
        private val user: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * ID of the model to use for completion. You can select one of `ada`, `babbage`, `curie`,
         * or `davinci`.
         */
        @JsonProperty("model") fun model(): String? = model

        /** Question to get answered. */
        @JsonProperty("question") fun question(): String? = question

        /**
         * List of (question, answer) pairs that will help steer the model towards the tone and
         * answer format you'd like. We recommend adding 2 to 3 examples.
         */
        @JsonProperty("examples") fun examples(): List<List<String>>? = examples

        /**
         * A text snippet containing the contextual information used to generate the answers for the
         * `examples` you provide.
         */
        @JsonProperty("examples_context") fun examplesContext(): String? = examplesContext

        /**
         * List of documents from which the answer for the input `question` should be derived. If
         * this is an empty list, the question will be answered based on the question-answer
         * examples.
         *
         * You should specify either `documents` or a `file`, but not both.
         */
        @JsonProperty("documents") fun documents(): List<String>? = documents

        /**
         * The ID of an uploaded file that contains documents to search over. See
         * [upload file](/docs/api-reference/files/upload) for how to upload a file of the desired
         * format and purpose.
         *
         * You should specify either `documents` or a `file`, but not both.
         */
        @JsonProperty("file") fun file(): String? = file

        /**
         * ID of the model to use for [Search](/docs/api-reference/searches/create). You can select
         * one of `ada`, `babbage`, `curie`, or `davinci`.
         */
        @JsonProperty("search_model") fun searchModel(): String? = searchModel

        /**
         * The maximum number of documents to be ranked by
         * [Search](/docs/api-reference/searches/create) when using `file`. Setting it to a higher
         * value leads to improved accuracy but with increased latency and cost.
         */
        @JsonProperty("max_rerank") fun maxRerank(): Long? = maxRerank

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         */
        @JsonProperty("temperature") fun temperature(): Double? = temperature

        /**
         * Include the log probabilities on the `logprobs` most likely tokens, as well the chosen
         * tokens. For example, if `logprobs` is 5, the API will return a list of the 5 most likely
         * tokens. The API will always return the `logprob` of the sampled token, so there may be up
         * to `logprobs+1` elements in the response.
         *
         * The maximum value for `logprobs` is 5. If you need more than this, please contact us
         * through our [Help center](https://help.openai.com) and describe your use case.
         *
         * When `logprobs` is set, `completion` will be automatically added into `expand` to get the
         * logprobs.
         */
        @JsonProperty("logprobs") fun logprobs(): Long? = logprobs

        /** The maximum number of tokens allowed for the generated answer */
        @JsonProperty("max_tokens") fun maxTokens(): Long? = maxTokens

        /**
         * Up to 4 sequences where the API will stop generating further tokens. The returned text
         * will not contain the stop sequence.
         */
        @JsonProperty("stop") fun stop(): Stop? = stop

        /** How many answers to generate for each question. */
        @JsonProperty("n") fun n(): Long? = n

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
         * A special boolean flag for showing metadata. If set to `true`, each document entry in the
         * returned JSON will contain a "metadata" field.
         *
         * This flag only takes effect when `file` is set.
         */
        @JsonProperty("return_metadata") fun returnMetadata(): Boolean? = returnMetadata

        /**
         * If set to `true`, the returned JSON will include a "prompt" field containing the final
         * prompt that was used to request a completion. This is mainly useful for debugging
         * purposes.
         */
        @JsonProperty("return_prompt") fun returnPrompt(): Boolean? = returnPrompt

        /**
         * If an object name is in the list, we provide the full information of the object;
         * otherwise, we only provide the object ID. Currently we support `completion` and `file`
         * objects for expansion.
         */
        @JsonProperty("expand") fun expand(): List<JsonValue>? = expand

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

            return other is AnswerCreateBody &&
                this.model == other.model &&
                this.question == other.question &&
                this.examples == other.examples &&
                this.examplesContext == other.examplesContext &&
                this.documents == other.documents &&
                this.file == other.file &&
                this.searchModel == other.searchModel &&
                this.maxRerank == other.maxRerank &&
                this.temperature == other.temperature &&
                this.logprobs == other.logprobs &&
                this.maxTokens == other.maxTokens &&
                this.stop == other.stop &&
                this.n == other.n &&
                this.logitBias == other.logitBias &&
                this.returnMetadata == other.returnMetadata &&
                this.returnPrompt == other.returnPrompt &&
                this.expand == other.expand &&
                this.user == other.user &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        model,
                        question,
                        examples,
                        examplesContext,
                        documents,
                        file,
                        searchModel,
                        maxRerank,
                        temperature,
                        logprobs,
                        maxTokens,
                        stop,
                        n,
                        logitBias,
                        returnMetadata,
                        returnPrompt,
                        expand,
                        user,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "AnswerCreateBody{model=$model, question=$question, examples=$examples, examplesContext=$examplesContext, documents=$documents, file=$file, searchModel=$searchModel, maxRerank=$maxRerank, temperature=$temperature, logprobs=$logprobs, maxTokens=$maxTokens, stop=$stop, n=$n, logitBias=$logitBias, returnMetadata=$returnMetadata, returnPrompt=$returnPrompt, expand=$expand, user=$user, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: String? = null
            private var question: String? = null
            private var examples: List<List<String>>? = null
            private var examplesContext: String? = null
            private var documents: List<String>? = null
            private var file: String? = null
            private var searchModel: String? = null
            private var maxRerank: Long? = null
            private var temperature: Double? = null
            private var logprobs: Long? = null
            private var maxTokens: Long? = null
            private var stop: Stop? = null
            private var n: Long? = null
            private var logitBias: JsonValue? = null
            private var returnMetadata: Boolean? = null
            private var returnPrompt: Boolean? = null
            private var expand: List<JsonValue>? = null
            private var user: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(answerCreateBody: AnswerCreateBody) = apply {
                this.model = answerCreateBody.model
                this.question = answerCreateBody.question
                this.examples = answerCreateBody.examples
                this.examplesContext = answerCreateBody.examplesContext
                this.documents = answerCreateBody.documents
                this.file = answerCreateBody.file
                this.searchModel = answerCreateBody.searchModel
                this.maxRerank = answerCreateBody.maxRerank
                this.temperature = answerCreateBody.temperature
                this.logprobs = answerCreateBody.logprobs
                this.maxTokens = answerCreateBody.maxTokens
                this.stop = answerCreateBody.stop
                this.n = answerCreateBody.n
                this.logitBias = answerCreateBody.logitBias
                this.returnMetadata = answerCreateBody.returnMetadata
                this.returnPrompt = answerCreateBody.returnPrompt
                this.expand = answerCreateBody.expand
                this.user = answerCreateBody.user
                additionalProperties(answerCreateBody.additionalProperties)
            }

            /**
             * ID of the model to use for completion. You can select one of `ada`, `babbage`,
             * `curie`, or `davinci`.
             */
            @JsonProperty("model") fun model(model: String) = apply { this.model = model }

            /** Question to get answered. */
            @JsonProperty("question")
            fun question(question: String) = apply { this.question = question }

            /**
             * List of (question, answer) pairs that will help steer the model towards the tone and
             * answer format you'd like. We recommend adding 2 to 3 examples.
             */
            @JsonProperty("examples")
            fun examples(examples: List<List<String>>) = apply { this.examples = examples }

            /**
             * A text snippet containing the contextual information used to generate the answers for
             * the `examples` you provide.
             */
            @JsonProperty("examples_context")
            fun examplesContext(examplesContext: String) = apply {
                this.examplesContext = examplesContext
            }

            /**
             * List of documents from which the answer for the input `question` should be derived.
             * If this is an empty list, the question will be answered based on the question-answer
             * examples.
             *
             * You should specify either `documents` or a `file`, but not both.
             */
            @JsonProperty("documents")
            fun documents(documents: List<String>) = apply { this.documents = documents }

            /**
             * The ID of an uploaded file that contains documents to search over. See
             * [upload file](/docs/api-reference/files/upload) for how to upload a file of the
             * desired format and purpose.
             *
             * You should specify either `documents` or a `file`, but not both.
             */
            @JsonProperty("file") fun file(file: String) = apply { this.file = file }

            /**
             * ID of the model to use for [Search](/docs/api-reference/searches/create). You can
             * select one of `ada`, `babbage`, `curie`, or `davinci`.
             */
            @JsonProperty("search_model")
            fun searchModel(searchModel: String) = apply { this.searchModel = searchModel }

            /**
             * The maximum number of documents to be ranked by
             * [Search](/docs/api-reference/searches/create) when using `file`. Setting it to a
             * higher value leads to improved accuracy but with increased latency and cost.
             */
            @JsonProperty("max_rerank")
            fun maxRerank(maxRerank: Long) = apply { this.maxRerank = maxRerank }

            /**
             * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make
             * the output more random, while lower values like 0.2 will make it more focused and
             * deterministic.
             */
            @JsonProperty("temperature")
            fun temperature(temperature: Double) = apply { this.temperature = temperature }

            /**
             * Include the log probabilities on the `logprobs` most likely tokens, as well the
             * chosen tokens. For example, if `logprobs` is 5, the API will return a list of the 5
             * most likely tokens. The API will always return the `logprob` of the sampled token, so
             * there may be up to `logprobs+1` elements in the response.
             *
             * The maximum value for `logprobs` is 5. If you need more than this, please contact us
             * through our [Help center](https://help.openai.com) and describe your use case.
             *
             * When `logprobs` is set, `completion` will be automatically added into `expand` to get
             * the logprobs.
             */
            @JsonProperty("logprobs")
            fun logprobs(logprobs: Long) = apply { this.logprobs = logprobs }

            /** The maximum number of tokens allowed for the generated answer */
            @JsonProperty("max_tokens")
            fun maxTokens(maxTokens: Long) = apply { this.maxTokens = maxTokens }

            /**
             * Up to 4 sequences where the API will stop generating further tokens. The returned
             * text will not contain the stop sequence.
             */
            @JsonProperty("stop") fun stop(stop: Stop) = apply { this.stop = stop }

            /** How many answers to generate for each question. */
            @JsonProperty("n") fun n(n: Long) = apply { this.n = n }

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
             * A special boolean flag for showing metadata. If set to `true`, each document entry in
             * the returned JSON will contain a "metadata" field.
             *
             * This flag only takes effect when `file` is set.
             */
            @JsonProperty("return_metadata")
            fun returnMetadata(returnMetadata: Boolean) = apply {
                this.returnMetadata = returnMetadata
            }

            /**
             * If set to `true`, the returned JSON will include a "prompt" field containing the
             * final prompt that was used to request a completion. This is mainly useful for
             * debugging purposes.
             */
            @JsonProperty("return_prompt")
            fun returnPrompt(returnPrompt: Boolean) = apply { this.returnPrompt = returnPrompt }

            /**
             * If an object name is in the list, we provide the full information of the object;
             * otherwise, we only provide the object ID. Currently we support `completion` and
             * `file` objects for expansion.
             */
            @JsonProperty("expand")
            fun expand(expand: List<JsonValue>) = apply { this.expand = expand }

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

            fun build(): AnswerCreateBody =
                AnswerCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    checkNotNull(question) { "`question` is required but was not set" },
                    checkNotNull(examples) { "`examples` is required but was not set" }
                        .toUnmodifiable(),
                    checkNotNull(examplesContext) {
                        "`examplesContext` is required but was not set"
                    },
                    documents?.toUnmodifiable(),
                    file,
                    searchModel,
                    maxRerank,
                    temperature,
                    logprobs,
                    maxTokens,
                    stop,
                    n,
                    logitBias,
                    returnMetadata,
                    returnPrompt,
                    expand?.toUnmodifiable(),
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

        return other is AnswerCreateParams &&
            this.model == other.model &&
            this.question == other.question &&
            this.examples == other.examples &&
            this.examplesContext == other.examplesContext &&
            this.documents == other.documents &&
            this.file == other.file &&
            this.searchModel == other.searchModel &&
            this.maxRerank == other.maxRerank &&
            this.temperature == other.temperature &&
            this.logprobs == other.logprobs &&
            this.maxTokens == other.maxTokens &&
            this.stop == other.stop &&
            this.n == other.n &&
            this.logitBias == other.logitBias &&
            this.returnMetadata == other.returnMetadata &&
            this.returnPrompt == other.returnPrompt &&
            this.expand == other.expand &&
            this.user == other.user &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            model,
            question,
            examples,
            examplesContext,
            documents,
            file,
            searchModel,
            maxRerank,
            temperature,
            logprobs,
            maxTokens,
            stop,
            n,
            logitBias,
            returnMetadata,
            returnPrompt,
            expand,
            user,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "AnswerCreateParams{model=$model, question=$question, examples=$examples, examplesContext=$examplesContext, documents=$documents, file=$file, searchModel=$searchModel, maxRerank=$maxRerank, temperature=$temperature, logprobs=$logprobs, maxTokens=$maxTokens, stop=$stop, n=$n, logitBias=$logitBias, returnMetadata=$returnMetadata, returnPrompt=$returnPrompt, expand=$expand, user=$user, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: String? = null
        private var question: String? = null
        private var examples: List<List<String>>? = null
        private var examplesContext: String? = null
        private var documents: List<String>? = null
        private var file: String? = null
        private var searchModel: String? = null
        private var maxRerank: Long? = null
        private var temperature: Double? = null
        private var logprobs: Long? = null
        private var maxTokens: Long? = null
        private var stop: Stop? = null
        private var n: Long? = null
        private var logitBias: JsonValue? = null
        private var returnMetadata: Boolean? = null
        private var returnPrompt: Boolean? = null
        private var expand: List<JsonValue>? = null
        private var user: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(answerCreateParams: AnswerCreateParams) = apply {
            this.model = answerCreateParams.model
            this.question = answerCreateParams.question
            this.examples = answerCreateParams.examples
            this.examplesContext = answerCreateParams.examplesContext
            this.documents = answerCreateParams.documents
            this.file = answerCreateParams.file
            this.searchModel = answerCreateParams.searchModel
            this.maxRerank = answerCreateParams.maxRerank
            this.temperature = answerCreateParams.temperature
            this.logprobs = answerCreateParams.logprobs
            this.maxTokens = answerCreateParams.maxTokens
            this.stop = answerCreateParams.stop
            this.n = answerCreateParams.n
            this.logitBias = answerCreateParams.logitBias
            this.returnMetadata = answerCreateParams.returnMetadata
            this.returnPrompt = answerCreateParams.returnPrompt
            this.expand = answerCreateParams.expand
            this.user = answerCreateParams.user
            additionalQueryParams(answerCreateParams.additionalQueryParams)
            additionalHeaders(answerCreateParams.additionalHeaders)
            additionalBodyProperties(answerCreateParams.additionalBodyProperties)
        }

        /**
         * ID of the model to use for completion. You can select one of `ada`, `babbage`, `curie`,
         * or `davinci`.
         */
        fun model(model: String) = apply { this.model = model }

        /** Question to get answered. */
        fun question(question: String) = apply { this.question = question }

        /**
         * List of (question, answer) pairs that will help steer the model towards the tone and
         * answer format you'd like. We recommend adding 2 to 3 examples.
         */
        fun examples(examples: List<List<String>>) = apply { this.examples = examples }

        /**
         * A text snippet containing the contextual information used to generate the answers for the
         * `examples` you provide.
         */
        fun examplesContext(examplesContext: String) = apply {
            this.examplesContext = examplesContext
        }

        /**
         * List of documents from which the answer for the input `question` should be derived. If
         * this is an empty list, the question will be answered based on the question-answer
         * examples.
         *
         * You should specify either `documents` or a `file`, but not both.
         */
        fun documents(documents: List<String>) = apply { this.documents = documents }

        /**
         * The ID of an uploaded file that contains documents to search over. See
         * [upload file](/docs/api-reference/files/upload) for how to upload a file of the desired
         * format and purpose.
         *
         * You should specify either `documents` or a `file`, but not both.
         */
        fun file(file: String) = apply { this.file = file }

        /**
         * ID of the model to use for [Search](/docs/api-reference/searches/create). You can select
         * one of `ada`, `babbage`, `curie`, or `davinci`.
         */
        fun searchModel(searchModel: String) = apply { this.searchModel = searchModel }

        /**
         * The maximum number of documents to be ranked by
         * [Search](/docs/api-reference/searches/create) when using `file`. Setting it to a higher
         * value leads to improved accuracy but with increased latency and cost.
         */
        fun maxRerank(maxRerank: Long) = apply { this.maxRerank = maxRerank }

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         */
        fun temperature(temperature: Double) = apply { this.temperature = temperature }

        /**
         * Include the log probabilities on the `logprobs` most likely tokens, as well the chosen
         * tokens. For example, if `logprobs` is 5, the API will return a list of the 5 most likely
         * tokens. The API will always return the `logprob` of the sampled token, so there may be up
         * to `logprobs+1` elements in the response.
         *
         * The maximum value for `logprobs` is 5. If you need more than this, please contact us
         * through our [Help center](https://help.openai.com) and describe your use case.
         *
         * When `logprobs` is set, `completion` will be automatically added into `expand` to get the
         * logprobs.
         */
        fun logprobs(logprobs: Long) = apply { this.logprobs = logprobs }

        /** The maximum number of tokens allowed for the generated answer */
        fun maxTokens(maxTokens: Long) = apply { this.maxTokens = maxTokens }

        /**
         * Up to 4 sequences where the API will stop generating further tokens. The returned text
         * will not contain the stop sequence.
         */
        fun stop(stop: Stop) = apply { this.stop = stop }

        /** How many answers to generate for each question. */
        fun n(n: Long) = apply { this.n = n }

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
         * A special boolean flag for showing metadata. If set to `true`, each document entry in the
         * returned JSON will contain a "metadata" field.
         *
         * This flag only takes effect when `file` is set.
         */
        fun returnMetadata(returnMetadata: Boolean) = apply { this.returnMetadata = returnMetadata }

        /**
         * If set to `true`, the returned JSON will include a "prompt" field containing the final
         * prompt that was used to request a completion. This is mainly useful for debugging
         * purposes.
         */
        fun returnPrompt(returnPrompt: Boolean) = apply { this.returnPrompt = returnPrompt }

        /**
         * If an object name is in the list, we provide the full information of the object;
         * otherwise, we only provide the object ID. Currently we support `completion` and `file`
         * objects for expansion.
         */
        fun expand(expand: List<JsonValue>) = apply { this.expand = expand }

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

        fun build(): AnswerCreateParams =
            AnswerCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                checkNotNull(question) { "`question` is required but was not set" },
                checkNotNull(examples) { "`examples` is required but was not set" }
                    .toUnmodifiable(),
                checkNotNull(examplesContext) { "`examplesContext` is required but was not set" },
                documents?.toUnmodifiable(),
                file,
                searchModel,
                maxRerank,
                temperature,
                logprobs,
                maxTokens,
                stop,
                n,
                logitBias,
                returnMetadata,
                returnPrompt,
                expand?.toUnmodifiable(),
                user,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
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
