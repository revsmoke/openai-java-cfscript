package com.openai.api.models

import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ImageCreateVariationParamsTest {

    @Test
    fun createImageCreateVariationParams() {
        ImageCreateVariationParams.builder()
            .image("file.txt")
            .n(123L)
            .size(ImageCreateVariationParams.Size._256X256)
            .responseFormat(ImageCreateVariationParams.ResponseFormat.URL)
            .user("user-1234")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            ImageCreateVariationParams.builder()
                .image("file.txt")
                .n(123L)
                .size(ImageCreateVariationParams.Size._256X256)
                .responseFormat(ImageCreateVariationParams.ResponseFormat.URL)
                .user("user-1234")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.image()).isEqualTo("file.txt")
        assertThat(body.n()).isEqualTo(123L)
        assertThat(body.size()).isEqualTo(ImageCreateVariationParams.Size._256X256)
        assertThat(body.responseFormat()).isEqualTo(ImageCreateVariationParams.ResponseFormat.URL)
        assertThat(body.user()).isEqualTo("user-1234")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = ImageCreateVariationParams.builder().image("file.txt").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.image()).isEqualTo("file.txt")
    }
}
