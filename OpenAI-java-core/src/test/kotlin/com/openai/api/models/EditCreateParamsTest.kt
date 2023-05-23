package com.openai.api.models

import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EditCreateParamsTest {

    @Test
    fun createEditCreateParams() {
        EditCreateParams.builder()
            .model("string")
            .input("What day of the wek is it?")
            .instruction("Fix the spelling mistakes.")
            .n(123L)
            .temperature(42.23)
            .topP(42.23)
            .build()
    }

    @Test
    fun getBody() {
        val params =
            EditCreateParams.builder()
                .model("string")
                .input("What day of the wek is it?")
                .instruction("Fix the spelling mistakes.")
                .n(123L)
                .temperature(42.23)
                .topP(42.23)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo("string")
        assertThat(body.input()).isEqualTo("What day of the wek is it?")
        assertThat(body.instruction()).isEqualTo("Fix the spelling mistakes.")
        assertThat(body.n()).isEqualTo(123L)
        assertThat(body.temperature()).isEqualTo(42.23)
        assertThat(body.topP()).isEqualTo(42.23)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            EditCreateParams.builder()
                .model("string")
                .instruction("Fix the spelling mistakes.")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo("string")
        assertThat(body.instruction()).isEqualTo("Fix the spelling mistakes.")
    }
}
