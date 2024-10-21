package com.openai.core.http

import java.util.Objects

internal class SseMessage
private constructor(
    val event: String?,
    val data: String,
    val id: String?,
    val retry: Int?,
) {

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var event: String? = null
        private var data: String = ""
        private var id: String? = null
        private var retry: Int? = null

        fun event(event: String?) = apply { this.event = event }

        fun data(data: String) = apply { this.data = data }

        fun id(id: String?) = apply { this.id = id }

        fun retry(retry: Int?) = apply { this.retry = retry }

        fun build(): SseMessage = SseMessage(event, data, id, retry)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SseMessage &&
            event == other.event &&
            data == other.data &&
            id == other.id &&
            retry == other.retry
    }

    override fun hashCode(): Int = Objects.hash(event, data, id, retry)

    override fun toString(): String = "SseMessage{event=$event, data=$data, id=$id, retry=$retry}"
}
