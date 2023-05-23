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

@JsonDeserialize(builder = Model.Builder::class)
@NoAutoDetect
class Model
private constructor(
    private val id: JsonField<String>,
    private val object_: JsonField<String>,
    private val created: JsonField<Long>,
    private val ownedBy: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): String = id.getRequired("id")

    fun object_(): String = object_.getRequired("object")

    fun created(): Long = created.getRequired("created")

    fun ownedBy(): String = ownedBy.getRequired("owned_by")

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonProperty("created") @ExcludeMissing fun _created() = created

    @JsonProperty("owned_by") @ExcludeMissing fun _ownedBy() = ownedBy

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Model = apply {
        if (!validated) {
            id()
            object_()
            created()
            ownedBy()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Model &&
            this.id == other.id &&
            this.object_ == other.object_ &&
            this.created == other.created &&
            this.ownedBy == other.ownedBy &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    object_,
                    created,
                    ownedBy,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Model{id=$id, object_=$object_, created=$created, ownedBy=$ownedBy, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<String> = JsonMissing.of()
        private var created: JsonField<Long> = JsonMissing.of()
        private var ownedBy: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(model: Model) = apply {
            this.id = model.id
            this.object_ = model.object_
            this.created = model.created
            this.ownedBy = model.ownedBy
            additionalProperties(model.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        fun object_(object_: String) = object_(JsonField.of(object_))

        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

        fun created(created: Long) = created(JsonField.of(created))

        @JsonProperty("created")
        @ExcludeMissing
        fun created(created: JsonField<Long>) = apply { this.created = created }

        fun ownedBy(ownedBy: String) = ownedBy(JsonField.of(ownedBy))

        @JsonProperty("owned_by")
        @ExcludeMissing
        fun ownedBy(ownedBy: JsonField<String>) = apply { this.ownedBy = ownedBy }

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

        fun build(): Model =
            Model(
                id,
                object_,
                created,
                ownedBy,
                additionalProperties.toUnmodifiable(),
            )
    }
}
