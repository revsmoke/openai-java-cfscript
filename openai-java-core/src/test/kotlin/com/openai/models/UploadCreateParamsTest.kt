// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UploadCreateParamsTest {

    @Test
    fun createUploadCreateParams() {
        UploadCreateParams.builder()
            .bytes(123L)
            .filename("filename")
            .mimeType("mime_type")
            .purpose(FilePurpose.ASSISTANTS)
            .build()
    }

    @Test
    fun getBody() {
        val params =
            UploadCreateParams.builder()
                .bytes(123L)
                .filename("filename")
                .mimeType("mime_type")
                .purpose(FilePurpose.ASSISTANTS)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.bytes()).isEqualTo(123L)
        assertThat(body.filename()).isEqualTo("filename")
        assertThat(body.mimeType()).isEqualTo("mime_type")
        assertThat(body.purpose()).isEqualTo(FilePurpose.ASSISTANTS)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            UploadCreateParams.builder()
                .bytes(123L)
                .filename("filename")
                .mimeType("mime_type")
                .purpose(FilePurpose.ASSISTANTS)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.bytes()).isEqualTo(123L)
        assertThat(body.filename()).isEqualTo("filename")
        assertThat(body.mimeType()).isEqualTo("mime_type")
        assertThat(body.purpose()).isEqualTo(FilePurpose.ASSISTANTS)
    }
}
