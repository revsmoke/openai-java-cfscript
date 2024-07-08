package com.openai.errors

import com.google.common.collect.ListMultimap

class PermissionDeniedException
constructor(
    headers: ListMultimap<String, String>,
    private val error: OpenAIError,
) : OpenAIServiceException(headers, "${error}") {
    override fun statusCode(): Int = 403

    fun error(): OpenAIError = error
}
