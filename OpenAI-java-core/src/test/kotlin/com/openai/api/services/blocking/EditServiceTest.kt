package com.openai.api.services.blocking

import com.openai.api.TestServerExtension
import com.openai.api.client.okhttp.OpenAiOkHttpClient
import com.openai.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class EditServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val editService = client.edits()
        val edit =
            editService.create(
                EditCreateParams.builder()
                    .model("string")
                    .input("What day of the wek is it?")
                    .instruction("Fix the spelling mistakes.")
                    .n(123L)
                    .temperature(42.23)
                    .topP(42.23)
                    .build()
            )
        println(edit)
        edit.validate()
    }
}
