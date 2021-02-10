package com.example.countrieskotlin.repo.remote

import com.example.countrieskotlin.model.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface CountryService {
    @GET("{country}")
    fun getCountries(@Path("country") country: String?): Call<List<Country>>
}
