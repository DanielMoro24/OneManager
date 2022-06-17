package com.morodaniel.onemanagerapp.ui.players

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.morodaniel.onemanagerapp.R
import com.morodaniel.onemanagerapp.databinding.FragmentLoginBinding
import com.morodaniel.onemanagerapp.databinding.FragmentPlayersBinding
import com.morodaniel.onemanagerapp.network.NetworkConfig
import com.morodaniel.onemanagerapp.network.models.getManager.GetManagerRequest
import com.morodaniel.onemanagerapp.network.models.getManager.GetManagerResponse
import com.morodaniel.onemanagerapp.network.models.getManager.PlayerResponse
import com.morodaniel.onemanagerapp.network.models.getManager.toMap
import com.morodaniel.onemanagerapp.objects.PlayersObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayersFragment : Fragment() {
    private var _binding: FragmentPlayersBinding? = null
    private val binding get() = _binding!!
    private val args: PlayersFragmentArgs by navArgs()
    private var dniManager: String = " "
    private var players: List<PlayerResponse>? = null
    private val adapter = PlayersAdapter{

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dniManager = args.dniManager
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvPlayers.layoutManager = GridLayoutManager(context, 2)
        binding.rvPlayers.adapter = adapter

        getManager(dniManager)
    }

    private fun getManager(dniManager: String) {
        NetworkConfig.playersService.getManager(getManagerRequest = GetManagerRequest(dniManager)).enqueue(object :
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
                            players = response.body()?.manager?.players
                            adapter.submitList(players?.toMap())
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

}