package com.example.countrieskotlin.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrieskotlin.model.Country
import com.example.countrieskotlin.repo.CountryRepo

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryViewModel : ViewModel() {
    companion object {
        private const val TAG = "CountryViewModel"
    }

    private val _countries = MutableLiveData<List<Country>>()

    val countries: LiveData<List<Country>>
        get() = _countries

    init {
        fetchCountries("ireland")
    }

    fun fetchCountries(name: String) {
        val callback : Callback<List<Country>> = object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                _countries.value = response.body()
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.e(TAG, "onFailure: ", t)
            }
        }
        CountryRepo.countryService.getCountries(name).enqueue(callback)
    }
}