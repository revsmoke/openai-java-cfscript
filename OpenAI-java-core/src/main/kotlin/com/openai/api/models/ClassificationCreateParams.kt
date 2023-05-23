package com.openai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.api.core.ExcludeMissing
import com.openai.api.core.JsonValue
import com.openai.api.core.NoAutoDetect
import com.openai.api.core.toUnmodifiable
import com.openai.api.models.*
import java.util.Objects
import java.util.Optional

class ClassificationCreateParams
constructor(
    private val model: String,
    private val query: String,
    private val examples: List<List<String>>?,
    private val file: String?,
    private val labels: List<String>?,
    private val searchModel: String?,
    private val temperature: Double?,
    private val logprobs: Long?,
    private val maxExamples: Long?,
    private val logitBias: JsonValue?,
    private val returnPrompt: Boolean?,
    private val returnMetadata: Boolean?,
    private val expand: List<JsonValue>?,
    private val user: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): String = model

    fun query(): String = query

    fun examples(): Optional<List<List<String>>> = Optional.ofNullable(examples)

    fun file(): Optional<String> = Optional.ofNullable(file)

    fun labels(): Optional<List<String>> = Optional.ofNullable(labels)

    fun searchModel(): Optional<String> = Optional.ofNullable(searchModel)

    fun temperature(): Optional<Double> = Optional.ofNullable(temperature)

    fun logprobs(): Optional<Long> = Optional.ofNullable(logprobs)

    fun maxExamples(): Optional<Long> = Optional.ofNullable(maxExamples)

    fun logitBias(): Optional<JsonValue> = Optional.ofNullable(logitBias)

    fun returnPrompt(): Optional<Boolean> = Optional.ofNullable(returnPrompt)

    fun returnMetadata(): Optional<Boolean> = Optional.ofNullable(returnMetadata)

    fun expand(): Optional<List<JsonValue>> = Optional.ofNullable(expand)

    fun user(): Optional<String> = Optional.ofNullable(user)

    @JvmSynthetic
    internal fun getBody(): ClassificationCreateBody {
        return ClassificationCreateBody(
            model,
            query,
            examples,
            file,
            labels,
            searchModel,
            temperature,
            logprobs,
            maxExamples,
            logitBias,
            returnPrompt,
            returnMetadata,
            expand,
            user,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = ClassificationCreateBody.Builder::class)
    @NoAutoDetect
    class ClassificationCreateBody
    internal constructor(
        private val model: String?,
        private val query: String?,
        private val examples: List<List<String>>?,
        private val file: String?,
        private val labels: List<String>?,
        private val searchModel: String?,
        private val temperature: Double?,
        private val logprobs: Long?,
        private val maxExamples: Long?,
        private val logitBias: JsonValue?,
        private val returnPrompt: Boolean?,
        private val returnMetadata: Boolean?,
        private val expand: List<JsonValue>?,
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

        /** Query to be classified. */
        @JsonProperty("query") fun query(): String? = query

        /**
         * A list of examples with labels, in the following format:
         *
         * `[["The movie is so interesting.", "Positive"], ["It is quite boring.", "Negative"],
         * ...]`
         *
         * All the label strings will be normalized to be capitalized.
         *
         * You should specify either `examples` or `file`, but not both.
         */
        @JsonProperty("examples") fun examples(): List<List<String>>? = examples

        /**
         * The ID of the uploaded file that contains training examples. See
         * [upload file](/docs/api-reference/files/upload) for how to upload a file of the desired
         * format and purpose.
         *
         * You should specify either `examples` or `file`, but not both.
         */
        @JsonProperty("file") fun file(): String? = file

        /**
         * The set of categories being classified. If not specified, candidate labels will be
         * automatically collected from the examples you provide. All the label strings will be
         * normalized to be capitalized.
         */
        @JsonProperty("labels") fun labels(): List<String>? = labels

        /**
         * ID of the model to use for [Search](/docs/api-reference/searches/create). You can select
         * one of `ada`, `babbage`, `curie`, or `davinci`.
         */
        @JsonProperty("search_model") fun searchModel(): String? = searchModel

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

        /**
         * The maximum number of examples to be ranked by
         * [Search](/docs/api-reference/searches/create) when using `file`. Setting it to a higher
         * value leads to improved accuracy but with increased latency and cost.
         */
        @JsonProperty("max_examples") fun maxExamples(): Long? = maxExamples

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
         * If set to `true`, the returned JSON will include a "prompt" field containing the final
         * prompt that was used to request a completion. This is mainly useful for debugging
         * purposes.
         */
        @JsonProperty("return_prompt") fun returnPrompt(): Boolean? = returnPrompt

        /**
         * A special boolean flag for showing metadata. If set to `true`, each document entry in the
         * returned JSON will contain a "metadata" field.
         *
         * This flag only takes effect when `file` is set.
         */
        @JsonProperty("return_metadata") fun returnMetadata(): Boolean? = returnMetadata

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

            return other is ClassificationCreateBody &&
                this.model == other.model &&
                this.query == other.query &&
                this.examples == other.examples &&
                this.file == other.file &&
                this.labels == other.labels &&
                this.searchModel == other.searchModel &&
                this.temperature == other.temperature &&
                this.logprobs == other.logprobs &&
                this.maxExamples == other.maxExamples &&
                this.logitBias == other.logitBias &&
                this.returnPrompt == other.returnPrompt &&
                this.returnMetadata == other.returnMetadata &&
                this.expand == other.expand &&
                this.user == other.user &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        model,
                        query,
                        examples,
                        file,
                        labels,
                        searchModel,
                        temperature,
                        logprobs,
                        maxExamples,
                        logitBias,
                        returnPrompt,
                        returnMetadata,
                        expand,
                        user,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ClassificationCreateBody{model=$model, query=$query, examples=$examples, file=$file, labels=$labels, searchModel=$searchModel, temperature=$temperature, logprobs=$logprobs, maxExamples=$maxExamples, logitBias=$logitBias, returnPrompt=$returnPrompt, returnMetadata=$returnMetadata, expand=$expand, user=$user, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: String? = null
            private var query: String? = null
            private var examples: List<List<String>>? = null
            private var file: String? = null
            private var labels: List<String>? = null
            private var searchModel: String? = null
            private var temperature: Double? = null
            private var logprobs: Long? = null
            private var maxExamples: Long? = null
            private var logitBias: JsonValue? = null
            private var returnPrompt: Boolean? = null
            private var returnMetadata: Boolean? = null
            private var expand: List<JsonValue>? = null
            private var user: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(classificationCreateBody: ClassificationCreateBody) = apply {
                this.model = classificationCreateBody.model
                this.query = classificationCreateBody.query
                this.examples = classificationCreateBody.examples
                this.file = classificationCreateBody.file
                this.labels = classificationCreateBody.labels
                this.searchModel = classificationCreateBody.searchModel
                this.temperature = classificationCreateBody.temperature
                this.logprobs = classificationCreateBody.logprobs
                this.maxExamples = classificationCreateBody.maxExamples
                this.logitBias = classificationCreateBody.logitBias
                this.returnPrompt = classificationCreateBody.returnPrompt
                this.returnMetadata = classificationCreateBody.returnMetadata
                this.expand = classificationCreateBody.expand
                this.user = classificationCreateBody.user
                additionalProperties(classificationCreateBody.additionalProperties)
            }

            /**
             * ID of the model to use. You can use the
             * [List models](/docs/api-reference/models/list) API to see all of your available
             * models, or see our [Model overview](/docs/models/overview) for descriptions of them.
             */
            @JsonProperty("model") fun model(model: String) = apply { this.model = model }

            /** Query to be classified. */
            @JsonProperty("query") fun query(query: String) = apply { this.query = query }

            /**
             * A list of examples with labels, in the following format:
             *
             * `[["The movie is so interesting.", "Positive"], ["It is quite boring.", "Negative"],
             * ...]`
             *
             * All the label strings will be normalized to be capitalized.
             *
             * You should specify either `examples` or `file`, but not both.
             */
            @JsonProperty("examples")
            fun examples(examples: List<List<String>>) = apply { this.examples = examples }

            /**
             * The ID of the uploaded file that contains training examples. See
             * [upload file](/docs/api-reference/files/upload) for how to upload a file of the
             * desired format and purpose.
             *
             * You should specify either `examples` or `file`, but not both.
             */
            @JsonProperty("file") fun file(file: String) = apply { this.file = file }

            /**
             * The set of categories being classified. If not specified, candidate labels will be
             * automatically collected from the examples you provide. All the label strings will be
             * normalized to be capitalized.
             */
            @JsonProperty("labels")
            fun labels(labels: List<String>) = apply { this.labels = labels }

            /**
             * ID of the model to use for [Search](/docs/api-reference/searches/create). You can
             * select one of `ada`, `babbage`, `curie`, or `davinci`.
             */
            @JsonProperty("search_model")
            fun searchModel(searchModel: String) = apply { this.searchModel = searchModel }

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

            /**
             * The maximum number of examples to be ranked by
             * [Search](/docs/api-reference/searches/create) when using `file`. Setting it to a
             * higher value leads to improved accuracy but with increased latency and cost.
             */
            @JsonProperty("max_examples")
            fun maxExamples(maxExamples: Long) = apply { this.maxExamples = maxExamples }

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
             * If set to `true`, the returned JSON will include a "prompt" field containing the
             * final prompt that was used to request a completion. This is mainly useful for
             * debugging purposes.
             */
            @JsonProperty("return_prompt")
            fun returnPrompt(returnPrompt: Boolean) = apply { this.returnPrompt = returnPrompt }

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

            fun build(): ClassificationCreateBody =
                ClassificationCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    checkNotNull(query) { "`query` is required but was not set" },
                    examples?.toUnmodifiable(),
                    file,
                    labels?.toUnmodifiable(),
                    searchModel,
                    temperature,
                    logprobs,
                    maxExamples,
                    logitBias,
                    returnPrompt,
                    returnMetadata,
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

        return other is ClassificationCreateParams &&
            this.model == other.model &&
            this.query == other.query &&
            this.examples == other.examples &&
            this.file == other.file &&
            this.labels == other.labels &&
            this.searchModel == other.searchModel &&
            this.temperature == other.temperature &&
            this.logprobs == other.logprobs &&
            this.maxExamples == other.maxExamples &&
            this.logitBias == other.logitBias &&
            this.returnPrompt == other.returnPrompt &&
            this.returnMetadata == other.returnMetadata &&
            this.expand == other.expand &&
            this.user == other.user &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            model,
            query,
            examples,
            file,
            labels,
            searchModel,
            temperature,
            logprobs,
            maxExamples,
            logitBias,
            returnPrompt,
            returnMetadata,
            expand,
            user,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "ClassificationCreateParams{model=$model, query=$query, examples=$examples, file=$file, labels=$labels, searchModel=$searchModel, temperature=$temperature, logprobs=$logprobs, maxExamples=$maxExamples, logitBias=$logitBias, returnPrompt=$returnPrompt, returnMetadata=$returnMetadata, expand=$expand, user=$user, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: String? = null
        private var query: String? = null
        private var examples: List<List<String>>? = null
        private var file: String? = null
        private var labels: List<String>? = null
        private var searchModel: String? = null
        private var temperature: Double? = null
        private var logprobs: Long? = null
        private var maxExamples: Long? = null
        private var logitBias: JsonValue? = null
        private var returnPrompt: Boolean? = null
        private var returnMetadata: Boolean? = null
        private var expand: List<JsonValue>? = null
        private var user: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(classificationCreateParams: ClassificationCreateParams) = apply {
            this.model = classificationCreateParams.model
            this.query = classificationCreateParams.query
            this.examples = classificationCreateParams.examples
            this.file = classificationCreateParams.file
            this.labels = classificationCreateParams.labels
            this.searchModel = classificationCreateParams.searchModel
            this.temperature = classificationCreateParams.temperature
            this.logprobs = classificationCreateParams.logprobs
            this.maxExamples = classificationCreateParams.maxExamples
            this.logitBias = classificationCreateParams.logitBias
            this.returnPrompt = classificationCreateParams.returnPrompt
            this.returnMetadata = classificationCreateParams.returnMetadata
            this.expand = classificationCreateParams.expand
            this.user = classificationCreateParams.user
            additionalQueryParams(classificationCreateParams.additionalQueryParams)
            additionalHeaders(classificationCreateParams.additionalHeaders)
            additionalBodyProperties(classificationCreateParams.additionalBodyProperties)
        }

        /**
         * ID of the model to use. You can use the [List models](/docs/api-reference/models/list)
         * API to see all of your available models, or see our
         * [Model overview](/docs/models/overview) for descriptions of them.
         */
        fun model(model: String) = apply { this.model = model }

        /** Query to be classified. */
        fun query(query: String) = apply { this.query = query }

        /**
         * A list of examples with labels, in the following format:
         *
         * `[["The movie is so interesting.", "Positive"], ["It is quite boring.", "Negative"],
         * ...]`
         *
         * All the label strings will be normalized to be capitalized.
         *
         * You should specify either `examples` or `file`, but not both.
         */
        fun examples(examples: List<List<String>>) = apply { this.examples = examples }

        /**
         * The ID of the uploaded file that contains training examples. See
         * [upload file](/docs/api-reference/files/upload) for how to upload a file of the desired
         * format and purpose.
         *
         * You should specify either `examples` or `file`, but not both.
         */
        fun file(file: String) = apply { this.file = file }

        /**
         * The set of categories being classified. If not specified, candidate labels will be
         * automatically collected from the examples you provide. All the label strings will be
         * normalized to be capitalized.
         */
        fun labels(labels: List<String>) = apply { this.labels = labels }

        /**
         * ID of the model to use for [Search](/docs/api-reference/searches/create). You can select
         * one of `ada`, `babbage`, `curie`, or `davinci`.
         */
        fun searchModel(searchModel: String) = apply { this.searchModel = searchModel }

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

        /**
         * The maximum number of examples to be ranked by
         * [Search](/docs/api-reference/searches/create) when using `file`. Setting it to a higher
         * value leads to improved accuracy but with increased latency and cost.
         */
        fun maxExamples(maxExamples: Long) = apply { this.maxExamples = maxExamples }

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
         * If set to `true`, the returned JSON will include a "prompt" field containing the final
         * prompt that was used to request a completion. This is mainly useful for debugging
         * purposes.
         */
        fun returnPrompt(returnPrompt: Boolean) = apply { this.returnPrompt = returnPrompt }

        /**
         * A special boolean flag for showing metadata. If set to `true`, each document entry in the
         * returned JSON will contain a "metadata" field.
         *
         * This flag only takes effect when `file` is set.
         */
        fun returnMetadata(returnMetadata: Boolean) = apply { this.returnMetadata = returnMetadata }

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

        fun build(): ClassificationCreateParams =
            ClassificationCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                checkNotNull(query) { "`query` is required but was not set" },
                examples?.toUnmodifiable(),
                file,
                labels?.toUnmodifiable(),
                searchModel,
                temperature,
                logprobs,
                maxExamples,
                logitBias,
                returnPrompt,
                returnMetadata,
                expand?.toUnmodifiable(),
                user,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }
}
