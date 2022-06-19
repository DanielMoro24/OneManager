package com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers

data class Games(
    val _id: String,
    val appearences: Int,
    val captain: Boolean,
    val lineups: Int,
    val minutes: Int,
    val number: Int,
    val position: String,
    val rating: String
)