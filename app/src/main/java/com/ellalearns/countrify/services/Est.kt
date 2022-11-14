package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Est(
    val common: String,
    val official: String
)