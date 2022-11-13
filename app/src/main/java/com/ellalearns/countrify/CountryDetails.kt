package com.ellalearns.countrify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.country_details.*

class CountryDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.country_details)

        val countryData = intent

        val flagImage = countryData.getStringExtra("flagImage")
        val flagView : ImageView = findViewById(R.id.flagImage)
        Glide.with(flagView).load(flagImage).into(flagView)

        val coatOfArmsImage = countryData.getStringExtra("coatOfArmsImage")
        val coatOfArmsView : ImageView = findViewById(R.id.coatOfArmsImage)
        Glide.with(coatOfArmsView).load(coatOfArmsImage).into(coatOfArmsView)

        val mapImage = countryData.getStringExtra("mapImage")
        val mapView : ImageView = findViewById(R.id.mapImage)
        Glide.with(mapView).load(mapImage).into(mapView)

        val population = countryData.getIntExtra("population", 0)
        val populationView : TextView = findViewById(R.id.population)
        populationView.text = population.toString()

        val region = countryData.getStringExtra("region")
        val regionView : TextView = findViewById(R.id.region)
        regionView.text = region

        val capital = countryData.getStringExtra("capital2")
        val capitalView : TextView = findViewById(R.id.capital2)
        capitalView.text = capital

        val borders = countryData.getStringExtra("borders")
        val bordersView : TextView = findViewById(R.id.borders)
        bordersView.text = borders

        val spaceView1 : TextView = findViewById(R.id.space1)
        spaceView1.text = " "

        val officialLanguage = countryData.getStringExtra("officialLanguage")
        val languageView : TextView = findViewById(R.id.officialLanguage)
        languageView.text = officialLanguage

        val demonym = countryData.getStringExtra("demonym")
        val demonymView : TextView = findViewById(R.id.demonym)
        demonymView.text = demonym

        val landlocked = countryData.getStringExtra("landlocked")
        val landlockedView : TextView = findViewById(R.id.landlocked)
        landlockedView.text = landlocked

        val subRegion = countryData.getStringExtra("subRegion")
        val subRegionView : TextView = findViewById(R.id.subRegion)
        subRegionView.text = subRegion

        val spaceView2 : TextView = findViewById(R.id.space2)
        spaceView2.text = " "

        val independent = countryData.getStringExtra("independent")
        val independentView : TextView = findViewById(R.id.independent)
        independentView.text = independent

        val area = countryData.getStringExtra("area")
        val areaView : TextView = findViewById(R.id.area)
        areaView.text = area

        val currency = countryData.getStringExtra("currency")
        val currencyView : TextView = findViewById(R.id.currency)
        currencyView.text = currency

        val unMember = countryData.getStringExtra("unMember")
        val unMemberView : TextView = findViewById(R.id.unMember)
        unMemberView.text = unMember

        val spaceView3 : TextView = findViewById(R.id.space3)
        spaceView3.text = (" ")

        val timeZone = countryData.getStringExtra("timeZone")
        val timeZoneView : TextView = findViewById(R.id.timeZone)
        timeZoneView.text = timeZone

        val startOfWeek = countryData.getStringExtra("startOfWeek")
        val startOfWeekView : TextView = findViewById(R.id.startOfWeek)
        startOfWeekView.text = startOfWeek

        val dialingCode = countryData.getStringExtra("dialingCode")
        val dialingCodeView : TextView = findViewById(R.id.diallingCode)
        dialingCodeView.text = dialingCode

        val drivingSide = countryData.getStringExtra("drivingSide")
        val drivingSideView : TextView = findViewById(R.id.drivingSide)
        drivingSideView.text = drivingSide

        val spaceView4 : TextView = findViewById(R.id.space4)
        spaceView4.text = " "
    }
}