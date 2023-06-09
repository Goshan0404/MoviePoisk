package com.example.moviepoisk.data.model

data class Doc(
    val alternativeName: Any,
    val description: String,
    val enName: Any,
    val externalId: ExternalId,
    val id: Int,
    val logo: Logo,
    val movieLength: Int,
    val name: String,
    val names: List<Name>,
    val poster: Poster,
    val rating: Rating,
    val releaseYears: List<ReleaseYear>,
    val shortDescription: String,
    val type: String,
    val votes: Votes,
    val watchability: Watchability,
    val year: Int
)