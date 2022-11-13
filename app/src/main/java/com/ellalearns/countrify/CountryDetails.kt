package com.ellalearns.countrify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CountryDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.country_details)

        val countryData = intent
        val population = countryData.getIntExtra("population", 0)
        val populationView : TextView = findViewById(R.id.population)
        populationView.text = population.toString()
    }
}