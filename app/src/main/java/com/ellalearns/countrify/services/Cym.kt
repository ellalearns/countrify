package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Cym(
    val common: String,
    val official: String
)