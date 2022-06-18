package com.morodaniel.onemanagerapp.network.models.modifyManager

import com.google.gson.annotations.Expose

data class ModifyManagerResponse(
    @Expose
    val error: String,
    @Expose
    val resp: String,
    @Expose
    val result: String
)
