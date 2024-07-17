// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionAssistantMessageParamTest {

    @Test
    fun createChatCompletionAssistantMessageParam() {
        val chatCompletionAssistantMessageParam =
            ChatCompletionAssistantMessageParam.builder()
                .role(ChatCompletionAssistantMessageParam.Role.ASSISTANT)
                .content("content")
                .functionCall(
                    ChatCompletionAssistantMessageParam.FunctionCall.builder()
                        .arguments("arguments")
                        .name("name")
                        .build()
                )
                .name("name")
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
        assertThat(chatCompletionAssistantMessageParam).isNotNull
        assertThat(chatCompletionAssistantMessageParam.role())
            .isEqualTo(ChatCompletionAssistantMessageParam.Role.ASSISTANT)
        assertThat(chatCompletionAssistantMessageParam.content()).contains("content")
        assertThat(chatCompletionAssistantMessageParam.functionCall())
            .contains(
                ChatCompletionAssistantMessageParam.FunctionCall.builder()
                    .arguments("arguments")
                    .name("name")
                    .build()
            )
        assertThat(chatCompletionAssistantMessageParam.name()).contains("name")
        assertThat(chatCompletionAssistantMessageParam.toolCalls().get())
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
