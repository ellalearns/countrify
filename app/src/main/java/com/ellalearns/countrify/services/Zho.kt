package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Zho(
    val common: String,
    val official: String
)