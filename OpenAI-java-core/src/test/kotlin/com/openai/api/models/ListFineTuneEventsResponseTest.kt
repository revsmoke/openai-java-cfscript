package com.openai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ListFineTuneEventsResponseTest {

    @Test
    fun createListFineTuneEventsResponse() {
        val listFineTuneEventsResponse =
            ListFineTuneEventsResponse.builder()
                .object_("string")
                .data(
                    listOf(
                        ListFineTuneEventsResponse.FineTuneEvent.builder()
                            .object_("string")
                            .createdAt(123L)
                            .level("string")
                            .message("string")
                            .build()
                    )
                )
                .build()
        assertThat(listFineTuneEventsResponse).isNotNull
        assertThat(listFineTuneEventsResponse.object_()).isEqualTo("string")
        assertThat(listFineTuneEventsResponse.data())
            .containsExactly(
                ListFineTuneEventsResponse.FineTuneEvent.builder()
                    .object_("string")
                    .createdAt(123L)
                    .level("string")
                    .message("string")
                    .build()
            )
    }
}
