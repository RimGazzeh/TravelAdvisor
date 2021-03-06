package com.rim.traveladvisor.features.dashboard.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rim.domain.models.entity.UrbanArea
import com.rim.traveladvisor.features.dashboard.viewholder.UrbanAreaViewHolder

/**
 * Created by Rim Gazzah on 3/6/21.
 **/
class UrbanAreaAdapter(private val onClickUA: (UrbanArea) -> Unit) :
    RecyclerView.Adapter<UrbanAreaViewHolder>() {
    private var data = listOf<UrbanArea>()
    fun setData(newData: List<UrbanArea>) {
        data = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UrbanAreaViewHolder {
        return UrbanAreaViewHolder.Factory.create(parent)
    }

    override fun onBindViewHolder(holder: UrbanAreaViewHolder, position: Int) {
        holder.bind(data[position], onClickUA)
    }

    override fun getItemCount() = data.size
}