package com.morodaniel.onemanagerapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.morodaniel.onemanagerapp.databinding.FragmentRegisterBinding
import com.morodaniel.onemanagerapp.network.NetworkConfig
import com.morodaniel.onemanagerapp.network.models.register.LineupsRegisterRequest
import com.morodaniel.onemanagerapp.network.models.register.PlayerRegisterRequest
import com.morodaniel.onemanagerapp.network.models.register.RegisterRequest
import com.morodaniel.onemanagerapp.network.models.register.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val playersList: List<PlayerRegisterRequest> = emptyList()
    private val lineupsList: List<LineupsRegisterRequest> = emptyList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener { goBack() }
        binding.btnConfirm.setOnClickListener { checkRegister() }
    }

    private fun checkRegister() {
        if (checkEmpty()) {
            if (checkPass()) {
                saveManager()
            } else {
                resetPassLabels()
                // salta error
            }
        } else {
            // salta error
        }
    }

    private fun saveManager() {
        NetworkConfig.registerService.saveManager(
            registerRequest = RegisterRequest(
                binding.ptName.text.toString(),
                binding.ptFirstname.text.toString(),
                binding.ptDni2.text.toString(),
                binding.ptTeam.text.toString(),
                binding.ptPassword2.text.toString(),
                playersList,
                lineupsList
            )
        ).enqueue(object :
            Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {
                    val resp = response.body()?.resp
                    if (resp.equals("ok")) {
                        resetLabels()
                    } else {
                        //aviso de datos incorrectos
                    }
                } else {
                    Log.e("Network", "connexion error")
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.e("Network", "connexion error", t)


            }
        })
    }


    private fun goBack() {
        resetLabels()
        val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
        findNavController().navigate(action)
    }

    private fun checkEmpty(): Boolean {
        return binding.ptConfirmPass.text != null && binding.ptDni2.text != null && binding.ptFirstname.text != null && binding.ptName.text != null && binding.ptPassword2.text != null && binding.ptTeam.text != null
    }

    private fun checkPass(): Boolean {
        return binding.ptPassword2.text.toString() == binding.ptConfirmPass.text.toString()
    }

    private fun resetLabels() {
        binding.ptName.text.clear()
        binding.ptFirstname.text.clear()
        binding.ptDni2.text.clear()
        binding.ptTeam.text.clear()
        binding.ptConfirmPass.text.clear()
        binding.ptPassword2.text.clear()
    }

    private fun resetPassLabels() {
        binding.ptConfirmPass.text.clear()
        binding.ptPassword2.text.clear()
    }

}