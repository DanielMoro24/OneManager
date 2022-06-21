package com.morodaniel.onemanagerapp.ui.profesionalPlayers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.morodaniel.onemanagerapp.R
import com.morodaniel.onemanagerapp.databinding.FragmentDetailProfessionalPlayerBinding
import com.morodaniel.onemanagerapp.extensions.imageUrl
import com.morodaniel.onemanagerapp.extensions.imageUrl2
import com.morodaniel.onemanagerapp.extensions.mainActivity
import com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers.Statistic

class DetailProfessionalPlayerFragment : Fragment() {
    private var _binding: FragmentDetailProfessionalPlayerBinding? = null
    private val binding get() = _binding!!
    private val args: DetailProfessionalPlayerFragmentArgs by navArgs()
    private var dniManager: String = " "
    private var index: Int = 0
    private var proPlayers: List<Statistic>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           dniManager = args.dni
            index = args.pos
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailProfessionalPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivLogo10.imageUrl(R.drawable.soccer_player__negra)
        getProPlayers()
        binding.ivPlayerPhoto.imageUrl2(proPlayers?.get(index)?.player?.photo ?: "")
        setText()
        binding.btnBack6.setOnClickListener { goProPlayers() }
    }

    private fun goProPlayers() {
        val action = DetailProfessionalPlayerFragmentDirections.actionDetailProfessionalPlayerFragmentToProfesionalPlayersFragment(dniManager)
        findNavController().navigate(action)
    }

    private fun setText() {
        binding.tvPlayerName4.text = proPlayers?.get(index)?.player?.name ?: ""
        binding.tvPlayerTeam.text = proPlayers?.get(index)?.statistics?.get(0)?.team?.name ?: ""
        binding.tvPlayerLeague.text = proPlayers?.get(index)?.statistics?.get(0)?.league?.name ?: ""
        binding.tvPlayerMatch3.text = proPlayers?.get(index)?.statistics?.get(0)?.games?.appearences.toString() ?: ""
        binding.tvPlayerGoals4.text = proPlayers?.get(index)?.statistics?.get(0)?.goals?.total.toString() ?: ""
        binding.tvPlayerAssists5.text = proPlayers?.get(index)?.statistics?.get(0)?.goals?.assists.toString() ?: ""
        binding.tvPlayerYellow.text = proPlayers?.get(index)?.statistics?.get(0)?.cards?.yellow.toString() ?: ""
        binding.tvPlayerRed5.text = proPlayers?.get(index)?.statistics?.get(0)?.cards?.red.toString() ?: ""
        binding.tvPlayerAge5.text = proPlayers?.get(index)?.player?.age.toString() ?: ""
    }

    private fun getProPlayers() {
        proPlayers = mainActivity().sendProPlayers()

    }

}