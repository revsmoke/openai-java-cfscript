// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BatchListParamsTest {

    @Test
    fun createBatchListParams() {
        BatchListParams.builder().after("after").limit(123L).build()
    }

    @Test
    fun getQueryParams() {
        val params = BatchListParams.builder().after("after").limit(123L).build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("after", listOf("after"))
        expected.put("limit", listOf("123"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = BatchListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
