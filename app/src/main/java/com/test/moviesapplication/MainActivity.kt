package com.test.moviesapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject

/**
 * Activity class acting as a container to all Fragments
 */
class MainActivity : AppCompatActivity() {
    private val exampleFragment: MovieFragment by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.root, exampleFragment, "weather").commit()
    }
}
