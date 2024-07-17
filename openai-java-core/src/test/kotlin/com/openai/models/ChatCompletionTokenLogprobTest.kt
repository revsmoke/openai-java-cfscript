// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionTokenLogprobTest {

    @Test
    fun createChatCompletionTokenLogprob() {
        val chatCompletionTokenLogprob =
            ChatCompletionTokenLogprob.builder()
                .token("token")
                .bytes(listOf(123L))
                .logprob(42.23)
                .topLogprobs(
                    listOf(
                        ChatCompletionTokenLogprob.TopLogprob.builder()
                            .token("token")
                            .bytes(listOf(123L))
                            .logprob(42.23)
                            .build()
                    )
                )
                .build()
        assertThat(chatCompletionTokenLogprob).isNotNull
        assertThat(chatCompletionTokenLogprob.token()).isEqualTo("token")
        assertThat(chatCompletionTokenLogprob.bytes().get()).containsExactly(123L)
        assertThat(chatCompletionTokenLogprob.logprob()).isEqualTo(42.23)
        assertThat(chatCompletionTokenLogprob.topLogprobs())
            .containsExactly(
                ChatCompletionTokenLogprob.TopLogprob.builder()
                    .token("token")
                    .bytes(listOf(123L))
                    .logprob(42.23)
                    .build()
            )
    }
}
