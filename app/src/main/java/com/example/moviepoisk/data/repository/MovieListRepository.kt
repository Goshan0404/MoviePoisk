package com.example.moviepoisk.data.repository

import android.util.Log
import com.example.moviepoisk.BuildConfig
import com.example.moviepoisk.ViewModelRequestSuccessListener
import com.example.moviepoisk.api.RetrofitClient
import com.example.moviepoisk.data.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

object MovieListRepository {

    fun getMovies(category: String, successListener: ViewModelRequestSuccessListener) {
        try {
            val page = "1"
            val limit = "25"
            RetrofitClient.getClient(BuildConfig.BASE_URL)
                .getMovie(page, limit, category)
                .enqueue(object : Callback<Movie> {

                    override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                        if (response.isSuccessful && response.body() != null) {
                            successListener.onSuccess(response.body()!!.docs)
                        } else {
                            Log.e("Repository", "onResponse: " + response.message().toString())
                        }
                    }

                    override fun onFailure(call: Call<Movie>, t: Throwable) {
                        Log.e("Repository", "onFailure: " + t.message.toString())
                    }
                })
        } catch (e: IOException) {
            Log.e("Repository", "onFailure: " + e.message.toString())
        }
    }
}