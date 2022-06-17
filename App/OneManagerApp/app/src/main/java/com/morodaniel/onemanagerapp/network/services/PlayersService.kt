package com.morodaniel.onemanagerapp.network.services

import com.morodaniel.onemanagerapp.network.models.getManager.GetManagerRequest
import com.morodaniel.onemanagerapp.network.models.getManager.GetManagerResponse
import com.morodaniel.onemanagerapp.network.models.login.LoginRequest
import com.morodaniel.onemanagerapp.network.models.login.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PlayersService {
    @GET("manager")
    fun getManager(@Body getManagerRequest: GetManagerRequest): retrofit2.Call<GetManagerResponse>
}