package com.example.eggboilder

import androidx.recyclerview.widget.DiffUtil

class TimeDiffUtilCallBack : DiffUtil.ItemCallback<Boil>() {
    override fun areItemsTheSame(oldItem: Boil, newItem: Boil): Boolean {
        return oldItem.time == newItem.time
    }

    override fun areContentsTheSame(oldItem: Boil, newItem: Boil): Boolean {
        return oldItem == newItem
    }
}