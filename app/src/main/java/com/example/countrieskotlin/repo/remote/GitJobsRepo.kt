package com.example.countrieskotlin.repo.remote

import com.example.countrieskotlin.model.Jokes
import com.example.countrieskotlin.model.jobs.GitJob
import com.example.countrieskotlin.repo.remote.JokesRetroInstance
import retrofit2.Response

object GitJobsRepo {
        suspend fun getJobs(description: String?, location: String?) : Response<List<GitJob>> {
                return GitJobsRetroInstance.gitJobsService.getGitJobs(description, location)
        }
}