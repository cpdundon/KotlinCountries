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

        setUpListeners()
    }

    private fun setUpListeners() {
        binding.btnFetch.setOnClickListener(View.OnClickListener { openJokeList() })
    }

    private fun openJokeList() {
        intent = Intent(this, JokeListActivity::class.java)
        intent.putExtra("TEST", "BUTTON TEST")
        startActivity(intent)
//            intent.putExtra(Constants.INTENT_KEY_PHOTOGRAPHER, photo.photographer)
//            intent.putExtra(Constants.INTENT_KEY_PHOTOGRAPHER_URL, photo.photographer_url)
//
        //binding.root.context.startActivity(intent)
    }
}