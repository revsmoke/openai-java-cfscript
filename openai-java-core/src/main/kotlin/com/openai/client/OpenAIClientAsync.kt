// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.client

import com.openai.models.*
import com.openai.services.async.*

interface OpenAIClientAsync {

    fun sync(): OpenAIClient

    fun chat(): ChatServiceAsync

    fun files(): FileServiceAsync

    fun models(): ModelServiceAsync

    fun fineTuning(): FineTuningServiceAsync

    fun batches(): BatchServiceAsync
}
