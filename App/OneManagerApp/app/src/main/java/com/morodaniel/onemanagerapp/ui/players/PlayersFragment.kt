package com.morodaniel.onemanagerapp.ui.players

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.morodaniel.onemanagerapp.R
import com.morodaniel.onemanagerapp.databinding.FragmentLoginBinding
import com.morodaniel.onemanagerapp.databinding.FragmentPlayersBinding
import com.morodaniel.onemanagerapp.extensions.mainActivity
import com.morodaniel.onemanagerapp.network.NetworkConfig
import com.morodaniel.onemanagerapp.network.models.getManager.GetManagerRequest
import com.morodaniel.onemanagerapp.network.models.getManager.GetManagerResponse
import com.morodaniel.onemanagerapp.network.models.getManager.PlayerResponse
import com.morodaniel.onemanagerapp.network.models.getManager.toMap
import com.morodaniel.onemanagerapp.objects.PlayersObject
import com.morodaniel.onemanagerapp.ui.LoginFragmentDirections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayersFragment : Fragment() {
    private var _binding: FragmentPlayersBinding? = null
    private val binding get() = _binding!!
    private val args: PlayersFragmentArgs by navArgs()
    private var dniManager: String = " "
    private var players: MutableList<PlayerResponse>? = null
    private val adapter = PlayersAdapter{
        val action = PlayersFragmentDirections.actionPlayersFragmentToDetailPlayerFragment(it.pos)
        findNavController().navigate(action)
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
        binding.fbtnAddPlayers.setOnClickListener {
            val action = PlayersFragmentDirections.actionPlayersFragmentToAddPlayersFragment(dniManager)
            findNavController().navigate(action)
        }
    }

    private fun getManager(dniManager: String) {
        players = mainActivity().sendManager(dniManager)?.players
        adapter.submitList(players?.toMap())
    }


}