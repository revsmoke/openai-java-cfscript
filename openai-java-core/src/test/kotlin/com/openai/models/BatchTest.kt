// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BatchTest {

    @Test
    fun createBatch() {
        val batch =
            Batch.builder()
                .id("id")
                .completionWindow("completion_window")
                .createdAt(123L)
                .endpoint("endpoint")
                .inputFileId("input_file_id")
                .object_(Batch.Object.BATCH)
                .status(Batch.Status.VALIDATING)
                .cancelledAt(123L)
                .cancellingAt(123L)
                .completedAt(123L)
                .errorFileId("error_file_id")
                .errors(
                    Batch.Errors.builder()
                        .data(
                            listOf(
                                BatchError.builder()
                                    .code("code")
                                    .line(123L)
                                    .message("message")
                                    .param("param")
                                    .build()
                            )
                        )
                        .object_("object")
                        .build()
                )
                .expiredAt(123L)
                .expiresAt(123L)
                .failedAt(123L)
                .finalizingAt(123L)
                .inProgressAt(123L)
                .metadata(JsonNull.of())
                .outputFileId("output_file_id")
                .requestCounts(
                    BatchRequestCounts.builder().completed(123L).failed(123L).total(123L).build()
                )
                .build()
        assertThat(batch).isNotNull
        assertThat(batch.id()).isEqualTo("id")
        assertThat(batch.completionWindow()).isEqualTo("completion_window")
        assertThat(batch.createdAt()).isEqualTo(123L)
        assertThat(batch.endpoint()).isEqualTo("endpoint")
        assertThat(batch.inputFileId()).isEqualTo("input_file_id")
        assertThat(batch.object_()).isEqualTo(Batch.Object.BATCH)
        assertThat(batch.status()).isEqualTo(Batch.Status.VALIDATING)
        assertThat(batch.cancelledAt()).contains(123L)
        assertThat(batch.cancellingAt()).contains(123L)
        assertThat(batch.completedAt()).contains(123L)
        assertThat(batch.errorFileId()).contains("error_file_id")
        assertThat(batch.errors())
            .contains(
                Batch.Errors.builder()
                    .data(
                        listOf(
                            BatchError.builder()
                                .code("code")
                                .line(123L)
                                .message("message")
                                .param("param")
                                .build()
                        )
                    )
                    .object_("object")
                    .build()
            )
        assertThat(batch.expiredAt()).contains(123L)
        assertThat(batch.expiresAt()).contains(123L)
        assertThat(batch.failedAt()).contains(123L)
        assertThat(batch.finalizingAt()).contains(123L)
        assertThat(batch.inProgressAt()).contains(123L)
        assertThat(batch._metadata()).isEqualTo(JsonNull.of())
        assertThat(batch.outputFileId()).contains("output_file_id")
        assertThat(batch.requestCounts())
            .contains(BatchRequestCounts.builder().completed(123L).failed(123L).total(123L).build())
    }
}
