package com.morodaniel.onemanagerapp.network.models.register

import com.google.gson.annotations.Expose

data class RegisterResponse(
    @Expose
    val error: String,
    @Expose
    val resp: String,
    @Expose
    val result: String
)
