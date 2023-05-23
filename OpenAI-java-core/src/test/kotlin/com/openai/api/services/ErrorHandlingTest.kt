package com.openai.api.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.google.common.collect.ImmutableListMultimap
import com.google.common.collect.ListMultimap
import com.openai.api.client.OpenAiClient
import com.openai.api.client.okhttp.OpenAiOkHttpClient
import com.openai.api.core.JsonString
import com.openai.api.core.jsonMapper
import com.openai.api.errors.BadRequestException
import com.openai.api.errors.InternalServerException
import com.openai.api.errors.NotFoundException
import com.openai.api.errors.OpenAiError
import com.openai.api.errors.OpenAiException
import com.openai.api.errors.PermissionDeniedException
import com.openai.api.errors.RateLimitException
import com.openai.api.errors.UnauthorizedException
import com.openai.api.errors.UnexpectedStatusCodeException
import com.openai.api.errors.UnprocessableEntityException
import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.InstanceOfAssertFactories
import org.assertj.guava.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@WireMockTest
class ErrorHandlingTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private val API_KEY: String = "apiKey"

    private val OPENAI_ERROR: OpenAiError =
        OpenAiError.builder().putAdditionalProperty("key", JsonString.of("value")).build()

    private lateinit var client: OpenAiClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            OpenAiOkHttpClient.builder()
                .apiKey(API_KEY)
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .build()
    }

    @Test
    fun fineTunesCreate200() {
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

        val expected =
            FineTune.builder()
                .id("string")
                .object_("string")
                .createdAt(123L)
                .updatedAt(123L)
                .model("string")
                .fineTunedModel("string")
                .organizationId("string")
                .status("string")
                .hyperparams(JsonString.of("abc"))
                .trainingFiles(
                    listOf(
                        File.builder()
                            .id("string")
                            .object_("string")
                            .bytes(123L)
                            .createdAt(123L)
                            .filename("string")
                            .purpose("string")
                            .status("string")
                            .statusDetails(JsonString.of("abc"))
                            .build()
                    )
                )
                .validationFiles(
                    listOf(
                        File.builder()
                            .id("string")
                            .object_("string")
                            .bytes(123L)
                            .createdAt(123L)
                            .filename("string")
                            .purpose("string")
                            .status("string")
                            .statusDetails(JsonString.of("abc"))
                            .build()
                    )
                )
                .resultFiles(
                    listOf(
                        File.builder()
                            .id("string")
                            .object_("string")
                            .bytes(123L)
                            .createdAt(123L)
                            .filename("string")
                            .purpose("string")
                            .status("string")
                            .statusDetails(JsonString.of("abc"))
                            .build()
                    )
                )
                .events(
                    listOf(
                        FineTune.FineTuneEvent.builder()
                            .object_("string")
                            .createdAt(123L)
                            .level("string")
                            .message("string")
                            .build()
                    )
                )
                .build()

        stubFor(post(anyUrl()).willReturn(ok().withBody(toJson(expected))))

        assertThat(client.fineTunes().create(params)).isEqualTo(expected)
    }

    @Test
    fun fineTunesCreate400() {
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

        stubFor(
            post(anyUrl())
                .willReturn(status(400).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTunes().create(params) })
            .satisfies({ e ->
                assertBadRequest(e, ImmutableListMultimap.of("Foo", "Bar"), OPENAI_ERROR)
            })
    }

    @Test
    fun fineTunesCreate401() {
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

        stubFor(
            post(anyUrl())
                .willReturn(status(401).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTunes().create(params) })
            .satisfies({ e ->
                assertUnauthorized(e, ImmutableListMultimap.of("Foo", "Bar"), OPENAI_ERROR)
            })
    }

    @Test
    fun fineTunesCreate403() {
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

        stubFor(
            post(anyUrl())
                .willReturn(status(403).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTunes().create(params) })
            .satisfies({ e ->
                assertPermissionDenied(e, ImmutableListMultimap.of("Foo", "Bar"), OPENAI_ERROR)
            })
    }

    @Test
    fun fineTunesCreate404() {
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

        stubFor(
            post(anyUrl())
                .willReturn(status(404).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTunes().create(params) })
            .satisfies({ e ->
                assertNotFound(e, ImmutableListMultimap.of("Foo", "Bar"), OPENAI_ERROR)
            })
    }

    @Test
    fun fineTunesCreate422() {
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

        stubFor(
            post(anyUrl())
                .willReturn(status(422).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTunes().create(params) })
            .satisfies({ e ->
                assertUnprocessableEntity(e, ImmutableListMultimap.of("Foo", "Bar"), OPENAI_ERROR)
            })
    }

    @Test
    fun fineTunesCreate429() {
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

        stubFor(
            post(anyUrl())
                .willReturn(status(429).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTunes().create(params) })
            .satisfies({ e ->
                assertRateLimit(e, ImmutableListMultimap.of("Foo", "Bar"), OPENAI_ERROR)
            })
    }

    @Test
    fun fineTunesCreate500() {
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

        stubFor(
            post(anyUrl())
                .willReturn(status(500).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTunes().create(params) })
            .satisfies({ e ->
                assertInternalServer(e, ImmutableListMultimap.of("Foo", "Bar"), OPENAI_ERROR)
            })
    }

    @Test
    fun unexpectedStatusCode() {
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

        stubFor(
            post(anyUrl())
                .willReturn(status(999).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTunes().create(params) })
            .satisfies({ e ->
                assertUnexpectedStatusCodeException(
                    e,
                    999,
                    ImmutableListMultimap.of("Foo", "Bar"),
                    toJson(OPENAI_ERROR)
                )
            })
    }

    @Test
    fun invalidBody() {
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

        stubFor(post(anyUrl()).willReturn(status(200).withBody("Not JSON")))

        assertThatThrownBy({ client.fineTunes().create(params) })
            .satisfies({ e ->
                assertThat(e)
                    .isInstanceOf(OpenAiException::class.java)
                    .hasMessage("Error reading response")
            })
    }

    @Test
    fun invalidErrorBody() {
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

        stubFor(post(anyUrl()).willReturn(status(400).withBody("Not JSON")))

        assertThatThrownBy({ client.fineTunes().create(params) })
            .satisfies({ e ->
                assertBadRequest(e, ImmutableListMultimap.of(), OpenAiError.builder().build())
            })
    }

    private fun <T> toJson(body: T): ByteArray {
        return JSON_MAPPER.writeValueAsBytes(body)
    }

    private fun assertUnexpectedStatusCodeException(
        throwable: Throwable,
        statusCode: Int,
        headers: ListMultimap<String, String>,
        responseBody: ByteArray
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnexpectedStatusCodeException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(statusCode)
                assertThat(e.body()).isEqualTo(String(responseBody))
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertBadRequest(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: OpenAiError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(BadRequestException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(400)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertUnauthorized(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: OpenAiError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(UnauthorizedException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(401)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertPermissionDenied(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: OpenAiError
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(PermissionDeniedException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(403)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertNotFound(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: OpenAiError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(NotFoundException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(404)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertUnprocessableEntity(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: OpenAiError
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnprocessableEntityException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(422)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertRateLimit(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: OpenAiError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(RateLimitException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(429)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertInternalServer(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: OpenAiError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(InternalServerException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(500)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }
}
