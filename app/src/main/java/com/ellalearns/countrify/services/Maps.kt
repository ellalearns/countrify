package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Maps(
    val googleMaps: String,
    val openStreetMaps: String
)