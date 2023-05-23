package com.openai.api.models

import com.openai.api.core.JsonString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ListFilesResponseTest {

    @Test
    fun createListFilesResponse() {
        val listFilesResponse =
            ListFilesResponse.builder()
                .object_("string")
                .data(
                    listOf(
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
                    )
                )
                .build()
        assertThat(listFilesResponse).isNotNull
        assertThat(listFilesResponse.object_()).isEqualTo("string")
        assertThat(listFilesResponse.data())
            .containsExactly(
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
            )
    }
}
