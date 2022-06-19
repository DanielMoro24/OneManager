package com.morodaniel.onemanagerapp.ui.lineups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.morodaniel.onemanagerapp.databinding.FragmentDetailLineupBinding
import com.morodaniel.onemanagerapp.network.models.getManager.ManagerResponse

class DetailLineupFragment : Fragment() {
    private var _binding: FragmentDetailLineupBinding? = null
    private val binding get() = _binding!!
    private val args: DetailLineupFragmentArgs by navArgs()
    private var dniManager: String = " "
    private var index: Int = 0
    private var manager: ManagerResponse? = null

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
    ): View? {
        _binding = FragmentDetailLineupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}