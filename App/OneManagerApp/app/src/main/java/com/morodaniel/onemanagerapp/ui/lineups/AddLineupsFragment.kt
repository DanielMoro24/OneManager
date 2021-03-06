package com.morodaniel.onemanagerapp.ui.lineups

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.morodaniel.onemanagerapp.R
import com.morodaniel.onemanagerapp.databinding.FragmentAddLineupsBinding
import com.morodaniel.onemanagerapp.extensions.imageUrl
import com.morodaniel.onemanagerapp.extensions.mainActivity
import com.morodaniel.onemanagerapp.network.NetworkConfig
import com.morodaniel.onemanagerapp.network.models.getManager.LineupsResponse
import com.morodaniel.onemanagerapp.network.models.getManager.ManagerResponse
import com.morodaniel.onemanagerapp.network.models.modifyManager.ModifyManagerRequest
import com.morodaniel.onemanagerapp.network.models.modifyManager.ModifyManagerResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddLineupsFragment : Fragment() {
    private var _binding: FragmentAddLineupsBinding? = null
    private val binding get() = _binding!!
    private val args: AddLineupsFragmentArgs by navArgs()
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
    ): View {
        _binding = FragmentAddLineupsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvMessage4.visibility = View.INVISIBLE
        binding.tvError5.visibility = View.INVISIBLE
        binding.ivLogo5.imageUrl(R.drawable.soccer_player__negra)
        getManager()
        binding.btnAdd2.setOnClickListener { addLineup() }
        binding.btnBack4.setOnClickListener { goPlayers() }
    }

    private fun goPlayers() {
        val action =
            AddLineupsFragmentDirections.actionAddLineupsFragmentToLineupsFragment(dniManager)
        findNavController().navigate(action)
    }

    @SuppressLint("SetTextI18n")
    private fun addLineup() {
        if (checkEmpty()) {
            manager?.lineups?.add(
                LineupsResponse(
                    binding.ptJourney.text.toString(),
                    binding.ptPlayerOne.text.toString(),
                    binding.ptPlayerTwo.text.toString(),
                    binding.ptPlayerThree.text.toString(),
                    binding.ptPlayerFour.text.toString(),
                    binding.ptPlayerFive.text.toString(),
                    binding.ptPlayerSix.text.toString(),
                    binding.ptPlayerSeven.text.toString(),
                    binding.ptPlayerEight.text.toString(),
                    binding.ptPlayerNine.text.toString(),
                    binding.ptPlayerTen.text.toString(),
                    binding.ptPlayerEleven.text.toString(),
                    binding.ptPlayerTwelve.text.toString(),
                    binding.ptPlayerThirteen.text.toString(),
                    binding.ptPlayerFourteen.text.toString(),
                    binding.ptPlayerFivteen.text.toString(),
                    binding.ptPlayerSixteen.text.toString(),
                    binding.ptPlayerSeventeen.text.toString(),
                    binding.ptPlayerEighteen.text.toString()
                )
            )

            modifyManager(manager)
        } else {
            binding.tvMessage4.visibility = View.INVISIBLE
            binding.tvError5.text = "Rellene todos los campos."
            binding.tvError5.visibility = View.VISIBLE
        }
    }

    private fun modifyManager(manager: ManagerResponse?) {
        NetworkConfig.managerService.modifyManager(ModifyManagerRequest(manager = manager)).enqueue(object :
            Callback<ModifyManagerResponse> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<ModifyManagerResponse>,
                response: Response<ModifyManagerResponse>
            ) {
                if (response.isSuccessful) {
                    val resp = response.body()
                    if (resp != null) {
                        if (resp.resp == "ok") {
                            clearText()
                            binding.tvError5.visibility = View.INVISIBLE
                            binding.tvMessage4.text = "La alineaci??n se ha a??adido correctamente."
                            binding.tvMessage4.visibility = View.VISIBLE
                        } else {
                            Log.e("Network", "data error")
                            binding.tvMessage4.visibility = View.INVISIBLE
                            binding.tvError5.text = "Error de inesperado."
                            binding.tvError5.visibility = View.VISIBLE
                        }
                    }
                } else {
                    Log.e("Network", "connexion error")
                    binding.tvMessage4.visibility = View.INVISIBLE
                    binding.tvError5.text = "Error de conexi??n."
                    binding.tvError5.visibility = View.VISIBLE
                }
            }

            @SuppressLint("SetTextI18n")
            override fun onFailure(call: Call<ModifyManagerResponse>, t: Throwable) {
                Log.e("Network", "connexion error", t)
                binding.tvMessage4.visibility = View.INVISIBLE
                binding.tvError5.text = "Error de conexi??n."
                binding.tvError5.visibility = View.VISIBLE
            }
        })

    }

    private fun clearText() {
        binding.ptJourney.text.clear()
        binding.ptPlayerOne.text.clear()
        binding.ptPlayerTwo.text.clear()
        binding.ptPlayerThree.text.clear()
        binding.ptPlayerFour.text.clear()
        binding.ptPlayerFive.text.clear()
        binding.ptPlayerSix.text.clear()
        binding.ptPlayerSeven.text.clear()
        binding.ptPlayerEight.text.clear()
        binding.ptPlayerNine.text.clear()
        binding.ptPlayerTen.text.clear()
        binding.ptPlayerEleven.text.clear()
        binding.ptPlayerTwelve.text.clear()
        binding.ptPlayerThirteen.text.clear()
        binding.ptPlayerFourteen.text.clear()
        binding.ptPlayerFivteen.text.clear()
        binding.ptPlayerSixteen.text.clear()
        binding.ptPlayerSeventeen.text.clear()
        binding.ptPlayerEighteen.text.clear()
    }

    private fun checkEmpty(): Boolean {
        return binding.ptJourney.text.toString() != "" && binding.ptPlayerOne.text.toString() != "" && binding.ptPlayerTwo.text.toString() != "" && binding.ptPlayerThree.text.toString() != "" && binding.ptPlayerFour.text.toString() != "" && binding.ptPlayerFive.text.toString() != "" && binding.ptPlayerSix.text.toString() != "" && binding.ptPlayerSeven.text.toString() != "" && binding.ptPlayerEight.text.toString() != "" && binding.ptPlayerNine.text.toString() != "" && binding.ptPlayerTen.text.toString() != "" && binding.ptPlayerEleven.text.toString() != "" && binding.ptPlayerTwelve.text.toString() != "" && binding.ptPlayerThirteen.text.toString() != "" && binding.ptPlayerFourteen.text.toString() != "" && binding.ptPlayerFivteen.text.toString() != "" && binding.ptPlayerSixteen.text.toString() != "" && binding.ptPlayerSeventeen.text.toString() != "" && binding.ptPlayerEighteen.text.toString() != ""
    }

    private fun getManager() {
        manager = mainActivity().sendManager()
    }

}