package com.openai.errors

import com.google.common.collect.ListMultimap

class InternalServerException(
    statusCode: Int,
    headers: ListMultimap<String, String>,
    body: String,
    error: OpenAIError,
) : OpenAIServiceException(statusCode, headers, body, error)
