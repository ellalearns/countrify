package com.ellalearns.countrify

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ellalearns.countrify.databinding.CountryItemBinding
import com.ellalearns.countrify.services.Country
import kotlinx.android.synthetic.main.country_item.view.*

class CountryListAdapter : RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(val binding: CountryItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.capital == newItem.capital
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var countries: List<Country>
        get() = differ.currentList
        set(value) { differ.submitList(value) }

    override fun getItemCount() = countries.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(CountryItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.binding.apply {
            val country = countries[position]
            capital.text = country.capital[0]
            commonName.text = country.name.common
            Glide.with(holder.itemView.getContext()).load(country.flags.png).into(homeFlag)
        }
    }
}