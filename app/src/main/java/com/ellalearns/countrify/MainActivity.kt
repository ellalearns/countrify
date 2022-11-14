package com.ellalearns.countrify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.cardview.widget.CardView
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
        supportActionBar?.setTitle("Explore.")

        setupSearchView()

        initRecyclerView()
        initViewModel()

        val button = findViewById<CardView>(R.id.langs)

        button.setOnClickListener {
            setContentView(R.layout.lang_dialog)
        }

    }

    private fun initRecyclerView() {
        rvCountries.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = CountryListAdapter(this)
        rvCountries.adapter = recyclerAdapter
    }

    private fun initViewModel() {
        val viewModel: MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveData().observe(this) {
            if (it != null) {
                recyclerAdapter.setCountryList(it)
                recyclerAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Network error getting countries.", Toast.LENGTH_LONG).show()
            }
        }
        viewModel.makeAPICall()
    }


    fun setupSearchView() {
        val searchView: SearchView = findViewById(R.id.searchCountry)
        val viewModel: MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.searchCountryList(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.searchCountryList(newText)
                return false
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.explore, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mode -> {
                setContentView(R.layout.homenight)
                initRecyclerView()
                initViewModel()
                return true
            }
            else -> {
                setContentView(R.layout.activity_main)
                return false
            }
        }
    }



}
