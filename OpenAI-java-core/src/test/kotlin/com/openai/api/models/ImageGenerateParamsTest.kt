package com.openai.api.models

import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ImageGenerateParamsTest {

    @Test
    fun createImageGenerateParams() {
        ImageGenerateParams.builder()
            .prompt("A cute baby sea otter")
            .n(123L)
            .size(ImageGenerateParams.Size._256X256)
            .responseFormat(ImageGenerateParams.ResponseFormat.URL)
            .user("user-1234")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            ImageGenerateParams.builder()
                .prompt("A cute baby sea otter")
                .n(123L)
                .size(ImageGenerateParams.Size._256X256)
                .responseFormat(ImageGenerateParams.ResponseFormat.URL)
                .user("user-1234")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.prompt()).isEqualTo("A cute baby sea otter")
        assertThat(body.n()).isEqualTo(123L)
        assertThat(body.size()).isEqualTo(ImageGenerateParams.Size._256X256)
        assertThat(body.responseFormat()).isEqualTo(ImageGenerateParams.ResponseFormat.URL)
        assertThat(body.user()).isEqualTo("user-1234")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = ImageGenerateParams.builder().prompt("A cute baby sea otter").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.prompt()).isEqualTo("A cute baby sea otter")
    }
}
