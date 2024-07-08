// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionToolMessageParamTest {

    @Test
    fun createChatCompletionToolMessageParam() {
        val chatCompletionToolMessageParam =
            ChatCompletionToolMessageParam.builder()
                .content("string")
                .role(ChatCompletionToolMessageParam.Role.TOOL)
                .toolCallId("string")
                .build()
        assertThat(chatCompletionToolMessageParam).isNotNull
        assertThat(chatCompletionToolMessageParam.content()).isEqualTo("string")
        assertThat(chatCompletionToolMessageParam.role())
            .isEqualTo(ChatCompletionToolMessageParam.Role.TOOL)
        assertThat(chatCompletionToolMessageParam.toolCallId()).isEqualTo("string")
    }
}
