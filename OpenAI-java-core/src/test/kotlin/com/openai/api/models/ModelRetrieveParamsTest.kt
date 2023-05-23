package com.openai.api.models

import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ModelRetrieveParamsTest {

    @Test
    fun createModelRetrieveParams() {
        ModelRetrieveParams.builder().model("text-davinci-001").build()
    }

    @Test
    fun getPathParam() {
        val params = ModelRetrieveParams.builder().model("text-davinci-001").build()
        assertThat(params).isNotNull
        // path param "model"
        assertThat(params.getPathParam(0)).isEqualTo("text-davinci-001")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
