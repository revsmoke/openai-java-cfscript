// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.JsonValue
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

@JsonDeserialize(using = ChatCompletionMessageParam.Deserializer::class)
@JsonSerialize(using = ChatCompletionMessageParam.Serializer::class)
class ChatCompletionMessageParam
private constructor(
    private val chatCompletionRequestSystemMessage: ChatCompletionSystemMessageParam? = null,
    private val chatCompletionRequestUserMessage: ChatCompletionUserMessageParam? = null,
    private val chatCompletionRequestAssistantMessage: ChatCompletionAssistantMessageParam? = null,
    private val chatCompletionRequestToolMessage: ChatCompletionToolMessageParam? = null,
    private val chatCompletionRequestFunctionMessage: ChatCompletionFunctionMessageParam? = null,
    private val _json: JsonValue? = null,
) {

    private var validated: Boolean = false

    fun chatCompletionRequestSystemMessage(): Optional<ChatCompletionSystemMessageParam> =
        Optional.ofNullable(chatCompletionRequestSystemMessage)

    fun chatCompletionRequestUserMessage(): Optional<ChatCompletionUserMessageParam> =
        Optional.ofNullable(chatCompletionRequestUserMessage)

    fun chatCompletionRequestAssistantMessage(): Optional<ChatCompletionAssistantMessageParam> =
        Optional.ofNullable(chatCompletionRequestAssistantMessage)

    fun chatCompletionRequestToolMessage(): Optional<ChatCompletionToolMessageParam> =
        Optional.ofNullable(chatCompletionRequestToolMessage)

    fun chatCompletionRequestFunctionMessage(): Optional<ChatCompletionFunctionMessageParam> =
        Optional.ofNullable(chatCompletionRequestFunctionMessage)

    fun isChatCompletionRequestSystemMessage(): Boolean = chatCompletionRequestSystemMessage != null

    fun isChatCompletionRequestUserMessage(): Boolean = chatCompletionRequestUserMessage != null

    fun isChatCompletionRequestAssistantMessage(): Boolean =
        chatCompletionRequestAssistantMessage != null

    fun isChatCompletionRequestToolMessage(): Boolean = chatCompletionRequestToolMessage != null

    fun isChatCompletionRequestFunctionMessage(): Boolean =
        chatCompletionRequestFunctionMessage != null

    fun asChatCompletionRequestSystemMessage(): ChatCompletionSystemMessageParam =
        chatCompletionRequestSystemMessage.getOrThrow("chatCompletionRequestSystemMessage")

    fun asChatCompletionRequestUserMessage(): ChatCompletionUserMessageParam =
        chatCompletionRequestUserMessage.getOrThrow("chatCompletionRequestUserMessage")

    fun asChatCompletionRequestAssistantMessage(): ChatCompletionAssistantMessageParam =
        chatCompletionRequestAssistantMessage.getOrThrow("chatCompletionRequestAssistantMessage")

    fun asChatCompletionRequestToolMessage(): ChatCompletionToolMessageParam =
        chatCompletionRequestToolMessage.getOrThrow("chatCompletionRequestToolMessage")

    fun asChatCompletionRequestFunctionMessage(): ChatCompletionFunctionMessageParam =
        chatCompletionRequestFunctionMessage.getOrThrow("chatCompletionRequestFunctionMessage")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            chatCompletionRequestSystemMessage != null ->
                visitor.visitChatCompletionRequestSystemMessage(chatCompletionRequestSystemMessage)
            chatCompletionRequestUserMessage != null ->
                visitor.visitChatCompletionRequestUserMessage(chatCompletionRequestUserMessage)
            chatCompletionRequestAssistantMessage != null ->
                visitor.visitChatCompletionRequestAssistantMessage(
                    chatCompletionRequestAssistantMessage
                )
            chatCompletionRequestToolMessage != null ->
                visitor.visitChatCompletionRequestToolMessage(chatCompletionRequestToolMessage)
            chatCompletionRequestFunctionMessage != null ->
                visitor.visitChatCompletionRequestFunctionMessage(
                    chatCompletionRequestFunctionMessage
                )
            else -> visitor.unknown(_json)
        }
    }

    fun validate(): ChatCompletionMessageParam = apply {
        if (!validated) {
            if (
                chatCompletionRequestSystemMessage == null &&
                    chatCompletionRequestUserMessage == null &&
                    chatCompletionRequestAssistantMessage == null &&
                    chatCompletionRequestToolMessage == null &&
                    chatCompletionRequestFunctionMessage == null
            ) {
                throw OpenAIInvalidDataException("Unknown ChatCompletionMessageParam: $_json")
            }
            chatCompletionRequestSystemMessage?.validate()
            chatCompletionRequestUserMessage?.validate()
            chatCompletionRequestAssistantMessage?.validate()
            chatCompletionRequestToolMessage?.validate()
            chatCompletionRequestFunctionMessage?.validate()
            validated = true
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatCompletionMessageParam &&
            this.chatCompletionRequestSystemMessage == other.chatCompletionRequestSystemMessage &&
            this.chatCompletionRequestUserMessage == other.chatCompletionRequestUserMessage &&
            this.chatCompletionRequestAssistantMessage ==
                other.chatCompletionRequestAssistantMessage &&
            this.chatCompletionRequestToolMessage == other.chatCompletionRequestToolMessage &&
            this.chatCompletionRequestFunctionMessage == other.chatCompletionRequestFunctionMessage
    }

    override fun hashCode(): Int {
        return Objects.hash(
            chatCompletionRequestSystemMessage,
            chatCompletionRequestUserMessage,
            chatCompletionRequestAssistantMessage,
            chatCompletionRequestToolMessage,
            chatCompletionRequestFunctionMessage,
        )
    }

    override fun toString(): String {
        return when {
            chatCompletionRequestSystemMessage != null ->
                "ChatCompletionMessageParam{chatCompletionRequestSystemMessage=$chatCompletionRequestSystemMessage}"
            chatCompletionRequestUserMessage != null ->
                "ChatCompletionMessageParam{chatCompletionRequestUserMessage=$chatCompletionRequestUserMessage}"
            chatCompletionRequestAssistantMessage != null ->
                "ChatCompletionMessageParam{chatCompletionRequestAssistantMessage=$chatCompletionRequestAssistantMessage}"
            chatCompletionRequestToolMessage != null ->
                "ChatCompletionMessageParam{chatCompletionRequestToolMessage=$chatCompletionRequestToolMessage}"
            chatCompletionRequestFunctionMessage != null ->
                "ChatCompletionMessageParam{chatCompletionRequestFunctionMessage=$chatCompletionRequestFunctionMessage}"
            _json != null -> "ChatCompletionMessageParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ChatCompletionMessageParam")
        }
    }

    companion object {

        @JvmStatic
        fun ofChatCompletionRequestSystemMessage(
            chatCompletionRequestSystemMessage: ChatCompletionSystemMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionRequestSystemMessage = chatCompletionRequestSystemMessage
            )

        @JvmStatic
        fun ofChatCompletionRequestUserMessage(
            chatCompletionRequestUserMessage: ChatCompletionUserMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionRequestUserMessage = chatCompletionRequestUserMessage
            )

        @JvmStatic
        fun ofChatCompletionRequestAssistantMessage(
            chatCompletionRequestAssistantMessage: ChatCompletionAssistantMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionRequestAssistantMessage = chatCompletionRequestAssistantMessage
            )

        @JvmStatic
        fun ofChatCompletionRequestToolMessage(
            chatCompletionRequestToolMessage: ChatCompletionToolMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionRequestToolMessage = chatCompletionRequestToolMessage
            )

        @JvmStatic
        fun ofChatCompletionRequestFunctionMessage(
            chatCompletionRequestFunctionMessage: ChatCompletionFunctionMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionRequestFunctionMessage = chatCompletionRequestFunctionMessage
            )
    }

    interface Visitor<out T> {

        fun visitChatCompletionRequestSystemMessage(
            chatCompletionRequestSystemMessage: ChatCompletionSystemMessageParam
        ): T

        fun visitChatCompletionRequestUserMessage(
            chatCompletionRequestUserMessage: ChatCompletionUserMessageParam
        ): T

        fun visitChatCompletionRequestAssistantMessage(
            chatCompletionRequestAssistantMessage: ChatCompletionAssistantMessageParam
        ): T

        fun visitChatCompletionRequestToolMessage(
            chatCompletionRequestToolMessage: ChatCompletionToolMessageParam
        ): T

        fun visitChatCompletionRequestFunctionMessage(
            chatCompletionRequestFunctionMessage: ChatCompletionFunctionMessageParam
        ): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ChatCompletionMessageParam: $json")
        }
    }

    class Deserializer :
        BaseDeserializer<ChatCompletionMessageParam>(ChatCompletionMessageParam::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ChatCompletionMessageParam {
            val json = JsonValue.fromJsonNode(node)
            tryDeserialize(node, jacksonTypeRef<ChatCompletionSystemMessageParam>()) {
                    it.validate()
                }
                ?.let {
                    return ChatCompletionMessageParam(
                        chatCompletionRequestSystemMessage = it,
                        _json = json
                    )
                }
            tryDeserialize(node, jacksonTypeRef<ChatCompletionUserMessageParam>()) { it.validate() }
                ?.let {
                    return ChatCompletionMessageParam(
                        chatCompletionRequestUserMessage = it,
                        _json = json
                    )
                }
            tryDeserialize(node, jacksonTypeRef<ChatCompletionAssistantMessageParam>()) {
                    it.validate()
                }
                ?.let {
                    return ChatCompletionMessageParam(
                        chatCompletionRequestAssistantMessage = it,
                        _json = json
                    )
                }
            tryDeserialize(node, jacksonTypeRef<ChatCompletionToolMessageParam>()) { it.validate() }
                ?.let {
                    return ChatCompletionMessageParam(
                        chatCompletionRequestToolMessage = it,
                        _json = json
                    )
                }
            tryDeserialize(node, jacksonTypeRef<ChatCompletionFunctionMessageParam>()) {
                    it.validate()
                }
                ?.let {
                    return ChatCompletionMessageParam(
                        chatCompletionRequestFunctionMessage = it,
                        _json = json
                    )
                }

            return ChatCompletionMessageParam(_json = json)
        }
    }

    class Serializer :
        BaseSerializer<ChatCompletionMessageParam>(ChatCompletionMessageParam::class) {

        override fun serialize(
            value: ChatCompletionMessageParam,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.chatCompletionRequestSystemMessage != null ->
                    generator.writeObject(value.chatCompletionRequestSystemMessage)
                value.chatCompletionRequestUserMessage != null ->
                    generator.writeObject(value.chatCompletionRequestUserMessage)
                value.chatCompletionRequestAssistantMessage != null ->
                    generator.writeObject(value.chatCompletionRequestAssistantMessage)
                value.chatCompletionRequestToolMessage != null ->
                    generator.writeObject(value.chatCompletionRequestToolMessage)
                value.chatCompletionRequestFunctionMessage != null ->
                    generator.writeObject(value.chatCompletionRequestFunctionMessage)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ChatCompletionMessageParam")
            }
        }
    }
}
