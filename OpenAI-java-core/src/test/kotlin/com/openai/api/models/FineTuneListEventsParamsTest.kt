package com.openai.api.models

import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FineTuneListEventsParamsTest {

    @Test
    fun createFineTuneListEventsParams() {
        FineTuneListEventsParams.builder()
            .fineTuneId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
            .stream(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            FineTuneListEventsParams.builder()
                .fineTuneId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                .stream(true)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("stream", listOf("true"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            FineTuneListEventsParams.builder().fineTuneId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
        val params =
            FineTuneListEventsParams.builder().fineTuneId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
        assertThat(params).isNotNull
        // path param "fineTuneId"
        assertThat(params.getPathParam(0)).isEqualTo("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
