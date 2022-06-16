package com.morodaniel.onemanagerapp.network.models.register

data class RegisterRequest(
    val name: String,
    val firstname: String,
    val dni: String,
    val team: String,
    val pass: String,
    val players: List<PlayerRegisterRequest>,
    val lineups: List<LineupsRegisterRequest>
)

data class PlayerRegisterRequest(
    val name: String,
    val firstname: String,
    val dni: String,
    val age: Int,
    val position: String,
    val height: String,
    val weight: String,
    val goals: Int,
    val assists: Int,
    val yellow: Int,
    val red: Int,
    val appearences: Int,
    val minutes: Int,
    val rating: String
)

data class LineupsRegisterRequest(
    val journey: String,
    val playerOne: String,
    val playerTwo: String,
    val playerThree: String,
    val playerFour: String,
    val playerFive: String,
    val playerSix: String,
    val playerSeven: String,
    val playerEight: String,
    val playerNine: String,
    val playerTen: String,
    val playerEleven: String,
    val playerTwelve: String,
    val playerThirteen: String,
    val playerFourteen: String,
    val playerFivteen: String,
    val playerSixteen: String,
    val playerSeventeen: String,
    val playerEighteen: String
)