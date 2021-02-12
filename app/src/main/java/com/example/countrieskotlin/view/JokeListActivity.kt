package com.example.countrieskotlin.view

import android.content.Intent
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
import com.example.countrieskotlin.model.IntentInfo
import com.example.countrieskotlin.model.IntentInfoSerializer
import com.example.countrieskotlin.model.Jokes
import com.example.countrieskotlin.nav.HideShowIconInterface
import com.example.countrieskotlin.viewModel.JokesViewModel
import com.squareup.moshi.JsonClass
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class JokeListActivity : AppCompatActivity(), HideShowIconInterface {
    // leverages lazy and extension functions to create viwemodel
    private val viewModel by viewModels<JokesViewModel>()

    private lateinit var binding: JokeListBinding
    private var gridToggle = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JokeListBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        val tst = Json.encodeToString(IntentInfo("TEST", "JokeCategories"))
        val tObj = Json.decodeFromString<IntentInfo>(tst)

        viewModel.jokes.observe(this) { jokes ->
            Toast.makeText(this, "List size is ${jokes.jokes?.size}", Toast.LENGTH_SHORT).show()
        }

        setUpListeners()
        setUpObservers()
    }

    override fun onResume() {
        super.onResume()
        //showBackIcon(false)
        val fromMain = intent.getBooleanExtra("FROM_MAIN", false)
        val category = intent.getStringExtra("JOKE_CATEGORY")?: "Any"
        if (fromMain) {
            viewModel.fetchJokes(10, "twopart", category)
            intent.putExtra("FROM_MAIN", !fromMain)
            setGridLayoutMgr()
        } else {
            if (viewModel.jokes.value != null) {
                val jokesAdapter = JokesAdapter(viewModel.jokes.value!!)
                binding.rvJokeList.adapter = jokesAdapter
            }
            this.localClassName
        }
    }

    override fun showBackIcon(isOn: Boolean) {
        //mActionBarDrawerToggle.setDrawerIndicatorEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(isOn)
    }

    private fun setUpListeners() {
        binding.btnLayout.setOnClickListener(View.OnClickListener {
            setGridLayoutMgr()
        })

        binding.btnSettings.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, MainJokes::class.java))
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