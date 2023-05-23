package com.openai.api.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.api.client.OpenAiClient
import com.openai.api.client.okhttp.OpenAiOkHttpClient
import com.openai.api.core.JsonString
import com.openai.api.core.JsonValue
import com.openai.api.core.jsonMapper
import com.openai.api.models.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@WireMockTest
class ServiceParamsTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private val API_KEY: String = "apiKey"

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
    fun completionsCreateWithAdditionalParams() {
        val additionalHeaders = mutableMapOf<String, List<String>>()

        additionalHeaders.put("x-test-header", listOf("abc1234"))

        val additionalQueryParams = mutableMapOf<String, List<String>>()

        additionalQueryParams.put("test_query_param", listOf("def567"))

        val additionalBodyProperties = mutableMapOf<String, JsonValue>()

        additionalBodyProperties.put("testBodyProperty", JsonString.of("ghi890"))

        val params =
            CompletionCreateParams.builder()
                .model("string")
                .prompt(CompletionCreateParams.Prompt.ofString("This is a test."))
                .suffix("test.")
                .maxTokens(123L)
                .temperature(42.23)
                .topP(42.23)
                .n(123L)
                .stream(true)
                .logprobs(123L)
                .echo(true)
                .stop(CompletionCreateParams.Stop.ofString("\n"))
                .presencePenalty(42.23)
                .frequencyPenalty(42.23)
                .bestOf(123L)
                .logitBias(JsonString.of("abc"))
                .user("user-1234")
                .additionalHeaders(additionalHeaders)
                .additionalBodyProperties(additionalBodyProperties)
                .additionalQueryParams(additionalQueryParams)
                .build()

        val apiResponse =
            Completion.builder()
                .id("string")
                .object_("string")
                .created(123L)
                .model("string")
                .choices(
                    listOf(
                        Completion.Choice.builder()
                            .text("string")
                            .index(123L)
                            .logprobs(
                                Completion.Choice.Logprobs.builder()
                                    .tokens(listOf("string"))
                                    .tokenLogprobs(listOf(42.23))
                                    .topLogprobs(listOf(JsonString.of("abc")))
                                    .textOffset(listOf(123L))
                                    .build()
                            )
                            .finishReason("string")
                            .build()
                    )
                )
                .usage(
                    Completion.Usage.builder()
                        .promptTokens(123L)
                        .completionTokens(123L)
                        .totalTokens(123L)
                        .build()
                )
                .build()

        stubFor(
            post(anyUrl())
                .withHeader("x-test-header", equalTo("abc1234"))
                .withQueryParam("test_query_param", equalTo("def567"))
                .withRequestBody(matchingJsonPath("$.testBodyProperty", equalTo("ghi890")))
                .willReturn(ok(JSON_MAPPER.writeValueAsString(apiResponse)))
        )

        client.completions().create(params)

        verify(postRequestedFor(anyUrl()))
    }
}
