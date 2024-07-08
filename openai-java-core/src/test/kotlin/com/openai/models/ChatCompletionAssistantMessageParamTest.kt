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
                .content("string")
                .functionCall(
                    ChatCompletionAssistantMessageParam.FunctionCall.builder()
                        .arguments("string")
                        .name("string")
                        .build()
                )
                .name("string")
                .toolCalls(
                    listOf(
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
                    )
                )
                .build()
        assertThat(chatCompletionAssistantMessageParam).isNotNull
        assertThat(chatCompletionAssistantMessageParam.role())
            .isEqualTo(ChatCompletionAssistantMessageParam.Role.ASSISTANT)
        assertThat(chatCompletionAssistantMessageParam.content()).contains("string")
        assertThat(chatCompletionAssistantMessageParam.functionCall())
            .contains(
                ChatCompletionAssistantMessageParam.FunctionCall.builder()
                    .arguments("string")
                    .name("string")
                    .build()
            )
        assertThat(chatCompletionAssistantMessageParam.name()).contains("string")
        assertThat(chatCompletionAssistantMessageParam.toolCalls().get())
            .containsExactly(
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
            )
    }
}
