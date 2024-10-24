package com.hizari.common.extention

/**
 * Spaceflight News - com.hizari.common.extention
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

fun String?.isNotNullOrEmpty(): Boolean {
    return isNullOrEmpty().not()
}