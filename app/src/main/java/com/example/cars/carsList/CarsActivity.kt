package com.example.cars.carsList

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cars.CarViewModel
import com.example.cars.carDetails.CarDetailsActivity
import com.example.cars.dataModels.CarsModel
import com.example.cars.databinding.ActivityCarsBinding

class CarsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCarsBinding
    private lateinit var rvAdapter: CarsAdapter
    private val viewModel: CarViewModel by viewModels()

    companion object {
        const val INTENT_CAR_DETAILS = "details_screen"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerview()

        rvAdapter.setOnClickListener(object : CarsAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, car: CarsModel) {
                val intent = Intent(this@CarsActivity, CarDetailsActivity::class.java)
                intent.putExtra(INTENT_CAR_DETAILS, car)
                startActivity(intent)
            }
        })
        viewModel.carsLiveData.observe(this) { cars ->
            cars?.let { rvAdapter.setData(it) }
        }
        // Fetch the data from the API
        viewModel.fetchCarsFromApi()
    }

    private fun setRecyclerview() {
        rvAdapter = CarsAdapter()
        binding.rvCars.setHasFixedSize(true)
        binding.rvCars.layoutManager = LinearLayoutManager(this)
        binding.rvCars.adapter = rvAdapter
    }
}