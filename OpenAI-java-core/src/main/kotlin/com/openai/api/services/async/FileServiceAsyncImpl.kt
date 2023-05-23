package com.openai.api.services.async

import com.openai.api.core.ClientOptions
import com.openai.api.core.RequestOptions
import com.openai.api.core.http.HttpMethod
import com.openai.api.core.http.HttpRequest
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.models.DeleteFileResponse
import com.openai.api.models.File
import com.openai.api.models.FileCreateParams
import com.openai.api.models.FileDeleteParams
import com.openai.api.models.FileListParams
import com.openai.api.models.FileRetrieveFileContentParams
import com.openai.api.models.FileRetrieveParams
import com.openai.api.models.ListFilesResponse
import com.openai.api.services.errorHandler
import com.openai.api.services.json
import com.openai.api.services.jsonHandler
import com.openai.api.services.stringHandler
import com.openai.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class FileServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : FileServiceAsync {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<File> =
        jsonHandler<File>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Upload a file that contains document(s) to be used across various endpoints/features.
     * Currently, the size of all the files uploaded by one organization can be up to 1 GB. Please
     * contact us if you need to increase the storage limit.
     */
    override fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<File> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("files")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val retrieveHandler: Handler<File> =
        jsonHandler<File>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns information about a specific file. */
    override fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<File> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("files", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<ListFilesResponse> =
        jsonHandler<ListFilesResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a list of files that belong to the user's organization. */
    override fun list(
        params: FileListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ListFilesResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("files")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val deleteHandler: Handler<DeleteFileResponse> =
        jsonHandler<DeleteFileResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Delete a file. */
    override fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions
    ): CompletableFuture<DeleteFileResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("files", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { deleteHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val retrieveFileContentHandler: Handler<String> =
        stringHandler().withErrorHandler(errorHandler)

    /** Returns the contents of the specified file */
    override fun retrieveFileContent(
        params: FileRetrieveFileContentParams,
        requestOptions: RequestOptions
    ): CompletableFuture<String> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("files", params.getPathParam(0), "content")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response.let { retrieveFileContentHandler.handle(it) }
        }
    }
}
