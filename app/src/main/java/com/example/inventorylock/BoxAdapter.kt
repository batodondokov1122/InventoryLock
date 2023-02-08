package com.example.inventorylock

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class BoxAdapter(val listener: Listener): RecyclerView.Adapter<BoxHolder> (){
    val boxes = arrayListOf<Box>(Box(1,"Красный", true, 0),
        Box(2,"Зелёный", true, 2),
        Box(3,"Синий", true, 4),
        Box(4,"Жёлтый", true, 6),
        Box(5,"Серый", true, 8))


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoxHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.box, parent, false)
        return BoxHolder(view)
    }

    override fun onBindViewHolder(holder: BoxHolder, position: Int) {
        holder.bind(boxes[position], listener)
    }

    override fun getItemCount(): Int {
        return boxes.size
    }

    interface Listener{
        fun onClick(box: Box)
    }

}