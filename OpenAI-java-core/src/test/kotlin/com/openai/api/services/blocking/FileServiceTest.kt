package com.openai.api.services.blocking

import com.openai.api.TestServerExtension
import com.openai.api.client.okhttp.OpenAiOkHttpClient
import com.openai.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class FileServiceTest {

    @Disabled("Prism tests are broken")
    @Test
    fun callCreate() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val fileService = client.files()
        val file =
            fileService.create(
                FileCreateParams.builder().file("file.txt").purpose("string").build()
            )
        println(file)
        file.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val fileService = client.files()
        val file = fileService.retrieve(FileRetrieveParams.builder().fileId("string").build())
        println(file)
        file.validate()
    }

    @Test
    fun callList() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val fileService = client.files()
        val listFilesResponse = fileService.list(FileListParams.builder().build())
        println(listFilesResponse)
        listFilesResponse.validate()
    }

    @Test
    fun callDelete() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val fileService = client.files()
        val deleteFileResponse =
            fileService.delete(FileDeleteParams.builder().fileId("string").build())
        println(deleteFileResponse)
        deleteFileResponse.validate()
    }

    @Disabled("Prism tests are broken")
    @Test
    fun callRetrieveFileContent() {
        val client =
            OpenAiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .build()
        val fileService = client.files()
        val fileRetrieveFileContentResponse =
            fileService.retrieveFileContent(
                FileRetrieveFileContentParams.builder().fileId("string").build()
            )
        println(fileRetrieveFileContentResponse)
        assertThat(fileRetrieveFileContentResponse).isNotBlank()
    }
}
