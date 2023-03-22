package com.example.moviepoisk.api

import com.example.moviepoisk.BuildConfig
import com.example.moviepoisk.data.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitApi {

    @Headers("X-API-KEY: ${BuildConfig.API_KEY}")
    @GET("movie")
     fun getMovie(
                  @Query("page") page: String,
                  @Query("limit") limit: String,
                  @Query("type") category: String): Call<Movie>
}