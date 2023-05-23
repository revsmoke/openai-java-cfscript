@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.async

import com.openai.api.core.RequestOptions
import com.openai.api.models.DeleteFileResponse
import com.openai.api.models.File
import com.openai.api.models.FileCreateParams
import com.openai.api.models.FileDeleteParams
import com.openai.api.models.FileListParams
import com.openai.api.models.FileRetrieveFileContentParams
import com.openai.api.models.FileRetrieveParams
import com.openai.api.models.ListFilesResponse
import java.util.concurrent.CompletableFuture

interface FileServiceAsync {

    /**
     * Upload a file that contains document(s) to be used across various endpoints/features.
     * Currently, the size of all the files uploaded by one organization can be up to 1 GB. Please
     * contact us if you need to increase the storage limit.
     */
    @JvmOverloads
    fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<File>

    /** Returns information about a specific file. */
    @JvmOverloads
    fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<File>

    /** Returns a list of files that belong to the user's organization. */
    @JvmOverloads
    fun list(
        params: FileListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ListFilesResponse>

    /** Delete a file. */
    @JvmOverloads
    fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<DeleteFileResponse>

    /** Returns the contents of the specified file */
    @JvmOverloads
    fun retrieveFileContent(
        params: FileRetrieveFileContentParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<String>
}
