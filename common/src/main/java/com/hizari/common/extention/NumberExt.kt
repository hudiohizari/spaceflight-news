package com.hizari.common.extention

/**
 * Spaceflight News - com.hizari.common.extention
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

fun Double?.orZero(): Double {
    return this ?: 0.0
}

fun Int?.orZero(): Int {
    return this ?: 0
}

fun Long?.orZero(): Long {
    return this ?: 0
}