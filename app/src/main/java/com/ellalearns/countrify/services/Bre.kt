package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Bre(
    val common: String,
    val official: String
)