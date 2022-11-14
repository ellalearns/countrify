package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val common: String,
    val nativeName: NativeName,
    val official: String
)