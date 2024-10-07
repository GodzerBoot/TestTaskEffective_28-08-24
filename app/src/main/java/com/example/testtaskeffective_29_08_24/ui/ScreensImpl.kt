package com.example.testtaskeffective_29_08_24.ui

import com.example.core.navigation.Screens
import com.example.features.login.confirmation.ConfirmationFragment
import com.example.features.login.signin.SignInFragment
import com.example.features.main_screen.ui.MainScreenFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ScreensImpl : Screens {
    override fun signIn() = FragmentScreen { SignInFragment() }
    override fun main() = FragmentScreen { MainScreenFragment() }
    override fun conformation(email: String) = FragmentScreen { ConfirmationFragment.newInstance(email) }
}