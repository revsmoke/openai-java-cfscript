// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.services.blocking.chat.CompletionService

interface ChatService {

    fun completions(): CompletionService
}
