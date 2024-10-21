package com.openai.core.handlers

import com.google.common.collect.ImmutableListMultimap
import com.google.common.collect.ListMultimap
import com.openai.core.http.HttpResponse
import com.openai.core.http.SseMessage
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.charset.StandardCharsets
import java.util.stream.Collectors.toList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class SseHandlerTest {
    enum class TestCase(
        internal val body: String,
        internal val expectedMessages: List<SseMessage>
    ) {
        DATA_MISSING_EVENT(
            buildString {
                append("data: {\"foo\":true}\n")
                append("\n")
            },
            listOf(SseMessage.builder().data("{\"foo\":true}").build())
        ),
        MULTIPLE_DATA_MISSING_EVENT(
            buildString {
                append("data: {\"foo\":true}\n")
                append("\n")
                append("data: {\"bar\":false}\n")
                append("\n")
            },
            listOf(
                SseMessage.builder().data("{\"foo\":true}").build(),
                SseMessage.builder().data("{\"bar\":false}").build()
            )
        ),
        DATA_JSON_ESCAPED_DOUBLE_NEW_LINE(
            buildString {
                append("data: {\n")
                append("data: \"foo\":\n")
                append("data: true}\n")
                append("\n\n")
            },
            listOf(SseMessage.builder().data("{\n\"foo\":\ntrue}").build())
        ),
        MULTIPLE_DATA_LINES(
            buildString {
                append("data: {\n")
                append("data: \"foo\":\n")
                append("data: true}\n")
                append("\n\n")
            },
            listOf(SseMessage.builder().data("{\n\"foo\":\ntrue}").build())
        ),
        SPECIAL_NEW_LINE_CHARACTER(
            buildString {
                append("data: {\"content\":\" culpa\"}\n")
                append("\n")
                append("data: {\"content\":\" \u2028\"}\n")
                append("\n")
                append("data: {\"content\":\"foo\"}\n")
                append("\n")
            },
            listOf(
                SseMessage.builder().data("{\"content\":\" culpa\"}").build(),
                SseMessage.builder().data("{\"content\":\" \u2028\"}").build(),
                SseMessage.builder().data("{\"content\":\"foo\"}").build()
            )
        ),
        MULTI_BYTE_CHARACTER(
            buildString {
                append("data: {\"content\":\"\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u0438\"}\n")
                append("\n")
            },
            listOf(SseMessage.builder().data("{\"content\":\"известни\"}").build())
        )
    }

    @ParameterizedTest
    @EnumSource
    fun handle(testCase: TestCase) {
        val response =
            object : HttpResponse {
                override fun statusCode(): Int = 0

                override fun headers(): ListMultimap<String, String> = ImmutableListMultimap.of()

                override fun body(): InputStream =
                    ByteArrayInputStream(testCase.body.toByteArray(StandardCharsets.UTF_8))

                override fun close() {}
            }

        val messages = sseHandler().handle(response).use { it.stream().collect(toList()) }

        assertThat(messages).containsExactlyElementsOf(testCase.expectedMessages)
    }
}
