package com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers

data class Player(
    val age: Int,
    val birth: Birth,
    val firstname: String,
    val height: String,
    val injured: Boolean,
    val lastname: String,
    val name: String,
    val nationality: String,
    val photo: String,
    val weight: String
)