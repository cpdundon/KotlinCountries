package com.example.countrieskotlin.model


import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@Serializable
@JsonClass(generateAdapter = true)
data class Flags(
    val nsfw: Boolean?,
    val religious: Boolean?,
    val political: Boolean?,
    val racist: Boolean?,
    val sexist: Boolean?,
    val explicit: Boolean?
)