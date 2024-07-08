package com.openai.core.http

import com.openai.core.RequestOptions
import java.io.Closeable
import java.util.concurrent.CompletableFuture

interface HttpClient : Closeable {

    fun execute(
        request: HttpRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>
}
