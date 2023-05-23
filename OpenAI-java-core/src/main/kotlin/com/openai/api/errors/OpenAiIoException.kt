package com.openai.api.errors

class OpenAiIoException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : OpenAiException(message, cause)
