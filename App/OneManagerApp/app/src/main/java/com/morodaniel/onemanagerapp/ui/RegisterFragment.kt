package com.morodaniel.onemanagerapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.morodaniel.onemanagerapp.R
import com.morodaniel.onemanagerapp.databinding.FragmentRegisterBinding
import com.morodaniel.onemanagerapp.extensions.imageUrl
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
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvMessage.visibility = View.INVISIBLE
        binding.tvError2.visibility = View.INVISIBLE
        binding.ivLogo2.imageUrl(R.drawable.soccer_player__negra)
        binding.btnBack.setOnClickListener { goBack() }
        binding.btnConfirm.setOnClickListener { checkRegister() }
    }

    @SuppressLint("SetTextI18n")
    private fun checkRegister() {
        if (checkEmpty()) {
            if (checkPass()) {
                saveManager()
            } else {
                resetPassLabels()
                binding.tvMessage.visibility = View.INVISIBLE
                binding.tvError2.text = "Las contraseñas no coinciden."
                binding.tvError2.visibility = View.VISIBLE
            }
        } else {
            binding.tvMessage.visibility = View.INVISIBLE
            binding.tvError2.text = "Rellene todos los campos."
            binding.tvError2.visibility = View.VISIBLE
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
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {
                    val resp = response.body()?.resp
                    if (resp.equals("ok")) {
                        resetLabels()
                        binding.tvError2.visibility = View.INVISIBLE
                        binding.tvMessage.text = "Su usuario ha sido registrado."
                        binding.tvMessage.visibility = View.VISIBLE
                    } else {
                        binding.tvMessage.visibility = View.INVISIBLE
                        binding.tvError2.text = "Ya existe un usuario con este DNI."
                        binding.tvError2.visibility = View.VISIBLE
                    }
                } else {
                    Log.e("Network", "connexion error")
                    binding.tvMessage.visibility = View.INVISIBLE
                    binding.tvError2.visibility = View.VISIBLE
                    binding.tvError2.text = "Error de conexión."
                    binding.tvError2.visibility = View.VISIBLE
                }
            }

            @SuppressLint("SetTextI18n")
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.e("Network", "connexion error", t)
                binding.tvMessage.visibility = View.INVISIBLE
                binding.tvError2.text = "Error de conexión."
                binding.tvError2.visibility = View.VISIBLE
            }
        })
    }


    private fun goBack() {
        resetLabels()
        val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
        findNavController().navigate(action)
    }

    private fun checkEmpty(): Boolean {
        return binding.ptConfirmPass.text.toString() != "" && binding.ptDni2.text.toString() != "" && binding.ptFirstname.text.toString() != "" && binding.ptName.text.toString() != "" && binding.ptPassword2.text.toString() != "" && binding.ptTeam.text.toString() != ""
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