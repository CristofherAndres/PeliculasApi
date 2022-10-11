package com.example.pelicukasapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pelicukasapi.Adapter.MovieAdapter
import com.example.pelicukasapi.Model.Movie
import com.example.pelicukasapi.Model.MovieResponse
import com.example.pelicukasapi.Services.MovieApiInterface
import com.example.pelicukasapi.Services.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response






class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movies.layoutManager = LinearLayoutManager(this)
        rv_movies.setHasFixedSize(true)
        getMovieData { movies : List<Movie> ->
            rv_movies.adapter = MovieAdapter(movies)
        }


    }

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMoviesList().enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

        })

    }


}