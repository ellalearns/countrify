package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Swe(
    val common: String,
    val official: String
)