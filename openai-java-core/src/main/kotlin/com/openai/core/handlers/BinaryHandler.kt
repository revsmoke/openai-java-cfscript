@file:JvmName("BinaryHandler")

package com.openai.core.handlers

import com.openai.core.http.BinaryResponseContent
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import java.io.InputStream
import java.io.OutputStream
import java.util.Optional

@JvmSynthetic internal fun binaryHandler(): Handler<BinaryResponseContent> = BinaryHandlerInternal

private object BinaryHandlerInternal : Handler<BinaryResponseContent> {
    override fun handle(response: HttpResponse): BinaryResponseContent =
        object : BinaryResponseContent {
            override fun contentType(): Optional<String> =
                Optional.ofNullable(response.headers().get("Content-Type").firstOrNull())

            override fun body(): InputStream = response.body()

            override fun close() = response.close()

            override fun writeTo(outputStream: OutputStream) {
                response.body().copyTo(outputStream)
            }
        }
}
