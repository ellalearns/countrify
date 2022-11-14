package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Flags(
    val png: String,
    val svg: String
)