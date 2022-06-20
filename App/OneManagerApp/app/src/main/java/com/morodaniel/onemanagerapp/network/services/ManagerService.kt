package com.morodaniel.onemanagerapp.network.services

import com.morodaniel.onemanagerapp.network.models.modifyManager.ModifyManagerRequest
import com.morodaniel.onemanagerapp.network.models.modifyManager.ModifyManagerResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ManagerService {
    @POST("manager/update")
    fun modifyManager(@Body modifyManagerRequest: ModifyManagerRequest): retrofit2.Call<ModifyManagerResponse>
}