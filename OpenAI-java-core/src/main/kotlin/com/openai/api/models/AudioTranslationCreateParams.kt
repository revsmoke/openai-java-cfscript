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

class AudioTranslationCreateParams
constructor(
    private val file: String,
    private val model: String,
    private val prompt: String?,
    private val responseFormat: String?,
    private val temperature: Double?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun file(): String = file

    fun model(): String = model

    fun prompt(): Optional<String> = Optional.ofNullable(prompt)

    fun responseFormat(): Optional<String> = Optional.ofNullable(responseFormat)

    fun temperature(): Optional<Double> = Optional.ofNullable(temperature)

    @JvmSynthetic
    internal fun getBody(): AudioTranslationCreateBody {
        return AudioTranslationCreateBody(
            file,
            model,
            prompt,
            responseFormat,
            temperature,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = AudioTranslationCreateBody.Builder::class)
    @NoAutoDetect
    class AudioTranslationCreateBody
    internal constructor(
        private val file: String?,
        private val model: String?,
        private val prompt: String?,
        private val responseFormat: String?,
        private val temperature: Double?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * The audio file to translate, in one of these formats: mp3, mp4, mpeg, mpga, m4a, wav, or
         * webm.
         */
        @JsonProperty("file") fun file(): String? = file

        /** ID of the model to use. Only `whisper-1` is currently available. */
        @JsonProperty("model") fun model(): String? = model

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](/docs/guides/speech-to-text/prompting) should be in English.
         */
        @JsonProperty("prompt") fun prompt(): String? = prompt

        /**
         * The format of the transcript output, in one of these options: json, text, srt,
         * verbose_json, or vtt.
         */
        @JsonProperty("response_format") fun responseFormat(): String? = responseFormat

        /**
         * The sampling temperature, between 0 and 1. Higher values like 0.8 will make the output
         * more random, while lower values like 0.2 will make it more focused and deterministic. If
         * set to 0, the model will use
         * [log probability](https://en.wikipedia.org/wiki/Log_probability) to automatically
         * increase the temperature until certain thresholds are hit.
         */
        @JsonProperty("temperature") fun temperature(): Double? = temperature

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AudioTranslationCreateBody &&
                this.file == other.file &&
                this.model == other.model &&
                this.prompt == other.prompt &&
                this.responseFormat == other.responseFormat &&
                this.temperature == other.temperature &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        file,
                        model,
                        prompt,
                        responseFormat,
                        temperature,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "AudioTranslationCreateBody{file=$file, model=$model, prompt=$prompt, responseFormat=$responseFormat, temperature=$temperature, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var file: String? = null
            private var model: String? = null
            private var prompt: String? = null
            private var responseFormat: String? = null
            private var temperature: Double? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(audioTranslationCreateBody: AudioTranslationCreateBody) = apply {
                this.file = audioTranslationCreateBody.file
                this.model = audioTranslationCreateBody.model
                this.prompt = audioTranslationCreateBody.prompt
                this.responseFormat = audioTranslationCreateBody.responseFormat
                this.temperature = audioTranslationCreateBody.temperature
                additionalProperties(audioTranslationCreateBody.additionalProperties)
            }

            /**
             * The audio file to translate, in one of these formats: mp3, mp4, mpeg, mpga, m4a, wav,
             * or webm.
             */
            @JsonProperty("file") fun file(file: String) = apply { this.file = file }

            /** ID of the model to use. Only `whisper-1` is currently available. */
            @JsonProperty("model") fun model(model: String) = apply { this.model = model }

            /**
             * An optional text to guide the model's style or continue a previous audio segment. The
             * [prompt](/docs/guides/speech-to-text/prompting) should be in English.
             */
            @JsonProperty("prompt") fun prompt(prompt: String) = apply { this.prompt = prompt }

            /**
             * The format of the transcript output, in one of these options: json, text, srt,
             * verbose_json, or vtt.
             */
            @JsonProperty("response_format")
            fun responseFormat(responseFormat: String) = apply {
                this.responseFormat = responseFormat
            }

            /**
             * The sampling temperature, between 0 and 1. Higher values like 0.8 will make the
             * output more random, while lower values like 0.2 will make it more focused and
             * deterministic. If set to 0, the model will use
             * [log probability](https://en.wikipedia.org/wiki/Log_probability) to automatically
             * increase the temperature until certain thresholds are hit.
             */
            @JsonProperty("temperature")
            fun temperature(temperature: Double) = apply { this.temperature = temperature }

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

            fun build(): AudioTranslationCreateBody =
                AudioTranslationCreateBody(
                    checkNotNull(file) { "`file` is required but was not set" },
                    checkNotNull(model) { "`model` is required but was not set" },
                    prompt,
                    responseFormat,
                    temperature,
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

        return other is AudioTranslationCreateParams &&
            this.file == other.file &&
            this.model == other.model &&
            this.prompt == other.prompt &&
            this.responseFormat == other.responseFormat &&
            this.temperature == other.temperature &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            file,
            model,
            prompt,
            responseFormat,
            temperature,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "AudioTranslationCreateParams{file=$file, model=$model, prompt=$prompt, responseFormat=$responseFormat, temperature=$temperature, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var file: String? = null
        private var model: String? = null
        private var prompt: String? = null
        private var responseFormat: String? = null
        private var temperature: Double? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(audioTranslationCreateParams: AudioTranslationCreateParams) = apply {
            this.file = audioTranslationCreateParams.file
            this.model = audioTranslationCreateParams.model
            this.prompt = audioTranslationCreateParams.prompt
            this.responseFormat = audioTranslationCreateParams.responseFormat
            this.temperature = audioTranslationCreateParams.temperature
            additionalQueryParams(audioTranslationCreateParams.additionalQueryParams)
            additionalHeaders(audioTranslationCreateParams.additionalHeaders)
            additionalBodyProperties(audioTranslationCreateParams.additionalBodyProperties)
        }

        /**
         * The audio file to translate, in one of these formats: mp3, mp4, mpeg, mpga, m4a, wav, or
         * webm.
         */
        fun file(file: String) = apply { this.file = file }

        /** ID of the model to use. Only `whisper-1` is currently available. */
        fun model(model: String) = apply { this.model = model }

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](/docs/guides/speech-to-text/prompting) should be in English.
         */
        fun prompt(prompt: String) = apply { this.prompt = prompt }

        /**
         * The format of the transcript output, in one of these options: json, text, srt,
         * verbose_json, or vtt.
         */
        fun responseFormat(responseFormat: String) = apply { this.responseFormat = responseFormat }

        /**
         * The sampling temperature, between 0 and 1. Higher values like 0.8 will make the output
         * more random, while lower values like 0.2 will make it more focused and deterministic. If
         * set to 0, the model will use
         * [log probability](https://en.wikipedia.org/wiki/Log_probability) to automatically
         * increase the temperature until certain thresholds are hit.
         */
        fun temperature(temperature: Double) = apply { this.temperature = temperature }

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

        fun build(): AudioTranslationCreateParams =
            AudioTranslationCreateParams(
                checkNotNull(file) { "`file` is required but was not set" },
                checkNotNull(model) { "`model` is required but was not set" },
                prompt,
                responseFormat,
                temperature,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }
}
