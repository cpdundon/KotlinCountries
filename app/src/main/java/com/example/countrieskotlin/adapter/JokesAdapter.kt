package com.example.countrieskotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countrieskotlin.databinding.CountryCardBinding
import com.example.countrieskotlin.databinding.JokeCardBinding
import com.example.countrieskotlin.model.Country
import com.example.countrieskotlin.model.Joke
import com.example.countrieskotlin.model.Jokes
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

//            Intent intent = new Intent(binding.getRoot().getContext(), DetailView.class);
//
//            intent.putExtra(Constants.INTENT_KEY_PHOTO_URL, photo.src.medium);
//            intent.putExtra(Constants.INTENT_KEY_PHOTOGRAPHER, photo.photographer);
//            intent.putExtra(Constants.INTENT_KEY_PHOTOGRAPHER_URL, photo.photographer_url);
//
//            binding.getRoot().getContext().startActivity(intent);
        }

    }

}
