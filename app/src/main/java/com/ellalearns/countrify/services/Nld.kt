package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Nld(
    val common: String,
    val official: String
)