package com.openai.errors

import com.google.common.collect.ListMultimap

class NotFoundException
constructor(
    headers: ListMultimap<String, String>,
    private val error: OpenAIError,
) : OpenAIServiceException(headers, "${error}") {
    override fun statusCode(): Int = 404

    fun error(): OpenAIError = error
}
