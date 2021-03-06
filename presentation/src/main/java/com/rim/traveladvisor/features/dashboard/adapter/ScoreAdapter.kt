package com.rim.traveladvisor.features.dashboard.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rim.domain.models.entity.ScoreCategory
import com.rim.traveladvisor.features.dashboard.viewholder.ScoreViewHolder

/**
 * Created by Rim Gazzah on 3/6/21.
 **/
class ScoreAdapter(private val data: List<ScoreCategory>) :
    RecyclerView.Adapter<ScoreViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        return ScoreViewHolder.Factory.create(parent)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}