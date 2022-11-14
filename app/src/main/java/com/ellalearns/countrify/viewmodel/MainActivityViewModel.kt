package com.ellalearns.countrify.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ellalearns.countrify.services.Country
import com.ellalearns.countrify.services.CountryAPI
import com.ellalearns.countrify.services.RetrofitInstance
import okhttp3.internal.filterList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    var countryList = mutableListOf<Country>()
    lateinit var liveDataList: MutableLiveData<List<Country>>
    lateinit var searchDataList: MutableLiveData<List<Country>>

    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveData(): MutableLiveData<List<Country>> {
        return liveDataList
    }

    fun searchCountryList(query: String) {
        val filteredCountries = countryList.filter {country: Country ->
            (country.name.common).contains(query, ignoreCase = true,)
        }
        liveDataList.postValue(filteredCountries)
    }

    fun makeAPICall() {
        val retrofitInstance = RetrofitInstance.getRetrofitInstance()
        val retroService = retrofitInstance.create(CountryAPI::class.java)
        val call = retroService.getCountries()
        call.enqueue(object : Callback<List<Country>> {
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                liveDataList.postValue(response.body())
            }
        })
    }
}
