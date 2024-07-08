// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ErrorObjectTest {

    @Test
    fun createErrorObject() {
        val errorObject =
            ErrorObject.builder()
                .code("string")
                .message("string")
                .param("string")
                .type("string")
                .build()
        assertThat(errorObject).isNotNull
        assertThat(errorObject.code()).contains("string")
        assertThat(errorObject.message()).isEqualTo("string")
        assertThat(errorObject.param()).contains("string")
        assertThat(errorObject.type()).isEqualTo("string")
    }
}
