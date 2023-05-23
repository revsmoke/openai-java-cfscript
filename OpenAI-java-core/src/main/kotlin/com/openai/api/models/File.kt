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

@JsonDeserialize(builder = File.Builder::class)
@NoAutoDetect
class File
private constructor(
    private val id: JsonField<String>,
    private val object_: JsonField<String>,
    private val bytes: JsonField<Long>,
    private val createdAt: JsonField<Long>,
    private val filename: JsonField<String>,
    private val purpose: JsonField<String>,
    private val status: JsonField<String>,
    private val statusDetails: JsonValue,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): String = id.getRequired("id")

    fun object_(): String = object_.getRequired("object")

    fun bytes(): Long = bytes.getRequired("bytes")

    fun createdAt(): Long = createdAt.getRequired("created_at")

    fun filename(): String = filename.getRequired("filename")

    fun purpose(): String = purpose.getRequired("purpose")

    fun status(): Optional<String> = Optional.ofNullable(status.getNullable("status"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonProperty("bytes") @ExcludeMissing fun _bytes() = bytes

    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    @JsonProperty("filename") @ExcludeMissing fun _filename() = filename

    @JsonProperty("purpose") @ExcludeMissing fun _purpose() = purpose

    @JsonProperty("status") @ExcludeMissing fun _status() = status

    @JsonProperty("status_details") @ExcludeMissing fun _statusDetails() = statusDetails

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): File = apply {
        if (!validated) {
            id()
            object_()
            bytes()
            createdAt()
            filename()
            purpose()
            status()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is File &&
            this.id == other.id &&
            this.object_ == other.object_ &&
            this.bytes == other.bytes &&
            this.createdAt == other.createdAt &&
            this.filename == other.filename &&
            this.purpose == other.purpose &&
            this.status == other.status &&
            this.statusDetails == other.statusDetails &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    object_,
                    bytes,
                    createdAt,
                    filename,
                    purpose,
                    status,
                    statusDetails,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "File{id=$id, object_=$object_, bytes=$bytes, createdAt=$createdAt, filename=$filename, purpose=$purpose, status=$status, statusDetails=$statusDetails, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<String> = JsonMissing.of()
        private var bytes: JsonField<Long> = JsonMissing.of()
        private var createdAt: JsonField<Long> = JsonMissing.of()
        private var filename: JsonField<String> = JsonMissing.of()
        private var purpose: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var statusDetails: JsonValue = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(file: File) = apply {
            this.id = file.id
            this.object_ = file.object_
            this.bytes = file.bytes
            this.createdAt = file.createdAt
            this.filename = file.filename
            this.purpose = file.purpose
            this.status = file.status
            this.statusDetails = file.statusDetails
            additionalProperties(file.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        fun object_(object_: String) = object_(JsonField.of(object_))

        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

        fun bytes(bytes: Long) = bytes(JsonField.of(bytes))

        @JsonProperty("bytes")
        @ExcludeMissing
        fun bytes(bytes: JsonField<Long>) = apply { this.bytes = bytes }

        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        @JsonProperty("created_at")
        @ExcludeMissing
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        fun filename(filename: String) = filename(JsonField.of(filename))

        @JsonProperty("filename")
        @ExcludeMissing
        fun filename(filename: JsonField<String>) = apply { this.filename = filename }

        fun purpose(purpose: String) = purpose(JsonField.of(purpose))

        @JsonProperty("purpose")
        @ExcludeMissing
        fun purpose(purpose: JsonField<String>) = apply { this.purpose = purpose }

        fun status(status: String) = status(JsonField.of(status))

        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<String>) = apply { this.status = status }

        @JsonProperty("status_details")
        @ExcludeMissing
        fun statusDetails(statusDetails: JsonValue) = apply { this.statusDetails = statusDetails }

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

        fun build(): File =
            File(
                id,
                object_,
                bytes,
                createdAt,
                filename,
                purpose,
                status,
                statusDetails,
                additionalProperties.toUnmodifiable(),
            )
    }
}
