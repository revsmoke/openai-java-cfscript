package com.openai.api.models

import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ModerationCreateParamsTest {

    @Test
    fun createModerationCreateParams() {
        ModerationCreateParams.builder()
            .input(ModerationCreateParams.Input.ofString("I want to kill them."))
            .model("text-moderation-stable")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            ModerationCreateParams.builder()
                .input(ModerationCreateParams.Input.ofString("I want to kill them."))
                .model("text-moderation-stable")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.input())
            .isEqualTo(ModerationCreateParams.Input.ofString("I want to kill them."))
        assertThat(body.model()).isEqualTo("text-moderation-stable")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            ModerationCreateParams.builder()
                .input(ModerationCreateParams.Input.ofString("I want to kill them."))
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.input())
            .isEqualTo(ModerationCreateParams.Input.ofString("I want to kill them."))
    }
}
