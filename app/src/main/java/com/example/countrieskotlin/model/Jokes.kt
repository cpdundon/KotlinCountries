package com.example.countrieskotlin.model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Jokes(
    val error: Boolean?,
    val amount: Int?,
    val jokes: List<Joke>?
)