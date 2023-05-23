package com.openai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.api.core.ExcludeMissing
import com.openai.api.core.JsonField
import com.openai.api.core.JsonMissing
import com.openai.api.core.JsonValue
import com.openai.api.core.NoAutoDetect
import com.openai.api.core.toUnmodifiable
import com.openai.api.errors.OpenAiInvalidDataException
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = ChatCompletion.Builder::class)
@NoAutoDetect
class ChatCompletion
private constructor(
    private val id: JsonField<String>,
    private val object_: JsonField<String>,
    private val created: JsonField<Long>,
    private val model: JsonField<String>,
    private val choices: JsonField<List<Choice>>,
    private val usage: JsonField<Usage>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): String = id.getRequired("id")

    fun object_(): String = object_.getRequired("object")

    fun created(): Long = created.getRequired("created")

    fun model(): String = model.getRequired("model")

    fun choices(): List<Choice> = choices.getRequired("choices")

    fun usage(): Optional<Usage> = Optional.ofNullable(usage.getNullable("usage"))

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonProperty("created") @ExcludeMissing fun _created() = created

    @JsonProperty("model") @ExcludeMissing fun _model() = model

    @JsonProperty("choices") @ExcludeMissing fun _choices() = choices

    @JsonProperty("usage") @ExcludeMissing fun _usage() = usage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletion = apply {
        if (!validated) {
            id()
            object_()
            created()
            model()
            choices().forEach { it.validate() }
            usage().map { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatCompletion &&
            this.id == other.id &&
            this.object_ == other.object_ &&
            this.created == other.created &&
            this.model == other.model &&
            this.choices == other.choices &&
            this.usage == other.usage &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    object_,
                    created,
                    model,
                    choices,
                    usage,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "ChatCompletion{id=$id, object_=$object_, created=$created, model=$model, choices=$choices, usage=$usage, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<String> = JsonMissing.of()
        private var created: JsonField<Long> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var choices: JsonField<List<Choice>> = JsonMissing.of()
        private var usage: JsonField<Usage> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletion: ChatCompletion) = apply {
            this.id = chatCompletion.id
            this.object_ = chatCompletion.object_
            this.created = chatCompletion.created
            this.model = chatCompletion.model
            this.choices = chatCompletion.choices
            this.usage = chatCompletion.usage
            additionalProperties(chatCompletion.additionalProperties)
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

        fun model(model: String) = model(JsonField.of(model))

        @JsonProperty("model")
        @ExcludeMissing
        fun model(model: JsonField<String>) = apply { this.model = model }

        fun choices(choices: List<Choice>) = choices(JsonField.of(choices))

        @JsonProperty("choices")
        @ExcludeMissing
        fun choices(choices: JsonField<List<Choice>>) = apply { this.choices = choices }

        fun usage(usage: Usage) = usage(JsonField.of(usage))

        @JsonProperty("usage")
        @ExcludeMissing
        fun usage(usage: JsonField<Usage>) = apply { this.usage = usage }

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

        fun build(): ChatCompletion =
            ChatCompletion(
                id,
                object_,
                created,
                model,
                choices.map { it.toUnmodifiable() },
                usage,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = Choice.Builder::class)
    @NoAutoDetect
    class Choice
    private constructor(
        private val index: JsonField<Long>,
        private val message: JsonField<ChatCompletionResponseMessage>,
        private val finishReason: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun index(): Optional<Long> = Optional.ofNullable(index.getNullable("index"))

        fun message(): Optional<ChatCompletionResponseMessage> =
            Optional.ofNullable(message.getNullable("message"))

        fun finishReason(): Optional<String> =
            Optional.ofNullable(finishReason.getNullable("finish_reason"))

        @JsonProperty("index") @ExcludeMissing fun _index() = index

        @JsonProperty("message") @ExcludeMissing fun _message() = message

        @JsonProperty("finish_reason") @ExcludeMissing fun _finishReason() = finishReason

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Choice = apply {
            if (!validated) {
                index()
                message().map { it.validate() }
                finishReason()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Choice &&
                this.index == other.index &&
                this.message == other.message &&
                this.finishReason == other.finishReason &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        index,
                        message,
                        finishReason,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Choice{index=$index, message=$message, finishReason=$finishReason, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var index: JsonField<Long> = JsonMissing.of()
            private var message: JsonField<ChatCompletionResponseMessage> = JsonMissing.of()
            private var finishReason: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(choice: Choice) = apply {
                this.index = choice.index
                this.message = choice.message
                this.finishReason = choice.finishReason
                additionalProperties(choice.additionalProperties)
            }

            fun index(index: Long) = index(JsonField.of(index))

            @JsonProperty("index")
            @ExcludeMissing
            fun index(index: JsonField<Long>) = apply { this.index = index }

            fun message(message: ChatCompletionResponseMessage) = message(JsonField.of(message))

            @JsonProperty("message")
            @ExcludeMissing
            fun message(message: JsonField<ChatCompletionResponseMessage>) = apply {
                this.message = message
            }

            fun finishReason(finishReason: String) = finishReason(JsonField.of(finishReason))

            @JsonProperty("finish_reason")
            @ExcludeMissing
            fun finishReason(finishReason: JsonField<String>) = apply {
                this.finishReason = finishReason
            }

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

            fun build(): Choice =
                Choice(
                    index,
                    message,
                    finishReason,
                    additionalProperties.toUnmodifiable(),
                )
        }

        @JsonDeserialize(builder = ChatCompletionResponseMessage.Builder::class)
        @NoAutoDetect
        class ChatCompletionResponseMessage
        private constructor(
            private val role: JsonField<Role>,
            private val content: JsonField<String>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            /** The role of the author of this message. */
            fun role(): Role = role.getRequired("role")

            /** The contents of the message */
            fun content(): String = content.getRequired("content")

            /** The role of the author of this message. */
            @JsonProperty("role") @ExcludeMissing fun _role() = role

            /** The contents of the message */
            @JsonProperty("content") @ExcludeMissing fun _content() = content

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): ChatCompletionResponseMessage = apply {
                if (!validated) {
                    role()
                    content()
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ChatCompletionResponseMessage &&
                    this.role == other.role &&
                    this.content == other.content &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            role,
                            content,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "ChatCompletionResponseMessage{role=$role, content=$content, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var role: JsonField<Role> = JsonMissing.of()
                private var content: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(chatCompletionResponseMessage: ChatCompletionResponseMessage) =
                    apply {
                        this.role = chatCompletionResponseMessage.role
                        this.content = chatCompletionResponseMessage.content
                        additionalProperties(chatCompletionResponseMessage.additionalProperties)
                    }

                /** The role of the author of this message. */
                fun role(role: Role) = role(JsonField.of(role))

                /** The role of the author of this message. */
                @JsonProperty("role")
                @ExcludeMissing
                fun role(role: JsonField<Role>) = apply { this.role = role }

                /** The contents of the message */
                fun content(content: String) = content(JsonField.of(content))

                /** The contents of the message */
                @JsonProperty("content")
                @ExcludeMissing
                fun content(content: JsonField<String>) = apply { this.content = content }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    this.additionalProperties.putAll(additionalProperties)
                }

                @JsonAnySetter
                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    this.additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun build(): ChatCompletionResponseMessage =
                    ChatCompletionResponseMessage(
                        role,
                        content,
                        additionalProperties.toUnmodifiable(),
                    )
            }

            class Role
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) {

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

                    @JvmField val SYSTEM = Role(JsonField.of("system"))

                    @JvmField val USER = Role(JsonField.of("user"))

                    @JvmField val ASSISTANT = Role(JsonField.of("assistant"))

                    @JvmStatic fun of(value: String) = Role(JsonField.of(value))
                }

                enum class Known {
                    SYSTEM,
                    USER,
                    ASSISTANT,
                }

                enum class Value {
                    SYSTEM,
                    USER,
                    ASSISTANT,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        SYSTEM -> Value.SYSTEM
                        USER -> Value.USER
                        ASSISTANT -> Value.ASSISTANT
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        SYSTEM -> Known.SYSTEM
                        USER -> Known.USER
                        ASSISTANT -> Known.ASSISTANT
                        else -> throw OpenAiInvalidDataException("Unknown Role: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()
            }
        }
    }

    @JsonDeserialize(builder = Usage.Builder::class)
    @NoAutoDetect
    class Usage
    private constructor(
        private val promptTokens: JsonField<Long>,
        private val completionTokens: JsonField<Long>,
        private val totalTokens: JsonField<Long>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun promptTokens(): Long = promptTokens.getRequired("prompt_tokens")

        fun completionTokens(): Long = completionTokens.getRequired("completion_tokens")

        fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

        @JsonProperty("prompt_tokens") @ExcludeMissing fun _promptTokens() = promptTokens

        @JsonProperty("completion_tokens")
        @ExcludeMissing
        fun _completionTokens() = completionTokens

        @JsonProperty("total_tokens") @ExcludeMissing fun _totalTokens() = totalTokens

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Usage = apply {
            if (!validated) {
                promptTokens()
                completionTokens()
                totalTokens()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Usage &&
                this.promptTokens == other.promptTokens &&
                this.completionTokens == other.completionTokens &&
                this.totalTokens == other.totalTokens &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        promptTokens,
                        completionTokens,
                        totalTokens,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Usage{promptTokens=$promptTokens, completionTokens=$completionTokens, totalTokens=$totalTokens, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var promptTokens: JsonField<Long> = JsonMissing.of()
            private var completionTokens: JsonField<Long> = JsonMissing.of()
            private var totalTokens: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(usage: Usage) = apply {
                this.promptTokens = usage.promptTokens
                this.completionTokens = usage.completionTokens
                this.totalTokens = usage.totalTokens
                additionalProperties(usage.additionalProperties)
            }

            fun promptTokens(promptTokens: Long) = promptTokens(JsonField.of(promptTokens))

            @JsonProperty("prompt_tokens")
            @ExcludeMissing
            fun promptTokens(promptTokens: JsonField<Long>) = apply {
                this.promptTokens = promptTokens
            }

            fun completionTokens(completionTokens: Long) =
                completionTokens(JsonField.of(completionTokens))

            @JsonProperty("completion_tokens")
            @ExcludeMissing
            fun completionTokens(completionTokens: JsonField<Long>) = apply {
                this.completionTokens = completionTokens
            }

            fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

            @JsonProperty("total_tokens")
            @ExcludeMissing
            fun totalTokens(totalTokens: JsonField<Long>) = apply { this.totalTokens = totalTokens }

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

            fun build(): Usage =
                Usage(
                    promptTokens,
                    completionTokens,
                    totalTokens,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
