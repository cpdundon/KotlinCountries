package com.example.countrieskotlin.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.countrieskotlin.R
import com.example.countrieskotlin.databinding.JokesMainBinding
import com.example.countrieskotlin.databinding.SplashScreenBinding
import com.example.countrieskotlin.viewModel.JokesViewModel
import io.reactivex.internal.schedulers.SchedulerPoolFactory.start

class SplashActivity : AppCompatActivity() {
        // leverages lazy and extension functions to create viwemodel
        //private val viewModel by viewModels<JokesViewModel>()

        // In kotlin declarations must have a default value
        // To be able to create a Top-Level Declaration with no init value we use [lateinit]
        // contract with compiler that says we promise to initialize this variable before we use it
        private lateinit var binding: SplashScreenBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            setTheme(R.style.Theme_CountriesKotlin_Launcher)
            super.onCreate(savedInstanceState)
            binding = SplashScreenBinding.inflate(layoutInflater).also {
                setContentView(it.root)
            }

            intent = Intent(this, JobsActivity::class.java)
            startActivity(intent)
            finish()
        }

    override fun onResume() {
        super.onResume()

//        intent = Intent(this, JobsActivity::class.java)
//        startActivity(intent)
//        finish()
    }
}