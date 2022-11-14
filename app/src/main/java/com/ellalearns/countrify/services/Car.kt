package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Car(
    val side: String,
    val signs: List<String>
)