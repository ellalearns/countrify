package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class FraX(
    val common: String,
    val official: String
)