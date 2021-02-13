package com.example.countrieskotlin.model.Intent

import kotlinx.serialization.Serializable

@Serializable
class IntentInfo(
        val caller: CallerData,
        val categories: String = "Any"
)