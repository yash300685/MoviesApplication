package com.test.moviesapplication

import android.app.Application
import com.test.moviesapplication.koinModules.appModule
import networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {

            androidContext(this@MovieApplication)
            modules(listOf(
                appModule,networkModule,fragmentModule
            ))
        }
    }
}