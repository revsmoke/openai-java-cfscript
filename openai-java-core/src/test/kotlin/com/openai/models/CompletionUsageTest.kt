// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CompletionUsageTest {

    @Test
    fun createCompletionUsage() {
        val completionUsage =
            CompletionUsage.builder()
                .completionTokens(123L)
                .promptTokens(123L)
                .totalTokens(123L)
                .completionTokensDetails(
                    CompletionUsage.CompletionTokensDetails.builder()
                        .audioTokens(123L)
                        .reasoningTokens(123L)
                        .build()
                )
                .promptTokensDetails(
                    CompletionUsage.PromptTokensDetails.builder()
                        .audioTokens(123L)
                        .cachedTokens(123L)
                        .build()
                )
                .build()
        assertThat(completionUsage).isNotNull
        assertThat(completionUsage.completionTokens()).isEqualTo(123L)
        assertThat(completionUsage.promptTokens()).isEqualTo(123L)
        assertThat(completionUsage.totalTokens()).isEqualTo(123L)
        assertThat(completionUsage.completionTokensDetails())
            .contains(
                CompletionUsage.CompletionTokensDetails.builder()
                    .audioTokens(123L)
                    .reasoningTokens(123L)
                    .build()
            )
        assertThat(completionUsage.promptTokensDetails())
            .contains(
                CompletionUsage.PromptTokensDetails.builder()
                    .audioTokens(123L)
                    .cachedTokens(123L)
                    .build()
            )
    }
}
