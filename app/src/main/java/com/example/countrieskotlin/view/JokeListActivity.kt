package com.example.countrieskotlin.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countrieskotlin.adapter.JokesAdapter
import com.example.countrieskotlin.databinding.JokeListBinding
import com.example.countrieskotlin.model.Jokes
import com.example.countrieskotlin.viewModel.JokesViewModel

class JokeListActivity : AppCompatActivity() {
    // leverages lazy and extension functions to create viwemodel
    private val viewModel by viewModels<JokesViewModel>()

    // In kotlin declarations must have a default value
    // To be able to create a Top-Level Declaration with no init value we use [lateinit]
    // contract with compiler that says we promise to initialize this variable before we use it
    private lateinit var binding: JokeListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JokeListBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        viewModel.jokes.observe(this) { jokes ->
            Toast.makeText(this, "List size is ${jokes.jokes?.size}", Toast.LENGTH_SHORT).show()
        }

//        setUpListeners()
        setUpObservers()
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchJokes(8,"twopart")
        setGridLayoutMgr(false)
    }

    private fun setUpListeners() {
//        binding.btnFetch.setOnClickListener(View.OnClickListener { reload() })

//        binding.etQuery.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
//            if (keyCode == 66) {
//                reload()
//                return@OnKeyListener true
//            }
//            false
//        })
    }

    private fun setUpObservers() {
        viewModel.jokes.observe(this,
            Observer<Jokes> {
                val jokesAdapter = JokesAdapter(it)
                binding.rvJokeList.adapter = jokesAdapter
            })
    }

    private fun setGridLayoutMgr(grid: Boolean) {
        if (grid) {
            val gridLayoutManager = GridLayoutManager(this, 3)
            binding.rvJokeList.layoutManager = gridLayoutManager
        } else {
            val linearLayoutManager = LinearLayoutManager(this)
            binding.rvJokeList.layoutManager = linearLayoutManager
        }
    }
}