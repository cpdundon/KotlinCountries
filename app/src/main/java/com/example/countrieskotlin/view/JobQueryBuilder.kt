package com.example.countrieskotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countrieskotlin.R
import com.example.countrieskotlin.adapter.GitJobsAdapter
import com.example.countrieskotlin.adapter.JokesAdapter
import com.example.countrieskotlin.databinding.FragmentJobQueryBuilderBinding
import com.example.countrieskotlin.model.Jokes
import com.example.countrieskotlin.model.jobs.GitJob
import com.example.countrieskotlin.viewModel.GitJobsViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [JobQueryBuilder.newInstance] factory method to
 * create an instance of this fragment.
 */
class JobQueryBuilder : Fragment() {
    private lateinit var binding: FragmentJobQueryBuilderBinding
    private var description :String? = null
    private var location :String? = null
    private val viewModel by activityViewModels<GitJobsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
              inflater: LayoutInflater, container: ViewGroup?,
              savedInstanceState: Bundle?
    ) = FragmentJobQueryBuilderBinding.inflate(inflater, container, false)
        .also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnFetch.setOnClickListener {
            viewModel.fetchJobs(binding.etDescription.text.toString().trim(), binding.etLocation.text.toString().trim())
        }
        setUpObservers()
        setGridLayoutMgr()
    }

    private fun setUpObservers() {
        viewModel.jobs.observe(viewLifecycleOwner,
            Observer<List<GitJob>> {
                val jobsAdapter = GitJobsAdapter(it)
                binding.rvJobs.adapter = jobsAdapter
            })
    }

    private fun setGridLayoutMgr(gridToggle: Boolean = false) {
        if (gridToggle) {
            val gridLayoutManager = GridLayoutManager(binding.root.context, 3)
            binding.rvJobs.layoutManager = gridLayoutManager
        } else {
            val linearLayoutManager = LinearLayoutManager(binding.root.context)
            binding.rvJobs.layoutManager = linearLayoutManager
        }
//        gridToggle = !gridToggle
    }

    companion object {
        @JvmStatic
        fun newInstance() = JobQueryBuilder().apply {
            arguments = Bundle()
        }
    }
}