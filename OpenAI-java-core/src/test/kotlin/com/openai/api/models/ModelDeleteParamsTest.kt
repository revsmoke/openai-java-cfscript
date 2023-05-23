package com.openai.api.models

import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ModelDeleteParamsTest {

    @Test
    fun createModelDeleteParams() {
        ModelDeleteParams.builder().model("curie:ft-acmeco-2021-03-03-21-44-20").build()
    }

    @Test
    fun getPathParam() {
        val params =
            ModelDeleteParams.builder().model("curie:ft-acmeco-2021-03-03-21-44-20").build()
        assertThat(params).isNotNull
        // path param "model"
        assertThat(params.getPathParam(0)).isEqualTo("curie:ft-acmeco-2021-03-03-21-44-20")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
