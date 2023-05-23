package com.openai.api.services.blocking.audio

import com.openai.api.TestServerExtension
import com.openai.api.client.okhttp.OpenAiOkHttpClient
import com.openai.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class TranscriptionServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val transcriptionService = client.audio().transcriptions()
        val transcription =
            transcriptionService.create(
                AudioTranscriptionCreateParams.builder()
                    .file("file.txt")
                    .model("string")
                    .prompt("string")
                    .responseFormat("string")
                    .temperature(42.23)
                    .language("string")
                    .build()
            )
        println(transcription)
        transcription.validate()
    }
}
