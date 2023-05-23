package com.openai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ModelTest {

    @Test
    fun createModel() {
        val model =
            Model.builder().id("string").object_("string").created(123L).ownedBy("string").build()
        assertThat(model).isNotNull
        assertThat(model.id()).isEqualTo("string")
        assertThat(model.object_()).isEqualTo("string")
        assertThat(model.created()).isEqualTo(123L)
        assertThat(model.ownedBy()).isEqualTo("string")
    }
}
