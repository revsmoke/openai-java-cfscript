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

@JsonDeserialize(builder = ChatCompletionToolMessageParam.Builder::class)
@NoAutoDetect
class ChatCompletionToolMessageParam
private constructor(
    private val role: JsonField<Role>,
    private val content: JsonField<String>,
    private val toolCallId: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The role of the messages author, in this case `tool`. */
    fun role(): Role = role.getRequired("role")

    /** The contents of the tool message. */
    fun content(): String = content.getRequired("content")

    /** Tool call that this message is responding to. */
    fun toolCallId(): String = toolCallId.getRequired("tool_call_id")

    /** The role of the messages author, in this case `tool`. */
    @JsonProperty("role") @ExcludeMissing fun _role() = role

    /** The contents of the tool message. */
    @JsonProperty("content") @ExcludeMissing fun _content() = content

    /** Tool call that this message is responding to. */
    @JsonProperty("tool_call_id") @ExcludeMissing fun _toolCallId() = toolCallId

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionToolMessageParam = apply {
        if (!validated) {
            role()
            content()
            toolCallId()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatCompletionToolMessageParam &&
            this.role == other.role &&
            this.content == other.content &&
            this.toolCallId == other.toolCallId &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    role,
                    content,
                    toolCallId,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "ChatCompletionToolMessageParam{role=$role, content=$content, toolCallId=$toolCallId, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var role: JsonField<Role> = JsonMissing.of()
        private var content: JsonField<String> = JsonMissing.of()
        private var toolCallId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionToolMessageParam: ChatCompletionToolMessageParam) = apply {
            this.role = chatCompletionToolMessageParam.role
            this.content = chatCompletionToolMessageParam.content
            this.toolCallId = chatCompletionToolMessageParam.toolCallId
            additionalProperties(chatCompletionToolMessageParam.additionalProperties)
        }

        /** The role of the messages author, in this case `tool`. */
        fun role(role: Role) = role(JsonField.of(role))

        /** The role of the messages author, in this case `tool`. */
        @JsonProperty("role")
        @ExcludeMissing
        fun role(role: JsonField<Role>) = apply { this.role = role }

        /** The contents of the tool message. */
        fun content(content: String) = content(JsonField.of(content))

        /** The contents of the tool message. */
        @JsonProperty("content")
        @ExcludeMissing
        fun content(content: JsonField<String>) = apply { this.content = content }

        /** Tool call that this message is responding to. */
        fun toolCallId(toolCallId: String) = toolCallId(JsonField.of(toolCallId))

        /** Tool call that this message is responding to. */
        @JsonProperty("tool_call_id")
        @ExcludeMissing
        fun toolCallId(toolCallId: JsonField<String>) = apply { this.toolCallId = toolCallId }

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

        fun build(): ChatCompletionToolMessageParam =
            ChatCompletionToolMessageParam(
                role,
                content,
                toolCallId,
                additionalProperties.toUnmodifiable(),
            )
    }

    class Role
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Role && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val TOOL = Role(JsonField.of("tool"))

            @JvmStatic fun of(value: String) = Role(JsonField.of(value))
        }

        enum class Known {
            TOOL,
        }

        enum class Value {
            TOOL,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                TOOL -> Value.TOOL
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                TOOL -> Known.TOOL
                else -> throw OpenAIInvalidDataException("Unknown Role: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
