// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionMessageToolCallTest {

    @Test
    fun createChatCompletionMessageToolCall() {
        val chatCompletionMessageToolCall =
            ChatCompletionMessageToolCall.builder()
                .id("string")
                .function(
                    ChatCompletionMessageToolCall.Function.builder()
                        .arguments("string")
                        .name("string")
                        .build()
                )
                .type(ChatCompletionMessageToolCall.Type.FUNCTION)
                .build()
        assertThat(chatCompletionMessageToolCall).isNotNull
        assertThat(chatCompletionMessageToolCall.id()).isEqualTo("string")
        assertThat(chatCompletionMessageToolCall.function())
            .isEqualTo(
                ChatCompletionMessageToolCall.Function.builder()
                    .arguments("string")
                    .name("string")
                    .build()
            )
        assertThat(chatCompletionMessageToolCall.type())
            .isEqualTo(ChatCompletionMessageToolCall.Type.FUNCTION)
    }
}
