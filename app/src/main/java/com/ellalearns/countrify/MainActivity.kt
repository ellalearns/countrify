package com.ellalearns.countrify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ellalearns.countrify.adapter.CountryListAdapter
import com.ellalearns.countrify.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: CountryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        rvCountries.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = CountryListAdapter(this)
        rvCountries.adapter = recyclerAdapter
    }

    private fun initViewModel() {
        val viewModel:MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveData().observe(this) {
            if (it != null) {
                recyclerAdapter.setCountryList(it)
                recyclerAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error in getting countries", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.makeAPICall()
    }
}
