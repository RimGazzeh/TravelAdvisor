package com.rim.traveladvisor.features.dashboard.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rim.domain.models.entity.UrbanArea
import com.rim.traveladvisor.databinding.ItemUrbanAreaBinding
import com.rim.traveladvisor.features.dashboard.adapter.ScoreAdapter

/**
 * Created by Rim Gazzah on 3/6/21.
 **/
class UrbanAreaViewHolder(private val binding: ItemUrbanAreaBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(urbanArea: UrbanArea, onClickUA: (UrbanArea) -> Unit) {
        binding.itemUATitle.text = urbanArea.name
        binding.itemUAListScores.adapter = ScoreAdapter(urbanArea.getTravelScoreCategories())
        binding.itemUARootView.setOnClickListener {
            onClickUA(urbanArea)
        }
    }

    object Factory {
        fun create(parent: ViewGroup): UrbanAreaViewHolder {
            val binding = ItemUrbanAreaBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return UrbanAreaViewHolder(binding)
        }
    }
}