package com.example.testtaskeffective_29_08_24.ui

import com.example.core.navigation.Screens
import com.example.features.login.confirmation.ConfirmationFragment
import com.example.features.login.signin.SignInFragment
import com.example.testtaskeffective_29_08_24.ui.main.MainFragment
import com.example.testtaskeffective_29_08_24.ui.mainfull.MainFullFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ScreensImpl : Screens {
    override fun signIn() = FragmentScreen { SignInFragment() }
    override fun main() = FragmentScreen { MainFragment() }
    override fun conformation(email: String) = FragmentScreen { ConfirmationFragment.newInstance(email) }
    override fun mainFull() = FragmentScreen { MainFullFragment() }
}