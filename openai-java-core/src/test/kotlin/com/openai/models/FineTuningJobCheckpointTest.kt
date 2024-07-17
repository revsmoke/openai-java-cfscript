// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FineTuningJobCheckpointTest {

    @Test
    fun createFineTuningJobCheckpoint() {
        val fineTuningJobCheckpoint =
            FineTuningJobCheckpoint.builder()
                .id("id")
                .createdAt(123L)
                .fineTunedModelCheckpoint("fine_tuned_model_checkpoint")
                .fineTuningJobId("fine_tuning_job_id")
                .metrics(
                    FineTuningJobCheckpoint.Metrics.builder()
                        .fullValidLoss(42.23)
                        .fullValidMeanTokenAccuracy(42.23)
                        .step(42.23)
                        .trainLoss(42.23)
                        .trainMeanTokenAccuracy(42.23)
                        .validLoss(42.23)
                        .validMeanTokenAccuracy(42.23)
                        .build()
                )
                .object_(FineTuningJobCheckpoint.Object.FINE_TUNING_JOB_CHECKPOINT)
                .stepNumber(123L)
                .build()
        assertThat(fineTuningJobCheckpoint).isNotNull
        assertThat(fineTuningJobCheckpoint.id()).isEqualTo("id")
        assertThat(fineTuningJobCheckpoint.createdAt()).isEqualTo(123L)
        assertThat(fineTuningJobCheckpoint.fineTunedModelCheckpoint())
            .isEqualTo("fine_tuned_model_checkpoint")
        assertThat(fineTuningJobCheckpoint.fineTuningJobId()).isEqualTo("fine_tuning_job_id")
        assertThat(fineTuningJobCheckpoint.metrics())
            .isEqualTo(
                FineTuningJobCheckpoint.Metrics.builder()
                    .fullValidLoss(42.23)
                    .fullValidMeanTokenAccuracy(42.23)
                    .step(42.23)
                    .trainLoss(42.23)
                    .trainMeanTokenAccuracy(42.23)
                    .validLoss(42.23)
                    .validMeanTokenAccuracy(42.23)
                    .build()
            )
        assertThat(fineTuningJobCheckpoint.object_())
            .isEqualTo(FineTuningJobCheckpoint.Object.FINE_TUNING_JOB_CHECKPOINT)
        assertThat(fineTuningJobCheckpoint.stepNumber()).isEqualTo(123L)
    }
}
