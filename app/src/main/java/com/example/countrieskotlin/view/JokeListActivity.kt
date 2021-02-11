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
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.Json.Default.decodeFromString
import kotlinx.serialization.json.Json.Default.encodeToString

class JokeListActivity : AppCompatActivity() {
    // leverages lazy and extension functions to create viwemodel
    private val viewModel by viewModels<JokesViewModel>()

    private lateinit var binding: JokeListBinding
    private var gridToggle = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JokeListBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        viewModel.jokes.observe(this) { jokes ->
            Toast.makeText(this, "List size is ${jokes.jokes?.size}", Toast.LENGTH_SHORT).show()
        }

        setUpListeners()
        setUpObservers()
    }

    override fun onResume() {
        super.onResume()

        val fromMain = intent.getBooleanExtra("FROM_MAIN", false)
        val category = intent.getStringExtra("JOKE_CATEGORY")?: "Any"
        if (fromMain) {
            viewModel.fetchJokes(10, "twopart", category)
            intent.putExtra("FROM_MAIN", !fromMain)
            setGridLayoutMgr()
        } else {
            val jokesAdapter = JokesAdapter(viewModel.jokes.value!!)
            binding.rvJokeList.adapter = jokesAdapter
        }
    }

    private fun setUpListeners() {
            binding.btnLayout.setOnClickListener(View.OnClickListener {
            setGridLayoutMgr()
        })
    }

    private fun setUpObservers() {
        viewModel.jokes.observe(this,
            Observer<Jokes> {
                val jokesAdapter = JokesAdapter(it)
                binding.rvJokeList.adapter = jokesAdapter
            })
    }

    private fun setGridLayoutMgr() {
        if (gridToggle) {
            val gridLayoutManager = GridLayoutManager(this, 3)
            binding.rvJokeList.layoutManager = gridLayoutManager
        } else {
            val linearLayoutManager = LinearLayoutManager(this)
            binding.rvJokeList.layoutManager = linearLayoutManager
        }
        gridToggle = !gridToggle
    }
}