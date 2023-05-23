package com.openai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TranscriptionTest {

    @Test
    fun createTranscription() {
        val transcription = Transcription.builder().text("string").build()
        assertThat(transcription).isNotNull
        assertThat(transcription.text()).isEqualTo("string")
    }
}
