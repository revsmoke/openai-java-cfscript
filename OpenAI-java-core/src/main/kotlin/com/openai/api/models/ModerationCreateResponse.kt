package com.openai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.api.core.ExcludeMissing
import com.openai.api.core.JsonField
import com.openai.api.core.JsonMissing
import com.openai.api.core.JsonValue
import com.openai.api.core.NoAutoDetect
import com.openai.api.core.toUnmodifiable
import java.util.Objects

@JsonDeserialize(builder = ModerationCreateResponse.Builder::class)
@NoAutoDetect
class ModerationCreateResponse
private constructor(
    private val id: JsonField<String>,
    private val model: JsonField<String>,
    private val results: JsonField<List<Result>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): String = id.getRequired("id")

    fun model(): String = model.getRequired("model")

    fun results(): List<Result> = results.getRequired("results")

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("model") @ExcludeMissing fun _model() = model

    @JsonProperty("results") @ExcludeMissing fun _results() = results

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ModerationCreateResponse = apply {
        if (!validated) {
            id()
            model()
            results().forEach { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ModerationCreateResponse &&
            this.id == other.id &&
            this.model == other.model &&
            this.results == other.results &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    model,
                    results,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "ModerationCreateResponse{id=$id, model=$model, results=$results, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var results: JsonField<List<Result>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(moderationCreateResponse: ModerationCreateResponse) = apply {
            this.id = moderationCreateResponse.id
            this.model = moderationCreateResponse.model
            this.results = moderationCreateResponse.results
            additionalProperties(moderationCreateResponse.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        fun model(model: String) = model(JsonField.of(model))

        @JsonProperty("model")
        @ExcludeMissing
        fun model(model: JsonField<String>) = apply { this.model = model }

        fun results(results: List<Result>) = results(JsonField.of(results))

        @JsonProperty("results")
        @ExcludeMissing
        fun results(results: JsonField<List<Result>>) = apply { this.results = results }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): ModerationCreateResponse =
            ModerationCreateResponse(
                id,
                model,
                results.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = Result.Builder::class)
    @NoAutoDetect
    class Result
    private constructor(
        private val flagged: JsonField<Boolean>,
        private val categories: JsonField<Categories>,
        private val categoryScores: JsonField<CategoryScores>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun flagged(): Boolean = flagged.getRequired("flagged")

        fun categories(): Categories = categories.getRequired("categories")

        fun categoryScores(): CategoryScores = categoryScores.getRequired("category_scores")

        @JsonProperty("flagged") @ExcludeMissing fun _flagged() = flagged

        @JsonProperty("categories") @ExcludeMissing fun _categories() = categories

        @JsonProperty("category_scores") @ExcludeMissing fun _categoryScores() = categoryScores

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Result = apply {
            if (!validated) {
                flagged()
                categories().validate()
                categoryScores().validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Result &&
                this.flagged == other.flagged &&
                this.categories == other.categories &&
                this.categoryScores == other.categoryScores &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        flagged,
                        categories,
                        categoryScores,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Result{flagged=$flagged, categories=$categories, categoryScores=$categoryScores, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var flagged: JsonField<Boolean> = JsonMissing.of()
            private var categories: JsonField<Categories> = JsonMissing.of()
            private var categoryScores: JsonField<CategoryScores> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(result: Result) = apply {
                this.flagged = result.flagged
                this.categories = result.categories
                this.categoryScores = result.categoryScores
                additionalProperties(result.additionalProperties)
            }

            fun flagged(flagged: Boolean) = flagged(JsonField.of(flagged))

            @JsonProperty("flagged")
            @ExcludeMissing
            fun flagged(flagged: JsonField<Boolean>) = apply { this.flagged = flagged }

            fun categories(categories: Categories) = categories(JsonField.of(categories))

            @JsonProperty("categories")
            @ExcludeMissing
            fun categories(categories: JsonField<Categories>) = apply {
                this.categories = categories
            }

            fun categoryScores(categoryScores: CategoryScores) =
                categoryScores(JsonField.of(categoryScores))

            @JsonProperty("category_scores")
            @ExcludeMissing
            fun categoryScores(categoryScores: JsonField<CategoryScores>) = apply {
                this.categoryScores = categoryScores
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): Result =
                Result(
                    flagged,
                    categories,
                    categoryScores,
                    additionalProperties.toUnmodifiable(),
                )
        }

        @JsonDeserialize(builder = Categories.Builder::class)
        @NoAutoDetect
        class Categories
        private constructor(
            private val hate: JsonField<Boolean>,
            private val hateThreatening: JsonField<Boolean>,
            private val selfHarm: JsonField<Boolean>,
            private val sexual: JsonField<Boolean>,
            private val sexualMinors: JsonField<Boolean>,
            private val violence: JsonField<Boolean>,
            private val violenceGraphic: JsonField<Boolean>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            fun hate(): Boolean = hate.getRequired("hate")

            fun hateThreatening(): Boolean = hateThreatening.getRequired("hate/threatening")

            fun selfHarm(): Boolean = selfHarm.getRequired("self-harm")

            fun sexual(): Boolean = sexual.getRequired("sexual")

            fun sexualMinors(): Boolean = sexualMinors.getRequired("sexual/minors")

            fun violence(): Boolean = violence.getRequired("violence")

            fun violenceGraphic(): Boolean = violenceGraphic.getRequired("violence/graphic")

            @JsonProperty("hate") @ExcludeMissing fun _hate() = hate

            @JsonProperty("hate/threatening")
            @ExcludeMissing
            fun _hateThreatening() = hateThreatening

            @JsonProperty("self-harm") @ExcludeMissing fun _selfHarm() = selfHarm

            @JsonProperty("sexual") @ExcludeMissing fun _sexual() = sexual

            @JsonProperty("sexual/minors") @ExcludeMissing fun _sexualMinors() = sexualMinors

            @JsonProperty("violence") @ExcludeMissing fun _violence() = violence

            @JsonProperty("violence/graphic")
            @ExcludeMissing
            fun _violenceGraphic() = violenceGraphic

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): Categories = apply {
                if (!validated) {
                    hate()
                    hateThreatening()
                    selfHarm()
                    sexual()
                    sexualMinors()
                    violence()
                    violenceGraphic()
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Categories &&
                    this.hate == other.hate &&
                    this.hateThreatening == other.hateThreatening &&
                    this.selfHarm == other.selfHarm &&
                    this.sexual == other.sexual &&
                    this.sexualMinors == other.sexualMinors &&
                    this.violence == other.violence &&
                    this.violenceGraphic == other.violenceGraphic &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            hate,
                            hateThreatening,
                            selfHarm,
                            sexual,
                            sexualMinors,
                            violence,
                            violenceGraphic,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "Categories{hate=$hate, hateThreatening=$hateThreatening, selfHarm=$selfHarm, sexual=$sexual, sexualMinors=$sexualMinors, violence=$violence, violenceGraphic=$violenceGraphic, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var hate: JsonField<Boolean> = JsonMissing.of()
                private var hateThreatening: JsonField<Boolean> = JsonMissing.of()
                private var selfHarm: JsonField<Boolean> = JsonMissing.of()
                private var sexual: JsonField<Boolean> = JsonMissing.of()
                private var sexualMinors: JsonField<Boolean> = JsonMissing.of()
                private var violence: JsonField<Boolean> = JsonMissing.of()
                private var violenceGraphic: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(categories: Categories) = apply {
                    this.hate = categories.hate
                    this.hateThreatening = categories.hateThreatening
                    this.selfHarm = categories.selfHarm
                    this.sexual = categories.sexual
                    this.sexualMinors = categories.sexualMinors
                    this.violence = categories.violence
                    this.violenceGraphic = categories.violenceGraphic
                    additionalProperties(categories.additionalProperties)
                }

                fun hate(hate: Boolean) = hate(JsonField.of(hate))

                @JsonProperty("hate")
                @ExcludeMissing
                fun hate(hate: JsonField<Boolean>) = apply { this.hate = hate }

                fun hateThreatening(hateThreatening: Boolean) =
                    hateThreatening(JsonField.of(hateThreatening))

                @JsonProperty("hate/threatening")
                @ExcludeMissing
                fun hateThreatening(hateThreatening: JsonField<Boolean>) = apply {
                    this.hateThreatening = hateThreatening
                }

                fun selfHarm(selfHarm: Boolean) = selfHarm(JsonField.of(selfHarm))

                @JsonProperty("self-harm")
                @ExcludeMissing
                fun selfHarm(selfHarm: JsonField<Boolean>) = apply { this.selfHarm = selfHarm }

                fun sexual(sexual: Boolean) = sexual(JsonField.of(sexual))

                @JsonProperty("sexual")
                @ExcludeMissing
                fun sexual(sexual: JsonField<Boolean>) = apply { this.sexual = sexual }

                fun sexualMinors(sexualMinors: Boolean) = sexualMinors(JsonField.of(sexualMinors))

                @JsonProperty("sexual/minors")
                @ExcludeMissing
                fun sexualMinors(sexualMinors: JsonField<Boolean>) = apply {
                    this.sexualMinors = sexualMinors
                }

                fun violence(violence: Boolean) = violence(JsonField.of(violence))

                @JsonProperty("violence")
                @ExcludeMissing
                fun violence(violence: JsonField<Boolean>) = apply { this.violence = violence }

                fun violenceGraphic(violenceGraphic: Boolean) =
                    violenceGraphic(JsonField.of(violenceGraphic))

                @JsonProperty("violence/graphic")
                @ExcludeMissing
                fun violenceGraphic(violenceGraphic: JsonField<Boolean>) = apply {
                    this.violenceGraphic = violenceGraphic
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    this.additionalProperties.putAll(additionalProperties)
                }

                @JsonAnySetter
                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    this.additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun build(): Categories =
                    Categories(
                        hate,
                        hateThreatening,
                        selfHarm,
                        sexual,
                        sexualMinors,
                        violence,
                        violenceGraphic,
                        additionalProperties.toUnmodifiable(),
                    )
            }
        }

        @JsonDeserialize(builder = CategoryScores.Builder::class)
        @NoAutoDetect
        class CategoryScores
        private constructor(
            private val hate: JsonField<Double>,
            private val hateThreatening: JsonField<Double>,
            private val selfHarm: JsonField<Double>,
            private val sexual: JsonField<Double>,
            private val sexualMinors: JsonField<Double>,
            private val violence: JsonField<Double>,
            private val violenceGraphic: JsonField<Double>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            fun hate(): Double = hate.getRequired("hate")

            fun hateThreatening(): Double = hateThreatening.getRequired("hate/threatening")

            fun selfHarm(): Double = selfHarm.getRequired("self-harm")

            fun sexual(): Double = sexual.getRequired("sexual")

            fun sexualMinors(): Double = sexualMinors.getRequired("sexual/minors")

            fun violence(): Double = violence.getRequired("violence")

            fun violenceGraphic(): Double = violenceGraphic.getRequired("violence/graphic")

            @JsonProperty("hate") @ExcludeMissing fun _hate() = hate

            @JsonProperty("hate/threatening")
            @ExcludeMissing
            fun _hateThreatening() = hateThreatening

            @JsonProperty("self-harm") @ExcludeMissing fun _selfHarm() = selfHarm

            @JsonProperty("sexual") @ExcludeMissing fun _sexual() = sexual

            @JsonProperty("sexual/minors") @ExcludeMissing fun _sexualMinors() = sexualMinors

            @JsonProperty("violence") @ExcludeMissing fun _violence() = violence

            @JsonProperty("violence/graphic")
            @ExcludeMissing
            fun _violenceGraphic() = violenceGraphic

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): CategoryScores = apply {
                if (!validated) {
                    hate()
                    hateThreatening()
                    selfHarm()
                    sexual()
                    sexualMinors()
                    violence()
                    violenceGraphic()
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is CategoryScores &&
                    this.hate == other.hate &&
                    this.hateThreatening == other.hateThreatening &&
                    this.selfHarm == other.selfHarm &&
                    this.sexual == other.sexual &&
                    this.sexualMinors == other.sexualMinors &&
                    this.violence == other.violence &&
                    this.violenceGraphic == other.violenceGraphic &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            hate,
                            hateThreatening,
                            selfHarm,
                            sexual,
                            sexualMinors,
                            violence,
                            violenceGraphic,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "CategoryScores{hate=$hate, hateThreatening=$hateThreatening, selfHarm=$selfHarm, sexual=$sexual, sexualMinors=$sexualMinors, violence=$violence, violenceGraphic=$violenceGraphic, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var hate: JsonField<Double> = JsonMissing.of()
                private var hateThreatening: JsonField<Double> = JsonMissing.of()
                private var selfHarm: JsonField<Double> = JsonMissing.of()
                private var sexual: JsonField<Double> = JsonMissing.of()
                private var sexualMinors: JsonField<Double> = JsonMissing.of()
                private var violence: JsonField<Double> = JsonMissing.of()
                private var violenceGraphic: JsonField<Double> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(categoryScores: CategoryScores) = apply {
                    this.hate = categoryScores.hate
                    this.hateThreatening = categoryScores.hateThreatening
                    this.selfHarm = categoryScores.selfHarm
                    this.sexual = categoryScores.sexual
                    this.sexualMinors = categoryScores.sexualMinors
                    this.violence = categoryScores.violence
                    this.violenceGraphic = categoryScores.violenceGraphic
                    additionalProperties(categoryScores.additionalProperties)
                }

                fun hate(hate: Double) = hate(JsonField.of(hate))

                @JsonProperty("hate")
                @ExcludeMissing
                fun hate(hate: JsonField<Double>) = apply { this.hate = hate }

                fun hateThreatening(hateThreatening: Double) =
                    hateThreatening(JsonField.of(hateThreatening))

                @JsonProperty("hate/threatening")
                @ExcludeMissing
                fun hateThreatening(hateThreatening: JsonField<Double>) = apply {
                    this.hateThreatening = hateThreatening
                }

                fun selfHarm(selfHarm: Double) = selfHarm(JsonField.of(selfHarm))

                @JsonProperty("self-harm")
                @ExcludeMissing
                fun selfHarm(selfHarm: JsonField<Double>) = apply { this.selfHarm = selfHarm }

                fun sexual(sexual: Double) = sexual(JsonField.of(sexual))

                @JsonProperty("sexual")
                @ExcludeMissing
                fun sexual(sexual: JsonField<Double>) = apply { this.sexual = sexual }

                fun sexualMinors(sexualMinors: Double) = sexualMinors(JsonField.of(sexualMinors))

                @JsonProperty("sexual/minors")
                @ExcludeMissing
                fun sexualMinors(sexualMinors: JsonField<Double>) = apply {
                    this.sexualMinors = sexualMinors
                }

                fun violence(violence: Double) = violence(JsonField.of(violence))

                @JsonProperty("violence")
                @ExcludeMissing
                fun violence(violence: JsonField<Double>) = apply { this.violence = violence }

                fun violenceGraphic(violenceGraphic: Double) =
                    violenceGraphic(JsonField.of(violenceGraphic))

                @JsonProperty("violence/graphic")
                @ExcludeMissing
                fun violenceGraphic(violenceGraphic: JsonField<Double>) = apply {
                    this.violenceGraphic = violenceGraphic
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    this.additionalProperties.putAll(additionalProperties)
                }

                @JsonAnySetter
                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    this.additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun build(): CategoryScores =
                    CategoryScores(
                        hate,
                        hateThreatening,
                        selfHarm,
                        sexual,
                        sexualMinors,
                        violence,
                        violenceGraphic,
                        additionalProperties.toUnmodifiable(),
                    )
            }
        }
    }
}
