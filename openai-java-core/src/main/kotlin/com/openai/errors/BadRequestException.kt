package com.openai.errors

import com.google.common.collect.ListMultimap

class BadRequestException
constructor(
    headers: ListMultimap<String, String>,
    private val error: OpenAIError,
) : OpenAIServiceException(headers, "${error}") {
    override fun statusCode(): Int = 400

    fun error(): OpenAIError = error
}
