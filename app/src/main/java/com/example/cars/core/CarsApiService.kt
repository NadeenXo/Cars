package com.example.cars.core

import com.example.cars.dataModels.CarsModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CarsApiService {
    @GET(" ")
    fun getData(): Call<List<CarsModel>>
}

object Retrofit {
    private const val BASE_URL = "http://private-fe87c-simpleclassifieds.apiary-mock.com/"
    fun getInstance(): CarsApiService {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CarsApiService::class.java)
    }
}