package com.test.moviesapplication


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.test.moviesapplication.api.Status
import com.test.moviesapplication.models.MovieModel
import com.test.moviesapplication.viewModels.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module

/**
 * A simple [Fragment] subclass.
 */
val fragmentModule = module {
    factory { MovieFragment() }
}
class MovieFragment : Fragment() {


    private val movieViewModel: MovieViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        movieViewModel.movieData.observe(this,observer)
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    private val observer = Observer<Result<Any>> {

        when (it.status) {
            Status.SUCCESS -> Toast.makeText(
                activity,
                (it.data as MovieModel).results[0].title,
                Toast.LENGTH_LONG
            ).show()
            Status.ERROR -> Toast.makeText(activity, (it.data as String), Toast.LENGTH_LONG).show()

        }


    }


}
