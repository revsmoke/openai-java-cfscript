package com.openai.api.services.blocking

import com.openai.api.TestServerExtension
import com.openai.api.client.okhttp.OpenAiOkHttpClient
import com.openai.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class FineTuneServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val fineTuneService = client.fineTunes()
        val fineTune =
            fineTuneService.create(
                FineTuneCreateParams.builder()
                    .trainingFile("file-ajSREls59WBbvgSzJSVWxMCB")
                    .validationFile("file-XjSREls59WBbvgSzJSVWxMCa")
                    .model("string")
                    .nEpochs(123L)
                    .batchSize(123L)
                    .learningRateMultiplier(42.23)
                    .promptLossWeight(42.23)
                    .computeClassificationMetrics(true)
                    .classificationNClasses(123L)
                    .classificationPositiveClass("string")
                    .classificationBetas(listOf(42.23))
                    .suffix("x")
                    .build()
            )
        println(fineTune)
        fineTune.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val fineTuneService = client.fineTunes()
        val fineTune =
            fineTuneService.retrieve(
                FineTuneRetrieveParams.builder().fineTuneId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
            )
        println(fineTune)
        fineTune.validate()
    }

    @Test
    fun callList() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val fineTuneService = client.fineTunes()
        val listFineTunesResponse = fineTuneService.list(FineTuneListParams.builder().build())
        println(listFineTunesResponse)
        listFineTunesResponse.validate()
    }

    @Test
    fun callCancel() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val fineTuneService = client.fineTunes()
        val fineTune =
            fineTuneService.cancel(
                FineTuneCancelParams.builder().fineTuneId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
            )
        println(fineTune)
        fineTune.validate()
    }

    @Test
    fun callListEvents() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val fineTuneService = client.fineTunes()
        val listFineTuneEventsResponse =
            fineTuneService.listEvents(
                FineTuneListEventsParams.builder()
                    .fineTuneId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                    .stream(true)
                    .build()
            )
        println(listFineTuneEventsResponse)
        listFineTuneEventsResponse.validate()
    }
}
