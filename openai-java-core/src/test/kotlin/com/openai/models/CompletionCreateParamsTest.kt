// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CompletionCreateParamsTest {

    @Test
    fun createCompletionCreateParams() {
        CompletionCreateParams.builder()
            .model(CompletionCreateParams.Model.ofString("string"))
            .prompt(CompletionCreateParams.Prompt.ofString("This is a test."))
            .bestOf(20L)
            .echo(true)
            .frequencyPenalty(2.0)
            .logitBias(CompletionCreateParams.LogitBias.builder().build())
            .logprobs(5L)
            .maxTokens(123L)
            .n(123L)
            .presencePenalty(2.0)
            .seed(123L)
            .stop(CompletionCreateParams.Stop.ofString("\n"))
            .streamOptions(ChatCompletionStreamOptions.builder().includeUsage(true).build())
            .suffix("test.")
            .temperature(2.0)
            .topP(1.0)
            .user("user-1234")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            CompletionCreateParams.builder()
                .model(CompletionCreateParams.Model.ofString("string"))
                .prompt(CompletionCreateParams.Prompt.ofString("This is a test."))
                .bestOf(20L)
                .echo(true)
                .frequencyPenalty(2.0)
                .logitBias(CompletionCreateParams.LogitBias.builder().build())
                .logprobs(5L)
                .maxTokens(123L)
                .n(123L)
                .presencePenalty(2.0)
                .seed(123L)
                .stop(CompletionCreateParams.Stop.ofString("\n"))
                .streamOptions(ChatCompletionStreamOptions.builder().includeUsage(true).build())
                .suffix("test.")
                .temperature(2.0)
                .topP(1.0)
                .user("user-1234")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(CompletionCreateParams.Model.ofString("string"))
        assertThat(body.prompt())
            .isEqualTo(CompletionCreateParams.Prompt.ofString("This is a test."))
        assertThat(body.bestOf()).isEqualTo(20L)
        assertThat(body.echo()).isEqualTo(true)
        assertThat(body.frequencyPenalty()).isEqualTo(2.0)
        assertThat(body.logitBias()).isEqualTo(CompletionCreateParams.LogitBias.builder().build())
        assertThat(body.logprobs()).isEqualTo(5L)
        assertThat(body.maxTokens()).isEqualTo(123L)
        assertThat(body.n()).isEqualTo(123L)
        assertThat(body.presencePenalty()).isEqualTo(2.0)
        assertThat(body.seed()).isEqualTo(123L)
        assertThat(body.stop()).isEqualTo(CompletionCreateParams.Stop.ofString("\n"))
        assertThat(body.streamOptions())
            .isEqualTo(ChatCompletionStreamOptions.builder().includeUsage(true).build())
        assertThat(body.suffix()).isEqualTo("test.")
        assertThat(body.temperature()).isEqualTo(2.0)
        assertThat(body.topP()).isEqualTo(1.0)
        assertThat(body.user()).isEqualTo("user-1234")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            CompletionCreateParams.builder()
                .model(CompletionCreateParams.Model.ofString("string"))
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(CompletionCreateParams.Model.ofString("string"))
    }
}
