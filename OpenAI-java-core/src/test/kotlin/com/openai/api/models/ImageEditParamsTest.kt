package com.openai.api.models

import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ImageEditParamsTest {

    @Test
    fun createImageEditParams() {
        ImageEditParams.builder()
            .image("file.txt")
            .mask("file.txt")
            .prompt("A cute baby sea otter wearing a beret")
            .n(123L)
            .size(ImageEditParams.Size._256X256)
            .responseFormat(ImageEditParams.ResponseFormat.URL)
            .user("user-1234")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            ImageEditParams.builder()
                .image("file.txt")
                .mask("file.txt")
                .prompt("A cute baby sea otter wearing a beret")
                .n(123L)
                .size(ImageEditParams.Size._256X256)
                .responseFormat(ImageEditParams.ResponseFormat.URL)
                .user("user-1234")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.image()).isEqualTo("file.txt")
        assertThat(body.mask()).isEqualTo("file.txt")
        assertThat(body.prompt()).isEqualTo("A cute baby sea otter wearing a beret")
        assertThat(body.n()).isEqualTo(123L)
        assertThat(body.size()).isEqualTo(ImageEditParams.Size._256X256)
        assertThat(body.responseFormat()).isEqualTo(ImageEditParams.ResponseFormat.URL)
        assertThat(body.user()).isEqualTo("user-1234")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            ImageEditParams.builder()
                .image("file.txt")
                .prompt("A cute baby sea otter wearing a beret")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.image()).isEqualTo("file.txt")
        assertThat(body.prompt()).isEqualTo("A cute baby sea otter wearing a beret")
    }
}
