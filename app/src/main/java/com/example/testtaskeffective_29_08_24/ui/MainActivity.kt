package com.example.testtaskeffective_29_08_24.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testtaskeffective_29_08_24.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
