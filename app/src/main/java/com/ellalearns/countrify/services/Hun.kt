package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Hun(
    val common: String,
    val official: String
)