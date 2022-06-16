package com.morodaniel.onemanagerapp.network.services

import com.morodaniel.onemanagerapp.network.models.register.RegisterRequest
import com.morodaniel.onemanagerapp.network.models.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("manager/new")
    fun saveManager(@Body registerRequest: RegisterRequest): retrofit2.Call<RegisterResponse>
}