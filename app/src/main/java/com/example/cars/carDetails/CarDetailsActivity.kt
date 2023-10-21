package com.example.cars.carDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cars.carsList.CarsActivity
import com.example.cars.dataModels.CarsModel
import com.example.cars.databinding.ActivityCarDetailsBinding

class CarDetailsActivity : AppCompatActivity() {
    private val adapter = ImageListAdapter()
    private lateinit var binding: ActivityCarDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val car = intent.getParcelableExtra<CarsModel>(CarsActivity.INTENT_CAR_DETAILS)

        if(car!=null) {
            setImgListRecyclerView()
            adapter.setData(car.images)

            binding.tvDetailsMake.text = car.make ?: "none"
            binding.tvDetailsModel.text = car.model?: "none"
            binding.tvDetailsPrice.text = car.price?.toString()?: "none"
            binding.tvDetailsDesc.text = car.description?: "none"

        }
    }

    private fun setImgListRecyclerView() {
        val recyclerView = binding.imageList
        recyclerView.layoutManager =
            LinearLayoutManager(this
            ,LinearLayoutManager.HORIZONTAL
            ,false)
        recyclerView.adapter = adapter
    }
}

//TO DO -> if there is no img show default one + colors
