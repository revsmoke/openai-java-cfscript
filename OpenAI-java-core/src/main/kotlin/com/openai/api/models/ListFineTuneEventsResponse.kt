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

@JsonDeserialize(builder = ListFineTuneEventsResponse.Builder::class)
@NoAutoDetect
class ListFineTuneEventsResponse
private constructor(
    private val object_: JsonField<String>,
    private val data: JsonField<List<FineTuneEvent>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun object_(): String = object_.getRequired("object")

    fun data(): List<FineTuneEvent> = data.getRequired("data")

    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonProperty("data") @ExcludeMissing fun _data() = data

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ListFineTuneEventsResponse = apply {
        if (!validated) {
            object_()
            data().forEach { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ListFineTuneEventsResponse &&
            this.object_ == other.object_ &&
            this.data == other.data &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    object_,
                    data,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "ListFineTuneEventsResponse{object_=$object_, data=$data, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var object_: JsonField<String> = JsonMissing.of()
        private var data: JsonField<List<FineTuneEvent>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(listFineTuneEventsResponse: ListFineTuneEventsResponse) = apply {
            this.object_ = listFineTuneEventsResponse.object_
            this.data = listFineTuneEventsResponse.data
            additionalProperties(listFineTuneEventsResponse.additionalProperties)
        }

        fun object_(object_: String) = object_(JsonField.of(object_))

        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

        fun data(data: List<FineTuneEvent>) = data(JsonField.of(data))

        @JsonProperty("data")
        @ExcludeMissing
        fun data(data: JsonField<List<FineTuneEvent>>) = apply { this.data = data }

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

        fun build(): ListFineTuneEventsResponse =
            ListFineTuneEventsResponse(
                object_,
                data.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = FineTuneEvent.Builder::class)
    @NoAutoDetect
    class FineTuneEvent
    private constructor(
        private val object_: JsonField<String>,
        private val createdAt: JsonField<Long>,
        private val level: JsonField<String>,
        private val message: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun object_(): String = object_.getRequired("object")

        fun createdAt(): Long = createdAt.getRequired("created_at")

        fun level(): String = level.getRequired("level")

        fun message(): String = message.getRequired("message")

        @JsonProperty("object") @ExcludeMissing fun _object_() = object_

        @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

        @JsonProperty("level") @ExcludeMissing fun _level() = level

        @JsonProperty("message") @ExcludeMissing fun _message() = message

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): FineTuneEvent = apply {
            if (!validated) {
                object_()
                createdAt()
                level()
                message()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FineTuneEvent &&
                this.object_ == other.object_ &&
                this.createdAt == other.createdAt &&
                this.level == other.level &&
                this.message == other.message &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        object_,
                        createdAt,
                        level,
                        message,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "FineTuneEvent{object_=$object_, createdAt=$createdAt, level=$level, message=$message, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var object_: JsonField<String> = JsonMissing.of()
            private var createdAt: JsonField<Long> = JsonMissing.of()
            private var level: JsonField<String> = JsonMissing.of()
            private var message: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fineTuneEvent: FineTuneEvent) = apply {
                this.object_ = fineTuneEvent.object_
                this.createdAt = fineTuneEvent.createdAt
                this.level = fineTuneEvent.level
                this.message = fineTuneEvent.message
                additionalProperties(fineTuneEvent.additionalProperties)
            }

            fun object_(object_: String) = object_(JsonField.of(object_))

            @JsonProperty("object")
            @ExcludeMissing
            fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

            fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

            @JsonProperty("created_at")
            @ExcludeMissing
            fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

            fun level(level: String) = level(JsonField.of(level))

            @JsonProperty("level")
            @ExcludeMissing
            fun level(level: JsonField<String>) = apply { this.level = level }

            fun message(message: String) = message(JsonField.of(message))

            @JsonProperty("message")
            @ExcludeMissing
            fun message(message: JsonField<String>) = apply { this.message = message }

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

            fun build(): FineTuneEvent =
                FineTuneEvent(
                    object_,
                    createdAt,
                    level,
                    message,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
