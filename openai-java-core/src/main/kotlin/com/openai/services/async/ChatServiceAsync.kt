// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.services.async.chat.CompletionServiceAsync

interface ChatServiceAsync {

    fun completions(): CompletionServiceAsync
}
