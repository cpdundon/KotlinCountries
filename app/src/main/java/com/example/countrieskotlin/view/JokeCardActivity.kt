package com.example.countrieskotlin.view

import android.R
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.countrieskotlin.databinding.JokeCardBinding


class JokeCardActivity : AppCompatActivity() {
    // leverages lazy and extension functions to create viwemodel
    //private val viewModel by viewModels<JokesViewModel>()

    // In kotlin declarations must have a default value
    // To be able to create a Top-Level Declaration with no init value we use [lateinit]
    // contract with compiler that says we promise to initialize this variable before we use it
    private lateinit var binding: JokeCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JokeCardBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding.tvSetup.text = intent.getStringExtra("SETUP")
        binding.tvDelivery.text = intent.getStringExtra("DELIVERY")

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}