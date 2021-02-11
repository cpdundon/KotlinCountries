package com.example.countrieskotlin.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.countrieskotlin.databinding.JokeCardBinding
import com.example.countrieskotlin.databinding.JokeCardTwoBinding
import com.example.countrieskotlin.databinding.JokesMainBinding
import com.example.countrieskotlin.viewModel.JokesViewModel

class JokeCardTwoActivity : AppCompatActivity() {
    // leverages lazy and extension functions to create viwemodel
    //private val viewModel by viewModels<JokesViewModel>()

    // In kotlin declarations must have a default value
    // To be able to create a Top-Level Declaration with no init value we use [lateinit]
    // contract with compiler that says we promise to initialize this variable before we use it
    private lateinit var binding: JokeCardTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JokeCardTwoBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        //intent = Intent(this, JokeListActivity::class.java)
        binding.tvSetup.text = intent.getStringExtra("SETUP")
        binding.tvDelivery.text = intent.getStringExtra("DELIVERY")

    }
}