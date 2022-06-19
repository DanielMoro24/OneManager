package com.morodaniel.onemanagerapp.network.services

import com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers.ProfessionalPlayersResponse
import retrofit2.http.GET


interface ProfessionalPlayersService {
    @GET("statistics")
    fun getStatistics(): retrofit2.Call<ProfessionalPlayersResponse>
}