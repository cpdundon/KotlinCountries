package com.example.countrieskotlin.repo.remote

import com.example.countrieskotlin.model.Country
import com.example.countrieskotlin.model.jobs.GitJob
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface GitJobsService {
    @GET("positions.json")
    suspend fun getGitJobs(@Query("description") description: String?, @Query("location") location: String?): Response<List<GitJob>>
}
