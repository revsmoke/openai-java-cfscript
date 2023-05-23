package com.openai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmbeddingTest {

    @Test
    fun createEmbedding() {
        val embedding =
            Embedding.builder()
                .object_("string")
                .model("string")
                .data(
                    listOf(
                        Embedding.Data.builder()
                            .index(123L)
                            .object_("string")
                            .embedding(listOf(42.23))
                            .build()
                    )
                )
                .usage(Embedding.Usage.builder().promptTokens(123L).totalTokens(123L).build())
                .build()
        assertThat(embedding).isNotNull
        assertThat(embedding.object_()).isEqualTo("string")
        assertThat(embedding.model()).isEqualTo("string")
        assertThat(embedding.data())
            .containsExactly(
                Embedding.Data.builder()
                    .index(123L)
                    .object_("string")
                    .embedding(listOf(42.23))
                    .build()
            )
        assertThat(embedding.usage())
            .isEqualTo(Embedding.Usage.builder().promptTokens(123L).totalTokens(123L).build())
    }
}
