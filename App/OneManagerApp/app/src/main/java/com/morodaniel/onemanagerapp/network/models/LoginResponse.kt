package com.morodaniel.onemanagerapp.network.models


import com.google.gson.annotations.Expose

data class LoginResponse(
    @Expose
    val error: String,
    @Expose
    val resp: String,
    @Expose
    val result: String
)