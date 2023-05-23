package com.openai.api.models

import com.openai.api.core.JsonString
import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CompletionCreateParamsTest {

    @Test
    fun createCompletionCreateParams() {
        CompletionCreateParams.builder()
            .model("string")
            .prompt(CompletionCreateParams.Prompt.ofString("This is a test."))
            .suffix("test.")
            .maxTokens(123L)
            .temperature(42.23)
            .topP(42.23)
            .n(123L)
            .stream(true)
            .logprobs(123L)
            .echo(true)
            .stop(CompletionCreateParams.Stop.ofString("\n"))
            .presencePenalty(42.23)
            .frequencyPenalty(42.23)
            .bestOf(123L)
            .logitBias(JsonString.of("abc"))
            .user("user-1234")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            CompletionCreateParams.builder()
                .model("string")
                .prompt(CompletionCreateParams.Prompt.ofString("This is a test."))
                .suffix("test.")
                .maxTokens(123L)
                .temperature(42.23)
                .topP(42.23)
                .n(123L)
                .stream(true)
                .logprobs(123L)
                .echo(true)
                .stop(CompletionCreateParams.Stop.ofString("\n"))
                .presencePenalty(42.23)
                .frequencyPenalty(42.23)
                .bestOf(123L)
                .logitBias(JsonString.of("abc"))
                .user("user-1234")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo("string")
        assertThat(body.prompt())
            .isEqualTo(CompletionCreateParams.Prompt.ofString("This is a test."))
        assertThat(body.suffix()).isEqualTo("test.")
        assertThat(body.maxTokens()).isEqualTo(123L)
        assertThat(body.temperature()).isEqualTo(42.23)
        assertThat(body.topP()).isEqualTo(42.23)
        assertThat(body.n()).isEqualTo(123L)
        assertThat(body.stream()).isEqualTo(true)
        assertThat(body.logprobs()).isEqualTo(123L)
        assertThat(body.echo()).isEqualTo(true)
        assertThat(body.stop()).isEqualTo(CompletionCreateParams.Stop.ofString("\n"))
        assertThat(body.presencePenalty()).isEqualTo(42.23)
        assertThat(body.frequencyPenalty()).isEqualTo(42.23)
        assertThat(body.bestOf()).isEqualTo(123L)
        assertThat(body.logitBias()).isEqualTo(JsonString.of("abc"))
        assertThat(body.user()).isEqualTo("user-1234")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = CompletionCreateParams.builder().model("string").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo("string")
    }
}
