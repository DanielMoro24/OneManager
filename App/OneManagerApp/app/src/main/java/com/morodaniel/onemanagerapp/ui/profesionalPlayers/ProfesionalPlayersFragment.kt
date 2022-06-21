package com.morodaniel.onemanagerapp.ui.profesionalPlayers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.morodaniel.onemanagerapp.databinding.FragmentProfesionalPlayersBinding
import com.morodaniel.onemanagerapp.extensions.mainActivity
import com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers.Statistic
import com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers.toMap

class ProfesionalPlayersFragment : Fragment() {
    private var _binding: FragmentProfesionalPlayersBinding? = null
    private val binding get() = _binding!!
    private val args: ProfesionalPlayersFragmentArgs by navArgs()
    private var dniManager: String = " "
    private var proPlayers: List<Statistic>? = null
    private val adapter = ProfessionalPlayersAdapter{
        val action = ProfesionalPlayersFragmentDirections.actionProfesionalPlayersFragmentToDetailProfessionalPlayerFragment(it.pos , dniManager)
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
        _binding = FragmentProfesionalPlayersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvProplayers.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvProplayers.adapter = adapter
        getProPlayers()
        adapter.submitList(proPlayers.toMap())
        binding.ibtnLineups3.setOnClickListener { goLineups() }
        binding.ibtnPlayers3.setOnClickListener { goPlayers() }
    }


    private fun goPlayers() {
        val action = ProfesionalPlayersFragmentDirections.actionProfesionalPlayersFragmentToPlayersFragment(dniManager)
        findNavController().navigate(action)
    }

    private fun getProPlayers() {
        proPlayers = mainActivity().sendCallProPlayers()
    }

    private fun goLineups() {
        val action = ProfesionalPlayersFragmentDirections.actionProfesionalPlayersFragmentToLineupsFragment(dniManager)
        findNavController().navigate(action)
    }

}