package com.example.countrieskotlin.model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Joke(
        val category: String?,
        val type: String?,
        val setup: String?,
        val delivery: String?,
        val flags: Flags?,
        val safe: Boolean?,
        val id: Int?,
        val lang: String?
)