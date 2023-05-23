package com.openai.api.models

import com.openai.api.core.JsonString
import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AnswerCreateParamsTest {

    @Test
    fun createAnswerCreateParams() {
        AnswerCreateParams.builder()
            .model("string")
            .question("What is the capital of Japan?")
            .examples(listOf(listOf("x")))
            .examplesContext(
                "Ottawa, Canada's capital, is located in the east of southern Ontario, near the city of Montréal and the U.S. border."
            )
            .documents(listOf("string"))
            .file("string")
            .searchModel("string")
            .maxRerank(123L)
            .temperature(42.23)
            .logprobs(123L)
            .maxTokens(123L)
            .stop(AnswerCreateParams.Stop.ofString("\n"))
            .n(123L)
            .logitBias(JsonString.of("abc"))
            .returnMetadata(true)
            .returnPrompt(true)
            .expand(listOf(JsonString.of("abc")))
            .user("user-1234")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            AnswerCreateParams.builder()
                .model("string")
                .question("What is the capital of Japan?")
                .examples(listOf(listOf("x")))
                .examplesContext(
                    "Ottawa, Canada's capital, is located in the east of southern Ontario, near the city of Montréal and the U.S. border."
                )
                .documents(listOf("string"))
                .file("string")
                .searchModel("string")
                .maxRerank(123L)
                .temperature(42.23)
                .logprobs(123L)
                .maxTokens(123L)
                .stop(AnswerCreateParams.Stop.ofString("\n"))
                .n(123L)
                .logitBias(JsonString.of("abc"))
                .returnMetadata(true)
                .returnPrompt(true)
                .expand(listOf(JsonString.of("abc")))
                .user("user-1234")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo("string")
        assertThat(body.question()).isEqualTo("What is the capital of Japan?")
        assertThat(body.examples()).isEqualTo(listOf(listOf("x")))
        assertThat(body.examplesContext())
            .isEqualTo(
                "Ottawa, Canada's capital, is located in the east of southern Ontario, near the city of Montréal and the U.S. border."
            )
        assertThat(body.documents()).isEqualTo(listOf("string"))
        assertThat(body.file()).isEqualTo("string")
        assertThat(body.searchModel()).isEqualTo("string")
        assertThat(body.maxRerank()).isEqualTo(123L)
        assertThat(body.temperature()).isEqualTo(42.23)
        assertThat(body.logprobs()).isEqualTo(123L)
        assertThat(body.maxTokens()).isEqualTo(123L)
        assertThat(body.stop()).isEqualTo(AnswerCreateParams.Stop.ofString("\n"))
        assertThat(body.n()).isEqualTo(123L)
        assertThat(body.logitBias()).isEqualTo(JsonString.of("abc"))
        assertThat(body.returnMetadata()).isEqualTo(true)
        assertThat(body.returnPrompt()).isEqualTo(true)
        assertThat(body.expand()).isEqualTo(listOf(JsonString.of("abc")))
        assertThat(body.user()).isEqualTo("user-1234")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            AnswerCreateParams.builder()
                .model("string")
                .question("What is the capital of Japan?")
                .examples(listOf(listOf("x")))
                .examplesContext(
                    "Ottawa, Canada's capital, is located in the east of southern Ontario, near the city of Montréal and the U.S. border."
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo("string")
        assertThat(body.question()).isEqualTo("What is the capital of Japan?")
        assertThat(body.examples()).isEqualTo(listOf(listOf("x")))
        assertThat(body.examplesContext())
            .isEqualTo(
                "Ottawa, Canada's capital, is located in the east of southern Ontario, near the city of Montréal and the U.S. border."
            )
    }
}
