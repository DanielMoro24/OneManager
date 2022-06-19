package com.morodaniel.onemanagerapp.ui.players

import android.annotation.SuppressLint
import android.net.Network
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.morodaniel.onemanagerapp.R
import com.morodaniel.onemanagerapp.databinding.FragmentAddPlayersBinding
import com.morodaniel.onemanagerapp.databinding.FragmentPlayersBinding
import com.morodaniel.onemanagerapp.extensions.imageUrl
import com.morodaniel.onemanagerapp.extensions.mainActivity
import com.morodaniel.onemanagerapp.network.NetworkConfig
import com.morodaniel.onemanagerapp.network.models.getManager.GetManagerResponse
import com.morodaniel.onemanagerapp.network.models.getManager.ManagerResponse
import com.morodaniel.onemanagerapp.network.models.getManager.PlayerResponse
import com.morodaniel.onemanagerapp.network.models.getManager.toMap
import com.morodaniel.onemanagerapp.network.models.modifyManager.ModifyManagerRequest
import com.morodaniel.onemanagerapp.network.models.modifyManager.ModifyManagerResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddPlayersFragment : Fragment() {
    private var _binding: FragmentAddPlayersBinding? = null
    private val binding get() = _binding!!
    private val args: AddPlayersFragmentArgs by navArgs()
    private var dniManager: String = " "
    private var manager: ManagerResponse? = null

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
        _binding = FragmentAddPlayersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivLogo3.imageUrl(R.drawable.soccer_player__negra)
        getManager()
        binding.btnAdd.setOnClickListener { addPlayer() }
        binding.btnBack2.setOnClickListener { goPlayers() }
    }

    private fun goPlayers() {
        val action =
            AddPlayersFragmentDirections.actionAddPlayersFragmentToPlayersFragment(dniManager)
        findNavController().navigate(action)
    }

    private fun getManager() {
        manager = mainActivity().sendManager()
    }

    private fun addPlayer() {
        if (checkEmpty()) {
            if (checkNumbers()) {
                manager?.players?.add(
                    PlayerResponse(
                        binding.ptName2.text.toString(),
                        binding.ptFirstname2.text.toString(),
                        binding.ptDni3.text.toString(),
                        binding.ptAge.text.toString().toInt(),
                        binding.ptPosition.text.toString(),
                        binding.ptHeight.text.toString(),
                        binding.ptWeight.text.toString(),
                        binding.ptGoals.text.toString().toInt(),
                        binding.ptAssists.text.toString().toInt(),
                        binding.ptYellow.text.toString().toInt(),
                        binding.ptRed.text.toString().toInt(),
                        binding.ptAppearences.text.toString().toInt(),
                        binding.ptMinutes.text.toString().toInt(),
                        binding.ptRating.text.toString()
                    )
                )
                modifyManager(manager)
            } else {
                //error hay un número que no es numero
            }
        } else {
            //algo esta vacio

        }

    }

    private fun modifyManager(manager: ManagerResponse?) {
        NetworkConfig.managerService.modifyManager(ModifyManagerRequest(manager = manager)).enqueue(object :
            Callback<ModifyManagerResponse> {
            override fun onResponse(
                call: Call<ModifyManagerResponse>,
                response: Response<ModifyManagerResponse>
            ) {
                if (response.isSuccessful) {
                    val resp = response.body()
                    if (resp != null) {
                        if (resp.resp == "ok") {
                            clearText()
                        }else {
                            Log.e("Network", "data error")
                        }
                    }
                } else {
                    Log.e("Network", "connexion error")
                }
            }

            override fun onFailure(call: Call<ModifyManagerResponse>, t: Throwable) {
                Log.e("Network", "connexion error", t)


            }
        })

    }

    private fun clearText() {
        binding.ptName2.text.clear()
        binding.ptFirstname2.text.clear()
        binding.ptDni3.text.clear()
        binding.ptAge.text.clear()
        binding.ptPosition.text.clear()
        binding.ptHeight.text.clear()
        binding.ptWeight.text.clear()
        binding.ptGoals.text.clear()
        binding.ptAssists.text.clear()
        binding.ptYellow.text.clear()
        binding.ptRed.text.clear()
        binding.ptAppearences.text.clear()
        binding.ptMinutes.text.clear()
        binding.ptRating.text.clear()
    }

    private fun checkNumbers(): Boolean {
        return binding.ptAge.text.toString()
            .toIntOrNull() != null && binding.ptGoals.text.toString()
            .toIntOrNull() != null && binding.ptAssists.text.toString()
            .toIntOrNull() != null && binding.ptYellow.text.toString()
            .toIntOrNull() != null && binding.ptRed.text.toString()
            .toIntOrNull() != null && binding.ptAppearences.text.toString()
            .toIntOrNull() != null && binding.ptMinutes.text.toString().toIntOrNull() != null
    }

    private fun checkEmpty(): Boolean {
        return binding.ptName2.text.toString() != "" && binding.ptMinutes.text.toString() != "" && binding.ptYellow.text.toString() != "" && binding.ptRed.text.toString() != "" && binding.ptAppearences.text.toString() != "" && binding.ptAssists.text.toString() != "" && binding.ptGoals.text.toString() != "" && binding.ptAge.text.toString() != "" && binding.ptDni3.text.toString() != "" && binding.ptFirstname2.text.toString() != "" && binding.ptHeight.text.toString() != "" && binding.ptPosition.text.toString() != "" && binding.ptRating.text.toString() != "" && binding.ptWeight.text.toString() != ""
    }

}