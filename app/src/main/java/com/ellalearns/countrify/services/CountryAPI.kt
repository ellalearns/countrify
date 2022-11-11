package com.ellalearns.countrify.services

import retrofit2.Response
import retrofit2.http.GET

interface CountryAPI {

    @GET("/v3.1/all")
    suspend fun getCountries(): Response<List<Country>>

}
