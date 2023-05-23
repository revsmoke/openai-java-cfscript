package com.openai.api.models

import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmbeddingCreateParamsTest {

    @Test
    fun createEmbeddingCreateParams() {
        EmbeddingCreateParams.builder()
            .model("string")
            .input(EmbeddingCreateParams.Input.ofString("This is a test."))
            .user("user-1234")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            EmbeddingCreateParams.builder()
                .model("string")
                .input(EmbeddingCreateParams.Input.ofString("This is a test."))
                .user("user-1234")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo("string")
        assertThat(body.input()).isEqualTo(EmbeddingCreateParams.Input.ofString("This is a test."))
        assertThat(body.user()).isEqualTo("user-1234")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            EmbeddingCreateParams.builder()
                .model("string")
                .input(EmbeddingCreateParams.Input.ofString("This is a test."))
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo("string")
        assertThat(body.input()).isEqualTo(EmbeddingCreateParams.Input.ofString("This is a test."))
    }
}
