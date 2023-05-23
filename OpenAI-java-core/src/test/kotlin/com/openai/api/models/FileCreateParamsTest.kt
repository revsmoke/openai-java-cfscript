package com.openai.api.models

import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileCreateParamsTest {

    @Test
    fun createFileCreateParams() {
        FileCreateParams.builder().file("file.txt").purpose("string").build()
    }

    @Test
    fun getBody() {
        val params = FileCreateParams.builder().file("file.txt").purpose("string").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.file()).isEqualTo("file.txt")
        assertThat(body.purpose()).isEqualTo("string")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = FileCreateParams.builder().file("file.txt").purpose("string").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.file()).isEqualTo("file.txt")
        assertThat(body.purpose()).isEqualTo("string")
    }
}
