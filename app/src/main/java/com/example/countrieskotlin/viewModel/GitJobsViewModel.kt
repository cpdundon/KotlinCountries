package com.example.countrieskotlin.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrieskotlin.model.Country
import com.example.countrieskotlin.model.Jokes
import com.example.countrieskotlin.model.jobs.GitJob
import com.example.countrieskotlin.repo.CountryRepo
import com.example.countrieskotlin.repo.JokesRepo
import com.example.countrieskotlin.repo.remote.GitJobsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitJobsViewModel : ViewModel() {
    companion object {
        private const val TAG = "GitJobsViewModel"
    }

    private val _jobs = MutableLiveData<List<GitJob>>()

    val jobs: LiveData<List<GitJob>>
        get() = _jobs

    fun fetchJobs(description: String?, location: String?) {
        viewModelScope.launch(Dispatchers.IO) {
        val jobs = GitJobsRepo.getJobs(description, location)
            _jobs.postValue(jobs.body())
        }
    }
}