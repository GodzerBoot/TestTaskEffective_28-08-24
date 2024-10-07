package com.example.core.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen

interface Screens {
    fun signIn(): FragmentScreen
    fun main(): FragmentScreen
    fun conformation(email: String): FragmentScreen
    fun mainFull(): FragmentScreen
}