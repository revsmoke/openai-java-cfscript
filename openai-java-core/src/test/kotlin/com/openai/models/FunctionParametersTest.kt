// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FunctionParametersTest {

    @Test
    fun createFunctionParameters() {
        val functionParameters = FunctionParameters.builder().build()
        assertThat(functionParameters).isNotNull
    }
}
