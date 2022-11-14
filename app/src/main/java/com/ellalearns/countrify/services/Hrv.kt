package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Hrv(
    val common: String,
    val official: String
)