package com.morodaniel.onemanagerapp.network.services

import com.morodaniel.onemanagerapp.network.models.getManager.GetManagerResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PlayersService {
    @GET("manager/{dni}")
    fun getManager(@Path("dni") dni: String): retrofit2.Call<GetManagerResponse>
}