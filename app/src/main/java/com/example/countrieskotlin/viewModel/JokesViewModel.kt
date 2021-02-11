package com.example.countrieskotlin.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrieskotlin.model.Country
import com.example.countrieskotlin.model.Jokes
import com.example.countrieskotlin.repo.CountryRepo
import com.example.countrieskotlin.repo.JokesRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokesViewModel : ViewModel() {
    companion object {
        private const val TAG = "JokesViewModel"
    }

    private val _jokes = MutableLiveData<Jokes>()

    val jokes: LiveData<Jokes>
        get() = _jokes

    fun fetchJokes(amount: Int, type: String) {
        viewModelScope.launch(Dispatchers.Main) {
        val jokes = JokesRepo.getJokes(amount, type)
            _jokes.value = jokes.body()
        }
    }
}