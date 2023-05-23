package com.openai.api.models

import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileRetrieveFileContentParamsTest {

    @Test
    fun createFileRetrieveFileContentParams() {
        FileRetrieveFileContentParams.builder().fileId("string").build()
    }

    @Test
    fun getPathParam() {
        val params = FileRetrieveFileContentParams.builder().fileId("string").build()
        assertThat(params).isNotNull
        // path param "fileId"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
