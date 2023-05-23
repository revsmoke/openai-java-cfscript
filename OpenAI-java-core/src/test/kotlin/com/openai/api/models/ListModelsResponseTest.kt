package com.openai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ListModelsResponseTest {

    @Test
    fun createListModelsResponse() {
        val listModelsResponse =
            ListModelsResponse.builder()
                .object_("string")
                .data(
                    listOf(
                        Model.builder()
                            .id("string")
                            .object_("string")
                            .created(123L)
                            .ownedBy("string")
                            .build()
                    )
                )
                .build()
        assertThat(listModelsResponse).isNotNull
        assertThat(listModelsResponse.object_()).isEqualTo("string")
        assertThat(listModelsResponse.data())
            .containsExactly(
                Model.builder()
                    .id("string")
                    .object_("string")
                    .created(123L)
                    .ownedBy("string")
                    .build()
            )
    }
}
