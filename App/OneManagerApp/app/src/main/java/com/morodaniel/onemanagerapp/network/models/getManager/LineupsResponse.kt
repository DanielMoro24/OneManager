package com.morodaniel.onemanagerapp.network.models.getManager

import com.google.gson.annotations.Expose
import com.morodaniel.onemanagerapp.objects.LineupsObject
import com.morodaniel.onemanagerapp.objects.PlayersObject

data class LineupsResponse(
    @Expose
    val journey: String,
    @Expose
    val playerOne: String,
    @Expose
    val playerTwo: String,
    @Expose
    val playerThree: String,
    @Expose
    val playerFour: String,
    @Expose
    val playerFive: String,
    @Expose
    val playerSix: String,
    @Expose
    val playerSeven: String,
    @Expose
    val playerEight: String,
    @Expose
    val playerNine: String,
    @Expose
    val playerTen: String,
    @Expose
    val playerEleven: String,
    @Expose
    val playerTwelve: String,
    @Expose
    val playerThirteen: String,
    @Expose
    val playerFourteen: String,
    @Expose
    val playerFivteen: String,
    @Expose
    val playerSixteen: String,
    @Expose
    val playerSeventeen: String,
    @Expose
    val playerEighteen: String
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
