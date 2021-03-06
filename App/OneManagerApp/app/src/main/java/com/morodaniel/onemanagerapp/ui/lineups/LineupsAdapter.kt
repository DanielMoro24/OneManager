package com.morodaniel.onemanagerapp.ui.lineups

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.morodaniel.onemanagerapp.R
import com.morodaniel.onemanagerapp.databinding.ItemLineupBinding
import com.morodaniel.onemanagerapp.extensions.imageUrl
import com.morodaniel.onemanagerapp.objects.LineupsObject

class LineupsAdapter(private val onLineupClick: (LineupsObject) -> Unit) :
    ListAdapter<LineupsObject, LineupsAdapter.ViewHolder>(LineupItemCallback()) {

    inner class ViewHolder(val binding: ItemLineupBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLineupBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LineupsAdapter.ViewHolder, position: Int) {
        val lineup = getItem(position)
        holder.binding.ivLogo8.imageUrl(R.drawable.soccer_player__negra)
        holder.binding.tvJourney.text = lineup.journey
        holder.binding.root.setOnClickListener { onLineupClick(lineup) }
    }

}

class LineupItemCallback : DiffUtil.ItemCallback<LineupsObject>() {
    override fun areItemsTheSame(oldItem: LineupsObject, newItem: LineupsObject): Boolean =
        oldItem.journey == newItem.journey

    override fun areContentsTheSame(oldItem: LineupsObject, newItem: LineupsObject): Boolean =
        oldItem.journey == newItem.journey && oldItem.pos == newItem.pos
}
