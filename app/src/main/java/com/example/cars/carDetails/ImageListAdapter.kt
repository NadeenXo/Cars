package com.example.cars.carDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cars.R
import com.example.cars.dataModels.Images
import com.example.cars.databinding.ItemImageListBinding

class ImageListAdapter :
    RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    private val images = mutableListOf<Images>()
    lateinit var binding: ItemImageListBinding


    fun setData(data: List<Images>) {
        images.clear()
        images.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = binding.imageView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemImageListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val image = images[position]

        Glide.with(holder.imageView.context)
            .load(image.url)
            .centerCrop()
            .placeholder(R.drawable.car)
            .error(R.drawable.car_crash)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}