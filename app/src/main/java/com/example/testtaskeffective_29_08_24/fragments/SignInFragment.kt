package com.example.testtaskeffective_29_08_24.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testtaskeffective_29_08_24.databinding.FragmentSigninBinding

class SignInFragment : Fragment() {
    private lateinit var binding : FragmentSigninBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSigninBinding.inflate(layoutInflater)
        return binding.root
    }

}