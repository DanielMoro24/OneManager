package com.morodaniel.onemanagerapp.ui.players

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.morodaniel.onemanagerapp.databinding.ItemPlayerBinding
import com.morodaniel.onemanagerapp.objects.PlayersObject

class PlayersAdapter(private val onPlayerClick: (PlayersObject) -> Unit) :
    ListAdapter<PlayersObject, PlayersAdapter.ViewHolder>(PlayerItemCallback()) {

    inner class ViewHolder(val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPlayerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = getItem(position)
        holder.binding.tvPlayerName.text = player.name + " " + player.firstname
        holder.binding.tvPlayerPosition.text = player.position
        holder.binding.tvPlayerAge.text = player.age.toString()
        holder.binding.tvPlayerGoals.text = player.goals.toString()
        holder.binding.tvPlayerAssists.text = player.assists.toString()
        holder.binding.root.setOnClickListener { onPlayerClick(player) }
    }

}

class PlayerItemCallback : DiffUtil.ItemCallback<PlayersObject>() {
    override fun areItemsTheSame(oldItem: PlayersObject, newItem: PlayersObject): Boolean =
        oldItem.dni == newItem.dni

    override fun areContentsTheSame(oldItem: PlayersObject, newItem: PlayersObject): Boolean =
        oldItem.name == newItem.name && oldItem.firstname == newItem.firstname
}