// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async

import com.openai.core.RequestOptions
import com.openai.core.http.BinaryResponseContent
import com.openai.models.FileContentParams
import com.openai.models.FileCreateParams
import com.openai.models.FileDeleteParams
import com.openai.models.FileDeleted
import com.openai.models.FileListPageAsync
import com.openai.models.FileListParams
import com.openai.models.FileObject
import com.openai.models.FileRetrieveParams
import java.util.concurrent.CompletableFuture

interface FileServiceAsync {

    /**
     * Upload a file that can be used across various endpoints. Individual files can be up to 512
     * MB, and the size of all files uploaded by one organization can be up to 100 GB.
     *
     * The Assistants API supports files up to 2 million tokens and of specific file types. See the
     * [Assistants Tools guide](https://platform.openai.com/docs/assistants/tools) for details.
     *
     * The Fine-tuning API only supports `.jsonl` files. The input also has certain required formats
     * for fine-tuning [chat](https://platform.openai.com/docs/api-reference/fine-tuning/chat-input)
     * or
     * [completions](https://platform.openai.com/docs/api-reference/fine-tuning/completions-input)
     * models.
     *
     * The Batch API only supports `.jsonl` files up to 100 MB in size. The input also has a
     * specific required
     * [format](https://platform.openai.com/docs/api-reference/batch/request-input).
     *
     * Please [contact us](https://help.openai.com/) if you need to increase these storage limits.
     */
    @JvmOverloads
    fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<FileObject>

    /** Returns information about a specific file. */
    @JvmOverloads
    fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<FileObject>

    /** Returns a list of files that belong to the user's organization. */
    @JvmOverloads
    fun list(
        params: FileListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<FileListPageAsync>

    /** Delete a file. */
    @JvmOverloads
    fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<FileDeleted>

    /** Returns the contents of the specified file. */
    @JvmOverloads
    fun content(
        params: FileContentParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<BinaryResponseContent>
}
