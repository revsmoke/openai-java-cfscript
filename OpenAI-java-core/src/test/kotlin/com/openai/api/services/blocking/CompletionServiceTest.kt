package com.openai.api.services.blocking

import com.openai.api.TestServerExtension
import com.openai.api.client.okhttp.OpenAiOkHttpClient
import com.openai.api.core.JsonString
import com.openai.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CompletionServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val completionService = client.completions()
        val completion =
            completionService.create(
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
            )
        println(completion)
        completion.validate()
    }
}
