package com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers

data class ProfessionalPlayersResponse(
    val error: String,
    val resp: String,
    val statistics: List<Statistic>?
)