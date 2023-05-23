package com.openai.api.models

import com.openai.api.core.JsonString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CompletionTest {

    @Test
    fun createCompletion() {
        val completion =
            Completion.builder()
                .id("string")
                .object_("string")
                .created(123L)
                .model("string")
                .choices(
                    listOf(
                        Completion.Choice.builder()
                            .text("string")
                            .index(123L)
                            .logprobs(
                                Completion.Choice.Logprobs.builder()
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
                    Completion.Usage.builder()
                        .promptTokens(123L)
                        .completionTokens(123L)
                        .totalTokens(123L)
                        .build()
                )
                .build()
        assertThat(completion).isNotNull
        assertThat(completion.id()).isEqualTo("string")
        assertThat(completion.object_()).isEqualTo("string")
        assertThat(completion.created()).isEqualTo(123L)
        assertThat(completion.model()).isEqualTo("string")
        assertThat(completion.choices())
            .containsExactly(
                Completion.Choice.builder()
                    .text("string")
                    .index(123L)
                    .logprobs(
                        Completion.Choice.Logprobs.builder()
                            .tokens(listOf("string"))
                            .tokenLogprobs(listOf(42.23))
                            .topLogprobs(listOf(JsonString.of("abc")))
                            .textOffset(listOf(123L))
                            .build()
                    )
                    .finishReason("string")
                    .build()
            )
        assertThat(completion.usage())
            .contains(
                Completion.Usage.builder()
                    .promptTokens(123L)
                    .completionTokens(123L)
                    .totalTokens(123L)
                    .build()
            )
    }
}
