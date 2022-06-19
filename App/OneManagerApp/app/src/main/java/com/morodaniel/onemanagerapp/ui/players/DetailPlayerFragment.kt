package com.morodaniel.onemanagerapp.ui.players

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
import com.morodaniel.onemanagerapp.databinding.FragmentDetailPlayerBinding
import com.morodaniel.onemanagerapp.extensions.imageUrl
import com.morodaniel.onemanagerapp.extensions.mainActivity
import com.morodaniel.onemanagerapp.network.NetworkConfig
import com.morodaniel.onemanagerapp.network.models.getManager.ManagerResponse
import com.morodaniel.onemanagerapp.network.models.getManager.PlayerResponse
import com.morodaniel.onemanagerapp.network.models.modifyManager.ModifyManagerRequest
import com.morodaniel.onemanagerapp.network.models.modifyManager.ModifyManagerResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailPlayerFragment : Fragment() {
    private var _binding: FragmentDetailPlayerBinding? = null
    private val binding get() = _binding!!
    private val args: DetailPlayerFragmentArgs by navArgs()
    private var dniManager: String = " "
    private var index: Int = 0
    private var manager: ManagerResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dniManager = args.dni
            index = args.pos
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivLogo4.imageUrl(R.drawable.soccer_player__negra)
        getManager()
        setText()
        binding.btnModify.setOnClickListener { modifyPlayer() }
        binding.btnDelete.setOnClickListener { deletePlayer() }
        binding.btnBack3.setOnClickListener { goPlayers() }
    }

    private fun deletePlayer() {
        manager?.players?.removeAt(index)
        modifyManager(manager)
        clearText()
        goPlayers()
    }

    private fun modifyPlayer() {
        if (checkEmpty()) {
            if (checkNumbers()) {
                manager?.players?.get(index)?.name = binding.ptName3.text.toString()
                manager?.players?.get(index)?.firstname = binding.ptFirstname3.text.toString()
                manager?.players?.get(index)?.dni = binding.ptDni4.text.toString()
                manager?.players?.get(index)?.age = binding.ptAge2.text.toString().toInt()
                manager?.players?.get(index)?.position = binding.ptPosition2.text.toString()
                manager?.players?.get(index)?.height = binding.ptHeight2.text.toString()
                manager?.players?.get(index)?.weight = binding.ptWeight2.text.toString()
                manager?.players?.get(index)?.goals = binding.ptGoals2.text.toString().toInt()
                manager?.players?.get(index)?.assists = binding.ptAssists2.text.toString().toInt()
                manager?.players?.get(index)?.yellow = binding.ptYellow2.text.toString().toInt()
                manager?.players?.get(index)?.red = binding.ptRed2.text.toString().toInt()
                manager?.players?.get(index)?.appearences =
                    binding.ptAppearences2.text.toString().toInt()
                manager?.players?.get(index)?.minutes = binding.ptMinutes2.text.toString().toInt()
                manager?.players?.get(index)?.rating = binding.ptRating2.text.toString()

                modifyManager(manager)
            } else {
                //error hay un número que no es numero
            }
        } else {
            //algo esta vacio

        }

    }

    private fun modifyManager(manager: ManagerResponse?) {
        NetworkConfig.managerService.modifyManager(ModifyManagerRequest(manager = manager))
            .enqueue(object :
                Callback<ModifyManagerResponse> {
                override fun onResponse(
                    call: Call<ModifyManagerResponse>,
                    response: Response<ModifyManagerResponse>
                ) {
                    if (response.isSuccessful) {
                        val resp = response.body()
                        if (resp != null) {
                            if (resp.resp == "ok") {
                                //se Ha modificado
                            } else {
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
        binding.ptName3.text.clear()
        binding.ptFirstname3.text.clear()
        binding.ptDni4.text.clear()
        binding.ptAge2.text.clear()
        binding.ptPosition2.text.clear()
        binding.ptHeight2.text.clear()
        binding.ptWeight2.text.clear()
        binding.ptGoals2.text.clear()
        binding.ptAssists2.text.clear()
        binding.ptYellow2.text.clear()
        binding.ptRed2.text.clear()
        binding.ptAppearences2.text.clear()
        binding.ptMinutes2.text.clear()
        binding.ptRating2.text.clear()
    }

    private fun goPlayers() {
        val action =
            DetailPlayerFragmentDirections.actionDetailPlayerFragmentToPlayersFragment(dniManager)
        findNavController().navigate(action)
    }

    private fun checkNumbers(): Boolean {
        return binding.ptAge2.text.toString()
            .toIntOrNull() != null && binding.ptGoals2.text.toString()
            .toIntOrNull() != null && binding.ptAssists2.text.toString()
            .toIntOrNull() != null && binding.ptYellow2.text.toString()
            .toIntOrNull() != null && binding.ptRed2.text.toString()
            .toIntOrNull() != null && binding.ptAppearences2.text.toString()
            .toIntOrNull() != null && binding.ptMinutes2.text.toString().toIntOrNull() != null
    }

    private fun checkEmpty(): Boolean {
        return binding.ptName3.text.toString() != "" && binding.ptMinutes2.text.toString() != "" && binding.ptYellow2.text.toString() != "" && binding.ptRed2.text.toString() != "" && binding.ptAppearences2.text.toString() != "" && binding.ptAssists2.text.toString() != "" && binding.ptGoals2.text.toString() != "" && binding.ptAge2.text.toString() != "" && binding.ptDni4.text.toString() != "" && binding.ptFirstname3.text.toString() != "" && binding.ptHeight2.text.toString() != "" && binding.ptPosition2.text.toString() != "" && binding.ptRating2.text.toString() != "" && binding.ptWeight2.text.toString() != ""
    }

    private fun setText() {
        binding.ptName3.setText(manager?.players?.get(index)?.name)
        binding.ptFirstname3.setText(manager?.players?.get(index)?.firstname)
        binding.ptDni4.setText(manager?.players?.get(index)?.dni)
        binding.ptAge2.setText(manager?.players?.get(index)?.age.toString())
        binding.ptPosition2.setText(manager?.players?.get(index)?.position)
        binding.ptGoals2.setText(manager?.players?.get(index)?.goals.toString())
        binding.ptAssists2.setText(manager?.players?.get(index)?.assists.toString())
        binding.ptYellow2.setText(manager?.players?.get(index)?.yellow.toString())
        binding.ptRed2.setText(manager?.players?.get(index)?.red.toString())
        binding.ptMinutes2.setText(manager?.players?.get(index)?.minutes.toString())
        binding.ptAppearences2.setText(manager?.players?.get(index)?.appearences.toString())
        binding.ptRating2.setText(manager?.players?.get(index)?.rating)
        binding.ptHeight2.setText(manager?.players?.get(index)?.height)
        binding.ptWeight2.setText(manager?.players?.get(index)?.weight)
    }

    private fun getManager() {
        manager = mainActivity().sendManager()
    }


}