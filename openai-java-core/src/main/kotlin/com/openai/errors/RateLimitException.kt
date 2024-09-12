package com.openai.errors

import com.google.common.collect.ListMultimap

class RateLimitException(
    headers: ListMultimap<String, String>,
    body: String,
    error: OpenAIError,
) : OpenAIServiceException(429, headers, body, error)
