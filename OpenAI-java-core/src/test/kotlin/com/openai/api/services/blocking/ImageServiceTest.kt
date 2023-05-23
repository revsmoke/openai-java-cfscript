package com.openai.api.services.blocking

import com.openai.api.TestServerExtension
import com.openai.api.client.okhttp.OpenAiOkHttpClient
import com.openai.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ImageServiceTest {

    @Test
    fun callCreateVariation() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val imageService = client.images()
        val image =
            imageService.createVariation(
                ImageCreateVariationParams.builder()
                    .image("file.txt")
                    .n(123L)
                    .size(ImageCreateVariationParams.Size._256X256)
                    .responseFormat(ImageCreateVariationParams.ResponseFormat.URL)
                    .user("user-1234")
                    .build()
            )
        println(image)
        image.validate()
    }

    @Test
    fun callEdit() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val imageService = client.images()
        val image =
            imageService.edit(
                ImageEditParams.builder()
                    .image("file.txt")
                    .mask("file.txt")
                    .prompt("A cute baby sea otter wearing a beret")
                    .n(123L)
                    .size(ImageEditParams.Size._256X256)
                    .responseFormat(ImageEditParams.ResponseFormat.URL)
                    .user("user-1234")
                    .build()
            )
        println(image)
        image.validate()
    }

    @Test
    fun callGenerate() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val imageService = client.images()
        val image =
            imageService.generate(
                ImageGenerateParams.builder()
                    .prompt("A cute baby sea otter")
                    .n(123L)
                    .size(ImageGenerateParams.Size._256X256)
                    .responseFormat(ImageGenerateParams.ResponseFormat.URL)
                    .user("user-1234")
                    .build()
            )
        println(image)
        image.validate()
    }
}
