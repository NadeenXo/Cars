package com.example.cars

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cars.core.Retrofit
import com.example.cars.dataModels.CarsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarViewModel : ViewModel() {
    private val _carsLiveData = MutableLiveData<List<CarsModel>>()
    val carsLiveData: LiveData<List<CarsModel>> = _carsLiveData

    fun fetchCarsFromApi() {
        val apiService = Retrofit.getInstance()
        val carsModelCall = apiService.getData()
        carsModelCall.enqueue(object : Callback<List<CarsModel>?> {
            override fun onResponse(
                call: Call<List<CarsModel>?>,
                response: Response<List<CarsModel>?>
            ) {
                _carsLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<CarsModel>?>, t: Throwable) {
                Log.d("CarsListActivity", "${t.message}")
            }
        })
    }
}