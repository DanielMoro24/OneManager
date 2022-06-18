package com.morodaniel.onemanagerapp.network.models.getManager

import com.google.gson.annotations.Expose
import com.morodaniel.onemanagerapp.objects.PlayersObject

data class PlayerResponse(
    @Expose
    var name: String,
    @Expose
    var firstname: String,
    @Expose
    var dni: String,
    @Expose
    var age: Int,
    @Expose
    var position: String,
    @Expose
    var height: String,
    @Expose
    var weight: String,
    @Expose
    var goals: Int,
    @Expose
    var assists: Int,
    @Expose
    var yellow: Int,
    @Expose
    var red: Int,
    @Expose
    var appearences: Int,
    @Expose
    var minutes: Int,
    @Expose
    var rating: String
)

fun PlayerResponse.toPlayersObject(pos: Int): PlayersObject {
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
        rating,
        pos
    )
}

fun List<PlayerResponse>?.toMap(): List<PlayersObject> {
    var pos = -1
    return this?.map {
        pos += 1
        it.toPlayersObject(pos)
    } ?: emptyList()
}
