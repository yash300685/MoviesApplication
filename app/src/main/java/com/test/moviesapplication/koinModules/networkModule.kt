
import com.test.moviesapplication.api.NetworkApi
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

/**
 * Network layer Koin Module to inject Retrofit dependency in Repository layer
 */
val networkModule = module {
    single { creteRetrofit() }
    single { createNetworkApi(get()) }
}

fun creteRetrofit():Retrofit
{
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit
}

fun createNetworkApi(retrofit: Retrofit): NetworkApi {
    return retrofit.create(NetworkApi::class.java)
}
