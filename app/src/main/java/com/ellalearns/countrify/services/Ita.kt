package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Ita(
    val common: String,
    val official: String
)