package com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers

data class Penalty(
    val _id: String,
    val commited: Int,
    val missed: Int,
    val saved: Int,
    val scored: Int,
    val won: Int
)