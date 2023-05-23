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

@JsonDeserialize(builder = ListFineTunesResponse.Builder::class)
@NoAutoDetect
class ListFineTunesResponse
private constructor(
    private val object_: JsonField<String>,
    private val data: JsonField<List<FineTune>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun object_(): String = object_.getRequired("object")

    fun data(): List<FineTune> = data.getRequired("data")

    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonProperty("data") @ExcludeMissing fun _data() = data

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ListFineTunesResponse = apply {
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

        return other is ListFineTunesResponse &&
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
        "ListFineTunesResponse{object_=$object_, data=$data, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var object_: JsonField<String> = JsonMissing.of()
        private var data: JsonField<List<FineTune>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(listFineTunesResponse: ListFineTunesResponse) = apply {
            this.object_ = listFineTunesResponse.object_
            this.data = listFineTunesResponse.data
            additionalProperties(listFineTunesResponse.additionalProperties)
        }

        fun object_(object_: String) = object_(JsonField.of(object_))

        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

        fun data(data: List<FineTune>) = data(JsonField.of(data))

        @JsonProperty("data")
        @ExcludeMissing
        fun data(data: JsonField<List<FineTune>>) = apply { this.data = data }

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

        fun build(): ListFineTunesResponse =
            ListFineTunesResponse(
                object_,
                data.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }
}
