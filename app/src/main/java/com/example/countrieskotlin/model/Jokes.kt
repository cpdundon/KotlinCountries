package com.example.countrieskotlin.model


import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@Serializable
@JsonClass(generateAdapter = true)
class Jokes (
    val error: Boolean?,
    val amount: Int?,
    val jokes: List<Joke>?
)