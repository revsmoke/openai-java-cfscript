// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionMessageTest {

    @Test
    fun createChatCompletionMessage() {
        val chatCompletionMessage =
            ChatCompletionMessage.builder()
                .content("content")
                .role(ChatCompletionMessage.Role.ASSISTANT)
                .functionCall(
                    ChatCompletionMessage.FunctionCall.builder()
                        .arguments("arguments")
                        .name("name")
                        .build()
                )
                .toolCalls(
                    listOf(
                        ChatCompletionMessageToolCall.builder()
                            .id("id")
                            .function(
                                ChatCompletionMessageToolCall.Function.builder()
                                    .arguments("arguments")
                                    .name("name")
                                    .build()
                            )
                            .type(ChatCompletionMessageToolCall.Type.FUNCTION)
                            .build()
                    )
                )
                .build()
        assertThat(chatCompletionMessage).isNotNull
        assertThat(chatCompletionMessage.content()).contains("content")
        assertThat(chatCompletionMessage.role()).isEqualTo(ChatCompletionMessage.Role.ASSISTANT)
        assertThat(chatCompletionMessage.functionCall())
            .contains(
                ChatCompletionMessage.FunctionCall.builder()
                    .arguments("arguments")
                    .name("name")
                    .build()
            )
        assertThat(chatCompletionMessage.toolCalls().get())
            .containsExactly(
                ChatCompletionMessageToolCall.builder()
                    .id("id")
                    .function(
                        ChatCompletionMessageToolCall.Function.builder()
                            .arguments("arguments")
                            .name("name")
                            .build()
                    )
                    .type(ChatCompletionMessageToolCall.Type.FUNCTION)
                    .build()
            )
    }
}
