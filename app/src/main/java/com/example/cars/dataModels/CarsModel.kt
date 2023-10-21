package com.example.cars.dataModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CarsModel(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("make") var make: String? = null,
    @SerializedName("model") var model: String? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("firstRegistration") var firstRegistration: String? = null,
    @SerializedName("mileage") var mileage: Int? = null,
    @SerializedName("fuel") var fuel: String? = null,
    @SerializedName("images") var images: ArrayList<Images> = arrayListOf(),
    @SerializedName("description") var description: String? = null
) : Parcelable

@Parcelize
data class Images(
    @SerializedName("url") var url: String? = null
) : Parcelable

