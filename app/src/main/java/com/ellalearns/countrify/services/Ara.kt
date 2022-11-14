package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Ara(
    val common: String,
    val official: String
)