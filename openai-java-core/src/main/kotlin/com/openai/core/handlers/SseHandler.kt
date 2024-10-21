@file:JvmName("SseHandler")

package com.openai.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.SseMessage
import com.openai.core.http.StreamResponse
import com.openai.errors.OpenAIException
import java.util.stream.Stream
import kotlin.streams.asStream

@JvmSynthetic internal fun sseHandler(): Handler<StreamResponse<SseMessage>> = SseHandlerInternal

private object SseHandlerInternal : Handler<StreamResponse<SseMessage>> {

    override fun handle(response: HttpResponse): StreamResponse<SseMessage> {
        val sequence = sequence {
            response.body().bufferedReader().buffered().useLines { lines ->
                val state = SseState()
                var done = false
                for (line in lines) {
                    // Stop emitting messages, but iterate through the full stream.
                    if (done) {
                        continue
                    }
                    val message = state.decode(line) ?: continue

                    if (message.data.startsWith("[DONE]")) {
                        // In this case we don't break because we still want to iterate through the
                        // full stream.
                        done = true
                        continue
                    }

                    when (message.event) {
                        null -> yield(message)
                    }
                }
            }
        }

        return object : StreamResponse<SseMessage> {
            override fun stream(): Stream<SseMessage> = sequence.asStream()

            override fun close() = response.close()
        }
    }

    private class SseState(
        var event: String? = null,
        val data: MutableList<String> = mutableListOf(),
        var lastId: String? = null,
        var retry: Int? = null
    ) {
        // https://html.spec.whatwg.org/multipage/server-sent-events.html#event-stream-interpretation
        fun decode(line: String): SseMessage? {
            if (line.isEmpty()) {
                return flush()
            }

            if (line.startsWith(':')) {
                return null
            }

            val fieldName: String
            var value: String

            val colonIndex = line.indexOf(':')
            if (colonIndex == -1) {
                fieldName = line
                value = ""
            } else {
                fieldName = line.substring(0, colonIndex)
                value = line.substring(colonIndex + 1)
            }

            if (value.startsWith(' ')) {
                value = value.substring(1)
            }

            when (fieldName) {
                "event" -> event = value
                "data" -> data.add(value)
                "id" -> {
                    if (!value.contains('\u0000')) {
                        lastId = value
                    }
                }
                "retry" -> value.toIntOrNull()?.let { retry = it }
            }

            return null
        }

        private fun flush(): SseMessage? {
            if (isEmpty()) {
                return null
            }

            val message =
                SseMessage.builder()
                    .event(event)
                    .data(data.joinToString("\n"))
                    .id(lastId)
                    .retry(retry)
                    .build()

            // NOTE: Per the SSE spec, do not reset lastId.
            event = null
            data.clear()
            retry = null

            return message
        }

        private fun isEmpty(): Boolean =
            event.isNullOrEmpty() && data.isEmpty() && lastId.isNullOrEmpty() && retry == null
    }
}

@JvmSynthetic
internal inline fun <reified T> Handler<StreamResponse<SseMessage>>.mapJson(
    jsonMapper: JsonMapper
): Handler<StreamResponse<T>> =
    object : Handler<StreamResponse<T>> {
        override fun handle(response: HttpResponse): StreamResponse<T> =
            this@mapJson.handle(response).map {
                try {
                    jsonMapper.readValue(it.data, jacksonTypeRef())
                } catch (e: Exception) {
                    throw OpenAIException("Error reading response", e)
                }
            }
    }

@JvmSynthetic
internal fun <T, R> StreamResponse<T>.map(transform: (T) -> R): StreamResponse<R> =
    object : StreamResponse<R> {
        override fun stream(): Stream<R> = this@map.stream().map(transform)

        override fun close() = this@map.close()
    }
