package com.openai.api.errors

class OpenAiInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : OpenAiException(message, cause)
