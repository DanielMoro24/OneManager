package com.morodaniel.onemanagerapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.morodaniel.onemanagerapp.databinding.ActivityMainBinding
import com.morodaniel.onemanagerapp.network.NetworkConfig
import com.morodaniel.onemanagerapp.network.models.getManager.GetManagerRequest
import com.morodaniel.onemanagerapp.network.models.getManager.GetManagerResponse
import com.morodaniel.onemanagerapp.network.models.getManager.ManagerResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var manager: ManagerResponse? = null


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

     fun sendManager(dniManager: String): ManagerResponse? {
        callManager(dniManager)
        return manager
    }

}