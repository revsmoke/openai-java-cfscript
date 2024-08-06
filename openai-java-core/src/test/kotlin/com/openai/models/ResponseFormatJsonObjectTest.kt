// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseFormatJsonObjectTest {

    @Test
    fun createResponseFormatJsonObject() {
        val responseFormatJsonObject =
            ResponseFormatJsonObject.builder()
                .type(ResponseFormatJsonObject.Type.JSON_OBJECT)
                .build()
        assertThat(responseFormatJsonObject).isNotNull
        assertThat(responseFormatJsonObject.type())
            .isEqualTo(ResponseFormatJsonObject.Type.JSON_OBJECT)
    }
}
