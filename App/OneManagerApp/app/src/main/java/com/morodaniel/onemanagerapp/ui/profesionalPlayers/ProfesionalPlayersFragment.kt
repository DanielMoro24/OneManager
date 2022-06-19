package com.morodaniel.onemanagerapp.ui.profesionalPlayers

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.morodaniel.onemanagerapp.R
import com.morodaniel.onemanagerapp.databinding.FragmentLineupsBinding
import com.morodaniel.onemanagerapp.databinding.FragmentProfesionalPlayersBinding
import com.morodaniel.onemanagerapp.network.NetworkConfig
import com.morodaniel.onemanagerapp.network.models.getManager.GetManagerResponse
import com.morodaniel.onemanagerapp.network.models.getManager.LineupsResponse
import com.morodaniel.onemanagerapp.network.models.getManager.toMap
import com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers.ProfessionalPlayersResponse
import com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers.Statistic
import com.morodaniel.onemanagerapp.ui.lineups.LineupsFragmentArgs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfesionalPlayersFragment : Fragment() {
    private var _binding: FragmentProfesionalPlayersBinding? = null
    private val binding get() = _binding!!
    private val args: ProfesionalPlayersFragmentArgs by navArgs()
    private var dniManager: String = " "
    private var proPlayers: List<Statistic>? = null
    private val adapter = ProfessionalPlayersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dniManager = args.dni
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfesionalPlayersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvProplayers.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvProplayers.adapter = adapter
        getProPlayers()
        binding.ibtnLineups3.setOnClickListener { goLineups() }
        binding.ibtnPlayers3.setOnClickListener { goPlayers() }
    }


    private fun getProPlayers() {
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
                            adapter.submitList(proPlayers)
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

    private fun goPlayers() {
        val action = ProfesionalPlayersFragmentDirections.actionProfesionalPlayersFragmentToPlayersFragment(dniManager)
        findNavController().navigate(action)
    }

    private fun goLineups() {
        val action = ProfesionalPlayersFragmentDirections.actionProfesionalPlayersFragmentToLineupsFragment(dniManager)
        findNavController().navigate(action)
    }

}