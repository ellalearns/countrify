package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class MRU(
    val name: String,
    val symbol: String
)