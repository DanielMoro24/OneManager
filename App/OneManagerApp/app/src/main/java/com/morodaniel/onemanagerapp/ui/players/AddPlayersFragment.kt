package com.morodaniel.onemanagerapp.ui.players

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.morodaniel.onemanagerapp.R
import com.morodaniel.onemanagerapp.databinding.FragmentAddPlayersBinding
import com.morodaniel.onemanagerapp.databinding.FragmentPlayersBinding
import com.morodaniel.onemanagerapp.extensions.mainActivity
import com.morodaniel.onemanagerapp.network.models.getManager.ManagerResponse
import com.morodaniel.onemanagerapp.network.models.getManager.toMap

class AddPlayersFragment : Fragment() {
    private var _binding: FragmentAddPlayersBinding? = null
    private val binding get() = _binding!!
    private val args: AddPlayersFragmentArgs by navArgs()
    private var dniManager: String = " "
    private var manager: ManagerResponse? = null

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
        _binding = FragmentAddPlayersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getManager(dniManager)

    }

    private fun getManager(dniManager: String) {
        manager = mainActivity().sendManager(dniManager)
    }

    private fun addPlayer(){
        //manager.players.add()
    }

}