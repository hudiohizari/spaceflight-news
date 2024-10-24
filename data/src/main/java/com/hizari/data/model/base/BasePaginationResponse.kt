package com.hizari.data.model.base

/**
 * Spaceflight News - com.hizari.data.model.base
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

data class BasePaginationResponse<T>(
    val count: Int? = null,
    val detail: String? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<T>? = null
)
