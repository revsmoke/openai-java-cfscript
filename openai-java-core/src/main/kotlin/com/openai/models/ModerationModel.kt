// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException

class ModerationModel
@JsonCreator
private constructor(
    private val value: JsonField<String>,
) : Enum {

    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ModerationModel && this.value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()

    companion object {

        @JvmField
        val TEXT_MODERATION_LATEST = ModerationModel(JsonField.of("text-moderation-latest"))

        @JvmField
        val TEXT_MODERATION_STABLE = ModerationModel(JsonField.of("text-moderation-stable"))

        @JvmStatic fun of(value: String) = ModerationModel(JsonField.of(value))
    }

    enum class Known {
        TEXT_MODERATION_LATEST,
        TEXT_MODERATION_STABLE,
    }

    enum class Value {
        TEXT_MODERATION_LATEST,
        TEXT_MODERATION_STABLE,
        _UNKNOWN,
    }

    fun value(): Value =
        when (this) {
            TEXT_MODERATION_LATEST -> Value.TEXT_MODERATION_LATEST
            TEXT_MODERATION_STABLE -> Value.TEXT_MODERATION_STABLE
            else -> Value._UNKNOWN
        }

    fun known(): Known =
        when (this) {
            TEXT_MODERATION_LATEST -> Known.TEXT_MODERATION_LATEST
            TEXT_MODERATION_STABLE -> Known.TEXT_MODERATION_STABLE
            else -> throw OpenAIInvalidDataException("Unknown ModerationModel: $value")
        }

    fun asString(): String = _value().asStringOrThrow()
}
