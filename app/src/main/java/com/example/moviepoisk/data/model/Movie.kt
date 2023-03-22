package com.example.moviepoisk.data.model

data class Movie(
    val docs: List<Doc>,
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
    // 1
    // 1.1
)