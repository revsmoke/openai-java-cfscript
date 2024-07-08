package com.openai.errors

import com.google.common.collect.ListMultimap

abstract class OpenAIServiceException
@JvmOverloads
constructor(
    private val headers: ListMultimap<String, String>,
    message: String? = null,
    cause: Throwable? = null
) : OpenAIException(message, cause) {
    abstract fun statusCode(): Int

    fun headers(): ListMultimap<String, String> = headers
}
