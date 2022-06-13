package com.morodaniel.onemanagerapp.network.models

data class LoginRequest(
    var dni: String,
    val pass: String
)
