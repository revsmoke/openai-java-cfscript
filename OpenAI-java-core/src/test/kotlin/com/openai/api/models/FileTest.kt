package com.openai.api.models

import com.openai.api.core.JsonString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileTest {

    @Test
    fun createFile() {
        val file =
            File.builder()
                .id("string")
                .object_("string")
                .bytes(123L)
                .createdAt(123L)
                .filename("string")
                .purpose("string")
                .status("string")
                .statusDetails(JsonString.of("abc"))
                .build()
        assertThat(file).isNotNull
        assertThat(file.id()).isEqualTo("string")
        assertThat(file.object_()).isEqualTo("string")
        assertThat(file.bytes()).isEqualTo(123L)
        assertThat(file.createdAt()).isEqualTo(123L)
        assertThat(file.filename()).isEqualTo("string")
        assertThat(file.purpose()).isEqualTo("string")
        assertThat(file.status()).contains("string")
        assertThat(file._statusDetails()).isEqualTo(JsonString.of("abc"))
    }
}
