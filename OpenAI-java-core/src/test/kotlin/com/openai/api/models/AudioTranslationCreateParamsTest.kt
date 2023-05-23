package com.openai.api.models

import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AudioTranslationCreateParamsTest {

    @Test
    fun createAudioTranslationCreateParams() {
        AudioTranslationCreateParams.builder()
            .file("file.txt")
            .model("string")
            .prompt("string")
            .responseFormat("string")
            .temperature(42.23)
            .build()
    }

    @Test
    fun getBody() {
        val params =
            AudioTranslationCreateParams.builder()
                .file("file.txt")
                .model("string")
                .prompt("string")
                .responseFormat("string")
                .temperature(42.23)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.file()).isEqualTo("file.txt")
        assertThat(body.model()).isEqualTo("string")
        assertThat(body.prompt()).isEqualTo("string")
        assertThat(body.responseFormat()).isEqualTo("string")
        assertThat(body.temperature()).isEqualTo(42.23)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = AudioTranslationCreateParams.builder().file("file.txt").model("string").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.file()).isEqualTo("file.txt")
        assertThat(body.model()).isEqualTo("string")
    }
}
