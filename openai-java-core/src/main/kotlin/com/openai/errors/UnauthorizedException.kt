package com.openai.errors

import com.google.common.collect.ListMultimap

class UnauthorizedException
constructor(
    headers: ListMultimap<String, String>,
    private val error: OpenAIError,
) : OpenAIServiceException(headers, "${error}") {
    override fun statusCode(): Int = 401

    fun error(): OpenAIError = error
}
