package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Fin(
    val common: String,
    val official: String
)