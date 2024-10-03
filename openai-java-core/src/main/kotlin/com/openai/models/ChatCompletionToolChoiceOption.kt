// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

@JsonDeserialize(using = ChatCompletionToolChoiceOption.Deserializer::class)
@JsonSerialize(using = ChatCompletionToolChoiceOption.Serializer::class)
class ChatCompletionToolChoiceOption
private constructor(
    private val unionMember0: UnionMember0? = null,
    private val chatCompletionNamedToolChoice: ChatCompletionNamedToolChoice? = null,
    private val _json: JsonValue? = null,
) {

    private var validated: Boolean = false

    /**
     * `none` means the model will not call any tool and instead generates a message. `auto` means
     * the model can pick between generating a message or calling one or more tools. `required`
     * means the model must call one or more tools.
     */
    fun unionMember0(): Optional<UnionMember0> = Optional.ofNullable(unionMember0)
    /**
     * Specifies a tool the model should use. Use to force the model to call a specific function.
     */
    fun chatCompletionNamedToolChoice(): Optional<ChatCompletionNamedToolChoice> =
        Optional.ofNullable(chatCompletionNamedToolChoice)

    fun isUnionMember0(): Boolean = unionMember0 != null

    fun isChatCompletionNamedToolChoice(): Boolean = chatCompletionNamedToolChoice != null

    fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

    fun asChatCompletionNamedToolChoice(): ChatCompletionNamedToolChoice =
        chatCompletionNamedToolChoice.getOrThrow("chatCompletionNamedToolChoice")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
            chatCompletionNamedToolChoice != null ->
                visitor.visitChatCompletionNamedToolChoice(chatCompletionNamedToolChoice)
            else -> visitor.unknown(_json)
        }
    }

    fun validate(): ChatCompletionToolChoiceOption = apply {
        if (!validated) {
            if (unionMember0 == null && chatCompletionNamedToolChoice == null) {
                throw OpenAIInvalidDataException("Unknown ChatCompletionToolChoiceOption: $_json")
            }
            chatCompletionNamedToolChoice?.validate()
            validated = true
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionToolChoiceOption && this.unionMember0 == other.unionMember0 && this.chatCompletionNamedToolChoice == other.chatCompletionNamedToolChoice /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(unionMember0, chatCompletionNamedToolChoice) /* spotless:on */
    }

    override fun toString(): String {
        return when {
            unionMember0 != null -> "ChatCompletionToolChoiceOption{unionMember0=$unionMember0}"
            chatCompletionNamedToolChoice != null ->
                "ChatCompletionToolChoiceOption{chatCompletionNamedToolChoice=$chatCompletionNamedToolChoice}"
            _json != null -> "ChatCompletionToolChoiceOption{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ChatCompletionToolChoiceOption")
        }
    }

    companion object {

        @JvmStatic
        fun ofUnionMember0(unionMember0: UnionMember0) =
            ChatCompletionToolChoiceOption(unionMember0 = unionMember0)

        @JvmStatic
        fun ofChatCompletionNamedToolChoice(
            chatCompletionNamedToolChoice: ChatCompletionNamedToolChoice
        ) =
            ChatCompletionToolChoiceOption(
                chatCompletionNamedToolChoice = chatCompletionNamedToolChoice
            )
    }

    interface Visitor<out T> {

        fun visitUnionMember0(unionMember0: UnionMember0): T

        fun visitChatCompletionNamedToolChoice(
            chatCompletionNamedToolChoice: ChatCompletionNamedToolChoice
        ): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ChatCompletionToolChoiceOption: $json")
        }
    }

    class Deserializer :
        BaseDeserializer<ChatCompletionToolChoiceOption>(ChatCompletionToolChoiceOption::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ChatCompletionToolChoiceOption {
            val json = JsonValue.fromJsonNode(node)
            tryDeserialize(node, jacksonTypeRef<UnionMember0>())?.let {
                return ChatCompletionToolChoiceOption(unionMember0 = it, _json = json)
            }
            tryDeserialize(node, jacksonTypeRef<ChatCompletionNamedToolChoice>()) { it.validate() }
                ?.let {
                    return ChatCompletionToolChoiceOption(
                        chatCompletionNamedToolChoice = it,
                        _json = json
                    )
                }

            return ChatCompletionToolChoiceOption(_json = json)
        }
    }

    class Serializer :
        BaseSerializer<ChatCompletionToolChoiceOption>(ChatCompletionToolChoiceOption::class) {

        override fun serialize(
            value: ChatCompletionToolChoiceOption,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.unionMember0 != null -> generator.writeObject(value.unionMember0)
                value.chatCompletionNamedToolChoice != null ->
                    generator.writeObject(value.chatCompletionNamedToolChoice)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ChatCompletionToolChoiceOption")
            }
        }
    }

    class UnionMember0
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is UnionMember0 && this.value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val NONE = UnionMember0(JsonField.of("none"))

            @JvmField val AUTO = UnionMember0(JsonField.of("auto"))

            @JvmField val REQUIRED = UnionMember0(JsonField.of("required"))

            @JvmStatic fun of(value: String) = UnionMember0(JsonField.of(value))
        }

        enum class Known {
            NONE,
            AUTO,
            REQUIRED,
        }

        enum class Value {
            NONE,
            AUTO,
            REQUIRED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                NONE -> Value.NONE
                AUTO -> Value.AUTO
                REQUIRED -> Value.REQUIRED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                NONE -> Known.NONE
                AUTO -> Known.AUTO
                REQUIRED -> Known.REQUIRED
                else -> throw OpenAIInvalidDataException("Unknown UnionMember0: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
