package com.example.inventorylock

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.inventorylock.databinding.BoxBinding

class BoxHolder(item: View): RecyclerView.ViewHolder(item) {
    val binding = BoxBinding.bind(item)
    

    val imageList = listOf(R.drawable.red_locked,
        R.drawable.red_unlocked,
        R.drawable.green_locked,
        R.drawable.green_unlocked,
        R.drawable.blue_locked,
        R.drawable.blue_unlocked,
        R.drawable.yellow_locked,
        R.drawable.yellow_unlocked,
        R.drawable.gray_locked,
        R.drawable.gray_unlocked)

    fun bind(box: Box, listener: BoxAdapter.Listener){
        val status = if (box.status) "закрыт" else "открыт"
        with(binding){
            ivTitle.setImageResource(imageList[box.imgId])
            tvTitle.text = "${box.color} ящик №${box.id} $status"
            itemView.setOnClickListener{
                listener.onClick(box)
            }
        }
    }
}
