package com.example.countrieskotlin.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.countrieskotlin.databinding.JokesMainBinding
import com.example.countrieskotlin.viewModel.JokesViewModel

class MainJokes : AppCompatActivity() {
    // leverages lazy and extension functions to create viwemodel
    private val viewModel by viewModels<JokesViewModel>()

    // In kotlin declarations must have a default value
    // To be able to create a Top-Level Declaration with no init value we use [lateinit]
    // contract with compiler that says we promise to initialize this variable before we use it
    private lateinit var binding: JokesMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JokesMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        viewModel.jokes.observe(this) { jokes ->
            Toast.makeText(this, "List size is ${jokes.amount}", Toast.LENGTH_SHORT).show()
        }

        setUpListeners()
//        setUpObservers()
        viewModel.fetchJokes(10, "twopart")
//        setGridLayoutMgr(false)

    }

    private fun setUpListeners() {
        binding.btnFetch.setOnClickListener(View.OnClickListener { openJokeList() })

//        binding.etQuery.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
//            if (keyCode == 66) {
//                reload()
//                return@OnKeyListener true
//            }
//            false
//        })
    }
//
//    private fun setUpObservers() {
//        viewModel.countries.observe(this,
//            Observer<List<Country>?> {
//                binding.tvRtnTime.text = System.currentTimeMillis().toString()
//                val countryAdapter = CountryAdapter(it)
//                binding.rvImageList.adapter = countryAdapter
//            })
//    }
//
//    private fun setGridLayoutMgr(grid: Boolean) {
//        if (grid) {
//            val gridLayoutManager = GridLayoutManager(this, 3)
//            binding.rvImageList.layoutManager = gridLayoutManager
//        } else {
//            val linearLayoutManager = LinearLayoutManager(this)
//            binding.rvImageList.layoutManager = linearLayoutManager
//        }
//    }
//
    private fun openJokeList() {
        intent = Intent(this, JokeListActivity::class.java)
        intent.putExtra("TEST_KEY", "TEST_VALUE")
        startActivity(intent)
//            intent.putExtra(Constants.INTENT_KEY_PHOTOGRAPHER, photo.photographer)
//            intent.putExtra(Constants.INTENT_KEY_PHOTOGRAPHER_URL, photo.photographer_url)
//
        //binding.root.context.startActivity(intent)
    }
}