package com.hizari.common.data

import com.hizari.common.data.Resource.Empty.dataOr
import org.junit.Assert.*
import org.junit.Test

/**
 * Spaceflight News - com.hizari.common.data
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

class ResourceTest {

    @Test
    fun `success() should return true for Success`() {
        val resource: Resource<String> = Resource.Success("Test")
        assertTrue(resource.success())
    }

    @Test
    fun `success() should return false for non-Success types`() {
        val resourceError: Resource<String> = Resource.Error(message = "Error")
        val resourceLoading: Resource<String> = Resource.Loading
        val resourceEmpty: Resource<String> = Resource.Empty
        assertFalse(resourceError.success())
        assertFalse(resourceLoading.success())
        assertFalse(resourceEmpty.success())
    }

    @Test
    fun `empty() should return true for Empty`() {
        val resource: Resource<String> = Resource.Empty
        assertTrue(resource.empty())
    }

    @Test
    fun `empty() should return false for non-Empty types`() {
        val resourceSuccess: Resource<String> = Resource.Success("Test")
        val resourceError: Resource<String> = Resource.Error(message = "Error")
        val resourceLoading: Resource<String> = Resource.Loading
        assertFalse(resourceSuccess.empty())
        assertFalse(resourceError.empty())
        assertFalse(resourceLoading.empty())
    }

    @Test
    fun `error() should return true for Error`() {
        val resource: Resource<String> = Resource.Error(message = "Error")
        assertTrue(resource.error())
    }

    @Test
    fun `error() should return false for non-Error types`() {
        val resourceSuccess: Resource<String> = Resource.Success("Test")
        val resourceLoading: Resource<String> = Resource.Loading
        val resourceEmpty: Resource<String> = Resource.Empty
        assertFalse(resourceSuccess.error())
        assertFalse(resourceLoading.error())
        assertFalse(resourceEmpty.error())
    }

    @Test
    fun `loading() should return true for Loading`() {
        val resource: Resource<String> = Resource.Loading
        assertTrue(resource.loading())
    }

    @Test
    fun `loading() should return false for non-Loading types`() {
        val resourceSuccess: Resource<String> = Resource.Success("Test")
        val resourceError: Resource<String> = Resource.Error(message = "Error")
        val resourceEmpty: Resource<String> = Resource.Empty
        assertFalse(resourceSuccess.loading())
        assertFalse(resourceError.loading())
        assertFalse(resourceEmpty.loading())
    }

    @Test
    fun `asMessage should return error message when available`() {
        val errorMessage = "Test error message"
        Resource.Error(message = errorMessage).also { resource ->
            assertEquals(errorMessage, resource.asMessage())
        }
    }

    @Test
    fun `asMessage should return throwable message when error message is null`() {
        val throwableMessage = "Throwable error message"
        Resource.Error(throwable = Throwable(throwableMessage)).also { resource ->
            assertEquals(throwableMessage, resource.asMessage())
        }
    }

    @Test
    fun `asMessage should include error code if available`() {
        val errorMessage = "Test error message"
        val errorCode = 404
        Resource.Error(message = errorMessage, code = errorCode).also { resource ->
            assertEquals("$errorMessage (Code: $errorCode)", resource.asMessage())
        }
    }

    @Test
    fun `asMessage should return Unknown error when both message and throwable are null`() {
        Resource.Error().also { resource ->
            assertEquals("Unknown error", resource.asMessage())
        }
    }

    @Test
    fun `asThrowable should return throwable if available`() {
        val throwable = Throwable("Throwable error message")
        Resource.Error(throwable = throwable).also { resource ->
            assertSame(throwable, resource.asThrowable())
        }
    }

    @Test
    fun `asThrowable should return exception with message if throwable is null`() {
        val errorMessage = "Test error message"
        Resource.Error(message = errorMessage).also { resource ->
            val exception = resource.asThrowable()
            assertTrue(exception is Exception)
            assertEquals(errorMessage, exception.message)
        }
    }

    @Test
    fun `dataOr should return transformed data when Success`() {
        val resource: Resource<Int> = Resource.Success(10)
        val result = resource.dataOr(0) { it * 2 }
        assertEquals(20, result)
    }

    @Test
    fun `dataOr should return default value when not Success`() {
        val resource: Resource<Int> = Resource.Error(message = "Error")
        val result = resource.dataOr(0) { it * 2 }
        assertEquals(0, result)
    }
}
