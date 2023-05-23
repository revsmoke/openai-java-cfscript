package com.openai.api.models

import com.openai.api.core.JsonString
import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionCreateParamsTest {

    @Test
    fun createChatCompletionCreateParams() {
        ChatCompletionCreateParams.builder()
            .model("string")
            .messages(
                listOf(
                    ChatCompletionCreateParams.ChatCompletionRequestMessage.builder()
                        .role(ChatCompletionCreateParams.ChatCompletionRequestMessage.Role.SYSTEM)
                        .content("string")
                        .name("string")
                        .build()
                )
            )
            .temperature(42.23)
            .topP(42.23)
            .n(123L)
            .stream(true)
            .stop(ChatCompletionCreateParams.Stop.ofString("string"))
            .maxTokens(123L)
            .presencePenalty(42.23)
            .frequencyPenalty(42.23)
            .logitBias(JsonString.of("abc"))
            .user("user-1234")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            ChatCompletionCreateParams.builder()
                .model("string")
                .messages(
                    listOf(
                        ChatCompletionCreateParams.ChatCompletionRequestMessage.builder()
                            .role(
                                ChatCompletionCreateParams.ChatCompletionRequestMessage.Role.SYSTEM
                            )
                            .content("string")
                            .name("string")
                            .build()
                    )
                )
                .temperature(42.23)
                .topP(42.23)
                .n(123L)
                .stream(true)
                .stop(ChatCompletionCreateParams.Stop.ofString("string"))
                .maxTokens(123L)
                .presencePenalty(42.23)
                .frequencyPenalty(42.23)
                .logitBias(JsonString.of("abc"))
                .user("user-1234")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo("string")
        assertThat(body.messages())
            .isEqualTo(
                listOf(
                    ChatCompletionCreateParams.ChatCompletionRequestMessage.builder()
                        .role(ChatCompletionCreateParams.ChatCompletionRequestMessage.Role.SYSTEM)
                        .content("string")
                        .name("string")
                        .build()
                )
            )
        assertThat(body.temperature()).isEqualTo(42.23)
        assertThat(body.topP()).isEqualTo(42.23)
        assertThat(body.n()).isEqualTo(123L)
        assertThat(body.stream()).isEqualTo(true)
        assertThat(body.stop()).isEqualTo(ChatCompletionCreateParams.Stop.ofString("string"))
        assertThat(body.maxTokens()).isEqualTo(123L)
        assertThat(body.presencePenalty()).isEqualTo(42.23)
        assertThat(body.frequencyPenalty()).isEqualTo(42.23)
        assertThat(body.logitBias()).isEqualTo(JsonString.of("abc"))
        assertThat(body.user()).isEqualTo("user-1234")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            ChatCompletionCreateParams.builder()
                .model("string")
                .messages(
                    listOf(
                        ChatCompletionCreateParams.ChatCompletionRequestMessage.builder()
                            .role(
                                ChatCompletionCreateParams.ChatCompletionRequestMessage.Role.SYSTEM
                            )
                            .content("string")
                            .build()
                    )
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo("string")
        assertThat(body.messages())
            .isEqualTo(
                listOf(
                    ChatCompletionCreateParams.ChatCompletionRequestMessage.builder()
                        .role(ChatCompletionCreateParams.ChatCompletionRequestMessage.Role.SYSTEM)
                        .content("string")
                        .build()
                )
            )
    }
}
