package com.example.cars.carsList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cars.R
import com.example.cars.dataModels.CarsModel
import com.example.cars.databinding.ItemCarBinding

class CarsAdapter() : RecyclerView.Adapter<CarsAdapter.MyViewHolder>() {

    private val cars = mutableListOf<CarsModel>()
    private var onClickListener: OnItemClickListener? = null
    lateinit var binding: ItemCarBinding


    interface OnItemClickListener {
        fun onItemClick(position: Int, car: CarsModel)
    }

    fun setData(data: List<CarsModel>) {
        cars.clear()
        cars.addAll(data)
        notifyDataSetChanged()
    }
    // A function to bind the onclickListener.
    fun setOnClickListener(onClickListener: OnItemClickListener) {
        this.onClickListener = onClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemCarBinding.inflate(
            LayoutInflater.from(parent.context)
            , parent, false)
        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val car = cars[position]

        holder.bindData(car,position)
        holder.itemView.setOnClickListener{
            if (onClickListener != null) {
                onClickListener!!.onItemClick(position, car )
            }
        }
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(car: CarsModel, position: Int) {
            binding.tvMake.text= car.make.toString()
            binding.tvPrice.text = car.price.toString()

            loadCarImage(car, binding.ivCar)

        }
        private fun loadCarImage(car: CarsModel, imageView: ImageView) {
            var imageLoaded = false
            for (image in car.images) {
                if (image.url != null) {
                    Glide.with(imageView.context)
                        .load(image.url)
                        .centerCrop()
                        .into(imageView)
                    imageLoaded = true
                    break
                }
            }

            if (!imageLoaded) {
                // Load a default image or hide the ImageView
                imageView.setImageResource(R.drawable.car_crash)
                // OR
                // imageView.visibility = View.GONE
            }
        }
    }
}