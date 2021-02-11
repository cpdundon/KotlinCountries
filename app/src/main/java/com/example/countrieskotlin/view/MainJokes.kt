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

    override fun onResume() {
        super.onResume()
        binding.rdoDark.isSelected = true
    }

    private fun setUpListeners() {
        binding.btnFetch.setOnClickListener(View.OnClickListener {
            openJokeList()
            true
        })
    }

    private fun openJokeList() {
        val category = when {
            binding.rdoChristmas.isChecked -> {
                "Christmas"
            }
            binding.rdoMisc.isChecked -> {
                "Miscellaneous"
            }
            binding.rdoProgram.isChecked -> {
                "Programming"
            }
            binding.rdoPun.isChecked -> {
                "Pun"
            }
            binding.rdoSpooky.isChecked -> {
                "Spooky"
            }
            else -> {
                "Dark"
            }
        }

        intent = Intent(this, JokeListActivity::class.java)
        intent.putExtra("JOKE_CATEGORY", category)
        intent.putExtra("FROM_MAIN", true)
        startActivity(intent)
    }
}