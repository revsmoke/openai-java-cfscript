package com.openai.errors

import com.google.common.collect.ListMultimap

class UnprocessableEntityException(
    headers: ListMultimap<String, String>,
    body: String,
    error: OpenAIError,
) : OpenAIServiceException(422, headers, body, error)
