package com.openai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionTest {

    @Test
    fun createChatCompletion() {
        val chatCompletion =
            ChatCompletion.builder()
                .id("string")
                .object_("string")
                .created(123L)
                .model("string")
                .choices(
                    listOf(
                        ChatCompletion.Choice.builder()
                            .index(123L)
                            .message(
                                ChatCompletion.Choice.ChatCompletionResponseMessage.builder()
                                    .role(
                                        ChatCompletion.Choice.ChatCompletionResponseMessage.Role
                                            .SYSTEM
                                    )
                                    .content("string")
                                    .build()
                            )
                            .finishReason("string")
                            .build()
                    )
                )
                .usage(
                    ChatCompletion.Usage.builder()
                        .promptTokens(123L)
                        .completionTokens(123L)
                        .totalTokens(123L)
                        .build()
                )
                .build()
        assertThat(chatCompletion).isNotNull
        assertThat(chatCompletion.id()).isEqualTo("string")
        assertThat(chatCompletion.object_()).isEqualTo("string")
        assertThat(chatCompletion.created()).isEqualTo(123L)
        assertThat(chatCompletion.model()).isEqualTo("string")
        assertThat(chatCompletion.choices())
            .containsExactly(
                ChatCompletion.Choice.builder()
                    .index(123L)
                    .message(
                        ChatCompletion.Choice.ChatCompletionResponseMessage.builder()
                            .role(ChatCompletion.Choice.ChatCompletionResponseMessage.Role.SYSTEM)
                            .content("string")
                            .build()
                    )
                    .finishReason("string")
                    .build()
            )
        assertThat(chatCompletion.usage())
            .contains(
                ChatCompletion.Usage.builder()
                    .promptTokens(123L)
                    .completionTokens(123L)
                    .totalTokens(123L)
                    .build()
            )
    }
}
