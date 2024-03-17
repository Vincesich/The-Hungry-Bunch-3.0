package com.example.thehungrybunch30.ui.carousel_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.thehungrybunch30.R

class CarouselAdapter(private val imageList: List<Int>) :
    RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.carousel_item_layout, parent, false)
        return CarouselViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val imageResourceId = imageList[position]
        holder.imageView.setImageResource(imageResourceId)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    // ViewHolder class to hold references to views
    class CarouselViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.carousel_beef_samosa)
    }
}

