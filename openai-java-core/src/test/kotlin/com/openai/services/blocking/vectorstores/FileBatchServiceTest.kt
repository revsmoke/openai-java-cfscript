// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.vectorstores

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.vectorstores.AutoFileChunkingStrategyParam
import com.openai.models.vectorstores.filebatches.FileBatchCancelParams
import com.openai.models.vectorstores.filebatches.FileBatchCreateParams
import com.openai.models.vectorstores.filebatches.FileBatchListFilesParams
import com.openai.models.vectorstores.filebatches.FileBatchRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FileBatchServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileBatchService = client.vectorStores().fileBatches()

        val vectorStoreFileBatch =
            fileBatchService.create(
                FileBatchCreateParams.builder()
                    .vectorStoreId("vs_abc123")
                    .addFileId("string")
                    .attributes(
                        FileBatchCreateParams.Attributes.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                    .build()
            )

        vectorStoreFileBatch.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileBatchService = client.vectorStores().fileBatches()

        val vectorStoreFileBatch =
            fileBatchService.retrieve(
                FileBatchRetrieveParams.builder()
                    .vectorStoreId("vs_abc123")
                    .batchId("vsfb_abc123")
                    .build()
            )

        vectorStoreFileBatch.validate()
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileBatchService = client.vectorStores().fileBatches()

        val vectorStoreFileBatch =
            fileBatchService.cancel(
                FileBatchCancelParams.builder()
                    .vectorStoreId("vector_store_id")
                    .batchId("batch_id")
                    .build()
            )

        vectorStoreFileBatch.validate()
    }

    @Test
    fun listFiles() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileBatchService = client.vectorStores().fileBatches()

        val page =
            fileBatchService.listFiles(
                FileBatchListFilesParams.builder()
                    .vectorStoreId("vector_store_id")
                    .batchId("batch_id")
                    .build()
            )

        page.response().validate()
    }
}
