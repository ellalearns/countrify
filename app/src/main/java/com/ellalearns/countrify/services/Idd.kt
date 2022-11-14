package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Idd(
    val root: String,
    val suffixes: List<String>
)