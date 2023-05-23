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

@JsonDeserialize(builder = DeleteFileResponse.Builder::class)
@NoAutoDetect
class DeleteFileResponse
private constructor(
    private val id: JsonField<String>,
    private val object_: JsonField<String>,
    private val deleted: JsonField<Boolean>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): String = id.getRequired("id")

    fun object_(): String = object_.getRequired("object")

    fun deleted(): Boolean = deleted.getRequired("deleted")

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonProperty("deleted") @ExcludeMissing fun _deleted() = deleted

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): DeleteFileResponse = apply {
        if (!validated) {
            id()
            object_()
            deleted()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DeleteFileResponse &&
            this.id == other.id &&
            this.object_ == other.object_ &&
            this.deleted == other.deleted &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    object_,
                    deleted,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "DeleteFileResponse{id=$id, object_=$object_, deleted=$deleted, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<String> = JsonMissing.of()
        private var deleted: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(deleteFileResponse: DeleteFileResponse) = apply {
            this.id = deleteFileResponse.id
            this.object_ = deleteFileResponse.object_
            this.deleted = deleteFileResponse.deleted
            additionalProperties(deleteFileResponse.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        fun object_(object_: String) = object_(JsonField.of(object_))

        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

        fun deleted(deleted: Boolean) = deleted(JsonField.of(deleted))

        @JsonProperty("deleted")
        @ExcludeMissing
        fun deleted(deleted: JsonField<Boolean>) = apply { this.deleted = deleted }

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

        fun build(): DeleteFileResponse =
            DeleteFileResponse(
                id,
                object_,
                deleted,
                additionalProperties.toUnmodifiable(),
            )
    }
}
