package com.example.countrieskotlin.view

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.countrieskotlin.databinding.JobsFragmentHolderBinding
import com.example.countrieskotlin.viewModel.GitJobsViewModel

class JobsActivity : AppCompatActivity() {
    private val viewModel by viewModels<GitJobsViewModel>()

    private lateinit var binding: JobsFragmentHolderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JobsFragmentHolderBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        setUpListeners()
        setUpObservers()

    }

    private fun setUpListeners() {
        binding.btnFetch.setOnClickListener(View.OnClickListener {
            viewModel.fetchJobs("Python", "New York")
            true
        })
    }

    private fun setUpObservers() {
        viewModel.jobs.observe(this) { jobsList ->
            if (jobsList != null) Toast.makeText(this, "List size is ${jobsList.size}", Toast.LENGTH_LONG).show()
        }
    }

}