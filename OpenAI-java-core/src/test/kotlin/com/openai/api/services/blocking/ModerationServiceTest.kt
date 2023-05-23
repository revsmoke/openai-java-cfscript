package com.openai.api.services.blocking

import com.openai.api.TestServerExtension
import com.openai.api.client.okhttp.OpenAiOkHttpClient
import com.openai.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ModerationServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val moderationService = client.moderations()
        val moderationCreateResponse =
            moderationService.create(
                ModerationCreateParams.builder()
                    .input(ModerationCreateParams.Input.ofString("I want to kill them."))
                    .model("text-moderation-stable")
                    .build()
            )
        println(moderationCreateResponse)
        moderationCreateResponse.validate()
    }
}
