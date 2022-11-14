package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Pol(
    val common: String,
    val official: String
)