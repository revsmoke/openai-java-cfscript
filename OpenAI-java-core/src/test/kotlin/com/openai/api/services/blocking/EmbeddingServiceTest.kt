package com.openai.api.services.blocking

import com.openai.api.TestServerExtension
import com.openai.api.client.okhttp.OpenAiOkHttpClient
import com.openai.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class EmbeddingServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val embeddingService = client.embeddings()
        val embedding =
            embeddingService.create(
                EmbeddingCreateParams.builder()
                    .model("string")
                    .input(EmbeddingCreateParams.Input.ofString("This is a test."))
                    .user("user-1234")
                    .build()
            )
        println(embedding)
        embedding.validate()
    }
}
