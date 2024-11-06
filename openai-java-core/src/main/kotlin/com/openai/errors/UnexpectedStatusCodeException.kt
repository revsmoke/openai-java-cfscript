package com.openai.errors

import com.openai.core.http.Headers

class UnexpectedStatusCodeException(
    statusCode: Int,
    headers: Headers,
    body: String,
    error: OpenAIError,
) : OpenAIServiceException(statusCode, headers, body, error)
