package com.example.cars

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cars.carsList.CarsActivity
import com.example.cars.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnWelcome.setOnClickListener {
            intent = Intent(
                applicationContext,
                CarsActivity::class.java
            )
            startActivity(intent)
        }
    }
}