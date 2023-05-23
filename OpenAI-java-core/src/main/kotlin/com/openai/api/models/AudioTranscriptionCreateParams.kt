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

class AudioTranscriptionCreateParams
constructor(
    private val file: String,
    private val model: String,
    private val prompt: String?,
    private val responseFormat: String?,
    private val temperature: Double?,
    private val language: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun file(): String = file

    fun model(): String = model

    fun prompt(): Optional<String> = Optional.ofNullable(prompt)

    fun responseFormat(): Optional<String> = Optional.ofNullable(responseFormat)

    fun temperature(): Optional<Double> = Optional.ofNullable(temperature)

    fun language(): Optional<String> = Optional.ofNullable(language)

    @JvmSynthetic
    internal fun getBody(): AudioTranscriptionCreateBody {
        return AudioTranscriptionCreateBody(
            file,
            model,
            prompt,
            responseFormat,
            temperature,
            language,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = AudioTranscriptionCreateBody.Builder::class)
    @NoAutoDetect
    class AudioTranscriptionCreateBody
    internal constructor(
        private val file: String?,
        private val model: String?,
        private val prompt: String?,
        private val responseFormat: String?,
        private val temperature: Double?,
        private val language: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /**
         * The audio file to transcribe, in one of these formats: mp3, mp4, mpeg, mpga, m4a, wav, or
         * webm.
         */
        @JsonProperty("file") fun file(): String? = file

        /** ID of the model to use. Only `whisper-1` is currently available. */
        @JsonProperty("model") fun model(): String? = model

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](/docs/guides/speech-to-text/prompting) should match the audio language.
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

        /**
         * The language of the input audio. Supplying the input language in
         * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) format will improve
         * accuracy and latency.
         */
        @JsonProperty("language") fun language(): String? = language

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AudioTranscriptionCreateBody &&
                this.file == other.file &&
                this.model == other.model &&
                this.prompt == other.prompt &&
                this.responseFormat == other.responseFormat &&
                this.temperature == other.temperature &&
                this.language == other.language &&
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
                        language,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "AudioTranscriptionCreateBody{file=$file, model=$model, prompt=$prompt, responseFormat=$responseFormat, temperature=$temperature, language=$language, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var file: String? = null
            private var model: String? = null
            private var prompt: String? = null
            private var responseFormat: String? = null
            private var temperature: Double? = null
            private var language: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(audioTranscriptionCreateBody: AudioTranscriptionCreateBody) = apply {
                this.file = audioTranscriptionCreateBody.file
                this.model = audioTranscriptionCreateBody.model
                this.prompt = audioTranscriptionCreateBody.prompt
                this.responseFormat = audioTranscriptionCreateBody.responseFormat
                this.temperature = audioTranscriptionCreateBody.temperature
                this.language = audioTranscriptionCreateBody.language
                additionalProperties(audioTranscriptionCreateBody.additionalProperties)
            }

            /**
             * The audio file to transcribe, in one of these formats: mp3, mp4, mpeg, mpga, m4a,
             * wav, or webm.
             */
            @JsonProperty("file") fun file(file: String) = apply { this.file = file }

            /** ID of the model to use. Only `whisper-1` is currently available. */
            @JsonProperty("model") fun model(model: String) = apply { this.model = model }

            /**
             * An optional text to guide the model's style or continue a previous audio segment. The
             * [prompt](/docs/guides/speech-to-text/prompting) should match the audio language.
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

            /**
             * The language of the input audio. Supplying the input language in
             * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) format will
             * improve accuracy and latency.
             */
            @JsonProperty("language")
            fun language(language: String) = apply { this.language = language }

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

            fun build(): AudioTranscriptionCreateBody =
                AudioTranscriptionCreateBody(
                    checkNotNull(file) { "`file` is required but was not set" },
                    checkNotNull(model) { "`model` is required but was not set" },
                    prompt,
                    responseFormat,
                    temperature,
                    language,
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

        return other is AudioTranscriptionCreateParams &&
            this.file == other.file &&
            this.model == other.model &&
            this.prompt == other.prompt &&
            this.responseFormat == other.responseFormat &&
            this.temperature == other.temperature &&
            this.language == other.language &&
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
            language,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "AudioTranscriptionCreateParams{file=$file, model=$model, prompt=$prompt, responseFormat=$responseFormat, temperature=$temperature, language=$language, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

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
        private var language: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(audioTranscriptionCreateParams: AudioTranscriptionCreateParams) = apply {
            this.file = audioTranscriptionCreateParams.file
            this.model = audioTranscriptionCreateParams.model
            this.prompt = audioTranscriptionCreateParams.prompt
            this.responseFormat = audioTranscriptionCreateParams.responseFormat
            this.temperature = audioTranscriptionCreateParams.temperature
            this.language = audioTranscriptionCreateParams.language
            additionalQueryParams(audioTranscriptionCreateParams.additionalQueryParams)
            additionalHeaders(audioTranscriptionCreateParams.additionalHeaders)
            additionalBodyProperties(audioTranscriptionCreateParams.additionalBodyProperties)
        }

        /**
         * The audio file to transcribe, in one of these formats: mp3, mp4, mpeg, mpga, m4a, wav, or
         * webm.
         */
        fun file(file: String) = apply { this.file = file }

        /** ID of the model to use. Only `whisper-1` is currently available. */
        fun model(model: String) = apply { this.model = model }

        /**
         * An optional text to guide the model's style or continue a previous audio segment. The
         * [prompt](/docs/guides/speech-to-text/prompting) should match the audio language.
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

        /**
         * The language of the input audio. Supplying the input language in
         * [ISO-639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) format will improve
         * accuracy and latency.
         */
        fun language(language: String) = apply { this.language = language }

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

        fun build(): AudioTranscriptionCreateParams =
            AudioTranscriptionCreateParams(
                checkNotNull(file) { "`file` is required but was not set" },
                checkNotNull(model) { "`model` is required but was not set" },
                prompt,
                responseFormat,
                temperature,
                language,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }
}
