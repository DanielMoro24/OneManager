package com.morodaniel.onemanagerapp.network.services

import com.morodaniel.onemanagerapp.network.models.getManager.ManagerResponse
import com.morodaniel.onemanagerapp.network.models.login.LoginRequest
import com.morodaniel.onemanagerapp.network.models.login.LoginResponse
import com.morodaniel.onemanagerapp.network.models.modifyManager.ModifyManagerRequest
import com.morodaniel.onemanagerapp.network.models.modifyManager.ModifyManagerResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ManagerService {
    @POST("manager/modify")
    fun modifyManager(@Body modifyManagerRequest: ModifyManagerRequest): retrofit2.Call<ModifyManagerResponse>
}