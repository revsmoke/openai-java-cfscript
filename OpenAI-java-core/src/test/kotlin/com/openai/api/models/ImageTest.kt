package com.openai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ImageTest {

    @Test
    fun createImage() {
        val image =
            Image.builder()
                .created(123L)
                .data(listOf(Image.Data.builder().url("string").b64Json("string").build()))
                .build()
        assertThat(image).isNotNull
        assertThat(image.created()).isEqualTo(123L)
        assertThat(image.data())
            .containsExactly(Image.Data.builder().url("string").b64Json("string").build())
    }
}
