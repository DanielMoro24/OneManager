package com.morodaniel.onemanagerapp.network.models.getManager

import com.google.gson.annotations.Expose
import com.morodaniel.onemanagerapp.objects.PlayersObject

data class PlayerResponse(
    @Expose
    val name: String,
    @Expose
    val firstname: String,
    @Expose
    val dni: String,
    @Expose
    val age: Int,
    @Expose
    val position: String,
    @Expose
    val height: String,
    @Expose
    val weight: String,
    @Expose
    val goals: Int,
    @Expose
    val assists: Int,
    @Expose
    val yellow: Int,
    @Expose
    val red: Int,
    @Expose
    val appearences: Int,
    @Expose
    val minutes: Int,
    @Expose
    val rating: String
)

fun PlayerResponse.toPlayersObject(): PlayersObject {
    return PlayersObject(
        name,
        firstname,
        dni,
        age,
        position,
        height,
        weight,
        goals,
        assists,
        yellow,
        red,
        appearences,
        minutes,
        rating
    )
}

fun List<PlayerResponse>?.toMap(): List<PlayersObject> {
    return this?.map { it.toPlayersObject() } ?: emptyList()
}
