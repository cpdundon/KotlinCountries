package com.example.countrieskotlin.model.jobs

import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@Serializable
@JsonClass(generateAdapter = true)
data class GitJob (
        val id: String,
        val type: String,
        val url: String,
        val created_at: String,
        val company: String,
        val company_url: String?,
        val location: String,
        val title: String,
        val description: String,
        val how_to_apply: String,
        val company_logo: String
)