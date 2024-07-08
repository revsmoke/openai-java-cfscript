package com.openai.errors

class OpenAIIoException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : OpenAIException(message, cause)
