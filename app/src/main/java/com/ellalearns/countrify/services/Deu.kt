package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Deu(
    val common: String,
    val official: String
)