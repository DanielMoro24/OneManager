package com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers

data class Goals(
    val _id: String,
    val assists: Int,
    val conceded: Int,
    val saves: Int,
    val total: Int
)