package com.openai.errors

import com.google.common.collect.ListMultimap

class UnprocessableEntityException
constructor(
    headers: ListMultimap<String, String>,
    private val error: OpenAIError,
) : OpenAIServiceException(headers, "${error}") {
    override fun statusCode(): Int = 422

    fun error(): OpenAIError = error
}
