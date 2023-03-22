package com.example.moviepoisk.business.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.moviepoisk.RequestSuccessListener
import com.example.moviepoisk.ViewModelRequestSuccessListener
import com.example.moviepoisk.data.repository.MovieListRepository
import com.example.moviepoisk.data.model.Doc
import okhttp3.internal.notify


class MovieListViewModel(application: Application) : AndroidViewModel(application) {

    var allDocs = MutableLiveData<MutableList<List<Doc>>>()
    var categoryFilms =
        listOf("movie", "tv-series", "cartoon", "anime", "animated-series", "tv-show")

    init {
        allDocs.value = mutableListOf()
    }

    fun requestMovies() {
        for (category in categoryFilms) {
            MovieListRepository.getMovies(category, object : ViewModelRequestSuccessListener {

                override fun onSuccess(docs: List<Doc>) {
                    allDocs.value?.add(docs)
                    allDocs.value = allDocs.value
                }
            })
        }
    }


}