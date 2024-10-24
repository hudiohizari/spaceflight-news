package com.hizari.common.data

/**
 * Spaceflight News - com.hizari.common.data
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

sealed class Resource<out T> {

    data class Success<T>(val data: T) : Resource<T>()

    data class Error(
        val code: Int? = null,
        val message: String? = null,
        val throwable: Throwable? = null
    ) : Resource<Nothing>() {
        fun asMessage(): String {
            val message = message ?: throwable?.message ?: "Unknown error"
            return if (code == null) message else "$message (Code: $code)"
        }

        fun asThrowable() = throwable ?: Exception(asMessage())
    }

    data object Loading : Resource<Nothing>()

    data object Empty : Resource<Nothing>()

    fun success() = this is Success
    fun empty() = this is Empty
    fun error() = this is Error
    fun loading() = this is Loading

    inline fun <T : Any, R> Resource<T>.dataOr(defaultValue: R, transform: (T) -> R): R {
        return if (this is Success) {
            transform(data)
        } else {
            defaultValue
        }
    }

}