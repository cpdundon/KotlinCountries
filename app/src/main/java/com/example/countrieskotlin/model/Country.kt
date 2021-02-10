package com.example.countrieskotlin.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Country(
    val name: String?,
    val capital: String?,
    val region: String?,
    val subregion: String?,
    val population: Long?,
    val flag: String?
)