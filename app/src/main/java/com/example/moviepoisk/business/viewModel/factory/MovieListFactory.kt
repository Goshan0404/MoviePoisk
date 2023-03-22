package com.example.moviepoisk.business.viewModel.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviepoisk.business.viewModel.MovieListViewModel

class MovieListFactory(private val application: Application): ViewModelProvider.AndroidViewModelFactory(application) {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieListViewModel(application) as T
    }
}