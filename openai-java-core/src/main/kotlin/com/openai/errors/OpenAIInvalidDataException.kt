package com.openai.errors

class OpenAIInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : OpenAIException(message, cause)
