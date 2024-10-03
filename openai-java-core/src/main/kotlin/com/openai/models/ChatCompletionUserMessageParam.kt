// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.getOrThrow
import com.openai.core.toUnmodifiable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = ChatCompletionUserMessageParam.Builder::class)
@NoAutoDetect
class ChatCompletionUserMessageParam
private constructor(
    private val content: JsonField<Content>,
    private val role: JsonField<Role>,
    private val name: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The contents of the user message. */
    fun content(): Content = content.getRequired("content")

    /** The role of the messages author, in this case `user`. */
    fun role(): Role = role.getRequired("role")

    /**
     * An optional name for the participant. Provides the model information to differentiate between
     * participants of the same role.
     */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** The contents of the user message. */
    @JsonProperty("content") @ExcludeMissing fun _content() = content

    /** The role of the messages author, in this case `user`. */
    @JsonProperty("role") @ExcludeMissing fun _role() = role

    /**
     * An optional name for the participant. Provides the model information to differentiate between
     * participants of the same role.
     */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionUserMessageParam = apply {
        if (!validated) {
            content()
            role()
            name()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var content: JsonField<Content> = JsonMissing.of()
        private var role: JsonField<Role> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionUserMessageParam: ChatCompletionUserMessageParam) = apply {
            this.content = chatCompletionUserMessageParam.content
            this.role = chatCompletionUserMessageParam.role
            this.name = chatCompletionUserMessageParam.name
            additionalProperties(chatCompletionUserMessageParam.additionalProperties)
        }

        /** The contents of the user message. */
        fun content(content: Content) = content(JsonField.of(content))

        /** The contents of the user message. */
        @JsonProperty("content")
        @ExcludeMissing
        fun content(content: JsonField<Content>) = apply { this.content = content }

        /** The role of the messages author, in this case `user`. */
        fun role(role: Role) = role(JsonField.of(role))

        /** The role of the messages author, in this case `user`. */
        @JsonProperty("role")
        @ExcludeMissing
        fun role(role: JsonField<Role>) = apply { this.role = role }

        /**
         * An optional name for the participant. Provides the model information to differentiate
         * between participants of the same role.
         */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * An optional name for the participant. Provides the model information to differentiate
         * between participants of the same role.
         */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

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

        fun build(): ChatCompletionUserMessageParam =
            ChatCompletionUserMessageParam(
                content,
                role,
                name,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(using = Content.Deserializer::class)
    @JsonSerialize(using = Content.Serializer::class)
    class Content
    private constructor(
        private val string: String? = null,
        private val chatCompletionContentParts: List<ChatCompletionContentPart>? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        /** The text contents of the message. */
        fun string(): Optional<String> = Optional.ofNullable(string)
        /**
         * An array of content parts with a defined type, each can be of type `text` or `image_url`
         * when passing in images. You can pass multiple images by adding multiple `image_url`
         * content parts. Image input is only supported when using the `gpt-4o` model.
         */
        fun chatCompletionContentParts(): Optional<List<ChatCompletionContentPart>> =
            Optional.ofNullable(chatCompletionContentParts)

        fun isString(): Boolean = string != null

        fun isChatCompletionContentParts(): Boolean = chatCompletionContentParts != null

        fun asString(): String = string.getOrThrow("string")

        fun asChatCompletionContentParts(): List<ChatCompletionContentPart> =
            chatCompletionContentParts.getOrThrow("chatCompletionContentParts")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                chatCompletionContentParts != null ->
                    visitor.visitChatCompletionContentParts(chatCompletionContentParts)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Content = apply {
            if (!validated) {
                if (string == null && chatCompletionContentParts == null) {
                    throw OpenAIInvalidDataException("Unknown Content: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Content && this.string == other.string && this.chatCompletionContentParts == other.chatCompletionContentParts /* spotless:on */
        }

        override fun hashCode(): Int {
            return /* spotless:off */ Objects.hash(string, chatCompletionContentParts) /* spotless:on */
        }

        override fun toString(): String {
            return when {
                string != null -> "Content{string=$string}"
                chatCompletionContentParts != null ->
                    "Content{chatCompletionContentParts=$chatCompletionContentParts}"
                _json != null -> "Content{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Content")
            }
        }

        companion object {

            @JvmStatic fun ofString(string: String) = Content(string = string)

            @JvmStatic
            fun ofChatCompletionContentParts(
                chatCompletionContentParts: List<ChatCompletionContentPart>
            ) = Content(chatCompletionContentParts = chatCompletionContentParts)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitChatCompletionContentParts(
                chatCompletionContentParts: List<ChatCompletionContentPart>
            ): T

            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Content: $json")
            }
        }

        class Deserializer : BaseDeserializer<Content>(Content::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Content {
                val json = JsonValue.fromJsonNode(node)
                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Content(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<ChatCompletionContentPart>>())?.let {
                    return Content(chatCompletionContentParts = it, _json = json)
                }

                return Content(_json = json)
            }
        }

        class Serializer : BaseSerializer<Content>(Content::class) {

            override fun serialize(
                value: Content,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.chatCompletionContentParts != null ->
                        generator.writeObject(value.chatCompletionContentParts)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Content")
                }
            }
        }
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

            return /* spotless:off */ other is Role && this.value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val USER = Role(JsonField.of("user"))

            @JvmStatic fun of(value: String) = Role(JsonField.of(value))
        }

        enum class Known {
            USER,
        }

        enum class Value {
            USER,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                USER -> Value.USER
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                USER -> Known.USER
                else -> throw OpenAIInvalidDataException("Unknown Role: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionUserMessageParam && this.content == other.content && this.role == other.role && this.name == other.name && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(content, role, name, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "ChatCompletionUserMessageParam{content=$content, role=$role, name=$name, additionalProperties=$additionalProperties}"
}
