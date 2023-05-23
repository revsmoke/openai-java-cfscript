package com.openai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ClassificationCreateResponseTest {

    @Test
    fun createClassificationCreateResponse() {
        val classificationCreateResponse =
            ClassificationCreateResponse.builder()
                .object_("string")
                .model("string")
                .searchModel("string")
                .completion("string")
                .label("string")
                .selectedExamples(
                    listOf(
                        ClassificationCreateResponse.SelectedExample.builder()
                            .document(123L)
                            .text("string")
                            .label("string")
                            .build()
                    )
                )
                .build()
        assertThat(classificationCreateResponse).isNotNull
        assertThat(classificationCreateResponse.object_()).contains("string")
        assertThat(classificationCreateResponse.model()).contains("string")
        assertThat(classificationCreateResponse.searchModel()).contains("string")
        assertThat(classificationCreateResponse.completion()).contains("string")
        assertThat(classificationCreateResponse.label()).contains("string")
        assertThat(classificationCreateResponse.selectedExamples().get())
            .containsExactly(
                ClassificationCreateResponse.SelectedExample.builder()
                    .document(123L)
                    .text("string")
                    .label("string")
                    .build()
            )
    }
}
