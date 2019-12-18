package com.test.moviesapplication.api

import com.test.moviesapplication.models.MovieModel
import retrofit2.http.GET

/**
 * Retrofit interface class acting as an Api layer
 */

interface NetworkApi {

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(): MovieModel
}