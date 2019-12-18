package com.test.moviesapplication.repository

import com.test.moviesapplication.Result


interface MovieRepository {

    suspend fun getUpcomingMovies():Result<Any>
}