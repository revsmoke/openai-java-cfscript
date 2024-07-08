package com.openai.errors

import com.google.common.collect.ListMultimap

class RateLimitException
constructor(
    headers: ListMultimap<String, String>,
    private val error: OpenAIError,
) : OpenAIServiceException(headers, "${error}") {
    override fun statusCode(): Int = 429

    fun error(): OpenAIError = error
}
