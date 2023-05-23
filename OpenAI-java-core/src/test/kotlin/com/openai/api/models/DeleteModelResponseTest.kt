package com.openai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DeleteModelResponseTest {

    @Test
    fun createDeleteModelResponse() {
        val deleteModelResponse =
            DeleteModelResponse.builder().id("string").object_("string").deleted(true).build()
        assertThat(deleteModelResponse).isNotNull
        assertThat(deleteModelResponse.id()).isEqualTo("string")
        assertThat(deleteModelResponse.object_()).isEqualTo("string")
        assertThat(deleteModelResponse.deleted()).isEqualTo(true)
    }
}
