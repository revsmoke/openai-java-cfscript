// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BatchRequestCountsTest {

    @Test
    fun createBatchRequestCounts() {
        val batchRequestCounts =
            BatchRequestCounts.builder().completed(123L).failed(123L).total(123L).build()
        assertThat(batchRequestCounts).isNotNull
        assertThat(batchRequestCounts.completed()).isEqualTo(123L)
        assertThat(batchRequestCounts.failed()).isEqualTo(123L)
        assertThat(batchRequestCounts.total()).isEqualTo(123L)
    }
}
