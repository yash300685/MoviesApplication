package com.test.moviesapplication.viewModels

import androidx.lifecycle.LiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.test.moviesapplication.Result
import com.test.moviesapplication.repository.MovieRepository


/**
 * View Model layer which is simplified by using liveData builder which return Live Data result used in Data Binding
 *
 */
class MovieViewModel(private val movieRepo: MovieRepository): ViewModel() {


    val movieData: LiveData<Result<Any>> = liveData {

        emit(movieRepo.getUpcomingMovies())
    }


}