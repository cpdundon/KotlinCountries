package com.example.countrieskotlin.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.countrieskotlin.databinding.CountryCardBinding
import com.example.countrieskotlin.databinding.JokeCardBinding
import com.example.countrieskotlin.model.Country
import com.example.countrieskotlin.model.Joke
import com.example.countrieskotlin.model.Jokes
import com.example.countrieskotlin.view.JokeCardActivity
import com.example.countrieskotlin.view.JokeCardTwoActivity
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class JokesAdapter(private val jokes: Jokes) :
    RecyclerView.Adapter<JokesAdapter.JokesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {

        val binding: JokeCardBinding = JokeCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return JokesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return jokes.jokes?.size?: 0
    }

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        if (jokes.jokes != null) {
            val joke: Joke = jokes.jokes[position]
            holder.setJoke(joke)
        }
    }

    class JokesViewHolder(private val binding: JokeCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setJoke(joke: Joke) {

            binding.tvSetup.text = joke.setup
            setListeners(joke)
        }

        private fun setListeners(joke: Joke) {
            binding.tvSetup.setOnClickListener(View.OnClickListener { goToDetailActivity(joke) })
        }

        private fun goToDetailActivity(joke: Joke) {

            val intent = Intent(binding.root.context, JokeCardActivity::class.java)

            intent.putExtra("SETUP", joke.setup)
            intent.putExtra("DELIVERY", joke.delivery)

            binding.root.context.startActivity(intent)
        }

    }

}
