package com.morodaniel.onemanagerapp.ui.players

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.morodaniel.onemanagerapp.databinding.FragmentPlayersBinding
import com.morodaniel.onemanagerapp.extensions.mainActivity
import com.morodaniel.onemanagerapp.network.models.getManager.PlayerResponse
import com.morodaniel.onemanagerapp.network.models.getManager.toMap

class PlayersFragment : Fragment() {
    private var _binding: FragmentPlayersBinding? = null
    private val binding get() = _binding!!
    private val args: PlayersFragmentArgs by navArgs()
    private var dniManager: String = " "
    private var players: MutableList<PlayerResponse>? = null
    private val adapter = PlayersAdapter{
        val action = PlayersFragmentDirections.actionPlayersFragmentToDetailPlayerFragment(it.pos, dniManager)
        findNavController().navigate(action)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dniManager = args.dniManager
        }
        getManager(dniManager)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvPlayers.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvPlayers.adapter = adapter
        adapter.submitList(players?.toMap())


        binding.fbtnAdd.setOnClickListener { goAdd(dniManager) }
        binding.ibtnLineups.setOnClickListener { goLineups() }
        binding.ibtnProplayers.setOnClickListener { goProPlayers() }
    }


    private fun goAdd(dniManager: String) {
        val action2 = PlayersFragmentDirections.actionPlayersFragmentToAddPlayersFragment(dniManager)
        findNavController().navigate(action2)
    }

    private fun goProPlayers() {
        val action3 = PlayersFragmentDirections.actionPlayersFragmentToProfesionalPlayersFragment(dniManager)
        findNavController().navigate(action3)
    }

    private fun goLineups() {
        val action3 = PlayersFragmentDirections.actionPlayersFragmentToLineupsFragment(dniManager)
        findNavController().navigate(action3)
    }

    private fun getManager(dniManager: String) {
        players = mainActivity().sendCallManager(dniManager)?.players
    }


}