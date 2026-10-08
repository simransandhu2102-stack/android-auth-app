package com.practice.happypets.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PetsResponse(
    @SerialName("pets")
    val pets: List<Pet> = emptyList()
)

@Serializable
data class Pet(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
)
