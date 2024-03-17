package com.example.thehungrybunch30.ui.carousel_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.thehungrybunch30.R

class CarouselAdapter(private val images: List<Int>,private val onClickListener: (Int) -> Unit):
    RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        return CarouselViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.carousel_item_layout, parent, false
            )
        )
    }
    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
       holder.bind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size

    }

    inner class CarouselViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val carouselImageView: AppCompatImageView = view.findViewById(R.id.carousel_image_view)
        init {
            carouselImageView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onClickListener(images[position])
                }
            }
        }

        fun bind(imageUrl: Int){
            carouselImageView.load(imageUrl){
                transformations(RoundedCornersTransformation(8f))

            }
            carouselImageView.setOnClickListener { onClickListener(imageUrl) }
        }
    }
}



