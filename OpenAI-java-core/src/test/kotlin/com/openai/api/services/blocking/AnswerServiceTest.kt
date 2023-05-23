package com.openai.api.services.blocking

import com.openai.api.TestServerExtension
import com.openai.api.client.okhttp.OpenAiOkHttpClient
import com.openai.api.core.JsonString
import com.openai.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class AnswerServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val answerService = client.answers()
        val answerCreateResponse =
            answerService.create(
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
            )
        println(answerCreateResponse)
        answerCreateResponse.validate()
    }
}
