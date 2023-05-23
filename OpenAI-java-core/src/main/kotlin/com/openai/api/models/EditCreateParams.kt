package com.openai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.api.core.ExcludeMissing
import com.openai.api.core.JsonValue
import com.openai.api.core.NoAutoDetect
import com.openai.api.core.toUnmodifiable
import com.openai.api.models.*
import java.util.Objects
import java.util.Optional

class EditCreateParams
constructor(
    private val model: String,
    private val input: String?,
    private val instruction: String,
    private val n: Long?,
    private val temperature: Double?,
    private val topP: Double?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun model(): String = model

    fun input(): Optional<String> = Optional.ofNullable(input)

    fun instruction(): String = instruction

    fun n(): Optional<Long> = Optional.ofNullable(n)

    fun temperature(): Optional<Double> = Optional.ofNullable(temperature)

    fun topP(): Optional<Double> = Optional.ofNullable(topP)

    @JvmSynthetic
    internal fun getBody(): EditCreateBody {
        return EditCreateBody(
            model,
            input,
            instruction,
            n,
            temperature,
            topP,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = EditCreateBody.Builder::class)
    @NoAutoDetect
    class EditCreateBody
    internal constructor(
        private val model: String?,
        private val input: String?,
        private val instruction: String?,
        private val n: Long?,
        private val temperature: Double?,
        private val topP: Double?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * ID of the model to use. You can use the `text-davinci-edit-001` or
         * `code-davinci-edit-001` model with this endpoint.
         */
        @JsonProperty("model") fun model(): String? = model

        /** The input text to use as a starting point for the edit. */
        @JsonProperty("input") fun input(): String? = input

        /** The instruction that tells the model how to edit the prompt. */
        @JsonProperty("instruction") fun instruction(): String? = instruction

        /** How many edits to generate for the input and instruction. */
        @JsonProperty("n") fun n(): Long? = n

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         *
         * We generally recommend altering this or `top_p` but not both.
         */
        @JsonProperty("temperature") fun temperature(): Double? = temperature

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         */
        @JsonProperty("top_p") fun topP(): Double? = topP

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EditCreateBody &&
                this.model == other.model &&
                this.input == other.input &&
                this.instruction == other.instruction &&
                this.n == other.n &&
                this.temperature == other.temperature &&
                this.topP == other.topP &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        model,
                        input,
                        instruction,
                        n,
                        temperature,
                        topP,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "EditCreateBody{model=$model, input=$input, instruction=$instruction, n=$n, temperature=$temperature, topP=$topP, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: String? = null
            private var input: String? = null
            private var instruction: String? = null
            private var n: Long? = null
            private var temperature: Double? = null
            private var topP: Double? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(editCreateBody: EditCreateBody) = apply {
                this.model = editCreateBody.model
                this.input = editCreateBody.input
                this.instruction = editCreateBody.instruction
                this.n = editCreateBody.n
                this.temperature = editCreateBody.temperature
                this.topP = editCreateBody.topP
                additionalProperties(editCreateBody.additionalProperties)
            }

            /**
             * ID of the model to use. You can use the `text-davinci-edit-001` or
             * `code-davinci-edit-001` model with this endpoint.
             */
            @JsonProperty("model") fun model(model: String) = apply { this.model = model }

            /** The input text to use as a starting point for the edit. */
            @JsonProperty("input") fun input(input: String) = apply { this.input = input }

            /** The instruction that tells the model how to edit the prompt. */
            @JsonProperty("instruction")
            fun instruction(instruction: String) = apply { this.instruction = instruction }

            /** How many edits to generate for the input and instruction. */
            @JsonProperty("n") fun n(n: Long) = apply { this.n = n }

            /**
             * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make
             * the output more random, while lower values like 0.2 will make it more focused and
             * deterministic.
             *
             * We generally recommend altering this or `top_p` but not both.
             */
            @JsonProperty("temperature")
            fun temperature(temperature: Double) = apply { this.temperature = temperature }

            /**
             * An alternative to sampling with temperature, called nucleus sampling, where the model
             * considers the results of the tokens with top_p probability mass. So 0.1 means only
             * the tokens comprising the top 10% probability mass are considered.
             *
             * We generally recommend altering this or `temperature` but not both.
             */
            @JsonProperty("top_p") fun topP(topP: Double) = apply { this.topP = topP }

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

            fun build(): EditCreateBody =
                EditCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    input,
                    checkNotNull(instruction) { "`instruction` is required but was not set" },
                    n,
                    temperature,
                    topP,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EditCreateParams &&
            this.model == other.model &&
            this.input == other.input &&
            this.instruction == other.instruction &&
            this.n == other.n &&
            this.temperature == other.temperature &&
            this.topP == other.topP &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            model,
            input,
            instruction,
            n,
            temperature,
            topP,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "EditCreateParams{model=$model, input=$input, instruction=$instruction, n=$n, temperature=$temperature, topP=$topP, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var model: String? = null
        private var input: String? = null
        private var instruction: String? = null
        private var n: Long? = null
        private var temperature: Double? = null
        private var topP: Double? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(editCreateParams: EditCreateParams) = apply {
            this.model = editCreateParams.model
            this.input = editCreateParams.input
            this.instruction = editCreateParams.instruction
            this.n = editCreateParams.n
            this.temperature = editCreateParams.temperature
            this.topP = editCreateParams.topP
            additionalQueryParams(editCreateParams.additionalQueryParams)
            additionalHeaders(editCreateParams.additionalHeaders)
            additionalBodyProperties(editCreateParams.additionalBodyProperties)
        }

        /**
         * ID of the model to use. You can use the `text-davinci-edit-001` or
         * `code-davinci-edit-001` model with this endpoint.
         */
        fun model(model: String) = apply { this.model = model }

        /** The input text to use as a starting point for the edit. */
        fun input(input: String) = apply { this.input = input }

        /** The instruction that tells the model how to edit the prompt. */
        fun instruction(instruction: String) = apply { this.instruction = instruction }

        /** How many edits to generate for the input and instruction. */
        fun n(n: Long) = apply { this.n = n }

        /**
         * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the
         * output more random, while lower values like 0.2 will make it more focused and
         * deterministic.
         *
         * We generally recommend altering this or `top_p` but not both.
         */
        fun temperature(temperature: Double) = apply { this.temperature = temperature }

        /**
         * An alternative to sampling with temperature, called nucleus sampling, where the model
         * considers the results of the tokens with top_p probability mass. So 0.1 means only the
         * tokens comprising the top 10% probability mass are considered.
         *
         * We generally recommend altering this or `temperature` but not both.
         */
        fun topP(topP: Double) = apply { this.topP = topP }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): EditCreateParams =
            EditCreateParams(
                checkNotNull(model) { "`model` is required but was not set" },
                input,
                checkNotNull(instruction) { "`instruction` is required but was not set" },
                n,
                temperature,
                topP,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }
}
