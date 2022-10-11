package com.example.pelicukasapi.Services

import com.example.pelicukasapi.Model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    //Reemplazar por la api_key
    @GET("/3/movie/popular?api_key=14a60e6338a1c5b6f39e2944c074cdac")
    fun getMoviesList(): Call<MovieResponse>
}