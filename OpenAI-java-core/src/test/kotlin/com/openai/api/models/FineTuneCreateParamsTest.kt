package com.openai.api.models

import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FineTuneCreateParamsTest {

    @Test
    fun createFineTuneCreateParams() {
        FineTuneCreateParams.builder()
            .trainingFile("file-ajSREls59WBbvgSzJSVWxMCB")
            .validationFile("file-XjSREls59WBbvgSzJSVWxMCa")
            .model("string")
            .nEpochs(123L)
            .batchSize(123L)
            .learningRateMultiplier(42.23)
            .promptLossWeight(42.23)
            .computeClassificationMetrics(true)
            .classificationNClasses(123L)
            .classificationPositiveClass("string")
            .classificationBetas(listOf(42.23))
            .suffix("x")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            FineTuneCreateParams.builder()
                .trainingFile("file-ajSREls59WBbvgSzJSVWxMCB")
                .validationFile("file-XjSREls59WBbvgSzJSVWxMCa")
                .model("string")
                .nEpochs(123L)
                .batchSize(123L)
                .learningRateMultiplier(42.23)
                .promptLossWeight(42.23)
                .computeClassificationMetrics(true)
                .classificationNClasses(123L)
                .classificationPositiveClass("string")
                .classificationBetas(listOf(42.23))
                .suffix("x")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.trainingFile()).isEqualTo("file-ajSREls59WBbvgSzJSVWxMCB")
        assertThat(body.validationFile()).isEqualTo("file-XjSREls59WBbvgSzJSVWxMCa")
        assertThat(body.model()).isEqualTo("string")
        assertThat(body.nEpochs()).isEqualTo(123L)
        assertThat(body.batchSize()).isEqualTo(123L)
        assertThat(body.learningRateMultiplier()).isEqualTo(42.23)
        assertThat(body.promptLossWeight()).isEqualTo(42.23)
        assertThat(body.computeClassificationMetrics()).isEqualTo(true)
        assertThat(body.classificationNClasses()).isEqualTo(123L)
        assertThat(body.classificationPositiveClass()).isEqualTo("string")
        assertThat(body.classificationBetas()).isEqualTo(listOf(42.23))
        assertThat(body.suffix()).isEqualTo("x")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            FineTuneCreateParams.builder().trainingFile("file-ajSREls59WBbvgSzJSVWxMCB").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.trainingFile()).isEqualTo("file-ajSREls59WBbvgSzJSVWxMCB")
    }
}
