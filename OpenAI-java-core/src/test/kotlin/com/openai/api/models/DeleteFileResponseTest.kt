package com.openai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DeleteFileResponseTest {

    @Test
    fun createDeleteFileResponse() {
        val deleteFileResponse =
            DeleteFileResponse.builder().id("string").object_("string").deleted(true).build()
        assertThat(deleteFileResponse).isNotNull
        assertThat(deleteFileResponse.id()).isEqualTo("string")
        assertThat(deleteFileResponse.object_()).isEqualTo("string")
        assertThat(deleteFileResponse.deleted()).isEqualTo(true)
    }
}
