package com.morodaniel.onemanagerapp.objects

import com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers.Player
import com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers.StatisticX

data class StatisticObject(
    val _class: String,
    val _id: String,
    val player: Player,
    val statistics: List<StatisticX>,
    val pos: Int
)
