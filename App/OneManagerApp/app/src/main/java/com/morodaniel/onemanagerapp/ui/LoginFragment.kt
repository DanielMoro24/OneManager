package com.morodaniel.onemanagerapp.ui

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
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivLogo.imageUrl(R.drawable.soccer_player__negra)
        binding.btnLogin.setOnClickListener { checkLogin() }
        binding.btnRegister.setOnClickListener { goToRegister() }
    }

    private fun goToRegister() {
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        findNavController().navigate(action)
    }

    private fun checkLogin() {
        if (binding.ptDni.text != null && binding.ptPassword.text != null){
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
                            //aviso de datos incorrectos
                        }
                    } else {
                        Log.e("Network", "connexion error")
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("Network", "connexion error", t)


                }
            })

        }else{
            //aviso de rellenar campos
        }

    }

}