// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ModerationTextInputTest {

    @Test
    fun createModerationTextInput() {
        val moderationTextInput =
            ModerationTextInput.builder()
                .text("I want to kill them")
                .type(ModerationTextInput.Type.TEXT)
                .build()
        assertThat(moderationTextInput).isNotNull
        assertThat(moderationTextInput.text()).isEqualTo("I want to kill them")
        assertThat(moderationTextInput.type()).isEqualTo(ModerationTextInput.Type.TEXT)
    }
}
