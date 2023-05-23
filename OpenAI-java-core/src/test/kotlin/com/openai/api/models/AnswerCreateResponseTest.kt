package com.openai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AnswerCreateResponseTest {

    @Test
    fun createAnswerCreateResponse() {
        val answerCreateResponse =
            AnswerCreateResponse.builder()
                .object_("string")
                .model("string")
                .searchModel("string")
                .completion("string")
                .answers(listOf("string"))
                .selectedDocuments(
                    listOf(
                        AnswerCreateResponse.SelectedDocument.builder()
                            .document(123L)
                            .text("string")
                            .build()
                    )
                )
                .build()
        assertThat(answerCreateResponse).isNotNull
        assertThat(answerCreateResponse.object_()).contains("string")
        assertThat(answerCreateResponse.model()).contains("string")
        assertThat(answerCreateResponse.searchModel()).contains("string")
        assertThat(answerCreateResponse.completion()).contains("string")
        assertThat(answerCreateResponse.answers().get()).containsExactly("string")
        assertThat(answerCreateResponse.selectedDocuments().get())
            .containsExactly(
                AnswerCreateResponse.SelectedDocument.builder()
                    .document(123L)
                    .text("string")
                    .build()
            )
    }
}
