// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmbeddingTest {

    @Test
    fun createEmbedding() {
        val embedding =
            Embedding.builder()
                .embedding(listOf(42.23))
                .index(123L)
                .object_(Embedding.Object.EMBEDDING)
                .build()
        assertThat(embedding).isNotNull
        assertThat(embedding.embedding()).containsExactly(42.23)
        assertThat(embedding.index()).isEqualTo(123L)
        assertThat(embedding.object_()).isEqualTo(Embedding.Object.EMBEDDING)
    }
}
