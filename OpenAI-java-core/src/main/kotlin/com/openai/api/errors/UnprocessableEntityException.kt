package com.openai.api.errors

import com.google.common.collect.ListMultimap

class UnprocessableEntityException
constructor(
    headers: ListMultimap<String, String>,
    private val error: OpenAiError,
) : OpenAiServiceException(headers, "${error}") {
    override fun statusCode(): Int = 422
    fun error(): OpenAiError = error
}
