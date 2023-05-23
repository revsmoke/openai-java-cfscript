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

@JsonDeserialize(builder = AnswerCreateResponse.Builder::class)
@NoAutoDetect
class AnswerCreateResponse
private constructor(
    private val object_: JsonField<String>,
    private val model: JsonField<String>,
    private val searchModel: JsonField<String>,
    private val completion: JsonField<String>,
    private val answers: JsonField<List<String>>,
    private val selectedDocuments: JsonField<List<SelectedDocument>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun object_(): Optional<String> = Optional.ofNullable(object_.getNullable("object"))

    fun model(): Optional<String> = Optional.ofNullable(model.getNullable("model"))

    fun searchModel(): Optional<String> =
        Optional.ofNullable(searchModel.getNullable("search_model"))

    fun completion(): Optional<String> = Optional.ofNullable(completion.getNullable("completion"))

    fun answers(): Optional<List<String>> = Optional.ofNullable(answers.getNullable("answers"))

    fun selectedDocuments(): Optional<List<SelectedDocument>> =
        Optional.ofNullable(selectedDocuments.getNullable("selected_documents"))

    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonProperty("model") @ExcludeMissing fun _model() = model

    @JsonProperty("search_model") @ExcludeMissing fun _searchModel() = searchModel

    @JsonProperty("completion") @ExcludeMissing fun _completion() = completion

    @JsonProperty("answers") @ExcludeMissing fun _answers() = answers

    @JsonProperty("selected_documents") @ExcludeMissing fun _selectedDocuments() = selectedDocuments

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): AnswerCreateResponse = apply {
        if (!validated) {
            object_()
            model()
            searchModel()
            completion()
            answers()
            selectedDocuments().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AnswerCreateResponse &&
            this.object_ == other.object_ &&
            this.model == other.model &&
            this.searchModel == other.searchModel &&
            this.completion == other.completion &&
            this.answers == other.answers &&
            this.selectedDocuments == other.selectedDocuments &&
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
                    answers,
                    selectedDocuments,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "AnswerCreateResponse{object_=$object_, model=$model, searchModel=$searchModel, completion=$completion, answers=$answers, selectedDocuments=$selectedDocuments, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var object_: JsonField<String> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var searchModel: JsonField<String> = JsonMissing.of()
        private var completion: JsonField<String> = JsonMissing.of()
        private var answers: JsonField<List<String>> = JsonMissing.of()
        private var selectedDocuments: JsonField<List<SelectedDocument>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(answerCreateResponse: AnswerCreateResponse) = apply {
            this.object_ = answerCreateResponse.object_
            this.model = answerCreateResponse.model
            this.searchModel = answerCreateResponse.searchModel
            this.completion = answerCreateResponse.completion
            this.answers = answerCreateResponse.answers
            this.selectedDocuments = answerCreateResponse.selectedDocuments
            additionalProperties(answerCreateResponse.additionalProperties)
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

        fun answers(answers: List<String>) = answers(JsonField.of(answers))

        @JsonProperty("answers")
        @ExcludeMissing
        fun answers(answers: JsonField<List<String>>) = apply { this.answers = answers }

        fun selectedDocuments(selectedDocuments: List<SelectedDocument>) =
            selectedDocuments(JsonField.of(selectedDocuments))

        @JsonProperty("selected_documents")
        @ExcludeMissing
        fun selectedDocuments(selectedDocuments: JsonField<List<SelectedDocument>>) = apply {
            this.selectedDocuments = selectedDocuments
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

        fun build(): AnswerCreateResponse =
            AnswerCreateResponse(
                object_,
                model,
                searchModel,
                completion,
                answers.map { it.toUnmodifiable() },
                selectedDocuments.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = SelectedDocument.Builder::class)
    @NoAutoDetect
    class SelectedDocument
    private constructor(
        private val document: JsonField<Long>,
        private val text: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun document(): Optional<Long> = Optional.ofNullable(document.getNullable("document"))

        fun text(): Optional<String> = Optional.ofNullable(text.getNullable("text"))

        @JsonProperty("document") @ExcludeMissing fun _document() = document

        @JsonProperty("text") @ExcludeMissing fun _text() = text

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): SelectedDocument = apply {
            if (!validated) {
                document()
                text()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is SelectedDocument &&
                this.document == other.document &&
                this.text == other.text &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        document,
                        text,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "SelectedDocument{document=$document, text=$text, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var document: JsonField<Long> = JsonMissing.of()
            private var text: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(selectedDocument: SelectedDocument) = apply {
                this.document = selectedDocument.document
                this.text = selectedDocument.text
                additionalProperties(selectedDocument.additionalProperties)
            }

            fun document(document: Long) = document(JsonField.of(document))

            @JsonProperty("document")
            @ExcludeMissing
            fun document(document: JsonField<Long>) = apply { this.document = document }

            fun text(text: String) = text(JsonField.of(text))

            @JsonProperty("text")
            @ExcludeMissing
            fun text(text: JsonField<String>) = apply { this.text = text }

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

            fun build(): SelectedDocument =
                SelectedDocument(
                    document,
                    text,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
