package com.ellalearns.countrify.services

import retrofit2.Call
import retrofit2.http.GET

interface CountryAPI {

    @GET("/v3.1/all")
    fun getCountries(): Call<List<Country>>

}
