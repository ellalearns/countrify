package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Urd(
    val common: String,
    val official: String
)