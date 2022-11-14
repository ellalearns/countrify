package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Slk(
    val common: String,
    val official: String
)