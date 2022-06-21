package com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers

import com.morodaniel.onemanagerapp.network.models.getManager.PlayerResponse
import com.morodaniel.onemanagerapp.objects.PlayersObject
import com.morodaniel.onemanagerapp.objects.StatisticObject

data class Statistic(
    val _class: String,
    val _id: String,
    val player: Player,
    val statistics: List<StatisticX>
)

fun Statistic.toStatisticObject(pos: Int): StatisticObject {
    return StatisticObject(
        _class,
        _id,
        player,
        statistics,
        pos
    )
}

fun List<Statistic>?.toMap(): List<StatisticObject> {
    var pos = -1
    return this?.map {
        pos += 1
        it.toStatisticObject(pos)
    } ?: emptyList()
}