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

class FineTuningJobCreateParams
constructor(
    private val model: Model,
    private val trainingFile: String,
    private val hyperparameters: Hyperparameters?,
    private val integrations: List<Integration>?,
    private val seed: Long?,
    private val suffix: String?,
    private val validationFile: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): Model = model

    fun trainingFile(): String = trainingFile

    fun hyperparameters(): Optional<Hyperparameters> = Optional.ofNullable(hyperparameters)

    fun integrations(): Optional<List<Integration>> = Optional.ofNullable(integrations)

    fun seed(): Optional<Long> = Optional.ofNullable(seed)

    fun suffix(): Optional<String> = Optional.ofNullable(suffix)

    fun validationFile(): Optional<String> = Optional.ofNullable(validationFile)

    @JvmSynthetic
    internal fun getBody(): FineTuningJobCreateBody {
        return FineTuningJobCreateBody(
            model,
            trainingFile,
            hyperparameters,
            integrations,
            seed,
            suffix,
            validationFile,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = FineTuningJobCreateBody.Builder::class)
    @NoAutoDetect
    class FineTuningJobCreateBody
    internal constructor(
        private val model: Model?,
        private val trainingFile: String?,
        private val hyperparameters: Hyperparameters?,
        private val integrations: List<Integration>?,
        private val seed: Long?,
        private val suffix: String?,
        private val validationFile: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * The name of the model to fine-tune. You can select one of the
         * [supported models](https://platform.openai.com/docs/guides/fine-tuning/what-models-can-be-fine-tuned).
         */
        @JsonProperty("model") fun model(): Model? = model

        /**
         * The ID of an uploaded file that contains training data.
         *
         * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for how to
         * upload a file.
         *
         * Your dataset must be formatted as a JSONL file. Additionally, you must upload your file
         * with the purpose `fine-tune`.
         *
         * The contents of the file should differ depending on if the model uses the
         * [chat](https://platform.openai.com/docs/api-reference/fine-tuning/chat-input) or
         * [completions](https://platform.openai.com/docs/api-reference/fine-tuning/completions-input)
         * format.
         *
         * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more
         * details.
         */
        @JsonProperty("training_file") fun trainingFile(): String? = trainingFile

        /** The hyperparameters used for the fine-tuning job. */
        @JsonProperty("hyperparameters") fun hyperparameters(): Hyperparameters? = hyperparameters

        /** A list of integrations to enable for your fine-tuning job. */
        @JsonProperty("integrations") fun integrations(): List<Integration>? = integrations

        /**
         * The seed controls the reproducibility of the job. Passing in the same seed and job
         * parameters should produce the same results, but may differ in rare cases. If a seed is
         * not specified, one will be generated for you.
         */
        @JsonProperty("seed") fun seed(): Long? = seed

        /**
         * A string of up to 18 characters that will be added to your fine-tuned model name.
         *
         * For example, a `suffix` of "custom-model-name" would produce a model name like
         * `ft:gpt-3.5-turbo:openai:custom-model-name:7p4lURel`.
         */
        @JsonProperty("suffix") fun suffix(): String? = suffix

        /**
         * The ID of an uploaded file that contains validation data.
         *
         * If you provide this file, the data is used to generate validation metrics periodically
         * during fine-tuning. These metrics can be viewed in the fine-tuning results file. The same
         * data should not be present in both train and validation files.
         *
         * Your dataset must be formatted as a JSONL file. You must upload your file with the
         * purpose `fine-tune`.
         *
         * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more
         * details.
         */
        @JsonProperty("validation_file") fun validationFile(): String? = validationFile

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FineTuningJobCreateBody &&
                this.model == other.model &&
                this.trainingFile == other.trainingFile &&
                this.hyperparameters == other.hyperparameters &&
                this.integrations == other.integrations &&
                this.seed == other.seed &&
                this.suffix == other.suffix &&
                this.validationFile == other.validationFile &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        model,
                        trainingFile,
                        hyperparameters,
                        integrations,
                        seed,
                        suffix,
                        validationFile,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "FineTuningJobCreateBody{model=$model, trainingFile=$trainingFile, hyperparameters=$hyperparameters, integrations=$integrations, seed=$seed, suffix=$suffix, validationFile=$validationFile, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: Model? = null
            private var trainingFile: String? = null
            private var hyperparameters: Hyperparameters? = null
            private var integrations: List<Integration>? = null
            private var seed: Long? = null
            private var suffix: String? = null
            private var validationFile: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fineTuningJobCreateBody: FineTuningJobCreateBody) = apply {
                this.model = fineTuningJobCreateBody.model
                this.trainingFile = fineTuningJobCreateBody.trainingFile
                this.hyperparameters = fineTuningJobCreateBody.hyperparameters
                this.integrations = fineTuningJobCreateBody.integrations
                this.seed = fineTuningJobCreateBody.seed
                this.suffix = fineTuningJobCreateBody.suffix
                this.validationFile = fineTuningJobCreateBody.validationFile
                additionalProperties(fineTuningJobCreateBody.additionalProperties)
            }

            /**
             * The name of the model to fine-tune. You can select one of the
             * [supported models](https://platform.openai.com/docs/guides/fine-tuning/what-models-can-be-fine-tuned).
             */
            @JsonProperty("model") fun model(model: Model) = apply { this.model = model }

            /**
             * The ID of an uploaded file that contains training data.
             *
             * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for
             * how to upload a file.
             *
             * Your dataset must be formatted as a JSONL file. Additionally, you must upload your
             * file with the purpose `fine-tune`.
             *
             * The contents of the file should differ depending on if the model uses the
             * [chat](https://platform.openai.com/docs/api-reference/fine-tuning/chat-input) or
             * [completions](https://platform.openai.com/docs/api-reference/fine-tuning/completions-input)
             * format.
             *
             * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for
             * more details.
             */
            @JsonProperty("training_file")
            fun trainingFile(trainingFile: String) = apply { this.trainingFile = trainingFile }

            /** The hyperparameters used for the fine-tuning job. */
            @JsonProperty("hyperparameters")
            fun hyperparameters(hyperparameters: Hyperparameters) = apply {
                this.hyperparameters = hyperparameters
            }

            /** A list of integrations to enable for your fine-tuning job. */
            @JsonProperty("integrations")
            fun integrations(integrations: List<Integration>) = apply {
                this.integrations = integrations
            }

            /**
             * The seed controls the reproducibility of the job. Passing in the same seed and job
             * parameters should produce the same results, but may differ in rare cases. If a seed
             * is not specified, one will be generated for you.
             */
            @JsonProperty("seed") fun seed(seed: Long) = apply { this.seed = seed }

            /**
             * A string of up to 18 characters that will be added to your fine-tuned model name.
             *
             * For example, a `suffix` of "custom-model-name" would produce a model name like
             * `ft:gpt-3.5-turbo:openai:custom-model-name:7p4lURel`.
             */
            @JsonProperty("suffix") fun suffix(suffix: String) = apply { this.suffix = suffix }

            /**
             * The ID of an uploaded file that contains validation data.
             *
             * If you provide this file, the data is used to generate validation metrics
             * periodically during fine-tuning. These metrics can be viewed in the fine-tuning
             * results file. The same data should not be present in both train and validation files.
             *
             * Your dataset must be formatted as a JSONL file. You must upload your file with the
             * purpose `fine-tune`.
             *
             * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for
             * more details.
             */
            @JsonProperty("validation_file")
            fun validationFile(validationFile: String) = apply {
                this.validationFile = validationFile
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

            fun build(): FineTuningJobCreateBody =
                FineTuningJobCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    checkNotNull(trainingFile) { "`trainingFile` is required but was not set" },
                    hyperparameters,
                    integrations?.toUnmodifiable(),
                    seed,
                    suffix,
                    validationFile,
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

        return other is FineTuningJobCreateParams &&
            this.model == other.model &&
            this.trainingFile == other.trainingFile &&
            this.hyperparameters == other.hyperparameters &&
            this.integrations == other.integrations &&
            this.seed == other.seed &&
            this.suffix == other.suffix &&
            this.validationFile == other.validationFile &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            model,
            trainingFile,
            hyperparameters,
            integrations,
            seed,
            suffix,
            validationFile,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "FineTuningJobCreateParams{model=$model, trainingFile=$trainingFile, hyperparameters=$hyperparameters, integrations=$integrations, seed=$seed, suffix=$suffix, validationFile=$validationFile, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: Model? = null
        private var trainingFile: String? = null
        private var hyperparameters: Hyperparameters? = null
        private var integrations: MutableList<Integration> = mutableListOf()
        private var seed: Long? = null
        private var suffix: String? = null
        private var validationFile: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fineTuningJobCreateParams: FineTuningJobCreateParams) = apply {
            this.model = fineTuningJobCreateParams.model
            this.trainingFile = fineTuningJobCreateParams.trainingFile
            this.hyperparameters = fineTuningJobCreateParams.hyperparameters
            this.integrations(fineTuningJobCreateParams.integrations ?: listOf())
            this.seed = fineTuningJobCreateParams.seed
            this.suffix = fineTuningJobCreateParams.suffix
            this.validationFile = fineTuningJobCreateParams.validationFile
            additionalQueryParams(fineTuningJobCreateParams.additionalQueryParams)
            additionalHeaders(fineTuningJobCreateParams.additionalHeaders)
            additionalBodyProperties(fineTuningJobCreateParams.additionalBodyProperties)
        }

        /**
         * The name of the model to fine-tune. You can select one of the
         * [supported models](https://platform.openai.com/docs/guides/fine-tuning/what-models-can-be-fine-tuned).
         */
        fun model(model: Model) = apply { this.model = model }

        /**
         * The name of the model to fine-tune. You can select one of the
         * [supported models](https://platform.openai.com/docs/guides/fine-tuning/what-models-can-be-fine-tuned).
         */
        fun model(string: String) = apply { this.model = Model.ofString(string) }

        /**
         * The name of the model to fine-tune. You can select one of the
         * [supported models](https://platform.openai.com/docs/guides/fine-tuning/what-models-can-be-fine-tuned).
         */
        fun model(unionMember1: Model.UnionMember1) = apply {
            this.model = Model.ofUnionMember1(unionMember1)
        }

        /**
         * The ID of an uploaded file that contains training data.
         *
         * See [upload file](https://platform.openai.com/docs/api-reference/files/create) for how to
         * upload a file.
         *
         * Your dataset must be formatted as a JSONL file. Additionally, you must upload your file
         * with the purpose `fine-tune`.
         *
         * The contents of the file should differ depending on if the model uses the
         * [chat](https://platform.openai.com/docs/api-reference/fine-tuning/chat-input) or
         * [completions](https://platform.openai.com/docs/api-reference/fine-tuning/completions-input)
         * format.
         *
         * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more
         * details.
         */
        fun trainingFile(trainingFile: String) = apply { this.trainingFile = trainingFile }

        /** The hyperparameters used for the fine-tuning job. */
        fun hyperparameters(hyperparameters: Hyperparameters) = apply {
            this.hyperparameters = hyperparameters
        }

        /** A list of integrations to enable for your fine-tuning job. */
        fun integrations(integrations: List<Integration>) = apply {
            this.integrations.clear()
            this.integrations.addAll(integrations)
        }

        /** A list of integrations to enable for your fine-tuning job. */
        fun addIntegration(integration: Integration) = apply { this.integrations.add(integration) }

        /**
         * The seed controls the reproducibility of the job. Passing in the same seed and job
         * parameters should produce the same results, but may differ in rare cases. If a seed is
         * not specified, one will be generated for you.
         */
        fun seed(seed: Long) = apply { this.seed = seed }

        /**
         * A string of up to 18 characters that will be added to your fine-tuned model name.
         *
         * For example, a `suffix` of "custom-model-name" would produce a model name like
         * `ft:gpt-3.5-turbo:openai:custom-model-name:7p4lURel`.
         */
        fun suffix(suffix: String) = apply { this.suffix = suffix }

        /**
         * The ID of an uploaded file that contains validation data.
         *
         * If you provide this file, the data is used to generate validation metrics periodically
         * during fine-tuning. These metrics can be viewed in the fine-tuning results file. The same
         * data should not be present in both train and validation files.
         *
         * Your dataset must be formatted as a JSONL file. You must upload your file with the
         * purpose `fine-tune`.
         *
         * See the [fine-tuning guide](https://platform.openai.com/docs/guides/fine-tuning) for more
         * details.
         */
        fun validationFile(validationFile: String) = apply { this.validationFile = validationFile }

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

        fun build(): FineTuningJobCreateParams =
            FineTuningJobCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                checkNotNull(trainingFile) { "`trainingFile` is required but was not set" },
                hyperparameters,
                if (integrations.size == 0) null else integrations.toUnmodifiable(),
                seed,
                suffix,
                validationFile,
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

            return other is Model &&
                this.string == other.string &&
                this.unionMember1 == other.unionMember1
        }

        override fun hashCode(): Int {
            return Objects.hash(string, unionMember1)
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

                return other is UnionMember1 && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val BABBAGE_002 = UnionMember1(JsonField.of("babbage-002"))

                @JvmField val DAVINCI_002 = UnionMember1(JsonField.of("davinci-002"))

                @JvmField val GPT_3_5_TURBO = UnionMember1(JsonField.of("gpt-3.5-turbo"))

                @JvmStatic fun of(value: String) = UnionMember1(JsonField.of(value))
            }

            enum class Known {
                BABBAGE_002,
                DAVINCI_002,
                GPT_3_5_TURBO,
            }

            enum class Value {
                BABBAGE_002,
                DAVINCI_002,
                GPT_3_5_TURBO,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    BABBAGE_002 -> Value.BABBAGE_002
                    DAVINCI_002 -> Value.DAVINCI_002
                    GPT_3_5_TURBO -> Value.GPT_3_5_TURBO
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    BABBAGE_002 -> Known.BABBAGE_002
                    DAVINCI_002 -> Known.DAVINCI_002
                    GPT_3_5_TURBO -> Known.GPT_3_5_TURBO
                    else -> throw OpenAIInvalidDataException("Unknown UnionMember1: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }

    /** The hyperparameters used for the fine-tuning job. */
    @JsonDeserialize(builder = Hyperparameters.Builder::class)
    @NoAutoDetect
    class Hyperparameters
    private constructor(
        private val batchSize: BatchSize?,
        private val learningRateMultiplier: LearningRateMultiplier?,
        private val nEpochs: NEpochs?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * Number of examples in each batch. A larger batch size means that model parameters are
         * updated less frequently, but with lower variance.
         */
        @JsonProperty("batch_size") fun batchSize(): BatchSize? = batchSize

        /**
         * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
         * overfitting.
         */
        @JsonProperty("learning_rate_multiplier")
        fun learningRateMultiplier(): LearningRateMultiplier? = learningRateMultiplier

        /**
         * The number of epochs to train the model for. An epoch refers to one full cycle through
         * the training dataset.
         */
        @JsonProperty("n_epochs") fun nEpochs(): NEpochs? = nEpochs

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Hyperparameters &&
                this.batchSize == other.batchSize &&
                this.learningRateMultiplier == other.learningRateMultiplier &&
                this.nEpochs == other.nEpochs &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        batchSize,
                        learningRateMultiplier,
                        nEpochs,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Hyperparameters{batchSize=$batchSize, learningRateMultiplier=$learningRateMultiplier, nEpochs=$nEpochs, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var batchSize: BatchSize? = null
            private var learningRateMultiplier: LearningRateMultiplier? = null
            private var nEpochs: NEpochs? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(hyperparameters: Hyperparameters) = apply {
                this.batchSize = hyperparameters.batchSize
                this.learningRateMultiplier = hyperparameters.learningRateMultiplier
                this.nEpochs = hyperparameters.nEpochs
                additionalProperties(hyperparameters.additionalProperties)
            }

            /**
             * Number of examples in each batch. A larger batch size means that model parameters are
             * updated less frequently, but with lower variance.
             */
            @JsonProperty("batch_size")
            fun batchSize(batchSize: BatchSize) = apply { this.batchSize = batchSize }

            /**
             * Scaling factor for the learning rate. A smaller learning rate may be useful to avoid
             * overfitting.
             */
            @JsonProperty("learning_rate_multiplier")
            fun learningRateMultiplier(learningRateMultiplier: LearningRateMultiplier) = apply {
                this.learningRateMultiplier = learningRateMultiplier
            }

            /**
             * The number of epochs to train the model for. An epoch refers to one full cycle
             * through the training dataset.
             */
            @JsonProperty("n_epochs")
            fun nEpochs(nEpochs: NEpochs) = apply { this.nEpochs = nEpochs }

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

            fun build(): Hyperparameters =
                Hyperparameters(
                    batchSize,
                    learningRateMultiplier,
                    nEpochs,
                    additionalProperties.toUnmodifiable(),
                )
        }

        @JsonDeserialize(using = BatchSize.Deserializer::class)
        @JsonSerialize(using = BatchSize.Serializer::class)
        class BatchSize
        private constructor(
            private val unionMember0: UnionMember0? = null,
            private val long: Long? = null,
            private val _json: JsonValue? = null,
        ) {

            private var validated: Boolean = false

            fun unionMember0(): Optional<UnionMember0> = Optional.ofNullable(unionMember0)

            fun long(): Optional<Long> = Optional.ofNullable(long)

            fun isUnionMember0(): Boolean = unionMember0 != null

            fun isLong(): Boolean = long != null

            fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

            fun asLong(): Long = long.getOrThrow("long")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
                    long != null -> visitor.visitLong(long)
                    else -> visitor.unknown(_json)
                }
            }

            fun validate(): BatchSize = apply {
                if (!validated) {
                    if (unionMember0 == null && long == null) {
                        throw OpenAIInvalidDataException("Unknown BatchSize: $_json")
                    }
                    validated = true
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is BatchSize &&
                    this.unionMember0 == other.unionMember0 &&
                    this.long == other.long
            }

            override fun hashCode(): Int {
                return Objects.hash(unionMember0, long)
            }

            override fun toString(): String {
                return when {
                    unionMember0 != null -> "BatchSize{unionMember0=$unionMember0}"
                    long != null -> "BatchSize{long=$long}"
                    _json != null -> "BatchSize{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid BatchSize")
                }
            }

            companion object {

                @JvmStatic
                fun ofUnionMember0(unionMember0: UnionMember0) =
                    BatchSize(unionMember0 = unionMember0)

                @JvmStatic fun ofLong(long: Long) = BatchSize(long = long)
            }

            interface Visitor<out T> {

                fun visitUnionMember0(unionMember0: UnionMember0): T

                fun visitLong(long: Long): T

                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown BatchSize: $json")
                }
            }

            class Deserializer : BaseDeserializer<BatchSize>(BatchSize::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): BatchSize {
                    val json = JsonValue.fromJsonNode(node)
                    tryDeserialize(node, jacksonTypeRef<UnionMember0>())?.let {
                        return BatchSize(unionMember0 = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                        return BatchSize(long = it, _json = json)
                    }

                    return BatchSize(_json = json)
                }
            }

            class Serializer : BaseSerializer<BatchSize>(BatchSize::class) {

                override fun serialize(
                    value: BatchSize,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.unionMember0 != null -> generator.writeObject(value.unionMember0)
                        value.long != null -> generator.writeObject(value.long)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid BatchSize")
                    }
                }
            }

            class UnionMember0
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnionMember0 && this.value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()

                companion object {

                    @JvmField val AUTO = UnionMember0(JsonField.of("auto"))

                    @JvmStatic fun of(value: String) = UnionMember0(JsonField.of(value))
                }

                enum class Known {
                    AUTO,
                }

                enum class Value {
                    AUTO,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        AUTO -> Value.AUTO
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        AUTO -> Known.AUTO
                        else -> throw OpenAIInvalidDataException("Unknown UnionMember0: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()
            }
        }

        @JsonDeserialize(using = LearningRateMultiplier.Deserializer::class)
        @JsonSerialize(using = LearningRateMultiplier.Serializer::class)
        class LearningRateMultiplier
        private constructor(
            private val unionMember0: UnionMember0? = null,
            private val double: Double? = null,
            private val _json: JsonValue? = null,
        ) {

            private var validated: Boolean = false

            fun unionMember0(): Optional<UnionMember0> = Optional.ofNullable(unionMember0)

            fun double(): Optional<Double> = Optional.ofNullable(double)

            fun isUnionMember0(): Boolean = unionMember0 != null

            fun isDouble(): Boolean = double != null

            fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

            fun asDouble(): Double = double.getOrThrow("double")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
                    double != null -> visitor.visitDouble(double)
                    else -> visitor.unknown(_json)
                }
            }

            fun validate(): LearningRateMultiplier = apply {
                if (!validated) {
                    if (unionMember0 == null && double == null) {
                        throw OpenAIInvalidDataException("Unknown LearningRateMultiplier: $_json")
                    }
                    validated = true
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is LearningRateMultiplier &&
                    this.unionMember0 == other.unionMember0 &&
                    this.double == other.double
            }

            override fun hashCode(): Int {
                return Objects.hash(unionMember0, double)
            }

            override fun toString(): String {
                return when {
                    unionMember0 != null -> "LearningRateMultiplier{unionMember0=$unionMember0}"
                    double != null -> "LearningRateMultiplier{double=$double}"
                    _json != null -> "LearningRateMultiplier{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid LearningRateMultiplier")
                }
            }

            companion object {

                @JvmStatic
                fun ofUnionMember0(unionMember0: UnionMember0) =
                    LearningRateMultiplier(unionMember0 = unionMember0)

                @JvmStatic fun ofDouble(double: Double) = LearningRateMultiplier(double = double)
            }

            interface Visitor<out T> {

                fun visitUnionMember0(unionMember0: UnionMember0): T

                fun visitDouble(double: Double): T

                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown LearningRateMultiplier: $json")
                }
            }

            class Deserializer :
                BaseDeserializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): LearningRateMultiplier {
                    val json = JsonValue.fromJsonNode(node)
                    tryDeserialize(node, jacksonTypeRef<UnionMember0>())?.let {
                        return LearningRateMultiplier(unionMember0 = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                        return LearningRateMultiplier(double = it, _json = json)
                    }

                    return LearningRateMultiplier(_json = json)
                }
            }

            class Serializer :
                BaseSerializer<LearningRateMultiplier>(LearningRateMultiplier::class) {

                override fun serialize(
                    value: LearningRateMultiplier,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.unionMember0 != null -> generator.writeObject(value.unionMember0)
                        value.double != null -> generator.writeObject(value.double)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid LearningRateMultiplier")
                    }
                }
            }

            class UnionMember0
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnionMember0 && this.value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()

                companion object {

                    @JvmField val AUTO = UnionMember0(JsonField.of("auto"))

                    @JvmStatic fun of(value: String) = UnionMember0(JsonField.of(value))
                }

                enum class Known {
                    AUTO,
                }

                enum class Value {
                    AUTO,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        AUTO -> Value.AUTO
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        AUTO -> Known.AUTO
                        else -> throw OpenAIInvalidDataException("Unknown UnionMember0: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()
            }
        }

        @JsonDeserialize(using = NEpochs.Deserializer::class)
        @JsonSerialize(using = NEpochs.Serializer::class)
        class NEpochs
        private constructor(
            private val unionMember0: UnionMember0? = null,
            private val long: Long? = null,
            private val _json: JsonValue? = null,
        ) {

            private var validated: Boolean = false

            fun unionMember0(): Optional<UnionMember0> = Optional.ofNullable(unionMember0)

            fun long(): Optional<Long> = Optional.ofNullable(long)

            fun isUnionMember0(): Boolean = unionMember0 != null

            fun isLong(): Boolean = long != null

            fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

            fun asLong(): Long = long.getOrThrow("long")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
                    long != null -> visitor.visitLong(long)
                    else -> visitor.unknown(_json)
                }
            }

            fun validate(): NEpochs = apply {
                if (!validated) {
                    if (unionMember0 == null && long == null) {
                        throw OpenAIInvalidDataException("Unknown NEpochs: $_json")
                    }
                    validated = true
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is NEpochs &&
                    this.unionMember0 == other.unionMember0 &&
                    this.long == other.long
            }

            override fun hashCode(): Int {
                return Objects.hash(unionMember0, long)
            }

            override fun toString(): String {
                return when {
                    unionMember0 != null -> "NEpochs{unionMember0=$unionMember0}"
                    long != null -> "NEpochs{long=$long}"
                    _json != null -> "NEpochs{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid NEpochs")
                }
            }

            companion object {

                @JvmStatic
                fun ofUnionMember0(unionMember0: UnionMember0) =
                    NEpochs(unionMember0 = unionMember0)

                @JvmStatic fun ofLong(long: Long) = NEpochs(long = long)
            }

            interface Visitor<out T> {

                fun visitUnionMember0(unionMember0: UnionMember0): T

                fun visitLong(long: Long): T

                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown NEpochs: $json")
                }
            }

            class Deserializer : BaseDeserializer<NEpochs>(NEpochs::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): NEpochs {
                    val json = JsonValue.fromJsonNode(node)
                    tryDeserialize(node, jacksonTypeRef<UnionMember0>())?.let {
                        return NEpochs(unionMember0 = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                        return NEpochs(long = it, _json = json)
                    }

                    return NEpochs(_json = json)
                }
            }

            class Serializer : BaseSerializer<NEpochs>(NEpochs::class) {

                override fun serialize(
                    value: NEpochs,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.unionMember0 != null -> generator.writeObject(value.unionMember0)
                        value.long != null -> generator.writeObject(value.long)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid NEpochs")
                    }
                }
            }

            class UnionMember0
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnionMember0 && this.value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()

                companion object {

                    @JvmField val AUTO = UnionMember0(JsonField.of("auto"))

                    @JvmStatic fun of(value: String) = UnionMember0(JsonField.of(value))
                }

                enum class Known {
                    AUTO,
                }

                enum class Value {
                    AUTO,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        AUTO -> Value.AUTO
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        AUTO -> Known.AUTO
                        else -> throw OpenAIInvalidDataException("Unknown UnionMember0: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()
            }
        }
    }

    @JsonDeserialize(builder = Integration.Builder::class)
    @NoAutoDetect
    class Integration
    private constructor(
        private val type: Type?,
        private val wandb: Wandb?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * The type of integration to enable. Currently, only "wandb" (Weights and Biases) is
         * supported.
         */
        @JsonProperty("type") fun type(): Type? = type

        /**
         * The settings for your integration with Weights and Biases. This payload specifies the
         * project that metrics will be sent to. Optionally, you can set an explicit display name
         * for your run, add tags to your run, and set a default entity (team, username, etc) to be
         * associated with your run.
         */
        @JsonProperty("wandb") fun wandb(): Wandb? = wandb

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Integration &&
                this.type == other.type &&
                this.wandb == other.wandb &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        type,
                        wandb,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Integration{type=$type, wandb=$wandb, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var type: Type? = null
            private var wandb: Wandb? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(integration: Integration) = apply {
                this.type = integration.type
                this.wandb = integration.wandb
                additionalProperties(integration.additionalProperties)
            }

            /**
             * The type of integration to enable. Currently, only "wandb" (Weights and Biases) is
             * supported.
             */
            @JsonProperty("type") fun type(type: Type) = apply { this.type = type }

            /**
             * The settings for your integration with Weights and Biases. This payload specifies the
             * project that metrics will be sent to. Optionally, you can set an explicit display
             * name for your run, add tags to your run, and set a default entity (team, username,
             * etc) to be associated with your run.
             */
            @JsonProperty("wandb") fun wandb(wandb: Wandb) = apply { this.wandb = wandb }

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

            fun build(): Integration =
                Integration(
                    checkNotNull(type) { "`type` is required but was not set" },
                    checkNotNull(wandb) { "`wandb` is required but was not set" },
                    additionalProperties.toUnmodifiable(),
                )
        }

        class Type
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Type && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val WANDB = Type(JsonField.of("wandb"))

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            enum class Known {
                WANDB,
            }

            enum class Value {
                WANDB,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    WANDB -> Value.WANDB
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    WANDB -> Known.WANDB
                    else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }

        /**
         * The settings for your integration with Weights and Biases. This payload specifies the
         * project that metrics will be sent to. Optionally, you can set an explicit display name
         * for your run, add tags to your run, and set a default entity (team, username, etc) to be
         * associated with your run.
         */
        @JsonDeserialize(builder = Wandb.Builder::class)
        @NoAutoDetect
        class Wandb
        private constructor(
            private val project: String?,
            private val name: String?,
            private val entity: String?,
            private val tags: List<String>?,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var hashCode: Int = 0

            /** The name of the project that the new run will be created under. */
            @JsonProperty("project") fun project(): String? = project

            /**
             * A display name to set for the run. If not set, we will use the Job ID as the name.
             */
            @JsonProperty("name") fun name(): String? = name

            /**
             * The entity to use for the run. This allows you to set the team or username of the
             * WandB user that you would like associated with the run. If not set, the default
             * entity for the registered WandB API key is used.
             */
            @JsonProperty("entity") fun entity(): String? = entity

            /**
             * A list of tags to be attached to the newly created run. These tags are passed through
             * directly to WandB. Some default tags are generated by OpenAI: "openai/finetune",
             * "openai/{base-model}", "openai/{ftjob-abcdef}".
             */
            @JsonProperty("tags") fun tags(): List<String>? = tags

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Wandb &&
                    this.project == other.project &&
                    this.name == other.name &&
                    this.entity == other.entity &&
                    this.tags == other.tags &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            project,
                            name,
                            entity,
                            tags,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "Wandb{project=$project, name=$name, entity=$entity, tags=$tags, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var project: String? = null
                private var name: String? = null
                private var entity: String? = null
                private var tags: List<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(wandb: Wandb) = apply {
                    this.project = wandb.project
                    this.name = wandb.name
                    this.entity = wandb.entity
                    this.tags = wandb.tags
                    additionalProperties(wandb.additionalProperties)
                }

                /** The name of the project that the new run will be created under. */
                @JsonProperty("project")
                fun project(project: String) = apply { this.project = project }

                /**
                 * A display name to set for the run. If not set, we will use the Job ID as the
                 * name.
                 */
                @JsonProperty("name") fun name(name: String) = apply { this.name = name }

                /**
                 * The entity to use for the run. This allows you to set the team or username of the
                 * WandB user that you would like associated with the run. If not set, the default
                 * entity for the registered WandB API key is used.
                 */
                @JsonProperty("entity") fun entity(entity: String) = apply { this.entity = entity }

                /**
                 * A list of tags to be attached to the newly created run. These tags are passed
                 * through directly to WandB. Some default tags are generated by OpenAI:
                 * "openai/finetune", "openai/{base-model}", "openai/{ftjob-abcdef}".
                 */
                @JsonProperty("tags") fun tags(tags: List<String>) = apply { this.tags = tags }

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

                fun build(): Wandb =
                    Wandb(
                        checkNotNull(project) { "`project` is required but was not set" },
                        name,
                        entity,
                        tags?.toUnmodifiable(),
                        additionalProperties.toUnmodifiable(),
                    )
            }
        }
    }
}
