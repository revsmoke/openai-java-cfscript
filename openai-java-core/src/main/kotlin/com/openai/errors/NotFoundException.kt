package com.openai.errors

import com.google.common.collect.ListMultimap

class NotFoundException(
    headers: ListMultimap<String, String>,
    body: String,
    error: OpenAIError,
) : OpenAIServiceException(404, headers, body, error)
