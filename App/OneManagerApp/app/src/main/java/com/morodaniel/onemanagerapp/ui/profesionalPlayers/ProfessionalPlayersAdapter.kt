package com.morodaniel.onemanagerapp.ui.profesionalPlayers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.morodaniel.onemanagerapp.databinding.ItemProfessionalPlayerBinding
import com.morodaniel.onemanagerapp.network.models.getProfessionalPlayers.Statistic
import com.morodaniel.onemanagerapp.ui.lineups.LineupsAdapter

class ProfessionalPlayersAdapter() : ListAdapter<Statistic, ProfessionalPlayersAdapter.ViewHolder>(proPlayerItemCallback()) {

    inner class ViewHolder(val binding: ItemProfessionalPlayerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProfessionalPlayerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfessionalPlayersAdapter.ViewHolder, position: Int) {
        val proPlayer = getItem(position)

    }

}

class proPlayerItemCallback : DiffUtil.ItemCallback<Statistic>() {
    override fun areItemsTheSame(oldItem: Statistic, newItem: Statistic): Boolean =
        oldItem._id == newItem._id

    override fun areContentsTheSame(oldItem: Statistic, newItem: Statistic): Boolean =
        oldItem._id == newItem._id && oldItem.player.firstname == newItem.player.firstname
}