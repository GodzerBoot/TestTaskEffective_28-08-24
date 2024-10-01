package com.example.testtaskeffective_29_08_24.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testtaskeffective_29_08_24.R
import com.example.testtaskeffective_29_08_24.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val cicerone: Cicerone<Router> by inject()
    private val navigator = AppNavigator(this, R.id.fragment_container_view)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        cicerone.getNavigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        cicerone.getNavigatorHolder().removeNavigator()
        super.onPause()
    }
}
