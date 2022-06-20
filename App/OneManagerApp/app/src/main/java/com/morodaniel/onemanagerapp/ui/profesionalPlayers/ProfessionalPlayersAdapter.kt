package com.morodaniel.onemanagerapp.ui.profesionalPlayers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.morodaniel.onemanagerapp.R
import com.morodaniel.onemanagerapp.databinding.ItemProfessionalPlayerBinding
import com.morodaniel.onemanagerapp.extensions.imageUrl
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
        holder.binding.ivLogo9.imageUrl(R.drawable.soccer_player__negra)
        holder.binding.tvPlayerAge2.text = proPlayer.player.age.toString() + " años"
        holder.binding.tvPlayerName3.text = proPlayer.player.name
        holder.binding.tvPlayerMatch.text = proPlayer.statistics[0].games.appearences.toString()
        holder.binding.tvPlayerGoals2.text = proPlayer.statistics[0].goals.total.toString()
        holder.binding.tvPlayerAssists2.text = proPlayer.statistics[0].goals.assists.toString()
        holder.binding.tvPlayerPosition2.text = proPlayer.statistics[0].games.position
    }

}

class proPlayerItemCallback : DiffUtil.ItemCallback<Statistic>() {
    override fun areItemsTheSame(oldItem: Statistic, newItem: Statistic): Boolean =
        oldItem._id == newItem._id

    override fun areContentsTheSame(oldItem: Statistic, newItem: Statistic): Boolean =
        oldItem._id == newItem._id && oldItem.player.firstname == newItem.player.firstname
}