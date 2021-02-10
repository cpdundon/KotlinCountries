package com.example.countrieskotlin.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.countrieskotlin.databinding.CountryCardBinding
import com.example.countrieskotlin.viewModel.CountryViewModel

class CountryCardActivity : AppCompatActivity() {
    private var viewModel: CountryViewModel? = null
    private lateinit var binding: CountryCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CountryCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)

//        setUpObservers();
//        setUpListeners();
//        viewModel.fetchCountries()
    }
}