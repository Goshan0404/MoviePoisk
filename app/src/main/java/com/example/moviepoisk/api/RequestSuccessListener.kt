package com.example.moviepoisk

import com.example.moviepoisk.data.model.Doc

interface RequestSuccessListener {
    fun onSuccess(docs: List<List<Doc>>)
}

interface ViewModelRequestSuccessListener {
    fun onSuccess(docs: List<Doc>)
}