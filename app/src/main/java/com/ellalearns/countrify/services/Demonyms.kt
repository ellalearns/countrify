package com.ellalearns.countrify.services

import kotlinx.serialization.Serializable

@Serializable
data class Demonyms(
    val eng: Eng,
    val fra: Fra
)