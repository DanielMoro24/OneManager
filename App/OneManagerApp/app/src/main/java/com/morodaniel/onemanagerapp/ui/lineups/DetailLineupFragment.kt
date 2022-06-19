package com.morodaniel.onemanagerapp.ui.lineups

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.morodaniel.onemanagerapp.R
import com.morodaniel.onemanagerapp.databinding.FragmentDetailLineupBinding
import com.morodaniel.onemanagerapp.extensions.imageUrl
import com.morodaniel.onemanagerapp.extensions.mainActivity
import com.morodaniel.onemanagerapp.network.NetworkConfig
import com.morodaniel.onemanagerapp.network.models.getManager.ManagerResponse
import com.morodaniel.onemanagerapp.network.models.modifyManager.ModifyManagerRequest
import com.morodaniel.onemanagerapp.network.models.modifyManager.ModifyManagerResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailLineupFragment : Fragment() {
    private var _binding: FragmentDetailLineupBinding? = null
    private val binding get() = _binding!!
    private val args: DetailLineupFragmentArgs by navArgs()
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
        _binding = FragmentDetailLineupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivLogo6.imageUrl(R.drawable.soccer_player__negra)
        getManager()
        setText()
        binding.btnModify2.setOnClickListener { modifyLineup() }
        binding.btnDelete2.setOnClickListener { deletePlayer() }
        binding.btnBack5.setOnClickListener { goLineups() }
    }

    private fun deletePlayer() {
        manager?.lineups?.removeAt(index)
        modifyManager(manager)
        clearText()
        goLineups()
    }

    private fun goLineups() {
        val action =
            DetailLineupFragmentDirections.actionDetailLineupFragmentToLineupsFragment(dniManager)
        findNavController().navigate(action)
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

    private fun modifyLineup() {
        if (checkEmpty()) {
            manager?.lineups?.get(index)?.journey = binding.ptJourney2.text.toString()
            manager?.lineups?.get(index)?.playerOne = binding.ptPlayerOne2.text.toString()
            manager?.lineups?.get(index)?.playerTwo = binding.ptPlayerTwo2.text.toString()
            manager?.lineups?.get(index)?.playerThree = binding.ptPlayerThree2.text.toString()
            manager?.lineups?.get(index)?.playerFour = binding.ptPlayerFour2.text.toString()
            manager?.lineups?.get(index)?.playerFive = binding.ptPlayerFive2.text.toString()
            manager?.lineups?.get(index)?.playerSix = binding.ptPlayerSix2.text.toString()
            manager?.lineups?.get(index)?.playerSeven = binding.ptPlayerSeven2.text.toString()
            manager?.lineups?.get(index)?.playerEight = binding.ptPlayerEight2.text.toString()
            manager?.lineups?.get(index)?.playerNine = binding.ptPlayerNine2.text.toString()
            manager?.lineups?.get(index)?.playerTen = binding.ptPlayerTen2.text.toString()
            manager?.lineups?.get(index)?.playerEleven = binding.ptPlayerEleven2.text.toString()
            manager?.lineups?.get(index)?.playerTwelve = binding.ptPlayerTwelve2.text.toString()
            manager?.lineups?.get(index)?.playerThirteen = binding.ptPlayerThirteen2.text.toString()
            manager?.lineups?.get(index)?.playerFourteen = binding.ptPlayerFourteen2.text.toString()
            manager?.lineups?.get(index)?.playerFivteen = binding.ptPlayerFivteen2.text.toString()
            manager?.lineups?.get(index)?.playerSixteen = binding.ptPlayerSixteen2.text.toString()
            manager?.lineups?.get(index)?.playerSeventeen = binding.ptPlayerSeventeen2.text.toString()
            manager?.lineups?.get(index)?.playerEighteen = binding.ptPlayerEighteen2.text.toString()

            modifyManager(manager)
        } else {
            //algo esta vacio

        }

    }

    private fun checkEmpty(): Boolean {
        return binding.ptJourney2.text.toString() != "" && binding.ptPlayerOne2.text.toString() != "" && binding.ptPlayerTwo2.text.toString() != "" && binding.ptPlayerThree2.text.toString() != "" && binding.ptPlayerFour2.text.toString() != "" && binding.ptPlayerFive2.text.toString() != "" && binding.ptPlayerSix2.text.toString() != "" && binding.ptPlayerSeven2.text.toString() != "" && binding.ptPlayerEight2.text.toString() != "" && binding.ptPlayerNine2.text.toString() != "" && binding.ptPlayerTen2.text.toString() != "" && binding.ptPlayerEleven2.text.toString() != "" && binding.ptPlayerTwelve2.text.toString() != "" && binding.ptPlayerThirteen2.text.toString() != "" && binding.ptPlayerFourteen2.text.toString() != "" && binding.ptPlayerFivteen2.text.toString() != "" && binding.ptPlayerSixteen2.text.toString() != "" && binding.ptPlayerSeventeen2.text.toString() != "" && binding.ptPlayerEighteen2.text.toString() != ""
    }

    private fun clearText() {
        binding.ptJourney2.text.clear()
        binding.ptPlayerOne2.text.clear()
        binding.ptPlayerTwo2.text.clear()
        binding.ptPlayerThree2.text.clear()
        binding.ptPlayerFour2.text.clear()
        binding.ptPlayerFive2.text.clear()
        binding.ptPlayerSix2.text.clear()
        binding.ptPlayerSeven2.text.clear()
        binding.ptPlayerEight2.text.clear()
        binding.ptPlayerNine2.text.clear()
        binding.ptPlayerTen2.text.clear()
        binding.ptPlayerEleven2.text.clear()
        binding.ptPlayerTwelve2.text.clear()
        binding.ptPlayerThirteen2.text.clear()
        binding.ptPlayerFourteen2.text.clear()
        binding.ptPlayerFivteen2.text.clear()
        binding.ptPlayerSixteen2.text.clear()
        binding.ptPlayerSeventeen2.text.clear()
        binding.ptPlayerEighteen2.text.clear()
    }

    private fun setText() {
        binding.ptJourney2.setText(manager?.lineups?.get(index)?.journey)
        binding.ptPlayerOne2.setText(manager?.lineups?.get(index)?.playerOne)
        binding.ptPlayerTwo2.setText(manager?.lineups?.get(index)?.playerTwo)
        binding.ptPlayerThree2.setText(manager?.lineups?.get(index)?.playerThree)
        binding.ptPlayerFour2.setText(manager?.lineups?.get(index)?.playerFour)
        binding.ptPlayerFive2.setText(manager?.lineups?.get(index)?.playerFive)
        binding.ptPlayerSix2.setText(manager?.lineups?.get(index)?.playerSix)
        binding.ptPlayerSeven2.setText(manager?.lineups?.get(index)?.playerSeven)
        binding.ptPlayerEight2.setText(manager?.lineups?.get(index)?.playerEight)
        binding.ptPlayerNine2.setText(manager?.lineups?.get(index)?.playerNine)
        binding.ptPlayerTen2.setText(manager?.lineups?.get(index)?.playerTen)
        binding.ptPlayerEleven2.setText(manager?.lineups?.get(index)?.playerEleven)
        binding.ptPlayerTwelve2.setText(manager?.lineups?.get(index)?.playerTwelve)
        binding.ptPlayerThirteen2.setText(manager?.lineups?.get(index)?.playerThirteen)
        binding.ptPlayerFourteen2.setText(manager?.lineups?.get(index)?.playerFourteen)
        binding.ptPlayerFivteen2.setText(manager?.lineups?.get(index)?.playerFivteen)
        binding.ptPlayerSixteen2.setText(manager?.lineups?.get(index)?.playerSixteen)
        binding.ptPlayerSeventeen2.setText(manager?.lineups?.get(index)?.playerSeventeen)
        binding.ptPlayerEighteen2.setText(manager?.lineups?.get(index)?.playerEighteen)
    }

    private fun getManager() {
        manager = mainActivity().sendManager()
    }
}