// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FineTuningJobListEventsParamsTest {

    @Test
    fun createFineTuningJobListEventsParams() {
        FineTuningJobListEventsParams.builder()
            .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
            .after("after")
            .limit(123L)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            FineTuningJobListEventsParams.builder()
                .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                .after("after")
                .limit(123L)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("after", listOf("after"))
        expected.put("limit", listOf("123"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            FineTuningJobListEventsParams.builder()
                .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
        val params =
            FineTuningJobListEventsParams.builder()
                .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                .build()
        assertThat(params).isNotNull
        // path param "fineTuningJobId"
        assertThat(params.getPathParam(0)).isEqualTo("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
