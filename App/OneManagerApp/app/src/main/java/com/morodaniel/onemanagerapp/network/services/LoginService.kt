package com.morodaniel.onemanagerapp.network.services

import android.telecom.Call
import com.morodaniel.onemanagerapp.network.models.LoginRequest
import com.morodaniel.onemanagerapp.network.models.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("manager/login")
    fun checkManager(@Body loginRequest: LoginRequest): retrofit2.Call<LoginResponse>

}