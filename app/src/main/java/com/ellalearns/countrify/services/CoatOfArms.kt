package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class CoatOfArms(
    val png: String,
    val svg: String
)