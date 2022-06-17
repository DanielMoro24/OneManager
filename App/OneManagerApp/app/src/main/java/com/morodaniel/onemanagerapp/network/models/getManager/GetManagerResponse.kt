package com.morodaniel.onemanagerapp.network.models.getManager


import com.google.gson.annotations.Expose

data class GetManagerResponse(
    @Expose
    val error: String,
    @Expose
    val manager: ManagerResponse,
    @Expose
    val resp: String
)