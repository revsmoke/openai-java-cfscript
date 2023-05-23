package com.openai.api.services.blocking

import com.openai.api.TestServerExtension
import com.openai.api.client.okhttp.OpenAiOkHttpClient
import com.openai.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ModelServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val modelService = client.models()
        val model =
            modelService.retrieve(ModelRetrieveParams.builder().model("text-davinci-001").build())
        println(model)
        model.validate()
    }

    @Test
    fun callList() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val modelService = client.models()
        val listModelsResponse = modelService.list(ModelListParams.builder().build())
        println(listModelsResponse)
        listModelsResponse.validate()
    }

    @Test
    fun callDelete() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val modelService = client.models()
        val deleteModelResponse =
            modelService.delete(
                ModelDeleteParams.builder().model("curie:ft-acmeco-2021-03-03-21-44-20").build()
            )
        println(deleteModelResponse)
        deleteModelResponse.validate()
    }
}
