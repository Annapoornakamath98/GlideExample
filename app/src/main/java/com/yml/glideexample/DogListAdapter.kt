package com.yml.glideexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DogListAdapter(private val context: Context,
                     private val dogList: List<String>) : RecyclerView.Adapter<DogListAdapter.ResponseViewHolder>() {
    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ResponseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.image_list, parent, false)
        return ResponseViewHolder(itemView)
    }

    class ResponseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val responseItemView: ImageView = itemView.findViewById(R.id.images)

    }

    override fun onBindViewHolder(holder: ResponseViewHolder, position: Int) {
        Glide.with(context)
                .load(dogList[position])
                .placeholder(ContextCompat.getDrawable(context, R.drawable.ic_pet))
                .into(holder.responseItemView)
    }

    override fun getItemCount(): Int {
        return dogList.size
    }
}
