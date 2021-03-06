package com.rim.traveladvisor.features.dashboard.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rim.domain.models.entity.ScoreCategory
import com.rim.traveladvisor.databinding.ItemUaScoreBinding

/**
 * Created by Rim Gazzah on 3/6/21.
 **/
class ScoreViewHolder(private val binding: ItemUaScoreBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(scoreCategory: ScoreCategory) {
        binding.itemUAScore.setTile(scoreCategory.name).setPercentage(scoreCategory.score)
    }

    object Factory {
        fun create(parent: ViewGroup): ScoreViewHolder {
            val binding = ItemUaScoreBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return ScoreViewHolder(binding)
        }
    }
}