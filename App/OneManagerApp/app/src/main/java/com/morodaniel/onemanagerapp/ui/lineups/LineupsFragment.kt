package com.morodaniel.onemanagerapp.ui.lineups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.morodaniel.onemanagerapp.databinding.FragmentLineupsBinding
import com.morodaniel.onemanagerapp.extensions.mainActivity
import com.morodaniel.onemanagerapp.network.models.getManager.LineupsResponse
import com.morodaniel.onemanagerapp.network.models.getManager.toMap

class LineupsFragment : Fragment() {
    private var _binding: FragmentLineupsBinding? = null
    private val binding get() = _binding!!
    private val args: LineupsFragmentArgs by navArgs()
    private var dniManager: String = " "
    private var lineups: MutableList<LineupsResponse>? = null
    private val adapter = LineupsAdapter {
        val action = LineupsFragmentDirections.actionLineupsFragmentToDetailLineupFragment(dniManager, it.pos)
        findNavController().navigate(action)
    }

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
        _binding = FragmentLineupsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvLineups.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvLineups.adapter = adapter
        getManager(dniManager)
        adapter.submitList(lineups?.toMap())
        binding.fbtnAdd3.setOnClickListener { goAdd(dniManager) }
        binding.ibtnPlayers2.setOnClickListener { goPlayers() }
        binding.ibtnProplayers2.setOnClickListener { goProPlayers() }
    }

    override fun onStart() {
        super.onStart()
        adapter.submitList(lineups?.toMap())
    }

    private fun getManager(dniManager: String) {
        lineups = mainActivity().sendCallManager(dniManager)?.lineups
    }

    private fun goAdd(dniManager: String) {
        val action = LineupsFragmentDirections.actionLineupsFragmentToAddLineupsFragment(dniManager)
        findNavController().navigate(action)
    }

    private fun goProPlayers() {
        val action = LineupsFragmentDirections.actionLineupsFragmentToProfesionalPlayersFragment(dniManager)
        findNavController().navigate(action)
    }

    private fun goPlayers() {
        val action = LineupsFragmentDirections.actionLineupsFragmentToPlayersFragment(dniManager)
        findNavController().navigate(action)
    }

}