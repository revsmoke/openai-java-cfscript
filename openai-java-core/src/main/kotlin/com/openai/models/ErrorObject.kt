// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toUnmodifiable
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = ErrorObject.Builder::class)
@NoAutoDetect
class ErrorObject
private constructor(
    private val code: JsonField<String>,
    private val message: JsonField<String>,
    private val param: JsonField<String>,
    private val type: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    fun code(): Optional<String> = Optional.ofNullable(code.getNullable("code"))

    fun message(): String = message.getRequired("message")

    fun param(): Optional<String> = Optional.ofNullable(param.getNullable("param"))

    fun type(): String = type.getRequired("type")

    @JsonProperty("code") @ExcludeMissing fun _code() = code

    @JsonProperty("message") @ExcludeMissing fun _message() = message

    @JsonProperty("param") @ExcludeMissing fun _param() = param

    @JsonProperty("type") @ExcludeMissing fun _type() = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ErrorObject = apply {
        if (!validated) {
            code()
            message()
            param()
            type()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var code: JsonField<String> = JsonMissing.of()
        private var message: JsonField<String> = JsonMissing.of()
        private var param: JsonField<String> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(errorObject: ErrorObject) = apply {
            this.code = errorObject.code
            this.message = errorObject.message
            this.param = errorObject.param
            this.type = errorObject.type
            additionalProperties(errorObject.additionalProperties)
        }

        fun code(code: String) = code(JsonField.of(code))

        @JsonProperty("code")
        @ExcludeMissing
        fun code(code: JsonField<String>) = apply { this.code = code }

        fun message(message: String) = message(JsonField.of(message))

        @JsonProperty("message")
        @ExcludeMissing
        fun message(message: JsonField<String>) = apply { this.message = message }

        fun param(param: String) = param(JsonField.of(param))

        @JsonProperty("param")
        @ExcludeMissing
        fun param(param: JsonField<String>) = apply { this.param = param }

        fun type(type: String) = type(JsonField.of(type))

        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<String>) = apply { this.type = type }

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

        fun build(): ErrorObject =
            ErrorObject(
                code,
                message,
                param,
                type,
                additionalProperties.toUnmodifiable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ErrorObject &&
            this.code == other.code &&
            this.message == other.message &&
            this.param == other.param &&
            this.type == other.type &&
            this.additionalProperties == other.additionalProperties
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    code,
                    message,
                    param,
                    type,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "ErrorObject{code=$code, message=$message, param=$param, type=$type, additionalProperties=$additionalProperties}"
}
