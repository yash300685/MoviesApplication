package com.test.moviesapplication.koinModules


import com.test.moviesapplication.api.ResponseHandler
import com.test.moviesapplication.repository.MovieRepository
import com.test.moviesapplication.repository.MoviesRepositoryImpl
import com.test.moviesapplication.viewModels.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Koin Module for injecting dependencies as Constructor injection
 */

val appModule = module {
    single{ResponseHandler()}
    single<MovieRepository> { MoviesRepositoryImpl(get(),get())}
    viewModel { MovieViewModel(get()) }


}

