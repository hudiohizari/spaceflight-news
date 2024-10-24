package com.hizari.common.extention

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Spaceflight News - com.hizari.common.extention
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */
class StringExtTest {

    @Test
    fun `isNotNullOrEmpty should return false for null string`() {
        val nullString: String? = null
        assertFalse(nullString.isNotNullOrEmpty())
    }

    @Test
    fun `isNotNullOrEmpty should return false for empty string`() {
        val emptyString = ""
        assertFalse(emptyString.isNotNullOrEmpty())
    }

    @Test
    fun `isNotNullOrEmpty should return true for non-empty string`() {
        val nonEmptyString = "Hello"
        assertTrue(nonEmptyString.isNotNullOrEmpty())
    }

}