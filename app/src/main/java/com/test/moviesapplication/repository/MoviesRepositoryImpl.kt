package com.test.moviesapplication.repository

import com.test.moviesapplication.Result
import com.test.moviesapplication.api.NetworkApi
import com.test.moviesapplication.api.ResponseHandler

/**
 * Repository pattern implementation which is used to call API
 */
class MoviesRepositoryImpl(val networkApi: NetworkApi, val responseHandler: ResponseHandler) :MovieRepository

{

    override suspend fun getUpcomingMovies(): Result<Any> {
        return try {
            responseHandler.handleSuccess(networkApi.getUpcomingMovies())

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}