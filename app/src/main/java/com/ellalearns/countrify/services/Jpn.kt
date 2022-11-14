package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Jpn(
    val common: String,
    val official: String
)