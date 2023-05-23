package com.openai.api.models

import com.openai.api.core.JsonString
import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ClassificationCreateParamsTest {

    @Test
    fun createClassificationCreateParams() {
        ClassificationCreateParams.builder()
            .model("string")
            .query("The plot is not very attractive.")
            .examples(listOf(listOf("x")))
            .file("string")
            .labels(listOf("string"))
            .searchModel("string")
            .temperature(42.23)
            .logprobs(123L)
            .maxExamples(123L)
            .logitBias(JsonString.of("abc"))
            .returnPrompt(true)
            .returnMetadata(true)
            .expand(listOf(JsonString.of("abc")))
            .user("user-1234")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            ClassificationCreateParams.builder()
                .model("string")
                .query("The plot is not very attractive.")
                .examples(listOf(listOf("x")))
                .file("string")
                .labels(listOf("string"))
                .searchModel("string")
                .temperature(42.23)
                .logprobs(123L)
                .maxExamples(123L)
                .logitBias(JsonString.of("abc"))
                .returnPrompt(true)
                .returnMetadata(true)
                .expand(listOf(JsonString.of("abc")))
                .user("user-1234")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo("string")
        assertThat(body.query()).isEqualTo("The plot is not very attractive.")
        assertThat(body.examples()).isEqualTo(listOf(listOf("x")))
        assertThat(body.file()).isEqualTo("string")
        assertThat(body.labels()).isEqualTo(listOf("string"))
        assertThat(body.searchModel()).isEqualTo("string")
        assertThat(body.temperature()).isEqualTo(42.23)
        assertThat(body.logprobs()).isEqualTo(123L)
        assertThat(body.maxExamples()).isEqualTo(123L)
        assertThat(body.logitBias()).isEqualTo(JsonString.of("abc"))
        assertThat(body.returnPrompt()).isEqualTo(true)
        assertThat(body.returnMetadata()).isEqualTo(true)
        assertThat(body.expand()).isEqualTo(listOf(JsonString.of("abc")))
        assertThat(body.user()).isEqualTo("user-1234")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            ClassificationCreateParams.builder()
                .model("string")
                .query("The plot is not very attractive.")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo("string")
        assertThat(body.query()).isEqualTo("The plot is not very attractive.")
    }
}
