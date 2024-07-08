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

@JsonDeserialize(using = ChatCompletionContentPart.Deserializer::class)
@JsonSerialize(using = ChatCompletionContentPart.Serializer::class)
class ChatCompletionContentPart
private constructor(
    private val chatCompletionRequestMessageContentPartText: ChatCompletionContentPartText? = null,
    private val chatCompletionRequestMessageContentPartImage: ChatCompletionContentPartImage? =
        null,
    private val _json: JsonValue? = null,
) {

    private var validated: Boolean = false

    fun chatCompletionRequestMessageContentPartText(): Optional<ChatCompletionContentPartText> =
        Optional.ofNullable(chatCompletionRequestMessageContentPartText)

    fun chatCompletionRequestMessageContentPartImage(): Optional<ChatCompletionContentPartImage> =
        Optional.ofNullable(chatCompletionRequestMessageContentPartImage)

    fun isChatCompletionRequestMessageContentPartText(): Boolean =
        chatCompletionRequestMessageContentPartText != null

    fun isChatCompletionRequestMessageContentPartImage(): Boolean =
        chatCompletionRequestMessageContentPartImage != null

    fun asChatCompletionRequestMessageContentPartText(): ChatCompletionContentPartText =
        chatCompletionRequestMessageContentPartText.getOrThrow(
            "chatCompletionRequestMessageContentPartText"
        )

    fun asChatCompletionRequestMessageContentPartImage(): ChatCompletionContentPartImage =
        chatCompletionRequestMessageContentPartImage.getOrThrow(
            "chatCompletionRequestMessageContentPartImage"
        )

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            chatCompletionRequestMessageContentPartText != null ->
                visitor.visitChatCompletionRequestMessageContentPartText(
                    chatCompletionRequestMessageContentPartText
                )
            chatCompletionRequestMessageContentPartImage != null ->
                visitor.visitChatCompletionRequestMessageContentPartImage(
                    chatCompletionRequestMessageContentPartImage
                )
            else -> visitor.unknown(_json)
        }
    }

    fun validate(): ChatCompletionContentPart = apply {
        if (!validated) {
            if (
                chatCompletionRequestMessageContentPartText == null &&
                    chatCompletionRequestMessageContentPartImage == null
            ) {
                throw OpenAIInvalidDataException("Unknown ChatCompletionContentPart: $_json")
            }
            chatCompletionRequestMessageContentPartText?.validate()
            chatCompletionRequestMessageContentPartImage?.validate()
            validated = true
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatCompletionContentPart &&
            this.chatCompletionRequestMessageContentPartText ==
                other.chatCompletionRequestMessageContentPartText &&
            this.chatCompletionRequestMessageContentPartImage ==
                other.chatCompletionRequestMessageContentPartImage
    }

    override fun hashCode(): Int {
        return Objects.hash(
            chatCompletionRequestMessageContentPartText,
            chatCompletionRequestMessageContentPartImage
        )
    }

    override fun toString(): String {
        return when {
            chatCompletionRequestMessageContentPartText != null ->
                "ChatCompletionContentPart{chatCompletionRequestMessageContentPartText=$chatCompletionRequestMessageContentPartText}"
            chatCompletionRequestMessageContentPartImage != null ->
                "ChatCompletionContentPart{chatCompletionRequestMessageContentPartImage=$chatCompletionRequestMessageContentPartImage}"
            _json != null -> "ChatCompletionContentPart{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ChatCompletionContentPart")
        }
    }

    companion object {

        @JvmStatic
        fun ofChatCompletionRequestMessageContentPartText(
            chatCompletionRequestMessageContentPartText: ChatCompletionContentPartText
        ) =
            ChatCompletionContentPart(
                chatCompletionRequestMessageContentPartText =
                    chatCompletionRequestMessageContentPartText
            )

        @JvmStatic
        fun ofChatCompletionRequestMessageContentPartImage(
            chatCompletionRequestMessageContentPartImage: ChatCompletionContentPartImage
        ) =
            ChatCompletionContentPart(
                chatCompletionRequestMessageContentPartImage =
                    chatCompletionRequestMessageContentPartImage
            )
    }

    interface Visitor<out T> {

        fun visitChatCompletionRequestMessageContentPartText(
            chatCompletionRequestMessageContentPartText: ChatCompletionContentPartText
        ): T

        fun visitChatCompletionRequestMessageContentPartImage(
            chatCompletionRequestMessageContentPartImage: ChatCompletionContentPartImage
        ): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ChatCompletionContentPart: $json")
        }
    }

    class Deserializer :
        BaseDeserializer<ChatCompletionContentPart>(ChatCompletionContentPart::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ChatCompletionContentPart {
            val json = JsonValue.fromJsonNode(node)
            tryDeserialize(node, jacksonTypeRef<ChatCompletionContentPartText>()) { it.validate() }
                ?.let {
                    return ChatCompletionContentPart(
                        chatCompletionRequestMessageContentPartText = it,
                        _json = json
                    )
                }
            tryDeserialize(node, jacksonTypeRef<ChatCompletionContentPartImage>()) { it.validate() }
                ?.let {
                    return ChatCompletionContentPart(
                        chatCompletionRequestMessageContentPartImage = it,
                        _json = json
                    )
                }

            return ChatCompletionContentPart(_json = json)
        }
    }

    class Serializer : BaseSerializer<ChatCompletionContentPart>(ChatCompletionContentPart::class) {

        override fun serialize(
            value: ChatCompletionContentPart,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.chatCompletionRequestMessageContentPartText != null ->
                    generator.writeObject(value.chatCompletionRequestMessageContentPartText)
                value.chatCompletionRequestMessageContentPartImage != null ->
                    generator.writeObject(value.chatCompletionRequestMessageContentPartImage)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ChatCompletionContentPart")
            }
        }
    }
}
