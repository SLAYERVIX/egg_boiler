package com.example.eggboilder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.eggboilder.databinding.ItemRvBoilBinding

class TimeAdapter : ListAdapter<Boil, TimeAdapter.TimeViewHolder>(TimeDiffUtilCallBack()) {

    inner class TimeViewHolder(private val binding: ItemRvBoilBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Boil) {
            binding.boil = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeViewHolder {
        return TimeViewHolder(
            ItemRvBoilBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TimeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}