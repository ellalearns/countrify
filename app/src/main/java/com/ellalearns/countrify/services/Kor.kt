package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Kor(
    val common: String,
    val official: String
)