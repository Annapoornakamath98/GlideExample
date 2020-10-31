package com.yml.glideexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(private val uList: List<Any>) : RecyclerView.Adapter<AdapterClass.ResponseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResponseViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.image_list, parent, false)
        return ResponseViewHolder(itemView)
    }

    class ResponseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val responseItemView: TextView = itemView.findViewById(R.id.images)

    }

    override fun onBindViewHolder(holder: ResponseViewHolder, position: Int) {
        holder.responseItemView.text = uList[position].toString()
    }

    override fun getItemCount(): Int {
        return uList.size
    }
}