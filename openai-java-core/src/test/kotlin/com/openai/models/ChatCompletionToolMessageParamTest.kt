// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionToolMessageParamTest {

    @Test
    fun createChatCompletionToolMessageParam() {
        val chatCompletionToolMessageParam =
            ChatCompletionToolMessageParam.builder()
                .content("content")
                .role(ChatCompletionToolMessageParam.Role.TOOL)
                .toolCallId("tool_call_id")
                .build()
        assertThat(chatCompletionToolMessageParam).isNotNull
        assertThat(chatCompletionToolMessageParam.content()).isEqualTo("content")
        assertThat(chatCompletionToolMessageParam.role())
            .isEqualTo(ChatCompletionToolMessageParam.Role.TOOL)
        assertThat(chatCompletionToolMessageParam.toolCallId()).isEqualTo("tool_call_id")
    }
}
