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

/** Usage statistics for the completion request. */
@JsonDeserialize(builder = CompletionUsage.Builder::class)
@NoAutoDetect
class CompletionUsage
private constructor(
    private val completionTokens: JsonField<Long>,
    private val promptTokens: JsonField<Long>,
    private val totalTokens: JsonField<Long>,
    private val completionTokensDetails: JsonField<CompletionTokensDetails>,
    private val promptTokensDetails: JsonField<PromptTokensDetails>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** Number of tokens in the generated completion. */
    fun completionTokens(): Long = completionTokens.getRequired("completion_tokens")

    /** Number of tokens in the prompt. */
    fun promptTokens(): Long = promptTokens.getRequired("prompt_tokens")

    /** Total number of tokens used in the request (prompt + completion). */
    fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

    /** Breakdown of tokens used in a completion. */
    fun completionTokensDetails(): Optional<CompletionTokensDetails> =
        Optional.ofNullable(completionTokensDetails.getNullable("completion_tokens_details"))

    /** Breakdown of tokens used in the prompt. */
    fun promptTokensDetails(): Optional<PromptTokensDetails> =
        Optional.ofNullable(promptTokensDetails.getNullable("prompt_tokens_details"))

    /** Number of tokens in the generated completion. */
    @JsonProperty("completion_tokens") @ExcludeMissing fun _completionTokens() = completionTokens

    /** Number of tokens in the prompt. */
    @JsonProperty("prompt_tokens") @ExcludeMissing fun _promptTokens() = promptTokens

    /** Total number of tokens used in the request (prompt + completion). */
    @JsonProperty("total_tokens") @ExcludeMissing fun _totalTokens() = totalTokens

    /** Breakdown of tokens used in a completion. */
    @JsonProperty("completion_tokens_details")
    @ExcludeMissing
    fun _completionTokensDetails() = completionTokensDetails

    /** Breakdown of tokens used in the prompt. */
    @JsonProperty("prompt_tokens_details")
    @ExcludeMissing
    fun _promptTokensDetails() = promptTokensDetails

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): CompletionUsage = apply {
        if (!validated) {
            completionTokens()
            promptTokens()
            totalTokens()
            completionTokensDetails().map { it.validate() }
            promptTokensDetails().map { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var completionTokens: JsonField<Long> = JsonMissing.of()
        private var promptTokens: JsonField<Long> = JsonMissing.of()
        private var totalTokens: JsonField<Long> = JsonMissing.of()
        private var completionTokensDetails: JsonField<CompletionTokensDetails> = JsonMissing.of()
        private var promptTokensDetails: JsonField<PromptTokensDetails> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(completionUsage: CompletionUsage) = apply {
            this.completionTokens = completionUsage.completionTokens
            this.promptTokens = completionUsage.promptTokens
            this.totalTokens = completionUsage.totalTokens
            this.completionTokensDetails = completionUsage.completionTokensDetails
            this.promptTokensDetails = completionUsage.promptTokensDetails
            additionalProperties(completionUsage.additionalProperties)
        }

        /** Number of tokens in the generated completion. */
        fun completionTokens(completionTokens: Long) =
            completionTokens(JsonField.of(completionTokens))

        /** Number of tokens in the generated completion. */
        @JsonProperty("completion_tokens")
        @ExcludeMissing
        fun completionTokens(completionTokens: JsonField<Long>) = apply {
            this.completionTokens = completionTokens
        }

        /** Number of tokens in the prompt. */
        fun promptTokens(promptTokens: Long) = promptTokens(JsonField.of(promptTokens))

        /** Number of tokens in the prompt. */
        @JsonProperty("prompt_tokens")
        @ExcludeMissing
        fun promptTokens(promptTokens: JsonField<Long>) = apply { this.promptTokens = promptTokens }

        /** Total number of tokens used in the request (prompt + completion). */
        fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

        /** Total number of tokens used in the request (prompt + completion). */
        @JsonProperty("total_tokens")
        @ExcludeMissing
        fun totalTokens(totalTokens: JsonField<Long>) = apply { this.totalTokens = totalTokens }

        /** Breakdown of tokens used in a completion. */
        fun completionTokensDetails(completionTokensDetails: CompletionTokensDetails) =
            completionTokensDetails(JsonField.of(completionTokensDetails))

        /** Breakdown of tokens used in a completion. */
        @JsonProperty("completion_tokens_details")
        @ExcludeMissing
        fun completionTokensDetails(completionTokensDetails: JsonField<CompletionTokensDetails>) =
            apply {
                this.completionTokensDetails = completionTokensDetails
            }

        /** Breakdown of tokens used in the prompt. */
        fun promptTokensDetails(promptTokensDetails: PromptTokensDetails) =
            promptTokensDetails(JsonField.of(promptTokensDetails))

        /** Breakdown of tokens used in the prompt. */
        @JsonProperty("prompt_tokens_details")
        @ExcludeMissing
        fun promptTokensDetails(promptTokensDetails: JsonField<PromptTokensDetails>) = apply {
            this.promptTokensDetails = promptTokensDetails
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

        fun build(): CompletionUsage =
            CompletionUsage(
                completionTokens,
                promptTokens,
                totalTokens,
                completionTokensDetails,
                promptTokensDetails,
                additionalProperties.toUnmodifiable(),
            )
    }

    /** Breakdown of tokens used in a completion. */
    @JsonDeserialize(builder = CompletionTokensDetails.Builder::class)
    @NoAutoDetect
    class CompletionTokensDetails
    private constructor(
        private val audioTokens: JsonField<Long>,
        private val reasoningTokens: JsonField<Long>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        /** Audio input tokens generated by the model. */
        fun audioTokens(): Optional<Long> =
            Optional.ofNullable(audioTokens.getNullable("audio_tokens"))

        /** Tokens generated by the model for reasoning. */
        fun reasoningTokens(): Optional<Long> =
            Optional.ofNullable(reasoningTokens.getNullable("reasoning_tokens"))

        /** Audio input tokens generated by the model. */
        @JsonProperty("audio_tokens") @ExcludeMissing fun _audioTokens() = audioTokens

        /** Tokens generated by the model for reasoning. */
        @JsonProperty("reasoning_tokens") @ExcludeMissing fun _reasoningTokens() = reasoningTokens

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): CompletionTokensDetails = apply {
            if (!validated) {
                audioTokens()
                reasoningTokens()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var audioTokens: JsonField<Long> = JsonMissing.of()
            private var reasoningTokens: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(completionTokensDetails: CompletionTokensDetails) = apply {
                this.audioTokens = completionTokensDetails.audioTokens
                this.reasoningTokens = completionTokensDetails.reasoningTokens
                additionalProperties(completionTokensDetails.additionalProperties)
            }

            /** Audio input tokens generated by the model. */
            fun audioTokens(audioTokens: Long) = audioTokens(JsonField.of(audioTokens))

            /** Audio input tokens generated by the model. */
            @JsonProperty("audio_tokens")
            @ExcludeMissing
            fun audioTokens(audioTokens: JsonField<Long>) = apply { this.audioTokens = audioTokens }

            /** Tokens generated by the model for reasoning. */
            fun reasoningTokens(reasoningTokens: Long) =
                reasoningTokens(JsonField.of(reasoningTokens))

            /** Tokens generated by the model for reasoning. */
            @JsonProperty("reasoning_tokens")
            @ExcludeMissing
            fun reasoningTokens(reasoningTokens: JsonField<Long>) = apply {
                this.reasoningTokens = reasoningTokens
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

            fun build(): CompletionTokensDetails =
                CompletionTokensDetails(
                    audioTokens,
                    reasoningTokens,
                    additionalProperties.toUnmodifiable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is CompletionTokensDetails && this.audioTokens == other.audioTokens && this.reasoningTokens == other.reasoningTokens && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(audioTokens, reasoningTokens, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "CompletionTokensDetails{audioTokens=$audioTokens, reasoningTokens=$reasoningTokens, additionalProperties=$additionalProperties}"
    }

    /** Breakdown of tokens used in the prompt. */
    @JsonDeserialize(builder = PromptTokensDetails.Builder::class)
    @NoAutoDetect
    class PromptTokensDetails
    private constructor(
        private val audioTokens: JsonField<Long>,
        private val cachedTokens: JsonField<Long>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        /** Audio input tokens present in the prompt. */
        fun audioTokens(): Optional<Long> =
            Optional.ofNullable(audioTokens.getNullable("audio_tokens"))

        /** Cached tokens present in the prompt. */
        fun cachedTokens(): Optional<Long> =
            Optional.ofNullable(cachedTokens.getNullable("cached_tokens"))

        /** Audio input tokens present in the prompt. */
        @JsonProperty("audio_tokens") @ExcludeMissing fun _audioTokens() = audioTokens

        /** Cached tokens present in the prompt. */
        @JsonProperty("cached_tokens") @ExcludeMissing fun _cachedTokens() = cachedTokens

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): PromptTokensDetails = apply {
            if (!validated) {
                audioTokens()
                cachedTokens()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var audioTokens: JsonField<Long> = JsonMissing.of()
            private var cachedTokens: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(promptTokensDetails: PromptTokensDetails) = apply {
                this.audioTokens = promptTokensDetails.audioTokens
                this.cachedTokens = promptTokensDetails.cachedTokens
                additionalProperties(promptTokensDetails.additionalProperties)
            }

            /** Audio input tokens present in the prompt. */
            fun audioTokens(audioTokens: Long) = audioTokens(JsonField.of(audioTokens))

            /** Audio input tokens present in the prompt. */
            @JsonProperty("audio_tokens")
            @ExcludeMissing
            fun audioTokens(audioTokens: JsonField<Long>) = apply { this.audioTokens = audioTokens }

            /** Cached tokens present in the prompt. */
            fun cachedTokens(cachedTokens: Long) = cachedTokens(JsonField.of(cachedTokens))

            /** Cached tokens present in the prompt. */
            @JsonProperty("cached_tokens")
            @ExcludeMissing
            fun cachedTokens(cachedTokens: JsonField<Long>) = apply {
                this.cachedTokens = cachedTokens
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

            fun build(): PromptTokensDetails =
                PromptTokensDetails(
                    audioTokens,
                    cachedTokens,
                    additionalProperties.toUnmodifiable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is PromptTokensDetails && this.audioTokens == other.audioTokens && this.cachedTokens == other.cachedTokens && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(audioTokens, cachedTokens, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "PromptTokensDetails{audioTokens=$audioTokens, cachedTokens=$cachedTokens, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CompletionUsage && this.completionTokens == other.completionTokens && this.promptTokens == other.promptTokens && this.totalTokens == other.totalTokens && this.completionTokensDetails == other.completionTokensDetails && this.promptTokensDetails == other.promptTokensDetails && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(completionTokens, promptTokens, totalTokens, completionTokensDetails, promptTokensDetails, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "CompletionUsage{completionTokens=$completionTokens, promptTokens=$promptTokens, totalTokens=$totalTokens, completionTokensDetails=$completionTokensDetails, promptTokensDetails=$promptTokensDetails, additionalProperties=$additionalProperties}"
}
