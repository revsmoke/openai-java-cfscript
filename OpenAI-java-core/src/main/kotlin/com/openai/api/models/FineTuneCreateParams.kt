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

class FineTuneCreateParams
constructor(
    private val trainingFile: String,
    private val validationFile: String?,
    private val model: String?,
    private val nEpochs: Long?,
    private val batchSize: Long?,
    private val learningRateMultiplier: Double?,
    private val promptLossWeight: Double?,
    private val computeClassificationMetrics: Boolean?,
    private val classificationNClasses: Long?,
    private val classificationPositiveClass: String?,
    private val classificationBetas: List<Double>?,
    private val suffix: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun trainingFile(): String = trainingFile

    fun validationFile(): Optional<String> = Optional.ofNullable(validationFile)

    fun model(): Optional<String> = Optional.ofNullable(model)

    fun nEpochs(): Optional<Long> = Optional.ofNullable(nEpochs)

    fun batchSize(): Optional<Long> = Optional.ofNullable(batchSize)

    fun learningRateMultiplier(): Optional<Double> = Optional.ofNullable(learningRateMultiplier)

    fun promptLossWeight(): Optional<Double> = Optional.ofNullable(promptLossWeight)

    fun computeClassificationMetrics(): Optional<Boolean> =
        Optional.ofNullable(computeClassificationMetrics)

    fun classificationNClasses(): Optional<Long> = Optional.ofNullable(classificationNClasses)

    fun classificationPositiveClass(): Optional<String> =
        Optional.ofNullable(classificationPositiveClass)

    fun classificationBetas(): Optional<List<Double>> = Optional.ofNullable(classificationBetas)

    fun suffix(): Optional<String> = Optional.ofNullable(suffix)

    @JvmSynthetic
    internal fun getBody(): FineTuneCreateBody {
        return FineTuneCreateBody(
            trainingFile,
            validationFile,
            model,
            nEpochs,
            batchSize,
            learningRateMultiplier,
            promptLossWeight,
            computeClassificationMetrics,
            classificationNClasses,
            classificationPositiveClass,
            classificationBetas,
            suffix,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = FineTuneCreateBody.Builder::class)
    @NoAutoDetect
    class FineTuneCreateBody
    internal constructor(
        private val trainingFile: String?,
        private val validationFile: String?,
        private val model: String?,
        private val nEpochs: Long?,
        private val batchSize: Long?,
        private val learningRateMultiplier: Double?,
        private val promptLossWeight: Double?,
        private val computeClassificationMetrics: Boolean?,
        private val classificationNClasses: Long?,
        private val classificationPositiveClass: String?,
        private val classificationBetas: List<Double>?,
        private val suffix: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * The ID of an uploaded file that contains training data.
         *
         * See [upload file](/docs/api-reference/files/upload) for how to upload a file.
         *
         * Your dataset must be formatted as a JSONL file, where each training example is a JSON
         * object with the keys "prompt" and "completion". Additionally, you must upload your file
         * with the purpose `fine-tune`.
         *
         * See the [fine-tuning guide](/docs/guides/fine-tuning/creating-training-data) for more
         * details.
         */
        @JsonProperty("training_file") fun trainingFile(): String? = trainingFile

        /**
         * The ID of an uploaded file that contains validation data.
         *
         * If you provide this file, the data is used to generate validation metrics periodically
         * during fine-tuning. These metrics can be viewed in the
         * [fine-tuning results file](/docs/guides/fine-tuning/analyzing-your-fine-tuned-model).
         * Your train and validation data should be mutually exclusive.
         *
         * Your dataset must be formatted as a JSONL file, where each validation example is a JSON
         * object with the keys "prompt" and "completion". Additionally, you must upload your file
         * with the purpose `fine-tune`.
         *
         * See the [fine-tuning guide](/docs/guides/fine-tuning/creating-training-data) for more
         * details.
         */
        @JsonProperty("validation_file") fun validationFile(): String? = validationFile

        /**
         * The name of the base model to fine-tune. You can select one of "ada", "babbage", "curie",
         * "davinci", or a fine-tuned model created after 2022-04-21. To learn more about these
         * models, see the [Models](https://platform.openai.com/docs/models) documentation.
         */
        @JsonProperty("model") fun model(): String? = model

        /**
         * The number of epochs to train the model for. An epoch refers to one full cycle through
         * the training dataset.
         */
        @JsonProperty("n_epochs") fun nEpochs(): Long? = nEpochs

        /**
         * The batch size to use for training. The batch size is the number of training examples
         * used to train a single forward and backward pass.
         *
         * By default, the batch size will be dynamically configured to be ~0.2% of the number of
         * examples in the training set, capped at 256 - in general, we've found that larger batch
         * sizes tend to work better for larger datasets.
         */
        @JsonProperty("batch_size") fun batchSize(): Long? = batchSize

        /**
         * The learning rate multiplier to use for training. The fine-tuning learning rate is the
         * original learning rate used for pretraining multiplied by this value.
         *
         * By default, the learning rate multiplier is the 0.05, 0.1, or 0.2 depending on final
         * `batch_size` (larger learning rates tend to perform better with larger batch sizes). We
         * recommend experimenting with values in the range 0.02 to 0.2 to see what produces the
         * best results.
         */
        @JsonProperty("learning_rate_multiplier")
        fun learningRateMultiplier(): Double? = learningRateMultiplier

        /**
         * The weight to use for loss on the prompt tokens. This controls how much the model tries
         * to learn to generate the prompt (as compared to the completion which always has a weight
         * of 1.0), and can add a stabilizing effect to training when completions are short.
         *
         * If prompts are extremely long (relative to completions), it may make sense to reduce this
         * weight so as to avoid over-prioritizing learning the prompt.
         */
        @JsonProperty("prompt_loss_weight") fun promptLossWeight(): Double? = promptLossWeight

        /**
         * If set, we calculate classification-specific metrics such as accuracy and F-1 score using
         * the validation set at the end of every epoch. These metrics can be viewed in the
         * [results file](/docs/guides/fine-tuning/analyzing-your-fine-tuned-model).
         *
         * In order to compute classification metrics, you must provide a `validation_file`.
         * Additionally, you must specify `classification_n_classes` for multiclass classification
         * or `classification_positive_class` for binary classification.
         */
        @JsonProperty("compute_classification_metrics")
        fun computeClassificationMetrics(): Boolean? = computeClassificationMetrics

        /**
         * The number of classes in a classification task.
         *
         * This parameter is required for multiclass classification.
         */
        @JsonProperty("classification_n_classes")
        fun classificationNClasses(): Long? = classificationNClasses

        /**
         * The positive class in binary classification.
         *
         * This parameter is needed to generate precision, recall, and F1 metrics when doing binary
         * classification.
         */
        @JsonProperty("classification_positive_class")
        fun classificationPositiveClass(): String? = classificationPositiveClass

        /**
         * If this is provided, we calculate F-beta scores at the specified beta values. The F-beta
         * score is a generalization of F-1 score. This is only used for binary classification.
         *
         * With a beta of 1 (i.e. the F-1 score), precision and recall are given the same weight. A
         * larger beta score puts more weight on recall and less on precision. A smaller beta score
         * puts more weight on precision and less on recall.
         */
        @JsonProperty("classification_betas")
        fun classificationBetas(): List<Double>? = classificationBetas

        /**
         * A string of up to 40 characters that will be added to your fine-tuned model name.
         *
         * For example, a `suffix` of "custom-model-name" would produce a model name like
         * `ada:ft-your-org:custom-model-name-2022-02-15-04-21-04`.
         */
        @JsonProperty("suffix") fun suffix(): String? = suffix

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FineTuneCreateBody &&
                this.trainingFile == other.trainingFile &&
                this.validationFile == other.validationFile &&
                this.model == other.model &&
                this.nEpochs == other.nEpochs &&
                this.batchSize == other.batchSize &&
                this.learningRateMultiplier == other.learningRateMultiplier &&
                this.promptLossWeight == other.promptLossWeight &&
                this.computeClassificationMetrics == other.computeClassificationMetrics &&
                this.classificationNClasses == other.classificationNClasses &&
                this.classificationPositiveClass == other.classificationPositiveClass &&
                this.classificationBetas == other.classificationBetas &&
                this.suffix == other.suffix &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        trainingFile,
                        validationFile,
                        model,
                        nEpochs,
                        batchSize,
                        learningRateMultiplier,
                        promptLossWeight,
                        computeClassificationMetrics,
                        classificationNClasses,
                        classificationPositiveClass,
                        classificationBetas,
                        suffix,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "FineTuneCreateBody{trainingFile=$trainingFile, validationFile=$validationFile, model=$model, nEpochs=$nEpochs, batchSize=$batchSize, learningRateMultiplier=$learningRateMultiplier, promptLossWeight=$promptLossWeight, computeClassificationMetrics=$computeClassificationMetrics, classificationNClasses=$classificationNClasses, classificationPositiveClass=$classificationPositiveClass, classificationBetas=$classificationBetas, suffix=$suffix, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var trainingFile: String? = null
            private var validationFile: String? = null
            private var model: String? = null
            private var nEpochs: Long? = null
            private var batchSize: Long? = null
            private var learningRateMultiplier: Double? = null
            private var promptLossWeight: Double? = null
            private var computeClassificationMetrics: Boolean? = null
            private var classificationNClasses: Long? = null
            private var classificationPositiveClass: String? = null
            private var classificationBetas: List<Double>? = null
            private var suffix: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fineTuneCreateBody: FineTuneCreateBody) = apply {
                this.trainingFile = fineTuneCreateBody.trainingFile
                this.validationFile = fineTuneCreateBody.validationFile
                this.model = fineTuneCreateBody.model
                this.nEpochs = fineTuneCreateBody.nEpochs
                this.batchSize = fineTuneCreateBody.batchSize
                this.learningRateMultiplier = fineTuneCreateBody.learningRateMultiplier
                this.promptLossWeight = fineTuneCreateBody.promptLossWeight
                this.computeClassificationMetrics = fineTuneCreateBody.computeClassificationMetrics
                this.classificationNClasses = fineTuneCreateBody.classificationNClasses
                this.classificationPositiveClass = fineTuneCreateBody.classificationPositiveClass
                this.classificationBetas = fineTuneCreateBody.classificationBetas
                this.suffix = fineTuneCreateBody.suffix
                additionalProperties(fineTuneCreateBody.additionalProperties)
            }

            /**
             * The ID of an uploaded file that contains training data.
             *
             * See [upload file](/docs/api-reference/files/upload) for how to upload a file.
             *
             * Your dataset must be formatted as a JSONL file, where each training example is a JSON
             * object with the keys "prompt" and "completion". Additionally, you must upload your
             * file with the purpose `fine-tune`.
             *
             * See the [fine-tuning guide](/docs/guides/fine-tuning/creating-training-data) for more
             * details.
             */
            @JsonProperty("training_file")
            fun trainingFile(trainingFile: String) = apply { this.trainingFile = trainingFile }

            /**
             * The ID of an uploaded file that contains validation data.
             *
             * If you provide this file, the data is used to generate validation metrics
             * periodically during fine-tuning. These metrics can be viewed in the
             * [fine-tuning results file](/docs/guides/fine-tuning/analyzing-your-fine-tuned-model).
             * Your train and validation data should be mutually exclusive.
             *
             * Your dataset must be formatted as a JSONL file, where each validation example is a
             * JSON object with the keys "prompt" and "completion". Additionally, you must upload
             * your file with the purpose `fine-tune`.
             *
             * See the [fine-tuning guide](/docs/guides/fine-tuning/creating-training-data) for more
             * details.
             */
            @JsonProperty("validation_file")
            fun validationFile(validationFile: String) = apply {
                this.validationFile = validationFile
            }

            /**
             * The name of the base model to fine-tune. You can select one of "ada", "babbage",
             * "curie", "davinci", or a fine-tuned model created after 2022-04-21. To learn more
             * about these models, see the [Models](https://platform.openai.com/docs/models)
             * documentation.
             */
            @JsonProperty("model") fun model(model: String) = apply { this.model = model }

            /**
             * The number of epochs to train the model for. An epoch refers to one full cycle
             * through the training dataset.
             */
            @JsonProperty("n_epochs") fun nEpochs(nEpochs: Long) = apply { this.nEpochs = nEpochs }

            /**
             * The batch size to use for training. The batch size is the number of training examples
             * used to train a single forward and backward pass.
             *
             * By default, the batch size will be dynamically configured to be ~0.2% of the number
             * of examples in the training set, capped at 256 - in general, we've found that larger
             * batch sizes tend to work better for larger datasets.
             */
            @JsonProperty("batch_size")
            fun batchSize(batchSize: Long) = apply { this.batchSize = batchSize }

            /**
             * The learning rate multiplier to use for training. The fine-tuning learning rate is
             * the original learning rate used for pretraining multiplied by this value.
             *
             * By default, the learning rate multiplier is the 0.05, 0.1, or 0.2 depending on final
             * `batch_size` (larger learning rates tend to perform better with larger batch sizes).
             * We recommend experimenting with values in the range 0.02 to 0.2 to see what produces
             * the best results.
             */
            @JsonProperty("learning_rate_multiplier")
            fun learningRateMultiplier(learningRateMultiplier: Double) = apply {
                this.learningRateMultiplier = learningRateMultiplier
            }

            /**
             * The weight to use for loss on the prompt tokens. This controls how much the model
             * tries to learn to generate the prompt (as compared to the completion which always has
             * a weight of 1.0), and can add a stabilizing effect to training when completions are
             * short.
             *
             * If prompts are extremely long (relative to completions), it may make sense to reduce
             * this weight so as to avoid over-prioritizing learning the prompt.
             */
            @JsonProperty("prompt_loss_weight")
            fun promptLossWeight(promptLossWeight: Double) = apply {
                this.promptLossWeight = promptLossWeight
            }

            /**
             * If set, we calculate classification-specific metrics such as accuracy and F-1 score
             * using the validation set at the end of every epoch. These metrics can be viewed in
             * the [results file](/docs/guides/fine-tuning/analyzing-your-fine-tuned-model).
             *
             * In order to compute classification metrics, you must provide a `validation_file`.
             * Additionally, you must specify `classification_n_classes` for multiclass
             * classification or `classification_positive_class` for binary classification.
             */
            @JsonProperty("compute_classification_metrics")
            fun computeClassificationMetrics(computeClassificationMetrics: Boolean) = apply {
                this.computeClassificationMetrics = computeClassificationMetrics
            }

            /**
             * The number of classes in a classification task.
             *
             * This parameter is required for multiclass classification.
             */
            @JsonProperty("classification_n_classes")
            fun classificationNClasses(classificationNClasses: Long) = apply {
                this.classificationNClasses = classificationNClasses
            }

            /**
             * The positive class in binary classification.
             *
             * This parameter is needed to generate precision, recall, and F1 metrics when doing
             * binary classification.
             */
            @JsonProperty("classification_positive_class")
            fun classificationPositiveClass(classificationPositiveClass: String) = apply {
                this.classificationPositiveClass = classificationPositiveClass
            }

            /**
             * If this is provided, we calculate F-beta scores at the specified beta values. The
             * F-beta score is a generalization of F-1 score. This is only used for binary
             * classification.
             *
             * With a beta of 1 (i.e. the F-1 score), precision and recall are given the same
             * weight. A larger beta score puts more weight on recall and less on precision. A
             * smaller beta score puts more weight on precision and less on recall.
             */
            @JsonProperty("classification_betas")
            fun classificationBetas(classificationBetas: List<Double>) = apply {
                this.classificationBetas = classificationBetas
            }

            /**
             * A string of up to 40 characters that will be added to your fine-tuned model name.
             *
             * For example, a `suffix` of "custom-model-name" would produce a model name like
             * `ada:ft-your-org:custom-model-name-2022-02-15-04-21-04`.
             */
            @JsonProperty("suffix") fun suffix(suffix: String) = apply { this.suffix = suffix }

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

            fun build(): FineTuneCreateBody =
                FineTuneCreateBody(
                    checkNotNull(trainingFile) { "`trainingFile` is required but was not set" },
                    validationFile,
                    model,
                    nEpochs,
                    batchSize,
                    learningRateMultiplier,
                    promptLossWeight,
                    computeClassificationMetrics,
                    classificationNClasses,
                    classificationPositiveClass,
                    classificationBetas?.toUnmodifiable(),
                    suffix,
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

        return other is FineTuneCreateParams &&
            this.trainingFile == other.trainingFile &&
            this.validationFile == other.validationFile &&
            this.model == other.model &&
            this.nEpochs == other.nEpochs &&
            this.batchSize == other.batchSize &&
            this.learningRateMultiplier == other.learningRateMultiplier &&
            this.promptLossWeight == other.promptLossWeight &&
            this.computeClassificationMetrics == other.computeClassificationMetrics &&
            this.classificationNClasses == other.classificationNClasses &&
            this.classificationPositiveClass == other.classificationPositiveClass &&
            this.classificationBetas == other.classificationBetas &&
            this.suffix == other.suffix &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            trainingFile,
            validationFile,
            model,
            nEpochs,
            batchSize,
            learningRateMultiplier,
            promptLossWeight,
            computeClassificationMetrics,
            classificationNClasses,
            classificationPositiveClass,
            classificationBetas,
            suffix,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "FineTuneCreateParams{trainingFile=$trainingFile, validationFile=$validationFile, model=$model, nEpochs=$nEpochs, batchSize=$batchSize, learningRateMultiplier=$learningRateMultiplier, promptLossWeight=$promptLossWeight, computeClassificationMetrics=$computeClassificationMetrics, classificationNClasses=$classificationNClasses, classificationPositiveClass=$classificationPositiveClass, classificationBetas=$classificationBetas, suffix=$suffix, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var trainingFile: String? = null
        private var validationFile: String? = null
        private var model: String? = null
        private var nEpochs: Long? = null
        private var batchSize: Long? = null
        private var learningRateMultiplier: Double? = null
        private var promptLossWeight: Double? = null
        private var computeClassificationMetrics: Boolean? = null
        private var classificationNClasses: Long? = null
        private var classificationPositiveClass: String? = null
        private var classificationBetas: List<Double>? = null
        private var suffix: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fineTuneCreateParams: FineTuneCreateParams) = apply {
            this.trainingFile = fineTuneCreateParams.trainingFile
            this.validationFile = fineTuneCreateParams.validationFile
            this.model = fineTuneCreateParams.model
            this.nEpochs = fineTuneCreateParams.nEpochs
            this.batchSize = fineTuneCreateParams.batchSize
            this.learningRateMultiplier = fineTuneCreateParams.learningRateMultiplier
            this.promptLossWeight = fineTuneCreateParams.promptLossWeight
            this.computeClassificationMetrics = fineTuneCreateParams.computeClassificationMetrics
            this.classificationNClasses = fineTuneCreateParams.classificationNClasses
            this.classificationPositiveClass = fineTuneCreateParams.classificationPositiveClass
            this.classificationBetas = fineTuneCreateParams.classificationBetas
            this.suffix = fineTuneCreateParams.suffix
            additionalQueryParams(fineTuneCreateParams.additionalQueryParams)
            additionalHeaders(fineTuneCreateParams.additionalHeaders)
            additionalBodyProperties(fineTuneCreateParams.additionalBodyProperties)
        }

        /**
         * The ID of an uploaded file that contains training data.
         *
         * See [upload file](/docs/api-reference/files/upload) for how to upload a file.
         *
         * Your dataset must be formatted as a JSONL file, where each training example is a JSON
         * object with the keys "prompt" and "completion". Additionally, you must upload your file
         * with the purpose `fine-tune`.
         *
         * See the [fine-tuning guide](/docs/guides/fine-tuning/creating-training-data) for more
         * details.
         */
        fun trainingFile(trainingFile: String) = apply { this.trainingFile = trainingFile }

        /**
         * The ID of an uploaded file that contains validation data.
         *
         * If you provide this file, the data is used to generate validation metrics periodically
         * during fine-tuning. These metrics can be viewed in the
         * [fine-tuning results file](/docs/guides/fine-tuning/analyzing-your-fine-tuned-model).
         * Your train and validation data should be mutually exclusive.
         *
         * Your dataset must be formatted as a JSONL file, where each validation example is a JSON
         * object with the keys "prompt" and "completion". Additionally, you must upload your file
         * with the purpose `fine-tune`.
         *
         * See the [fine-tuning guide](/docs/guides/fine-tuning/creating-training-data) for more
         * details.
         */
        fun validationFile(validationFile: String) = apply { this.validationFile = validationFile }

        /**
         * The name of the base model to fine-tune. You can select one of "ada", "babbage", "curie",
         * "davinci", or a fine-tuned model created after 2022-04-21. To learn more about these
         * models, see the [Models](https://platform.openai.com/docs/models) documentation.
         */
        fun model(model: String) = apply { this.model = model }

        /**
         * The number of epochs to train the model for. An epoch refers to one full cycle through
         * the training dataset.
         */
        fun nEpochs(nEpochs: Long) = apply { this.nEpochs = nEpochs }

        /**
         * The batch size to use for training. The batch size is the number of training examples
         * used to train a single forward and backward pass.
         *
         * By default, the batch size will be dynamically configured to be ~0.2% of the number of
         * examples in the training set, capped at 256 - in general, we've found that larger batch
         * sizes tend to work better for larger datasets.
         */
        fun batchSize(batchSize: Long) = apply { this.batchSize = batchSize }

        /**
         * The learning rate multiplier to use for training. The fine-tuning learning rate is the
         * original learning rate used for pretraining multiplied by this value.
         *
         * By default, the learning rate multiplier is the 0.05, 0.1, or 0.2 depending on final
         * `batch_size` (larger learning rates tend to perform better with larger batch sizes). We
         * recommend experimenting with values in the range 0.02 to 0.2 to see what produces the
         * best results.
         */
        fun learningRateMultiplier(learningRateMultiplier: Double) = apply {
            this.learningRateMultiplier = learningRateMultiplier
        }

        /**
         * The weight to use for loss on the prompt tokens. This controls how much the model tries
         * to learn to generate the prompt (as compared to the completion which always has a weight
         * of 1.0), and can add a stabilizing effect to training when completions are short.
         *
         * If prompts are extremely long (relative to completions), it may make sense to reduce this
         * weight so as to avoid over-prioritizing learning the prompt.
         */
        fun promptLossWeight(promptLossWeight: Double) = apply {
            this.promptLossWeight = promptLossWeight
        }

        /**
         * If set, we calculate classification-specific metrics such as accuracy and F-1 score using
         * the validation set at the end of every epoch. These metrics can be viewed in the
         * [results file](/docs/guides/fine-tuning/analyzing-your-fine-tuned-model).
         *
         * In order to compute classification metrics, you must provide a `validation_file`.
         * Additionally, you must specify `classification_n_classes` for multiclass classification
         * or `classification_positive_class` for binary classification.
         */
        fun computeClassificationMetrics(computeClassificationMetrics: Boolean) = apply {
            this.computeClassificationMetrics = computeClassificationMetrics
        }

        /**
         * The number of classes in a classification task.
         *
         * This parameter is required for multiclass classification.
         */
        fun classificationNClasses(classificationNClasses: Long) = apply {
            this.classificationNClasses = classificationNClasses
        }

        /**
         * The positive class in binary classification.
         *
         * This parameter is needed to generate precision, recall, and F1 metrics when doing binary
         * classification.
         */
        fun classificationPositiveClass(classificationPositiveClass: String) = apply {
            this.classificationPositiveClass = classificationPositiveClass
        }

        /**
         * If this is provided, we calculate F-beta scores at the specified beta values. The F-beta
         * score is a generalization of F-1 score. This is only used for binary classification.
         *
         * With a beta of 1 (i.e. the F-1 score), precision and recall are given the same weight. A
         * larger beta score puts more weight on recall and less on precision. A smaller beta score
         * puts more weight on precision and less on recall.
         */
        fun classificationBetas(classificationBetas: List<Double>) = apply {
            this.classificationBetas = classificationBetas
        }

        /**
         * A string of up to 40 characters that will be added to your fine-tuned model name.
         *
         * For example, a `suffix` of "custom-model-name" would produce a model name like
         * `ada:ft-your-org:custom-model-name-2022-02-15-04-21-04`.
         */
        fun suffix(suffix: String) = apply { this.suffix = suffix }

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

        fun build(): FineTuneCreateParams =
            FineTuneCreateParams(
                checkNotNull(trainingFile) { "`trainingFile` is required but was not set" },
                validationFile,
                model,
                nEpochs,
                batchSize,
                learningRateMultiplier,
                promptLossWeight,
                computeClassificationMetrics,
                classificationNClasses,
                classificationPositiveClass,
                classificationBetas?.toUnmodifiable(),
                suffix,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }
}
