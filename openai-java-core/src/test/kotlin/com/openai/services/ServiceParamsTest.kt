// File generated from our OpenAPI spec by Stainless.

package com.openai.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.put
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.client.OpenAIClient
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonString
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@WireMockTest
class ServiceParamsTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private lateinit var client: OpenAIClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            OpenAIOkHttpClient.builder()
                .apiKey("My API Key")
                .organization("My Organization")
                .project("My Project")
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
            ChatCompletionCreateParams.builder()
                .messages(
                    listOf(
                        ChatCompletionMessageParam.ofChatCompletionSystemMessageParam(
                            ChatCompletionSystemMessageParam.builder()
                                .content(
                                    ChatCompletionSystemMessageParam.Content.ofTextContent("string")
                                )
                                .role(ChatCompletionSystemMessageParam.Role.SYSTEM)
                                .name("name")
                                .build()
                        )
                    )
                )
                .model(ChatCompletionCreateParams.Model.O1_PREVIEW)
                .audio(
                    ChatCompletionAudioParam.builder()
                        .format(ChatCompletionAudioParam.Format.WAV)
                        .voice(ChatCompletionAudioParam.Voice.ALLOY)
                        .build()
                )
                .frequencyPenalty(2.0)
                .functionCall(
                    ChatCompletionCreateParams.FunctionCall.ofBehavior(
                        ChatCompletionCreateParams.FunctionCall.Behavior.NONE
                    )
                )
                .functions(
                    listOf(
                        ChatCompletionCreateParams.Function.builder()
                            .name("name")
                            .description("description")
                            .parameters(FunctionParameters.builder().build())
                            .build()
                    )
                )
                .logitBias(ChatCompletionCreateParams.LogitBias.builder().build())
                .logprobs(true)
                .maxCompletionTokens(123L)
                .maxTokens(123L)
                .metadata(ChatCompletionCreateParams.Metadata.builder().build())
                .modalities(listOf(ChatCompletionModality.TEXT))
                .n(123L)
                .parallelToolCalls(true)
                .prediction(
                    ChatCompletionPredictionContent.builder()
                        .content(ChatCompletionPredictionContent.Content.ofTextContent("string"))
                        .type(ChatCompletionPredictionContent.Type.CONTENT)
                        .build()
                )
                .presencePenalty(2.0)
                .responseFormat(
                    ChatCompletionCreateParams.ResponseFormat.ofResponseFormatText(
                        ResponseFormatText.builder().type(ResponseFormatText.Type.TEXT).build()
                    )
                )
                .seed(123L)
                .serviceTier(ChatCompletionCreateParams.ServiceTier.AUTO)
                .stop(ChatCompletionCreateParams.Stop.ofString("string"))
                .store(true)
                .streamOptions(ChatCompletionStreamOptions.builder().includeUsage(true).build())
                .temperature(2.0)
                .toolChoice(
                    ChatCompletionToolChoiceOption.ofBehavior(
                        ChatCompletionToolChoiceOption.Behavior.NONE
                    )
                )
                .tools(
                    listOf(
                        ChatCompletionTool.builder()
                            .function(
                                FunctionDefinition.builder()
                                    .name("name")
                                    .description("description")
                                    .parameters(FunctionParameters.builder().build())
                                    .strict(true)
                                    .build()
                            )
                            .type(ChatCompletionTool.Type.FUNCTION)
                            .build()
                    )
                )
                .topLogprobs(20L)
                .topP(1.0)
                .user("user-1234")
                .additionalHeaders(additionalHeaders)
                .additionalBodyProperties(additionalBodyProperties)
                .additionalQueryParams(additionalQueryParams)
                .build()

        val apiResponse =
            ChatCompletion.builder()
                .id("id")
                .choices(
                    listOf(
                        ChatCompletion.Choice.builder()
                            .finishReason(ChatCompletion.Choice.FinishReason.STOP)
                            .index(123L)
                            .logprobs(
                                ChatCompletion.Choice.Logprobs.builder()
                                    .content(
                                        listOf(
                                            ChatCompletionTokenLogprob.builder()
                                                .token("token")
                                                .bytes(listOf(123L))
                                                .logprob(42.23)
                                                .topLogprobs(
                                                    listOf(
                                                        ChatCompletionTokenLogprob.TopLogprob
                                                            .builder()
                                                            .token("token")
                                                            .bytes(listOf(123L))
                                                            .logprob(42.23)
                                                            .build()
                                                    )
                                                )
                                                .build()
                                        )
                                    )
                                    .refusal(
                                        listOf(
                                            ChatCompletionTokenLogprob.builder()
                                                .token("token")
                                                .bytes(listOf(123L))
                                                .logprob(42.23)
                                                .topLogprobs(
                                                    listOf(
                                                        ChatCompletionTokenLogprob.TopLogprob
                                                            .builder()
                                                            .token("token")
                                                            .bytes(listOf(123L))
                                                            .logprob(42.23)
                                                            .build()
                                                    )
                                                )
                                                .build()
                                        )
                                    )
                                    .build()
                            )
                            .message(
                                ChatCompletionMessage.builder()
                                    .content("content")
                                    .refusal("refusal")
                                    .role(ChatCompletionMessage.Role.ASSISTANT)
                                    .audio(
                                        ChatCompletionAudio.builder()
                                            .id("id")
                                            .data("data")
                                            .expiresAt(123L)
                                            .transcript("transcript")
                                            .build()
                                    )
                                    .functionCall(
                                        ChatCompletionMessage.FunctionCall.builder()
                                            .arguments("arguments")
                                            .name("name")
                                            .build()
                                    )
                                    .toolCalls(
                                        listOf(
                                            ChatCompletionMessageToolCall.builder()
                                                .id("id")
                                                .function(
                                                    ChatCompletionMessageToolCall.Function.builder()
                                                        .arguments("arguments")
                                                        .name("name")
                                                        .build()
                                                )
                                                .type(ChatCompletionMessageToolCall.Type.FUNCTION)
                                                .build()
                                        )
                                    )
                                    .build()
                            )
                            .build()
                    )
                )
                .created(123L)
                .model("model")
                .object_(ChatCompletion.Object.CHAT_COMPLETION)
                .serviceTier(ChatCompletion.ServiceTier.SCALE)
                .systemFingerprint("system_fingerprint")
                .usage(
                    CompletionUsage.builder()
                        .completionTokens(123L)
                        .promptTokens(123L)
                        .totalTokens(123L)
                        .completionTokensDetails(
                            CompletionUsage.CompletionTokensDetails.builder()
                                .acceptedPredictionTokens(123L)
                                .audioTokens(123L)
                                .reasoningTokens(123L)
                                .rejectedPredictionTokens(123L)
                                .build()
                        )
                        .promptTokensDetails(
                            CompletionUsage.PromptTokensDetails.builder()
                                .audioTokens(123L)
                                .cachedTokens(123L)
                                .build()
                        )
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

        client.chat().completions().create(params)

        verify(postRequestedFor(anyUrl()))
    }
}
