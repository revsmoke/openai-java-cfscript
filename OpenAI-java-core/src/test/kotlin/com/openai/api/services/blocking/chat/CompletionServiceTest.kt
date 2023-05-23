package com.openai.api.services.blocking.chat

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
        val completionService = client.chat().completions()
        val chatCompletion =
            completionService.create(
                ChatCompletionCreateParams.builder()
                    .model("string")
                    .messages(
                        listOf(
                            ChatCompletionCreateParams.ChatCompletionRequestMessage.builder()
                                .role(
                                    ChatCompletionCreateParams.ChatCompletionRequestMessage.Role
                                        .SYSTEM
                                )
                                .content("string")
                                .name("string")
                                .build()
                        )
                    )
                    .temperature(42.23)
                    .topP(42.23)
                    .n(123L)
                    .stream(true)
                    .stop(ChatCompletionCreateParams.Stop.ofString("string"))
                    .maxTokens(123L)
                    .presencePenalty(42.23)
                    .frequencyPenalty(42.23)
                    .logitBias(JsonString.of("abc"))
                    .user("user-1234")
                    .build()
            )
        println(chatCompletion)
        chatCompletion.validate()
    }
}
