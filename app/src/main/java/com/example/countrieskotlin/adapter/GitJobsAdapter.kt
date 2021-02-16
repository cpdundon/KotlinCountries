package com.example.countrieskotlin.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.countrieskotlin.R
import com.example.countrieskotlin.databinding.JokeCardBinding
import com.example.countrieskotlin.databinding.ShortJobCardBinding
import com.example.countrieskotlin.model.Joke
import com.example.countrieskotlin.model.Jokes
import com.example.countrieskotlin.model.jobs.GitJob
import com.example.countrieskotlin.view.JobQueryBuilder
import com.example.countrieskotlin.view.JobsActivity
import com.example.countrieskotlin.view.JokeCardActivity
import com.example.countrieskotlin.viewModel.GitJobsViewModel

class GitJobsAdapter(private val jobs: List<GitJob>) :
    RecyclerView.Adapter<GitJobsAdapter.GitJobsViewHolder>() {
    lateinit var binding: ShortJobCardBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitJobsViewHolder {

        binding = ShortJobCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GitJobsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return jobs.size
    }

    override fun onBindViewHolder(holder: GitJobsViewHolder, position: Int) {
        val gitJob: GitJob = jobs[position]
        holder.setJob(gitJob, position)
        holder.itemView.setOnClickListener(View.OnClickListener { fragmentJump(gitJob) })
    }

    private fun fragmentJump(job: GitJob) {
        val nextFrag = JobQueryBuilder()
        val bundle = Bundle()
        bundle.putParcelable("RV_ITEM", job)
        nextFrag.arguments = bundle
        switchContent(R.id.constraint_query_fragment, nextFrag)
    }

    private fun switchContent(id: Int, fragment: Fragment) {
        val context = binding.root.context ?: return
        if (context is JobsActivity) {
            val jobsActivity = context as JobsActivity
            jobsActivity.switchContent(id, fragment)
        }

    }

    class GitJobsViewHolder(private val binding: ShortJobCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setJob(gitJob: GitJob, position: Int) {
            binding.tvCompany.text = gitJob.company
        }

    }

}
