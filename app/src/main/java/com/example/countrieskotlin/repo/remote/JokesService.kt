package com.example.countrieskotlin.repo.remote

import com.example.countrieskotlin.model.Jokes
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesService {
    @GET("Any")
    suspend fun getJokes(@Query("amount") amount: Int, @Query("type") type: String): Response<Jokes>
}
