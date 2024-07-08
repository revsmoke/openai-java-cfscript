// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.client

import com.openai.models.*
import com.openai.services.blocking.*

interface OpenAIClient {

    fun async(): OpenAIClientAsync

    fun chat(): ChatService
}
