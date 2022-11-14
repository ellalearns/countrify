package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Ces(
    val common: String,
    val official: String
)