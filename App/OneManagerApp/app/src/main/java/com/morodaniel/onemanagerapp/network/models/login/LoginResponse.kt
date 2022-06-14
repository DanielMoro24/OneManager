package com.morodaniel.onemanagerapp.network.models.login


import com.google.gson.annotations.Expose

data class LoginResponse(
    @Expose
    val error: String,
    @Expose
    val resp: String,
    @Expose
    val result: String
)