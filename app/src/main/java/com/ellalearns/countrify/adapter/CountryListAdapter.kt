package com.ellalearns.countrify.adapter

import android.app.Activity
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ellalearns.countrify.CountryDetails
import com.ellalearns.countrify.MainActivity
import com.ellalearns.countrify.R
import com.ellalearns.countrify.services.Country
import kotlinx.android.synthetic.main.country_item.view.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import org.json.JSONArray

class CountryListAdapter(val activity: Activity): RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    private var countryList: List<Country>? = null
    private var new_list: List<Country>? = null

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
            Glide.with(itemView).load(data.flags.png).fitCenter().into(homeFlag)
            itemView.setOnClickListener {
                val intent = Intent(activity, CountryDetails::class.java)

                intent.putExtra("flagImage", data.flags.png)
                intent.putExtra("coatOfArmsImage", data.coatOfArms.png)
                intent.putExtra("mapImage", data.maps.googleMaps)
                intent.putExtra("population", data.population)
                intent.putExtra("region", data.region)
                intent.putExtra("capital2", if (data.capital == null) {"no capital"} else {data.capital[0]})
                intent.putExtra("borders", if (data.borders == null) {"no borders"} else {data.borders.toString()})
                intent.putExtra("officialLanguage", if (data.languages == null ) { "no official languages" } else {data.languages.toString()})
                intent.putExtra("demonym", if (data.demonyms.eng.m == null) {"no demonym"} else {data.demonyms.eng.m})
                intent.putExtra("landlocked", if (data.landlocked == null) {"don't know"} else {data.landlocked.toString()})
                intent.putExtra("subRegion", data.subregion)
                intent.putExtra("independent", data.independent.toString())
                intent.putExtra("area", data.area.toString())
                intent.putExtra("currency", data.currencies.toString())
                intent.putExtra("unMember", data.unMember.toString())
                intent.putExtra("timeZone", data.timezones.toString())
                intent.putExtra("startOfWeek", data.startOfWeek)
                intent.putExtra("dialingCode", data.idd.root)
                intent.putExtra("drivingSide", data.car.side)

                activity.startActivity(intent)
            }
        }
    }
}