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

@JsonDeserialize(builder = FineTune.Builder::class)
@NoAutoDetect
class FineTune
private constructor(
    private val id: JsonField<String>,
    private val object_: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val updatedAt: JsonField<Long>,
    private val model: JsonField<String>,
    private val fineTunedModel: JsonField<String>,
    private val organizationId: JsonField<String>,
    private val status: JsonField<String>,
    private val hyperparams: JsonValue,
    private val trainingFiles: JsonField<List<File>>,
    private val validationFiles: JsonField<List<File>>,
    private val resultFiles: JsonField<List<File>>,
    private val events: JsonField<List<FineTuneEvent>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): String = id.getRequired("id")

    fun object_(): String = object_.getRequired("object")

    fun createdAt(): Long = createdAt.getRequired("created_at")

    fun updatedAt(): Long = updatedAt.getRequired("updated_at")

    fun model(): String = model.getRequired("model")

    fun fineTunedModel(): Optional<String> =
        Optional.ofNullable(fineTunedModel.getNullable("fine_tuned_model"))

    fun organizationId(): String = organizationId.getRequired("organization_id")

    fun status(): String = status.getRequired("status")

    fun trainingFiles(): List<File> = trainingFiles.getRequired("training_files")

    fun validationFiles(): List<File> = validationFiles.getRequired("validation_files")

    fun resultFiles(): List<File> = resultFiles.getRequired("result_files")

    fun events(): Optional<List<FineTuneEvent>> = Optional.ofNullable(events.getNullable("events"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    @JsonProperty("updated_at") @ExcludeMissing fun _updatedAt() = updatedAt

    @JsonProperty("model") @ExcludeMissing fun _model() = model

    @JsonProperty("fine_tuned_model") @ExcludeMissing fun _fineTunedModel() = fineTunedModel

    @JsonProperty("organization_id") @ExcludeMissing fun _organizationId() = organizationId

    @JsonProperty("status") @ExcludeMissing fun _status() = status

    @JsonProperty("hyperparams") @ExcludeMissing fun _hyperparams() = hyperparams

    @JsonProperty("training_files") @ExcludeMissing fun _trainingFiles() = trainingFiles

    @JsonProperty("validation_files") @ExcludeMissing fun _validationFiles() = validationFiles

    @JsonProperty("result_files") @ExcludeMissing fun _resultFiles() = resultFiles

    @JsonProperty("events") @ExcludeMissing fun _events() = events

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): FineTune = apply {
        if (!validated) {
            id()
            object_()
            createdAt()
            updatedAt()
            model()
            fineTunedModel()
            organizationId()
            status()
            trainingFiles().forEach { it.validate() }
            validationFiles().forEach { it.validate() }
            resultFiles().forEach { it.validate() }
            events().map { it.forEach { it.validate() } }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FineTune &&
            this.id == other.id &&
            this.object_ == other.object_ &&
            this.createdAt == other.createdAt &&
            this.updatedAt == other.updatedAt &&
            this.model == other.model &&
            this.fineTunedModel == other.fineTunedModel &&
            this.organizationId == other.organizationId &&
            this.status == other.status &&
            this.hyperparams == other.hyperparams &&
            this.trainingFiles == other.trainingFiles &&
            this.validationFiles == other.validationFiles &&
            this.resultFiles == other.resultFiles &&
            this.events == other.events &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    object_,
                    createdAt,
                    updatedAt,
                    model,
                    fineTunedModel,
                    organizationId,
                    status,
                    hyperparams,
                    trainingFiles,
                    validationFiles,
                    resultFiles,
                    events,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "FineTune{id=$id, object_=$object_, createdAt=$createdAt, updatedAt=$updatedAt, model=$model, fineTunedModel=$fineTunedModel, organizationId=$organizationId, status=$status, hyperparams=$hyperparams, trainingFiles=$trainingFiles, validationFiles=$validationFiles, resultFiles=$resultFiles, events=$events, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<Long> = JsonMissing.of()
        private var updatedAt: JsonField<Long> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var fineTunedModel: JsonField<String> = JsonMissing.of()
        private var organizationId: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var hyperparams: JsonValue = JsonMissing.of()
        private var trainingFiles: JsonField<List<File>> = JsonMissing.of()
        private var validationFiles: JsonField<List<File>> = JsonMissing.of()
        private var resultFiles: JsonField<List<File>> = JsonMissing.of()
        private var events: JsonField<List<FineTuneEvent>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fineTune: FineTune) = apply {
            this.id = fineTune.id
            this.object_ = fineTune.object_
            this.createdAt = fineTune.createdAt
            this.updatedAt = fineTune.updatedAt
            this.model = fineTune.model
            this.fineTunedModel = fineTune.fineTunedModel
            this.organizationId = fineTune.organizationId
            this.status = fineTune.status
            this.hyperparams = fineTune.hyperparams
            this.trainingFiles = fineTune.trainingFiles
            this.validationFiles = fineTune.validationFiles
            this.resultFiles = fineTune.resultFiles
            this.events = fineTune.events
            additionalProperties(fineTune.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        fun object_(object_: String) = object_(JsonField.of(object_))

        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        @JsonProperty("created_at")
        @ExcludeMissing
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        fun updatedAt(updatedAt: Long) = updatedAt(JsonField.of(updatedAt))

        @JsonProperty("updated_at")
        @ExcludeMissing
        fun updatedAt(updatedAt: JsonField<Long>) = apply { this.updatedAt = updatedAt }

        fun model(model: String) = model(JsonField.of(model))

        @JsonProperty("model")
        @ExcludeMissing
        fun model(model: JsonField<String>) = apply { this.model = model }

        fun fineTunedModel(fineTunedModel: String) = fineTunedModel(JsonField.of(fineTunedModel))

        @JsonProperty("fine_tuned_model")
        @ExcludeMissing
        fun fineTunedModel(fineTunedModel: JsonField<String>) = apply {
            this.fineTunedModel = fineTunedModel
        }

        fun organizationId(organizationId: String) = organizationId(JsonField.of(organizationId))

        @JsonProperty("organization_id")
        @ExcludeMissing
        fun organizationId(organizationId: JsonField<String>) = apply {
            this.organizationId = organizationId
        }

        fun status(status: String) = status(JsonField.of(status))

        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<String>) = apply { this.status = status }

        @JsonProperty("hyperparams")
        @ExcludeMissing
        fun hyperparams(hyperparams: JsonValue) = apply { this.hyperparams = hyperparams }

        fun trainingFiles(trainingFiles: List<File>) = trainingFiles(JsonField.of(trainingFiles))

        @JsonProperty("training_files")
        @ExcludeMissing
        fun trainingFiles(trainingFiles: JsonField<List<File>>) = apply {
            this.trainingFiles = trainingFiles
        }

        fun validationFiles(validationFiles: List<File>) =
            validationFiles(JsonField.of(validationFiles))

        @JsonProperty("validation_files")
        @ExcludeMissing
        fun validationFiles(validationFiles: JsonField<List<File>>) = apply {
            this.validationFiles = validationFiles
        }

        fun resultFiles(resultFiles: List<File>) = resultFiles(JsonField.of(resultFiles))

        @JsonProperty("result_files")
        @ExcludeMissing
        fun resultFiles(resultFiles: JsonField<List<File>>) = apply {
            this.resultFiles = resultFiles
        }

        fun events(events: List<FineTuneEvent>) = events(JsonField.of(events))

        @JsonProperty("events")
        @ExcludeMissing
        fun events(events: JsonField<List<FineTuneEvent>>) = apply { this.events = events }

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

        fun build(): FineTune =
            FineTune(
                id,
                object_,
                createdAt,
                updatedAt,
                model,
                fineTunedModel,
                organizationId,
                status,
                hyperparams,
                trainingFiles.map { it.toUnmodifiable() },
                validationFiles.map { it.toUnmodifiable() },
                resultFiles.map { it.toUnmodifiable() },
                events.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = FineTuneEvent.Builder::class)
    @NoAutoDetect
    class FineTuneEvent
    private constructor(
        private val object_: JsonField<String>,
        private val createdAt: JsonField<Long>,
        private val level: JsonField<String>,
        private val message: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun object_(): String = object_.getRequired("object")

        fun createdAt(): Long = createdAt.getRequired("created_at")

        fun level(): String = level.getRequired("level")

        fun message(): String = message.getRequired("message")

        @JsonProperty("object") @ExcludeMissing fun _object_() = object_

        @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

        @JsonProperty("level") @ExcludeMissing fun _level() = level

        @JsonProperty("message") @ExcludeMissing fun _message() = message

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): FineTuneEvent = apply {
            if (!validated) {
                object_()
                createdAt()
                level()
                message()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FineTuneEvent &&
                this.object_ == other.object_ &&
                this.createdAt == other.createdAt &&
                this.level == other.level &&
                this.message == other.message &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        object_,
                        createdAt,
                        level,
                        message,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "FineTuneEvent{object_=$object_, createdAt=$createdAt, level=$level, message=$message, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var object_: JsonField<String> = JsonMissing.of()
            private var createdAt: JsonField<Long> = JsonMissing.of()
            private var level: JsonField<String> = JsonMissing.of()
            private var message: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fineTuneEvent: FineTuneEvent) = apply {
                this.object_ = fineTuneEvent.object_
                this.createdAt = fineTuneEvent.createdAt
                this.level = fineTuneEvent.level
                this.message = fineTuneEvent.message
                additionalProperties(fineTuneEvent.additionalProperties)
            }

            fun object_(object_: String) = object_(JsonField.of(object_))

            @JsonProperty("object")
            @ExcludeMissing
            fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

            fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

            @JsonProperty("created_at")
            @ExcludeMissing
            fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

            fun level(level: String) = level(JsonField.of(level))

            @JsonProperty("level")
            @ExcludeMissing
            fun level(level: JsonField<String>) = apply { this.level = level }

            fun message(message: String) = message(JsonField.of(message))

            @JsonProperty("message")
            @ExcludeMissing
            fun message(message: JsonField<String>) = apply { this.message = message }

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

            fun build(): FineTuneEvent =
                FineTuneEvent(
                    object_,
                    createdAt,
                    level,
                    message,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
