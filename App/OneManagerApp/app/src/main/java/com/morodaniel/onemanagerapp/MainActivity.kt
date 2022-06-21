package com.morodaniel.onemanagerapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.morodaniel.onemanagerapp.databinding.ActivityMainBinding
import com.morodaniel.onemanagerapp.network.NetworkConfig
import com.morodaniel.onemanagerapp.network.models.getManager.GetManagerResponse
import com.morodaniel.onemanagerapp.network.models.getManager.ManagerResponse
import com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers.ProfessionalPlayersResponse
import com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers.Statistic
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var manager: ManagerResponse? = null
    private var proPlayers: List<Statistic>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

     private fun callManager(dniManager: String) {
        NetworkConfig.playersService.getManager(dni = dniManager).enqueue(object :
            Callback<GetManagerResponse> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<GetManagerResponse>,
                response: Response<GetManagerResponse>
            ) {
                if (response.isSuccessful) {
                    val resp = response.body()
                    if (resp != null) {
                        if (resp.resp == "ok") {
                            manager = resp.manager
                        }else {
                            Log.e("Network", "data error")
                        }
                    }
                } else {
                    Log.e("Network", "connexion error")
                }
            }

            override fun onFailure(call: Call<GetManagerResponse>, t: Throwable) {
                Log.e("Network", "connexion error", t)


            }
        })
    }

    private fun callProPlayers(){
        NetworkConfig.professionalPlayersService.getStatistics().enqueue(object :
            Callback<ProfessionalPlayersResponse> {
            override fun onResponse(
                call: Call<ProfessionalPlayersResponse>,
                response: Response<ProfessionalPlayersResponse>
            ) {
                if (response.isSuccessful) {
                    val resp = response.body()
                    if (resp != null) {
                        if (resp.resp == "ok") {
                            proPlayers = resp.statistics
                        } else {
                            Log.e("Network", "data error")
                        }
                    }
                } else {
                    Log.e("Network", "connexion error")
                }
            }

            override fun onFailure(call: Call<ProfessionalPlayersResponse>, t: Throwable) {
                Log.e("Network", "connexion error", t)


            }
        })
    }

    fun sendCallProPlayers(): List<Statistic>? {
       callProPlayers()
        return proPlayers
    }

    fun sendProPlayers(): List<Statistic>? {
        return proPlayers
    }

     fun sendCallManager(dniManager: String): ManagerResponse? {
        callManager(dniManager)
        return manager
    }

    fun sendManager(): ManagerResponse? {
        return manager
    }

}