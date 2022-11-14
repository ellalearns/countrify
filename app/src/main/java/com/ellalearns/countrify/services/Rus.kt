package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Rus(
    val common: String,
    val official: String
)