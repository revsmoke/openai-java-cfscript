package com.openai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TranslationTest {

    @Test
    fun createTranslation() {
        val translation = Translation.builder().text("string").build()
        assertThat(translation).isNotNull
        assertThat(translation.text()).isEqualTo("string")
    }
}
