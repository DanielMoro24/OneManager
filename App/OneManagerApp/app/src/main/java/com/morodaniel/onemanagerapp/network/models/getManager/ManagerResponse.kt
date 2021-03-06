package com.morodaniel.onemanagerapp.network.models.getManager


import com.google.gson.annotations.Expose

data class ManagerResponse(
    @Expose
    val __v: Int,
    @Expose
    val _id: String,
    @Expose
    val dni: String,
    @Expose
    val firstname: String,
    @Expose
    val lineups: MutableList<LineupsResponse>,
    @Expose
    val name: String,
    @Expose
    val pass: String,
    @Expose
    val players: MutableList<PlayerResponse>,
    @Expose
    val team: String
)