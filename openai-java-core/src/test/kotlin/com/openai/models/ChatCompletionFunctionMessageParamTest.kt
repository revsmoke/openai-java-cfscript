// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionFunctionMessageParamTest {

    @Test
    fun createChatCompletionFunctionMessageParam() {
        val chatCompletionFunctionMessageParam =
            ChatCompletionFunctionMessageParam.builder()
                .content("string")
                .name("string")
                .role(ChatCompletionFunctionMessageParam.Role.FUNCTION)
                .build()
        assertThat(chatCompletionFunctionMessageParam).isNotNull
        assertThat(chatCompletionFunctionMessageParam.content()).contains("string")
        assertThat(chatCompletionFunctionMessageParam.name()).isEqualTo("string")
        assertThat(chatCompletionFunctionMessageParam.role())
            .isEqualTo(ChatCompletionFunctionMessageParam.Role.FUNCTION)
    }
}
