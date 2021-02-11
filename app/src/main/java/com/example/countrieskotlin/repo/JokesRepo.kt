package com.example.countrieskotlin.repo

import com.example.countrieskotlin.model.Jokes
import com.example.countrieskotlin.repo.remote.JokesRetroInstance
import retrofit2.Response

object JokesRepo {
        suspend fun getJokes(amount: Int, type: String, category: String) : Response<Jokes> {
                return JokesRetroInstance.jokesService.getJokes(category, amount, type)
        }
}