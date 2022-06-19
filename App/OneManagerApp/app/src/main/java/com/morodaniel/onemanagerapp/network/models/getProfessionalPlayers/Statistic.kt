package com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers

data class Statistic(
    val _class: String,
    val _id: String,
    val player: Player,
    val statistics: List<StatisticX>
)