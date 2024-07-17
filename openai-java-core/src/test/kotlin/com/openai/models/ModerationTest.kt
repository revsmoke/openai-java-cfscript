// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ModerationTest {

    @Test
    fun createModeration() {
        val moderation =
            Moderation.builder()
                .categories(
                    Moderation.Categories.builder()
                        .harassment(true)
                        .harassmentThreatening(true)
                        .hate(true)
                        .hateThreatening(true)
                        .selfHarm(true)
                        .selfHarmInstructions(true)
                        .selfHarmIntent(true)
                        .sexual(true)
                        .sexualMinors(true)
                        .violence(true)
                        .violenceGraphic(true)
                        .build()
                )
                .categoryScores(
                    Moderation.CategoryScores.builder()
                        .harassment(42.23)
                        .harassmentThreatening(42.23)
                        .hate(42.23)
                        .hateThreatening(42.23)
                        .selfHarm(42.23)
                        .selfHarmInstructions(42.23)
                        .selfHarmIntent(42.23)
                        .sexual(42.23)
                        .sexualMinors(42.23)
                        .violence(42.23)
                        .violenceGraphic(42.23)
                        .build()
                )
                .flagged(true)
                .build()
        assertThat(moderation).isNotNull
        assertThat(moderation.categories())
            .isEqualTo(
                Moderation.Categories.builder()
                    .harassment(true)
                    .harassmentThreatening(true)
                    .hate(true)
                    .hateThreatening(true)
                    .selfHarm(true)
                    .selfHarmInstructions(true)
                    .selfHarmIntent(true)
                    .sexual(true)
                    .sexualMinors(true)
                    .violence(true)
                    .violenceGraphic(true)
                    .build()
            )
        assertThat(moderation.categoryScores())
            .isEqualTo(
                Moderation.CategoryScores.builder()
                    .harassment(42.23)
                    .harassmentThreatening(42.23)
                    .hate(42.23)
                    .hateThreatening(42.23)
                    .selfHarm(42.23)
                    .selfHarmInstructions(42.23)
                    .selfHarmIntent(42.23)
                    .sexual(42.23)
                    .sexualMinors(42.23)
                    .violence(42.23)
                    .violenceGraphic(42.23)
                    .build()
            )
        assertThat(moderation.flagged()).isEqualTo(true)
    }
}
