package com.morodaniel.onemanagerapp.ui.lineups

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.morodaniel.onemanagerapp.R
import com.morodaniel.onemanagerapp.databinding.FragmentLineupsBinding
import com.morodaniel.onemanagerapp.databinding.FragmentPlayersBinding
import com.morodaniel.onemanagerapp.extensions.mainActivity
import com.morodaniel.onemanagerapp.network.models.getManager.LineupsResponse
import com.morodaniel.onemanagerapp.network.models.getManager.PlayerResponse
import com.morodaniel.onemanagerapp.network.models.getManager.toMap
import com.morodaniel.onemanagerapp.ui.players.PlayersFragmentArgs

class LineupsFragment : Fragment() {
    private var _binding: FragmentLineupsBinding? = null
    private val binding get() = _binding!!
    private val args: LineupsFragmentArgs by navArgs()
    private var dniManager: String = " "
    private var lineups: MutableList<LineupsResponse>? = null
    private val adapter = LineupsAdapter {

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
    ): View? {
        _binding = FragmentLineupsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvLineups.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvLineups.adapter = adapter
        getManager(dniManager)
        adapter.submitList(lineups?.toMap())
    }

    override fun onStart() {
        super.onStart()
        adapter.submitList(lineups?.toMap())
    }

    private fun getManager(dniManager: String) {
        lineups = mainActivity().sendCallManager(dniManager)?.lineups
    }

}