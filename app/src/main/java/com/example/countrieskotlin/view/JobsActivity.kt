package com.example.countrieskotlin.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.countrieskotlin.R
import com.example.countrieskotlin.databinding.JobsFragmentHolderBinding
import com.example.countrieskotlin.model.jobs.GitJob
import com.example.countrieskotlin.viewModel.GitJobsViewModel

class JobsActivity : AppCompatActivity() {
    lateinit var binding : JobsFragmentHolderBinding
    private val viewModel by viewModels<GitJobsViewModel>()
    private lateinit var jobs: List<GitJob>
    private lateinit var jobLocation : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JobsFragmentHolderBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        loadFragment()

        //TODO: Get the description from the fragment
        viewModel.jobs.observe(this, Observer<List<GitJob>> {
            it
            jobs = it
        })

    }
    private fun loadFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.jobs_container, JobQueryBuilder.newInstance(), "SearchFragment")
            .commit()
    }

    public fun switchContent(id: Int, fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(id, fragment, fragment.toString())
        ft.addToBackStack(null)
        ft.commit()
    }
}