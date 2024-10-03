package com.example.testtaskeffective_29_08_24.ui

import com.example.testtaskeffective_29_08_24.ui.confirmation.ConfirmationFragment
import com.example.testtaskeffective_29_08_24.ui.main.MainFragment
import com.example.testtaskeffective_29_08_24.ui.mainfull.MainFullFragment
import com.example.testtaskeffective_29_08_24.ui.signin.SignInFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.core.component.KoinComponent

object Screens {
    fun signIn() = FragmentScreen { SignInFragment() }
    fun main() = FragmentScreen { MainFragment() }
    fun conformation(email: String) = FragmentScreen { ConfirmationFragment.newInstance(email) }
    fun mainFull() = FragmentScreen { MainFullFragment() }
}