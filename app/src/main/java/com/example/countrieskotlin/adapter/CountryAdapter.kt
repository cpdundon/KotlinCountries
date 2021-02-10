package com.example.countrieskotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.countrieskotlin.databinding.CountryCardBinding
import com.example.countrieskotlin.model.Country
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class CountryAdapter(countries: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    private val countries: List<Country> = countries

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding: CountryCardBinding = CountryCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country: Country = countries[position]
        holder.setCountry(country)
    }

    class CountryViewHolder(binding: CountryCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val binding: CountryCardBinding = binding
        fun setCountry(country: Country) {
            val imgFlag: ImageView = binding.ivFlag
            val requestBuilder = GlideToVectorYou
                .init()
                .with(binding.root.context)
                .requestBuilder
            requestBuilder
                .load(country.flag)
                .into(imgFlag)

            //Glide.with(this.itemView).load(country.getFlag()).into(imgFlag);
            binding.tvCountryName.setText(country.name)
            setListeners(country)
        }

        private fun setListeners(country: Country) {
            binding.ivFlag.setOnClickListener(View.OnClickListener { goToDetailActivity(country) })
        }

        private fun goToDetailActivity(country: Country) {

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
