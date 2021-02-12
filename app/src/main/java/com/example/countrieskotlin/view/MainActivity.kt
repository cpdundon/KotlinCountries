package com.example.countrieskotlin.view

import android.os.Bundle
import android.provider.SyncStateContract
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countrieskotlin.adapter.CountryAdapter
import com.example.countrieskotlin.databinding.ActivityMainBinding
import com.example.countrieskotlin.model.Country
import com.example.countrieskotlin.viewModel.CountryViewModel

class MainActivity : AppCompatActivity() {
    // leverages lazy and extension functions to create viwemodel
    private val viewModel by viewModels<CountryViewModel>()

    // In kotlin declarations must have a default value
    // To be able to create a Top-Level Declaration with no init value we use [lateinit]
    // contract with compiler that says we promise to initialize this variable before we use it
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        viewModel.countries.observe(this) { countryList ->
            Toast.makeText(this, "List size is ${countryList.size}", Toast.LENGTH_SHORT).show()
        }

        setUpListeners()
        setUpObservers()
        viewModel.fetchCountries("ireland")
        setGridLayoutMgr(false)

    }

    private fun setUpListeners() {
        binding.btnFetch.setOnClickListener(View.OnClickListener { reload() })

        binding.etQuery.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == 66) {
                reload()
                return@OnKeyListener true
            }
            false
        })
    }

    private fun setUpObservers() {
        viewModel.countries.observe(this,
            Observer<List<Country>?> {
                binding.tvRtnTime.text = System.currentTimeMillis().toString()
                val countryAdapter = CountryAdapter(it)
                binding.rvImageList.adapter = countryAdapter
            })
    }

    private fun setGridLayoutMgr(grid: Boolean) {
        if (grid) {
            val gridLayoutManager = GridLayoutManager(this, 3)
            binding.rvImageList.layoutManager = gridLayoutManager
        } else {
            val linearLayoutManager = LinearLayoutManager(this)
            binding.rvImageList.layoutManager = linearLayoutManager
        }
    }

    private fun reload() {
        var entered = (binding.etQuery as AppCompatEditText).text.toString().trim { it <= ' ' }
        if (entered == "") entered = "lighthouse"
        viewModel.fetchCountries(entered)
    }
}