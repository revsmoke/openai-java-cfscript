// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CompletionTest {

    @Test
    fun createCompletion() {
        val completion =
            Completion.builder()
                .id("id")
                .choices(
                    listOf(
                        CompletionChoice.builder()
                            .finishReason(CompletionChoice.FinishReason.STOP)
                            .index(123L)
                            .logprobs(
                                CompletionChoice.Logprobs.builder()
                                    .textOffset(listOf(123L))
                                    .tokenLogprobs(listOf(42.23))
                                    .tokens(listOf("string"))
                                    .topLogprobs(
                                        listOf(
                                            CompletionChoice.Logprobs.TopLogprob.builder().build()
                                        )
                                    )
                                    .build()
                            )
                            .text("text")
                            .build()
                    )
                )
                .created(123L)
                .model("model")
                .object_(Completion.Object.TEXT_COMPLETION)
                .systemFingerprint("system_fingerprint")
                .usage(
                    CompletionUsage.builder()
                        .completionTokens(123L)
                        .promptTokens(123L)
                        .totalTokens(123L)
                        .completionTokensDetails(
                            CompletionUsage.CompletionTokensDetails.builder()
                                .acceptedPredictionTokens(123L)
                                .audioTokens(123L)
                                .reasoningTokens(123L)
                                .rejectedPredictionTokens(123L)
                                .build()
                        )
                        .promptTokensDetails(
                            CompletionUsage.PromptTokensDetails.builder()
                                .audioTokens(123L)
                                .cachedTokens(123L)
                                .build()
                        )
                        .build()
                )
                .build()
        assertThat(completion).isNotNull
        assertThat(completion.id()).isEqualTo("id")
        assertThat(completion.choices())
            .containsExactly(
                CompletionChoice.builder()
                    .finishReason(CompletionChoice.FinishReason.STOP)
                    .index(123L)
                    .logprobs(
                        CompletionChoice.Logprobs.builder()
                            .textOffset(listOf(123L))
                            .tokenLogprobs(listOf(42.23))
                            .tokens(listOf("string"))
                            .topLogprobs(
                                listOf(CompletionChoice.Logprobs.TopLogprob.builder().build())
                            )
                            .build()
                    )
                    .text("text")
                    .build()
            )
        assertThat(completion.created()).isEqualTo(123L)
        assertThat(completion.model()).isEqualTo("model")
        assertThat(completion.object_()).isEqualTo(Completion.Object.TEXT_COMPLETION)
        assertThat(completion.systemFingerprint()).contains("system_fingerprint")
        assertThat(completion.usage())
            .contains(
                CompletionUsage.builder()
                    .completionTokens(123L)
                    .promptTokens(123L)
                    .totalTokens(123L)
                    .completionTokensDetails(
                        CompletionUsage.CompletionTokensDetails.builder()
                            .acceptedPredictionTokens(123L)
                            .audioTokens(123L)
                            .reasoningTokens(123L)
                            .rejectedPredictionTokens(123L)
                            .build()
                    )
                    .promptTokensDetails(
                        CompletionUsage.PromptTokensDetails.builder()
                            .audioTokens(123L)
                            .cachedTokens(123L)
                            .build()
                    )
                    .build()
            )
    }
}
