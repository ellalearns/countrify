package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Tur(
    val common: String,
    val official: String
)