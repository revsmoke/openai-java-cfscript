package com.openai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ModerationCreateResponseTest {

    @Test
    fun createModerationCreateResponse() {
        val moderationCreateResponse =
            ModerationCreateResponse.builder()
                .id("string")
                .model("string")
                .results(
                    listOf(
                        ModerationCreateResponse.Result.builder()
                            .flagged(true)
                            .categories(
                                ModerationCreateResponse.Result.Categories.builder()
                                    .hate(true)
                                    .hateThreatening(true)
                                    .selfHarm(true)
                                    .sexual(true)
                                    .sexualMinors(true)
                                    .violence(true)
                                    .violenceGraphic(true)
                                    .build()
                            )
                            .categoryScores(
                                ModerationCreateResponse.Result.CategoryScores.builder()
                                    .hate(42.23)
                                    .hateThreatening(42.23)
                                    .selfHarm(42.23)
                                    .sexual(42.23)
                                    .sexualMinors(42.23)
                                    .violence(42.23)
                                    .violenceGraphic(42.23)
                                    .build()
                            )
                            .build()
                    )
                )
                .build()
        assertThat(moderationCreateResponse).isNotNull
        assertThat(moderationCreateResponse.id()).isEqualTo("string")
        assertThat(moderationCreateResponse.model()).isEqualTo("string")
        assertThat(moderationCreateResponse.results())
            .containsExactly(
                ModerationCreateResponse.Result.builder()
                    .flagged(true)
                    .categories(
                        ModerationCreateResponse.Result.Categories.builder()
                            .hate(true)
                            .hateThreatening(true)
                            .selfHarm(true)
                            .sexual(true)
                            .sexualMinors(true)
                            .violence(true)
                            .violenceGraphic(true)
                            .build()
                    )
                    .categoryScores(
                        ModerationCreateResponse.Result.CategoryScores.builder()
                            .hate(42.23)
                            .hateThreatening(42.23)
                            .selfHarm(42.23)
                            .sexual(42.23)
                            .sexualMinors(42.23)
                            .violence(42.23)
                            .violenceGraphic(42.23)
                            .build()
                    )
                    .build()
            )
    }
}
