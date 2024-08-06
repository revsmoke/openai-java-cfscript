// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseFormatTextTest {

    @Test
    fun createResponseFormatText() {
        val responseFormatText =
            ResponseFormatText.builder().type(ResponseFormatText.Type.TEXT).build()
        assertThat(responseFormatText).isNotNull
        assertThat(responseFormatText.type()).isEqualTo(ResponseFormatText.Type.TEXT)
    }
}
