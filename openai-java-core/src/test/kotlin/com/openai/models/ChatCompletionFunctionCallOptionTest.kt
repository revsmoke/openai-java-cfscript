// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionFunctionCallOptionTest {

    @Test
    fun createChatCompletionFunctionCallOption() {
        val chatCompletionFunctionCallOption =
            ChatCompletionFunctionCallOption.builder().name("string").build()
        assertThat(chatCompletionFunctionCallOption).isNotNull
        assertThat(chatCompletionFunctionCallOption.name()).isEqualTo("string")
    }
}
