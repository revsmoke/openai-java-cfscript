package com.openai.errors

import com.google.common.collect.ListMultimap

class BadRequestException(
    headers: ListMultimap<String, String>,
    body: String,
    error: OpenAIError,
) : OpenAIServiceException(400, headers, body, error)
