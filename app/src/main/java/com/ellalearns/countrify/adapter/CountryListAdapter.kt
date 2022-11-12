package com.ellalearns.countrify.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ellalearns.countrify.R
import com.ellalearns.countrify.services.Country
import kotlinx.android.synthetic.main.country_item.view.*

class CountryListAdapter(val activity: Activity): RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    private var countryList: List<Country>? = null

    fun setCountryList(countryList: List<Country>) {
        this.countryList = countryList.sortedBy { it.name.common }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)

        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countryList?.get(position)!!, activity)
    }

    override fun getItemCount(): Int {
        if (countryList == null) return 0
        else return countryList?.size!!
    }

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val homeFlag = view.homeFlag
        val commonName = view.commonName
        val capital = view.capital

        fun bind(data: Country, activity: Activity) {
            commonName.text = data.name.common
            if (data.capital == null) {capital.text = "no capital"} else {capital.text = data.capital[0]}
//            capital.text = data.region
            Glide.with(itemView).load(data.flags.png).fitCenter().into(homeFlag)
        }
    }
}