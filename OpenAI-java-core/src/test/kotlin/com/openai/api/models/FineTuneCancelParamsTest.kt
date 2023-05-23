package com.openai.api.models

import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FineTuneCancelParamsTest {

    @Test
    fun createFineTuneCancelParams() {
        FineTuneCancelParams.builder().fineTuneId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
    }

    @Test
    fun getPathParam() {
        val params =
            FineTuneCancelParams.builder().fineTuneId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
        assertThat(params).isNotNull
        // path param "fineTuneId"
        assertThat(params.getPathParam(0)).isEqualTo("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
