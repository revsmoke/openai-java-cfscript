package com.openai.api.errors

import com.google.common.collect.ListMultimap

class PermissionDeniedException
constructor(
    headers: ListMultimap<String, String>,
    private val error: OpenAiError,
) : OpenAiServiceException(headers, "${error}") {
    override fun statusCode(): Int = 403
    fun error(): OpenAiError = error
}
