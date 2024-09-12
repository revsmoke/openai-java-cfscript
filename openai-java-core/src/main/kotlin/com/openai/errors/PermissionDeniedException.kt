package com.openai.errors

import com.google.common.collect.ListMultimap

class PermissionDeniedException(
    headers: ListMultimap<String, String>,
    body: String,
    error: OpenAIError,
) : OpenAIServiceException(403, headers, body, error)
