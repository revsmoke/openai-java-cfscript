// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toUnmodifiable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

@JsonDeserialize(builder = ResponseFormatJsonObject.Builder::class)
@NoAutoDetect
class ResponseFormatJsonObject
private constructor(
    private val type: JsonField<Type>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The type of response format being defined: `json_object` */
    fun type(): Type = type.getRequired("type")

    /** The type of response format being defined: `json_object` */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ResponseFormatJsonObject = apply {
        if (!validated) {
            type()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseFormatJsonObject: ResponseFormatJsonObject) = apply {
            this.type = responseFormatJsonObject.type
            additionalProperties(responseFormatJsonObject.additionalProperties)
        }

        /** The type of response format being defined: `json_object` */
        fun type(type: Type) = type(JsonField.of(type))

        /** The type of response format being defined: `json_object` */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<Type>) = apply { this.type = type }

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

        fun build(): ResponseFormatJsonObject =
            ResponseFormatJsonObject(type, additionalProperties.toUnmodifiable())
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

            @JvmField val JSON_OBJECT = Type(JsonField.of("json_object"))

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            JSON_OBJECT,
        }

        enum class Value {
            JSON_OBJECT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                JSON_OBJECT -> Value.JSON_OBJECT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                JSON_OBJECT -> Known.JSON_OBJECT
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseFormatJsonObject &&
            this.type == other.type &&
            this.additionalProperties == other.additionalProperties
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = Objects.hash(type, additionalProperties)
        }
        return hashCode
    }

    override fun toString() =
        "ResponseFormatJsonObject{type=$type, additionalProperties=$additionalProperties}"
}
