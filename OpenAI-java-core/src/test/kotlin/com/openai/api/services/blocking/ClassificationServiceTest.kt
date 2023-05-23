package com.openai.api.services.blocking

import com.openai.api.TestServerExtension
import com.openai.api.client.okhttp.OpenAiOkHttpClient
import com.openai.api.core.JsonString
import com.openai.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ClassificationServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val classificationService = client.classifications()
        val classificationCreateResponse =
            classificationService.create(
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
            )
        println(classificationCreateResponse)
        classificationCreateResponse.validate()
    }
}
