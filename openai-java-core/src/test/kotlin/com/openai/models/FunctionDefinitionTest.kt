// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FunctionDefinitionTest {

    @Test
    fun createFunctionDefinition() {
        val functionDefinition =
            FunctionDefinition.builder()
                .name("string")
                .description("string")
                .parameters(FunctionParameters.builder().build())
                .build()
        assertThat(functionDefinition).isNotNull
        assertThat(functionDefinition.name()).isEqualTo("string")
        assertThat(functionDefinition.description()).contains("string")
        assertThat(functionDefinition.parameters()).contains(FunctionParameters.builder().build())
    }
}
