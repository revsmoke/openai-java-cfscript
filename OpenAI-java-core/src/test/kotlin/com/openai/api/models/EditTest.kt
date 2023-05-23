package com.openai.api.models

import com.openai.api.core.JsonString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EditTest {

    @Test
    fun createEdit() {
        val edit =
            Edit.builder()
                .object_("string")
                .created(123L)
                .choices(
                    listOf(
                        Edit.Choice.builder()
                            .text("string")
                            .index(123L)
                            .logprobs(
                                Edit.Choice.Logprobs.builder()
                                    .tokens(listOf("string"))
                                    .tokenLogprobs(listOf(42.23))
                                    .topLogprobs(listOf(JsonString.of("abc")))
                                    .textOffset(listOf(123L))
                                    .build()
                            )
                            .finishReason("string")
                            .build()
                    )
                )
                .usage(
                    Edit.Usage.builder()
                        .promptTokens(123L)
                        .completionTokens(123L)
                        .totalTokens(123L)
                        .build()
                )
                .build()
        assertThat(edit).isNotNull
        assertThat(edit.object_()).isEqualTo("string")
        assertThat(edit.created()).isEqualTo(123L)
        assertThat(edit.choices())
            .containsExactly(
                Edit.Choice.builder()
                    .text("string")
                    .index(123L)
                    .logprobs(
                        Edit.Choice.Logprobs.builder()
                            .tokens(listOf("string"))
                            .tokenLogprobs(listOf(42.23))
                            .topLogprobs(listOf(JsonString.of("abc")))
                            .textOffset(listOf(123L))
                            .build()
                    )
                    .finishReason("string")
                    .build()
            )
        assertThat(edit.usage())
            .isEqualTo(
                Edit.Usage.builder()
                    .promptTokens(123L)
                    .completionTokens(123L)
                    .totalTokens(123L)
                    .build()
            )
    }
}
