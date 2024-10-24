package com.hizari.data.network.util

import android.content.Context
import com.google.gson.Gson
import com.hizari.common.data.Resource
import com.hizari.data.R
import com.hizari.data.model.base.ErrorResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.internal.http.HTTP_NO_CONTENT
import org.json.JSONException
import retrofit2.HttpException
import retrofit2.Response
import java.net.HttpURLConnection
import javax.inject.Inject

/**
 * Spaceflight News - com.hizari.data.network.util
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

abstract class SafeApiRequest {
    @Inject
    @ApplicationContext
    lateinit var context: Context

    suspend fun <T : Any> apiRequest(
        call: suspend () -> Response<T>
    ): Resource<T> {
        return try {
            val response = call.invoke()
            if (response.isSuccessful) {
                response.body()?.let {
                    Resource.Success(it)
                } ?: Resource.Error(
                    code = HttpURLConnection.HTTP_NO_CONTENT,
                    message = "Response body is null"
                )
            } else {
                val responseErrorBody = response.errorBody()?.string()
                val responseCode = response.code()
                parseErrorMessage(responseCode, responseErrorBody)
            }
        } catch (e: HttpException) {
            Resource.Error(code = e.code(), message = e.message())
        } catch (e: Throwable) {
            Resource.Error(throwable = e)
        }
    }

    private fun <T : Any> parseErrorMessage(code: Int, errorBody: String?): Resource<T> {
        return if (code >= HttpURLConnection.HTTP_INTERNAL_ERROR) {
            Resource.Error(code, context.getString(R.string.server_down))
        } else {
            errorBody?.let {
                try {
                    val data = Gson().fromJson(it, ErrorResponse::class.java)
                    val resDetail = data.detail ?: context.getString(R.string.server_down)
                    Resource.Error(code, resDetail)
                } catch (e: JSONException) {
                    Resource.Error(code, e.message)
                } catch (e: Exception) {
                    Resource.Error(code, e.message)
                }
            } ?: run {
                Resource.Error(code, context.getString(R.string.server_down))
            }
        }
    }

    suspend fun <T : Any, R : Any> handleResource(
        resourceCall: suspend () -> Resource<T>,
        onError: suspend (Int?, String?, Throwable?) -> Resource<R> = { code, message, throwable ->
            Resource.Error(code, message, throwable)
        },
        onSuccess: suspend (T) -> Resource<R>
    ): Resource<R> {
        return when (val result = resourceCall()) {
            is Resource.Success -> onSuccess(result.data)
            is Resource.Error -> onError(result.code, result.message, result.throwable)
            is Resource.Loading -> result
            is Resource.Empty -> result
        }
    }

    suspend fun <T : Any, R : Any> handleResourceWithNoContent(
        resourceCall: suspend () -> Resource<T>,
        onError: suspend (Int?, String?, Throwable?) -> Resource<R> = { code, message, throwable ->
            Resource.Error(code, message, throwable)
        },
        onSuccess: suspend (T?) -> Resource<R>
    ): Resource<R> {
        return when (val result = resourceCall()) {
            is Resource.Success -> onSuccess(result.data)
            is Resource.Error -> {
                if (result.code == HTTP_NO_CONTENT) {
                    onSuccess(null)
                } else {
                    onError(result.code, result.message, result.throwable)
                }
            }
            is Resource.Loading -> result
            is Resource.Empty -> result
        }
    }
}