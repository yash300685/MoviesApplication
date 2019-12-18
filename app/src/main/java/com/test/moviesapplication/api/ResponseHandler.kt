package com.test.moviesapplication.api

import com.test.moviesapplication.Result
import retrofit2.HttpException

/**
 * Class for Handling success and failure response from API.Also acts as a common Error handling layer
 */

 open class ResponseHandler {
    fun <T : Any> handleSuccess(data: T): Result<T> {
        return Result.Success(data)
    }

    fun <T : Any> handleException(e: Exception): Result<T> {
        return when (e) {
            is HttpException -> Result.Failure(getErrorMessage(e.code()))

            else -> Result.Failure(getErrorMessage(Int.MAX_VALUE))
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            401 -> "Unauthorised"
            404 -> "Not found"
            else -> "Something went wrong"
        }
    }
}