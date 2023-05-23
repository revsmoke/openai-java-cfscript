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

@JsonDeserialize(builder = ClassificationCreateResponse.Builder::class)
@NoAutoDetect
class ClassificationCreateResponse
private constructor(
    private val object_: JsonField<String>,
    private val model: JsonField<String>,
    private val searchModel: JsonField<String>,
    private val completion: JsonField<String>,
    private val label: JsonField<String>,
    private val selectedExamples: JsonField<List<SelectedExample>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun object_(): Optional<String> = Optional.ofNullable(object_.getNullable("object"))

    fun model(): Optional<String> = Optional.ofNullable(model.getNullable("model"))

    fun searchModel(): Optional<String> =
        Optional.ofNullable(searchModel.getNullable("search_model"))

    fun completion(): Optional<String> = Optional.ofNullable(completion.getNullable("completion"))

    fun label(): Optional<String> = Optional.ofNullable(label.getNullable("label"))

    fun selectedExamples(): Optional<List<SelectedExample>> =
        Optional.ofNullable(selectedExamples.getNullable("selected_examples"))

    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonProperty("model") @ExcludeMissing fun _model() = model

    @JsonProperty("search_model") @ExcludeMissing fun _searchModel() = searchModel

    @JsonProperty("completion") @ExcludeMissing fun _completion() = completion

    @JsonProperty("label") @ExcludeMissing fun _label() = label

    @JsonProperty("selected_examples") @ExcludeMissing fun _selectedExamples() = selectedExamples

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ClassificationCreateResponse = apply {
        if (!validated) {
            object_()
            model()
            searchModel()
            completion()
            label()
            selectedExamples().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ClassificationCreateResponse &&
            this.object_ == other.object_ &&
            this.model == other.model &&
            this.searchModel == other.searchModel &&
            this.completion == other.completion &&
            this.label == other.label &&
            this.selectedExamples == other.selectedExamples &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    object_,
                    model,
                    searchModel,
                    completion,
                    label,
                    selectedExamples,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "ClassificationCreateResponse{object_=$object_, model=$model, searchModel=$searchModel, completion=$completion, label=$label, selectedExamples=$selectedExamples, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var object_: JsonField<String> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var searchModel: JsonField<String> = JsonMissing.of()
        private var completion: JsonField<String> = JsonMissing.of()
        private var label: JsonField<String> = JsonMissing.of()
        private var selectedExamples: JsonField<List<SelectedExample>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(classificationCreateResponse: ClassificationCreateResponse) = apply {
            this.object_ = classificationCreateResponse.object_
            this.model = classificationCreateResponse.model
            this.searchModel = classificationCreateResponse.searchModel
            this.completion = classificationCreateResponse.completion
            this.label = classificationCreateResponse.label
            this.selectedExamples = classificationCreateResponse.selectedExamples
            additionalProperties(classificationCreateResponse.additionalProperties)
        }

        fun object_(object_: String) = object_(JsonField.of(object_))

        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

        fun model(model: String) = model(JsonField.of(model))

        @JsonProperty("model")
        @ExcludeMissing
        fun model(model: JsonField<String>) = apply { this.model = model }

        fun searchModel(searchModel: String) = searchModel(JsonField.of(searchModel))

        @JsonProperty("search_model")
        @ExcludeMissing
        fun searchModel(searchModel: JsonField<String>) = apply { this.searchModel = searchModel }

        fun completion(completion: String) = completion(JsonField.of(completion))

        @JsonProperty("completion")
        @ExcludeMissing
        fun completion(completion: JsonField<String>) = apply { this.completion = completion }

        fun label(label: String) = label(JsonField.of(label))

        @JsonProperty("label")
        @ExcludeMissing
        fun label(label: JsonField<String>) = apply { this.label = label }

        fun selectedExamples(selectedExamples: List<SelectedExample>) =
            selectedExamples(JsonField.of(selectedExamples))

        @JsonProperty("selected_examples")
        @ExcludeMissing
        fun selectedExamples(selectedExamples: JsonField<List<SelectedExample>>) = apply {
            this.selectedExamples = selectedExamples
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

        fun build(): ClassificationCreateResponse =
            ClassificationCreateResponse(
                object_,
                model,
                searchModel,
                completion,
                label,
                selectedExamples.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = SelectedExample.Builder::class)
    @NoAutoDetect
    class SelectedExample
    private constructor(
        private val document: JsonField<Long>,
        private val text: JsonField<String>,
        private val label: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun document(): Optional<Long> = Optional.ofNullable(document.getNullable("document"))

        fun text(): Optional<String> = Optional.ofNullable(text.getNullable("text"))

        fun label(): Optional<String> = Optional.ofNullable(label.getNullable("label"))

        @JsonProperty("document") @ExcludeMissing fun _document() = document

        @JsonProperty("text") @ExcludeMissing fun _text() = text

        @JsonProperty("label") @ExcludeMissing fun _label() = label

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): SelectedExample = apply {
            if (!validated) {
                document()
                text()
                label()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is SelectedExample &&
                this.document == other.document &&
                this.text == other.text &&
                this.label == other.label &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        document,
                        text,
                        label,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "SelectedExample{document=$document, text=$text, label=$label, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var document: JsonField<Long> = JsonMissing.of()
            private var text: JsonField<String> = JsonMissing.of()
            private var label: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(selectedExample: SelectedExample) = apply {
                this.document = selectedExample.document
                this.text = selectedExample.text
                this.label = selectedExample.label
                additionalProperties(selectedExample.additionalProperties)
            }

            fun document(document: Long) = document(JsonField.of(document))

            @JsonProperty("document")
            @ExcludeMissing
            fun document(document: JsonField<Long>) = apply { this.document = document }

            fun text(text: String) = text(JsonField.of(text))

            @JsonProperty("text")
            @ExcludeMissing
            fun text(text: JsonField<String>) = apply { this.text = text }

            fun label(label: String) = label(JsonField.of(label))

            @JsonProperty("label")
            @ExcludeMissing
            fun label(label: JsonField<String>) = apply { this.label = label }

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

            fun build(): SelectedExample =
                SelectedExample(
                    document,
                    text,
                    label,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
