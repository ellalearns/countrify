package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Spa(
    val common: String,
    val official: String
)