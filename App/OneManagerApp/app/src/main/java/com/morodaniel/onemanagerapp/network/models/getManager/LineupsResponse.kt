package com.morodaniel.onemanagerapp.network.models.getManager

import com.google.gson.annotations.Expose
import com.morodaniel.onemanagerapp.objects.LineupsObject
import com.morodaniel.onemanagerapp.objects.PlayersObject

data class LineupsResponse(
    @Expose
    var journey: String,
    @Expose
    var playerOne: String,
    @Expose
    var playerTwo: String,
    @Expose
    var playerThree: String,
    @Expose
    var playerFour: String,
    @Expose
    var playerFive: String,
    @Expose
    var playerSix: String,
    @Expose
    var playerSeven: String,
    @Expose
    var playerEight: String,
    @Expose
    var playerNine: String,
    @Expose
    var playerTen: String,
    @Expose
    var playerEleven: String,
    @Expose
    var playerTwelve: String,
    @Expose
    var playerThirteen: String,
    @Expose
    var playerFourteen: String,
    @Expose
    var playerFivteen: String,
    @Expose
    var playerSixteen: String,
    @Expose
    var playerSeventeen: String,
    @Expose
    var playerEighteen: String
)

fun LineupsResponse.toLineupObject(pos: Int): LineupsObject {
    return LineupsObject(
        journey,
        playerOne,
        playerTwo,
        playerThree,
        playerFour,
        playerFive,
        playerSix,
        playerSeven,
        playerEight,
        playerNine,
        playerTen,
        playerEleven,
        playerTwelve,
        playerThirteen,
        playerFourteen,
        playerFivteen,
        playerSixteen,
        playerSeventeen,
        playerEighteen,
        pos
    )
}

fun List<LineupsResponse>?.toMap(): List<LineupsObject> {
    var pos = -1
    return this?.map {
        pos += 1
        it.toLineupObject(pos)
    } ?: emptyList()
}
