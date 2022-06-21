package com.morodaniel.onemanagerapp.network

import com.morodaniel.onemanagerapp.network.services.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {
    private const val URLBase: String = "http://192.168.52.2:3000/"

    private val logging = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()


    private val retrofit = Retrofit.Builder()
        .baseUrl(this.URLBase)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Services
    val playersService: PlayersService = retrofit.create(PlayersService::class.java)
    val loginService: LoginService = retrofit.create(LoginService::class.java)
    val registerService: RegisterService = retrofit.create(RegisterService::class.java)
    val managerService: ManagerService = retrofit.create(ManagerService::class.java)
    val professionalPlayersService: ProfessionalPlayersService = retrofit.create(
        ProfessionalPlayersService::class.java)
}