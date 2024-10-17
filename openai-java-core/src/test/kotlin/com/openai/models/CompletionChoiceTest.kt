// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CompletionChoiceTest {

    @Test
    fun createCompletionChoice() {
        val completionChoice =
            CompletionChoice.builder()
                .finishReason(CompletionChoice.FinishReason.STOP)
                .index(123L)
                .logprobs(
                    CompletionChoice.Logprobs.builder()
                        .textOffset(listOf(123L))
                        .tokenLogprobs(listOf(42.23))
                        .tokens(listOf("string"))
                        .topLogprobs(listOf(CompletionChoice.Logprobs.TopLogprob.builder().build()))
                        .build()
                )
                .text("text")
                .build()
        assertThat(completionChoice).isNotNull
        assertThat(completionChoice.finishReason()).isEqualTo(CompletionChoice.FinishReason.STOP)
        assertThat(completionChoice.index()).isEqualTo(123L)
        assertThat(completionChoice.logprobs())
            .contains(
                CompletionChoice.Logprobs.builder()
                    .textOffset(listOf(123L))
                    .tokenLogprobs(listOf(42.23))
                    .tokens(listOf("string"))
                    .topLogprobs(listOf(CompletionChoice.Logprobs.TopLogprob.builder().build()))
                    .build()
            )
        assertThat(completionChoice.text()).isEqualTo("text")
    }
}
