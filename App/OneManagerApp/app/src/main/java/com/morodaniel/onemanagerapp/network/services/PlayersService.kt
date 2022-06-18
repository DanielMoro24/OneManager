package com.morodaniel.onemanagerapp.network.services

import com.morodaniel.onemanagerapp.network.models.getManager.GetManagerRequest
import com.morodaniel.onemanagerapp.network.models.getManager.GetManagerResponse
import com.morodaniel.onemanagerapp.network.models.login.LoginRequest
import com.morodaniel.onemanagerapp.network.models.login.LoginResponse
import retrofit2.http.*

interface PlayersService {
    @GET("manager/{dni}")
    fun getManager(@Path("dni") dni: String): retrofit2.Call<GetManagerResponse>
}