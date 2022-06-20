package com.morodaniel.onemanagerapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.morodaniel.onemanagerapp.R
import com.morodaniel.onemanagerapp.databinding.FragmentLoginBinding
import com.morodaniel.onemanagerapp.extensions.imageUrl
import com.morodaniel.onemanagerapp.network.NetworkConfig
import com.morodaniel.onemanagerapp.network.models.login.LoginRequest
import com.morodaniel.onemanagerapp.network.models.login.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private var dniManager: String = " "

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvError.visibility = View.INVISIBLE
        binding.ivLogo.imageUrl(R.drawable.soccer_player__negra)
        binding.btnLogin.setOnClickListener { checkLogin() }
        binding.btnRegister.setOnClickListener { goToRegister() }
    }

    private fun goToRegister() {
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        findNavController().navigate(action)
    }

    @SuppressLint("SetTextI18n")
    private fun checkLogin() {
        if (binding.ptDni.text.toString() != "" && binding.ptPassword.text.toString() != "  "){
            dniManager = binding.ptDni.text.toString()
            NetworkConfig.loginService.checkManager(loginRequest = LoginRequest(binding.ptDni.text.toString(), binding.ptPassword.text.toString())).enqueue(object :
                Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        val resp = response.body()?.resp
                        if (resp.equals("ok")) {
                            val action = LoginFragmentDirections.actionLoginFragmentToPlayersFragment(dniManager)
                            findNavController().navigate(action)
                        }else{
                            binding.tvError.text = "El DNI o la contraseña son incorrectos."
                            binding.tvError.visibility = View.VISIBLE
                        }
                    } else {
                        Log.e("Network", "connexion error")
                        binding.tvError.text = "Ha ocurrido un error."
                        binding.tvError.visibility = View.VISIBLE
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("Network", "connexion error", t)
                    binding.tvError.text = "El DNI o la contraseña son incorrectos."
                    binding.tvError.visibility = View.VISIBLE
                }
            })

        }else{
            binding.tvError.text = "Rellene todos los campos."
            binding.tvError.visibility = View.VISIBLE
        }

    }

}