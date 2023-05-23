package com.openai.api.models

import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AudioTranscriptionCreateParamsTest {

    @Test
    fun createAudioTranscriptionCreateParams() {
        AudioTranscriptionCreateParams.builder()
            .file("file.txt")
            .model("string")
            .prompt("string")
            .responseFormat("string")
            .temperature(42.23)
            .language("string")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            AudioTranscriptionCreateParams.builder()
                .file("file.txt")
                .model("string")
                .prompt("string")
                .responseFormat("string")
                .temperature(42.23)
                .language("string")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.file()).isEqualTo("file.txt")
        assertThat(body.model()).isEqualTo("string")
        assertThat(body.prompt()).isEqualTo("string")
        assertThat(body.responseFormat()).isEqualTo("string")
        assertThat(body.temperature()).isEqualTo(42.23)
        assertThat(body.language()).isEqualTo("string")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            AudioTranscriptionCreateParams.builder().file("file.txt").model("string").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.file()).isEqualTo("file.txt")
        assertThat(body.model()).isEqualTo("string")
    }
}
