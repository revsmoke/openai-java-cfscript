// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toUnmodifiable
import java.util.Objects

@JsonDeserialize(builder = Moderation.Builder::class)
@NoAutoDetect
class Moderation
private constructor(
    private val flagged: JsonField<Boolean>,
    private val categories: JsonField<Categories>,
    private val categoryScores: JsonField<CategoryScores>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** Whether any of the below categories are flagged. */
    fun flagged(): Boolean = flagged.getRequired("flagged")

    /** A list of the categories, and whether they are flagged or not. */
    fun categories(): Categories = categories.getRequired("categories")

    /** A list of the categories along with their scores as predicted by model. */
    fun categoryScores(): CategoryScores = categoryScores.getRequired("category_scores")

    /** Whether any of the below categories are flagged. */
    @JsonProperty("flagged") @ExcludeMissing fun _flagged() = flagged

    /** A list of the categories, and whether they are flagged or not. */
    @JsonProperty("categories") @ExcludeMissing fun _categories() = categories

    /** A list of the categories along with their scores as predicted by model. */
    @JsonProperty("category_scores") @ExcludeMissing fun _categoryScores() = categoryScores

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Moderation = apply {
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

        return other is Moderation &&
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
        "Moderation{flagged=$flagged, categories=$categories, categoryScores=$categoryScores, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var flagged: JsonField<Boolean> = JsonMissing.of()
        private var categories: JsonField<Categories> = JsonMissing.of()
        private var categoryScores: JsonField<CategoryScores> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(moderation: Moderation) = apply {
            this.flagged = moderation.flagged
            this.categories = moderation.categories
            this.categoryScores = moderation.categoryScores
            additionalProperties(moderation.additionalProperties)
        }

        /** Whether any of the below categories are flagged. */
        fun flagged(flagged: Boolean) = flagged(JsonField.of(flagged))

        /** Whether any of the below categories are flagged. */
        @JsonProperty("flagged")
        @ExcludeMissing
        fun flagged(flagged: JsonField<Boolean>) = apply { this.flagged = flagged }

        /** A list of the categories, and whether they are flagged or not. */
        fun categories(categories: Categories) = categories(JsonField.of(categories))

        /** A list of the categories, and whether they are flagged or not. */
        @JsonProperty("categories")
        @ExcludeMissing
        fun categories(categories: JsonField<Categories>) = apply { this.categories = categories }

        /** A list of the categories along with their scores as predicted by model. */
        fun categoryScores(categoryScores: CategoryScores) =
            categoryScores(JsonField.of(categoryScores))

        /** A list of the categories along with their scores as predicted by model. */
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

        fun build(): Moderation =
            Moderation(
                flagged,
                categories,
                categoryScores,
                additionalProperties.toUnmodifiable(),
            )
    }

    /** A list of the categories, and whether they are flagged or not. */
    @JsonDeserialize(builder = Categories.Builder::class)
    @NoAutoDetect
    class Categories
    private constructor(
        private val hate: JsonField<Boolean>,
        private val hateThreatening: JsonField<Boolean>,
        private val harassment: JsonField<Boolean>,
        private val harassmentThreatening: JsonField<Boolean>,
        private val selfHarm: JsonField<Boolean>,
        private val selfHarmIntent: JsonField<Boolean>,
        private val selfHarmInstructions: JsonField<Boolean>,
        private val sexual: JsonField<Boolean>,
        private val sexualMinors: JsonField<Boolean>,
        private val violence: JsonField<Boolean>,
        private val violenceGraphic: JsonField<Boolean>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /**
         * Content that expresses, incites, or promotes hate based on race, gender, ethnicity,
         * religion, nationality, sexual orientation, disability status, or caste. Hateful content
         * aimed at non-protected groups (e.g., chess players) is harassment.
         */
        fun hate(): Boolean = hate.getRequired("hate")

        /**
         * Hateful content that also includes violence or serious harm towards the targeted group
         * based on race, gender, ethnicity, religion, nationality, sexual orientation, disability
         * status, or caste.
         */
        fun hateThreatening(): Boolean = hateThreatening.getRequired("hate/threatening")

        /** Content that expresses, incites, or promotes harassing language towards any target. */
        fun harassment(): Boolean = harassment.getRequired("harassment")

        /** Harassment content that also includes violence or serious harm towards any target. */
        fun harassmentThreatening(): Boolean =
            harassmentThreatening.getRequired("harassment/threatening")

        /**
         * Content that promotes, encourages, or depicts acts of self-harm, such as suicide,
         * cutting, and eating disorders.
         */
        fun selfHarm(): Boolean = selfHarm.getRequired("self-harm")

        /**
         * Content where the speaker expresses that they are engaging or intend to engage in acts of
         * self-harm, such as suicide, cutting, and eating disorders.
         */
        fun selfHarmIntent(): Boolean = selfHarmIntent.getRequired("self-harm/intent")

        /**
         * Content that encourages performing acts of self-harm, such as suicide, cutting, and
         * eating disorders, or that gives instructions or advice on how to commit such acts.
         */
        fun selfHarmInstructions(): Boolean =
            selfHarmInstructions.getRequired("self-harm/instructions")

        /**
         * Content meant to arouse sexual excitement, such as the description of sexual activity, or
         * that promotes sexual services (excluding sex education and wellness).
         */
        fun sexual(): Boolean = sexual.getRequired("sexual")

        /** Sexual content that includes an individual who is under 18 years old. */
        fun sexualMinors(): Boolean = sexualMinors.getRequired("sexual/minors")

        /** Content that depicts death, violence, or physical injury. */
        fun violence(): Boolean = violence.getRequired("violence")

        /** Content that depicts death, violence, or physical injury in graphic detail. */
        fun violenceGraphic(): Boolean = violenceGraphic.getRequired("violence/graphic")

        /**
         * Content that expresses, incites, or promotes hate based on race, gender, ethnicity,
         * religion, nationality, sexual orientation, disability status, or caste. Hateful content
         * aimed at non-protected groups (e.g., chess players) is harassment.
         */
        @JsonProperty("hate") @ExcludeMissing fun _hate() = hate

        /**
         * Hateful content that also includes violence or serious harm towards the targeted group
         * based on race, gender, ethnicity, religion, nationality, sexual orientation, disability
         * status, or caste.
         */
        @JsonProperty("hate/threatening") @ExcludeMissing fun _hateThreatening() = hateThreatening

        /** Content that expresses, incites, or promotes harassing language towards any target. */
        @JsonProperty("harassment") @ExcludeMissing fun _harassment() = harassment

        /** Harassment content that also includes violence or serious harm towards any target. */
        @JsonProperty("harassment/threatening")
        @ExcludeMissing
        fun _harassmentThreatening() = harassmentThreatening

        /**
         * Content that promotes, encourages, or depicts acts of self-harm, such as suicide,
         * cutting, and eating disorders.
         */
        @JsonProperty("self-harm") @ExcludeMissing fun _selfHarm() = selfHarm

        /**
         * Content where the speaker expresses that they are engaging or intend to engage in acts of
         * self-harm, such as suicide, cutting, and eating disorders.
         */
        @JsonProperty("self-harm/intent") @ExcludeMissing fun _selfHarmIntent() = selfHarmIntent

        /**
         * Content that encourages performing acts of self-harm, such as suicide, cutting, and
         * eating disorders, or that gives instructions or advice on how to commit such acts.
         */
        @JsonProperty("self-harm/instructions")
        @ExcludeMissing
        fun _selfHarmInstructions() = selfHarmInstructions

        /**
         * Content meant to arouse sexual excitement, such as the description of sexual activity, or
         * that promotes sexual services (excluding sex education and wellness).
         */
        @JsonProperty("sexual") @ExcludeMissing fun _sexual() = sexual

        /** Sexual content that includes an individual who is under 18 years old. */
        @JsonProperty("sexual/minors") @ExcludeMissing fun _sexualMinors() = sexualMinors

        /** Content that depicts death, violence, or physical injury. */
        @JsonProperty("violence") @ExcludeMissing fun _violence() = violence

        /** Content that depicts death, violence, or physical injury in graphic detail. */
        @JsonProperty("violence/graphic") @ExcludeMissing fun _violenceGraphic() = violenceGraphic

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Categories = apply {
            if (!validated) {
                hate()
                hateThreatening()
                harassment()
                harassmentThreatening()
                selfHarm()
                selfHarmIntent()
                selfHarmInstructions()
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
                this.harassment == other.harassment &&
                this.harassmentThreatening == other.harassmentThreatening &&
                this.selfHarm == other.selfHarm &&
                this.selfHarmIntent == other.selfHarmIntent &&
                this.selfHarmInstructions == other.selfHarmInstructions &&
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
                        harassment,
                        harassmentThreatening,
                        selfHarm,
                        selfHarmIntent,
                        selfHarmInstructions,
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
            "Categories{hate=$hate, hateThreatening=$hateThreatening, harassment=$harassment, harassmentThreatening=$harassmentThreatening, selfHarm=$selfHarm, selfHarmIntent=$selfHarmIntent, selfHarmInstructions=$selfHarmInstructions, sexual=$sexual, sexualMinors=$sexualMinors, violence=$violence, violenceGraphic=$violenceGraphic, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var hate: JsonField<Boolean> = JsonMissing.of()
            private var hateThreatening: JsonField<Boolean> = JsonMissing.of()
            private var harassment: JsonField<Boolean> = JsonMissing.of()
            private var harassmentThreatening: JsonField<Boolean> = JsonMissing.of()
            private var selfHarm: JsonField<Boolean> = JsonMissing.of()
            private var selfHarmIntent: JsonField<Boolean> = JsonMissing.of()
            private var selfHarmInstructions: JsonField<Boolean> = JsonMissing.of()
            private var sexual: JsonField<Boolean> = JsonMissing.of()
            private var sexualMinors: JsonField<Boolean> = JsonMissing.of()
            private var violence: JsonField<Boolean> = JsonMissing.of()
            private var violenceGraphic: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(categories: Categories) = apply {
                this.hate = categories.hate
                this.hateThreatening = categories.hateThreatening
                this.harassment = categories.harassment
                this.harassmentThreatening = categories.harassmentThreatening
                this.selfHarm = categories.selfHarm
                this.selfHarmIntent = categories.selfHarmIntent
                this.selfHarmInstructions = categories.selfHarmInstructions
                this.sexual = categories.sexual
                this.sexualMinors = categories.sexualMinors
                this.violence = categories.violence
                this.violenceGraphic = categories.violenceGraphic
                additionalProperties(categories.additionalProperties)
            }

            /**
             * Content that expresses, incites, or promotes hate based on race, gender, ethnicity,
             * religion, nationality, sexual orientation, disability status, or caste. Hateful
             * content aimed at non-protected groups (e.g., chess players) is harassment.
             */
            fun hate(hate: Boolean) = hate(JsonField.of(hate))

            /**
             * Content that expresses, incites, or promotes hate based on race, gender, ethnicity,
             * religion, nationality, sexual orientation, disability status, or caste. Hateful
             * content aimed at non-protected groups (e.g., chess players) is harassment.
             */
            @JsonProperty("hate")
            @ExcludeMissing
            fun hate(hate: JsonField<Boolean>) = apply { this.hate = hate }

            /**
             * Hateful content that also includes violence or serious harm towards the targeted
             * group based on race, gender, ethnicity, religion, nationality, sexual orientation,
             * disability status, or caste.
             */
            fun hateThreatening(hateThreatening: Boolean) =
                hateThreatening(JsonField.of(hateThreatening))

            /**
             * Hateful content that also includes violence or serious harm towards the targeted
             * group based on race, gender, ethnicity, religion, nationality, sexual orientation,
             * disability status, or caste.
             */
            @JsonProperty("hate/threatening")
            @ExcludeMissing
            fun hateThreatening(hateThreatening: JsonField<Boolean>) = apply {
                this.hateThreatening = hateThreatening
            }

            /**
             * Content that expresses, incites, or promotes harassing language towards any target.
             */
            fun harassment(harassment: Boolean) = harassment(JsonField.of(harassment))

            /**
             * Content that expresses, incites, or promotes harassing language towards any target.
             */
            @JsonProperty("harassment")
            @ExcludeMissing
            fun harassment(harassment: JsonField<Boolean>) = apply { this.harassment = harassment }

            /**
             * Harassment content that also includes violence or serious harm towards any target.
             */
            fun harassmentThreatening(harassmentThreatening: Boolean) =
                harassmentThreatening(JsonField.of(harassmentThreatening))

            /**
             * Harassment content that also includes violence or serious harm towards any target.
             */
            @JsonProperty("harassment/threatening")
            @ExcludeMissing
            fun harassmentThreatening(harassmentThreatening: JsonField<Boolean>) = apply {
                this.harassmentThreatening = harassmentThreatening
            }

            /**
             * Content that promotes, encourages, or depicts acts of self-harm, such as suicide,
             * cutting, and eating disorders.
             */
            fun selfHarm(selfHarm: Boolean) = selfHarm(JsonField.of(selfHarm))

            /**
             * Content that promotes, encourages, or depicts acts of self-harm, such as suicide,
             * cutting, and eating disorders.
             */
            @JsonProperty("self-harm")
            @ExcludeMissing
            fun selfHarm(selfHarm: JsonField<Boolean>) = apply { this.selfHarm = selfHarm }

            /**
             * Content where the speaker expresses that they are engaging or intend to engage in
             * acts of self-harm, such as suicide, cutting, and eating disorders.
             */
            fun selfHarmIntent(selfHarmIntent: Boolean) =
                selfHarmIntent(JsonField.of(selfHarmIntent))

            /**
             * Content where the speaker expresses that they are engaging or intend to engage in
             * acts of self-harm, such as suicide, cutting, and eating disorders.
             */
            @JsonProperty("self-harm/intent")
            @ExcludeMissing
            fun selfHarmIntent(selfHarmIntent: JsonField<Boolean>) = apply {
                this.selfHarmIntent = selfHarmIntent
            }

            /**
             * Content that encourages performing acts of self-harm, such as suicide, cutting, and
             * eating disorders, or that gives instructions or advice on how to commit such acts.
             */
            fun selfHarmInstructions(selfHarmInstructions: Boolean) =
                selfHarmInstructions(JsonField.of(selfHarmInstructions))

            /**
             * Content that encourages performing acts of self-harm, such as suicide, cutting, and
             * eating disorders, or that gives instructions or advice on how to commit such acts.
             */
            @JsonProperty("self-harm/instructions")
            @ExcludeMissing
            fun selfHarmInstructions(selfHarmInstructions: JsonField<Boolean>) = apply {
                this.selfHarmInstructions = selfHarmInstructions
            }

            /**
             * Content meant to arouse sexual excitement, such as the description of sexual
             * activity, or that promotes sexual services (excluding sex education and wellness).
             */
            fun sexual(sexual: Boolean) = sexual(JsonField.of(sexual))

            /**
             * Content meant to arouse sexual excitement, such as the description of sexual
             * activity, or that promotes sexual services (excluding sex education and wellness).
             */
            @JsonProperty("sexual")
            @ExcludeMissing
            fun sexual(sexual: JsonField<Boolean>) = apply { this.sexual = sexual }

            /** Sexual content that includes an individual who is under 18 years old. */
            fun sexualMinors(sexualMinors: Boolean) = sexualMinors(JsonField.of(sexualMinors))

            /** Sexual content that includes an individual who is under 18 years old. */
            @JsonProperty("sexual/minors")
            @ExcludeMissing
            fun sexualMinors(sexualMinors: JsonField<Boolean>) = apply {
                this.sexualMinors = sexualMinors
            }

            /** Content that depicts death, violence, or physical injury. */
            fun violence(violence: Boolean) = violence(JsonField.of(violence))

            /** Content that depicts death, violence, or physical injury. */
            @JsonProperty("violence")
            @ExcludeMissing
            fun violence(violence: JsonField<Boolean>) = apply { this.violence = violence }

            /** Content that depicts death, violence, or physical injury in graphic detail. */
            fun violenceGraphic(violenceGraphic: Boolean) =
                violenceGraphic(JsonField.of(violenceGraphic))

            /** Content that depicts death, violence, or physical injury in graphic detail. */
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): Categories =
                Categories(
                    hate,
                    hateThreatening,
                    harassment,
                    harassmentThreatening,
                    selfHarm,
                    selfHarmIntent,
                    selfHarmInstructions,
                    sexual,
                    sexualMinors,
                    violence,
                    violenceGraphic,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    /** A list of the categories along with their scores as predicted by model. */
    @JsonDeserialize(builder = CategoryScores.Builder::class)
    @NoAutoDetect
    class CategoryScores
    private constructor(
        private val hate: JsonField<Double>,
        private val hateThreatening: JsonField<Double>,
        private val harassment: JsonField<Double>,
        private val harassmentThreatening: JsonField<Double>,
        private val selfHarm: JsonField<Double>,
        private val selfHarmIntent: JsonField<Double>,
        private val selfHarmInstructions: JsonField<Double>,
        private val sexual: JsonField<Double>,
        private val sexualMinors: JsonField<Double>,
        private val violence: JsonField<Double>,
        private val violenceGraphic: JsonField<Double>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /** The score for the category 'hate'. */
        fun hate(): Double = hate.getRequired("hate")

        /** The score for the category 'hate/threatening'. */
        fun hateThreatening(): Double = hateThreatening.getRequired("hate/threatening")

        /** The score for the category 'harassment'. */
        fun harassment(): Double = harassment.getRequired("harassment")

        /** The score for the category 'harassment/threatening'. */
        fun harassmentThreatening(): Double =
            harassmentThreatening.getRequired("harassment/threatening")

        /** The score for the category 'self-harm'. */
        fun selfHarm(): Double = selfHarm.getRequired("self-harm")

        /** The score for the category 'self-harm/intent'. */
        fun selfHarmIntent(): Double = selfHarmIntent.getRequired("self-harm/intent")

        /** The score for the category 'self-harm/instructions'. */
        fun selfHarmInstructions(): Double =
            selfHarmInstructions.getRequired("self-harm/instructions")

        /** The score for the category 'sexual'. */
        fun sexual(): Double = sexual.getRequired("sexual")

        /** The score for the category 'sexual/minors'. */
        fun sexualMinors(): Double = sexualMinors.getRequired("sexual/minors")

        /** The score for the category 'violence'. */
        fun violence(): Double = violence.getRequired("violence")

        /** The score for the category 'violence/graphic'. */
        fun violenceGraphic(): Double = violenceGraphic.getRequired("violence/graphic")

        /** The score for the category 'hate'. */
        @JsonProperty("hate") @ExcludeMissing fun _hate() = hate

        /** The score for the category 'hate/threatening'. */
        @JsonProperty("hate/threatening") @ExcludeMissing fun _hateThreatening() = hateThreatening

        /** The score for the category 'harassment'. */
        @JsonProperty("harassment") @ExcludeMissing fun _harassment() = harassment

        /** The score for the category 'harassment/threatening'. */
        @JsonProperty("harassment/threatening")
        @ExcludeMissing
        fun _harassmentThreatening() = harassmentThreatening

        /** The score for the category 'self-harm'. */
        @JsonProperty("self-harm") @ExcludeMissing fun _selfHarm() = selfHarm

        /** The score for the category 'self-harm/intent'. */
        @JsonProperty("self-harm/intent") @ExcludeMissing fun _selfHarmIntent() = selfHarmIntent

        /** The score for the category 'self-harm/instructions'. */
        @JsonProperty("self-harm/instructions")
        @ExcludeMissing
        fun _selfHarmInstructions() = selfHarmInstructions

        /** The score for the category 'sexual'. */
        @JsonProperty("sexual") @ExcludeMissing fun _sexual() = sexual

        /** The score for the category 'sexual/minors'. */
        @JsonProperty("sexual/minors") @ExcludeMissing fun _sexualMinors() = sexualMinors

        /** The score for the category 'violence'. */
        @JsonProperty("violence") @ExcludeMissing fun _violence() = violence

        /** The score for the category 'violence/graphic'. */
        @JsonProperty("violence/graphic") @ExcludeMissing fun _violenceGraphic() = violenceGraphic

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): CategoryScores = apply {
            if (!validated) {
                hate()
                hateThreatening()
                harassment()
                harassmentThreatening()
                selfHarm()
                selfHarmIntent()
                selfHarmInstructions()
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
                this.harassment == other.harassment &&
                this.harassmentThreatening == other.harassmentThreatening &&
                this.selfHarm == other.selfHarm &&
                this.selfHarmIntent == other.selfHarmIntent &&
                this.selfHarmInstructions == other.selfHarmInstructions &&
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
                        harassment,
                        harassmentThreatening,
                        selfHarm,
                        selfHarmIntent,
                        selfHarmInstructions,
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
            "CategoryScores{hate=$hate, hateThreatening=$hateThreatening, harassment=$harassment, harassmentThreatening=$harassmentThreatening, selfHarm=$selfHarm, selfHarmIntent=$selfHarmIntent, selfHarmInstructions=$selfHarmInstructions, sexual=$sexual, sexualMinors=$sexualMinors, violence=$violence, violenceGraphic=$violenceGraphic, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var hate: JsonField<Double> = JsonMissing.of()
            private var hateThreatening: JsonField<Double> = JsonMissing.of()
            private var harassment: JsonField<Double> = JsonMissing.of()
            private var harassmentThreatening: JsonField<Double> = JsonMissing.of()
            private var selfHarm: JsonField<Double> = JsonMissing.of()
            private var selfHarmIntent: JsonField<Double> = JsonMissing.of()
            private var selfHarmInstructions: JsonField<Double> = JsonMissing.of()
            private var sexual: JsonField<Double> = JsonMissing.of()
            private var sexualMinors: JsonField<Double> = JsonMissing.of()
            private var violence: JsonField<Double> = JsonMissing.of()
            private var violenceGraphic: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(categoryScores: CategoryScores) = apply {
                this.hate = categoryScores.hate
                this.hateThreatening = categoryScores.hateThreatening
                this.harassment = categoryScores.harassment
                this.harassmentThreatening = categoryScores.harassmentThreatening
                this.selfHarm = categoryScores.selfHarm
                this.selfHarmIntent = categoryScores.selfHarmIntent
                this.selfHarmInstructions = categoryScores.selfHarmInstructions
                this.sexual = categoryScores.sexual
                this.sexualMinors = categoryScores.sexualMinors
                this.violence = categoryScores.violence
                this.violenceGraphic = categoryScores.violenceGraphic
                additionalProperties(categoryScores.additionalProperties)
            }

            /** The score for the category 'hate'. */
            fun hate(hate: Double) = hate(JsonField.of(hate))

            /** The score for the category 'hate'. */
            @JsonProperty("hate")
            @ExcludeMissing
            fun hate(hate: JsonField<Double>) = apply { this.hate = hate }

            /** The score for the category 'hate/threatening'. */
            fun hateThreatening(hateThreatening: Double) =
                hateThreatening(JsonField.of(hateThreatening))

            /** The score for the category 'hate/threatening'. */
            @JsonProperty("hate/threatening")
            @ExcludeMissing
            fun hateThreatening(hateThreatening: JsonField<Double>) = apply {
                this.hateThreatening = hateThreatening
            }

            /** The score for the category 'harassment'. */
            fun harassment(harassment: Double) = harassment(JsonField.of(harassment))

            /** The score for the category 'harassment'. */
            @JsonProperty("harassment")
            @ExcludeMissing
            fun harassment(harassment: JsonField<Double>) = apply { this.harassment = harassment }

            /** The score for the category 'harassment/threatening'. */
            fun harassmentThreatening(harassmentThreatening: Double) =
                harassmentThreatening(JsonField.of(harassmentThreatening))

            /** The score for the category 'harassment/threatening'. */
            @JsonProperty("harassment/threatening")
            @ExcludeMissing
            fun harassmentThreatening(harassmentThreatening: JsonField<Double>) = apply {
                this.harassmentThreatening = harassmentThreatening
            }

            /** The score for the category 'self-harm'. */
            fun selfHarm(selfHarm: Double) = selfHarm(JsonField.of(selfHarm))

            /** The score for the category 'self-harm'. */
            @JsonProperty("self-harm")
            @ExcludeMissing
            fun selfHarm(selfHarm: JsonField<Double>) = apply { this.selfHarm = selfHarm }

            /** The score for the category 'self-harm/intent'. */
            fun selfHarmIntent(selfHarmIntent: Double) =
                selfHarmIntent(JsonField.of(selfHarmIntent))

            /** The score for the category 'self-harm/intent'. */
            @JsonProperty("self-harm/intent")
            @ExcludeMissing
            fun selfHarmIntent(selfHarmIntent: JsonField<Double>) = apply {
                this.selfHarmIntent = selfHarmIntent
            }

            /** The score for the category 'self-harm/instructions'. */
            fun selfHarmInstructions(selfHarmInstructions: Double) =
                selfHarmInstructions(JsonField.of(selfHarmInstructions))

            /** The score for the category 'self-harm/instructions'. */
            @JsonProperty("self-harm/instructions")
            @ExcludeMissing
            fun selfHarmInstructions(selfHarmInstructions: JsonField<Double>) = apply {
                this.selfHarmInstructions = selfHarmInstructions
            }

            /** The score for the category 'sexual'. */
            fun sexual(sexual: Double) = sexual(JsonField.of(sexual))

            /** The score for the category 'sexual'. */
            @JsonProperty("sexual")
            @ExcludeMissing
            fun sexual(sexual: JsonField<Double>) = apply { this.sexual = sexual }

            /** The score for the category 'sexual/minors'. */
            fun sexualMinors(sexualMinors: Double) = sexualMinors(JsonField.of(sexualMinors))

            /** The score for the category 'sexual/minors'. */
            @JsonProperty("sexual/minors")
            @ExcludeMissing
            fun sexualMinors(sexualMinors: JsonField<Double>) = apply {
                this.sexualMinors = sexualMinors
            }

            /** The score for the category 'violence'. */
            fun violence(violence: Double) = violence(JsonField.of(violence))

            /** The score for the category 'violence'. */
            @JsonProperty("violence")
            @ExcludeMissing
            fun violence(violence: JsonField<Double>) = apply { this.violence = violence }

            /** The score for the category 'violence/graphic'. */
            fun violenceGraphic(violenceGraphic: Double) =
                violenceGraphic(JsonField.of(violenceGraphic))

            /** The score for the category 'violence/graphic'. */
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): CategoryScores =
                CategoryScores(
                    hate,
                    hateThreatening,
                    harassment,
                    harassmentThreatening,
                    selfHarm,
                    selfHarmIntent,
                    selfHarmInstructions,
                    sexual,
                    sexualMinors,
                    violence,
                    violenceGraphic,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
