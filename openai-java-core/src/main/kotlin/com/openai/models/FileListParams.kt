// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.ListMultimap
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.*
import java.util.Objects
import java.util.Optional

class FileListParams
constructor(
    private val after: String?,
    private val limit: Long?,
    private val order: Order?,
    private val purpose: String?,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalQueryParams: Map<String, List<String>>,
) {

    fun after(): Optional<String> = Optional.ofNullable(after)

    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    fun order(): Optional<Order> = Optional.ofNullable(order)

    fun purpose(): Optional<String> = Optional.ofNullable(purpose)

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.after?.let { params.put("after", listOf(it.toString())) }
        this.limit?.let { params.put("limit", listOf(it.toString())) }
        this.order?.let { params.put("order", listOf(it.toString())) }
        this.purpose?.let { params.put("purpose", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toImmutable()
    }

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileListParams && this.after == other.after && this.limit == other.limit && this.order == other.order && this.purpose == other.purpose && this.additionalHeaders == other.additionalHeaders && this.additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(after, limit, order, purpose, additionalHeaders, additionalQueryParams) /* spotless:on */
    }

    override fun toString() =
        "FileListParams{after=$after, limit=$limit, order=$order, purpose=$purpose, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var after: String? = null
        private var limit: Long? = null
        private var order: Order? = null
        private var purpose: String? = null
        private var additionalHeaders: ListMultimap<String, String> = ArrayListMultimap.create()
        private var additionalQueryParams: ListMultimap<String, String> = ArrayListMultimap.create()

        @JvmSynthetic
        internal fun from(fileListParams: FileListParams) = apply {
            this.after = fileListParams.after
            this.limit = fileListParams.limit
            this.order = fileListParams.order
            this.purpose = fileListParams.purpose
            additionalHeaders(fileListParams.additionalHeaders)
            additionalQueryParams(fileListParams.additionalQueryParams)
        }

        /**
         * A cursor for use in pagination. `after` is an object ID that defines your place in the
         * list. For instance, if you make a list request and receive 100 objects, ending with
         * obj_foo, your subsequent call can include after=obj_foo in order to fetch the next page
         * of the list.
         */
        fun after(after: String) = apply { this.after = after }

        /**
         * A limit on the number of objects to be returned. Limit can range between 1 and 10,000,
         * and the default is 10,000.
         */
        fun limit(limit: Long) = apply { this.limit = limit }

        /**
         * Sort order by the `created_at` timestamp of the objects. `asc` for ascending order and
         * `desc` for descending order.
         */
        fun order(order: Order) = apply { this.order = order }

        /** Only return files with the given purpose. */
        fun purpose(purpose: String) = apply { this.purpose = purpose }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.putAll(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(::putAdditionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replaceValues(name, listOf(value))
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replaceValues(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(::replaceAdditionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.removeAll(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            names.forEach(::removeAdditionalHeaders)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.putAll(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                additionalQueryParams.forEach(::putAdditionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replaceValues(key, listOf(value))
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replaceValues(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                additionalQueryParams.forEach(::replaceAdditionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply {
            additionalQueryParams.removeAll(key)
        }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalQueryParams)
        }

        fun build(): FileListParams =
            FileListParams(
                after,
                limit,
                order,
                purpose,
                additionalHeaders
                    .asMap()
                    .mapValues { it.value.toList().toImmutable() }
                    .toImmutable(),
                additionalQueryParams
                    .asMap()
                    .mapValues { it.value.toList().toImmutable() }
                    .toImmutable(),
            )
    }

    class Order
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Order && this.value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val ASC = Order(JsonField.of("asc"))

            @JvmField val DESC = Order(JsonField.of("desc"))

            @JvmStatic fun of(value: String) = Order(JsonField.of(value))
        }

        enum class Known {
            ASC,
            DESC,
        }

        enum class Value {
            ASC,
            DESC,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ASC -> Value.ASC
                DESC -> Value.DESC
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ASC -> Known.ASC
                DESC -> Known.DESC
                else -> throw OpenAIInvalidDataException("Unknown Order: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
