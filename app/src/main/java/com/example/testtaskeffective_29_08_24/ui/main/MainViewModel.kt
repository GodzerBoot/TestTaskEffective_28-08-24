package com.example.testtaskeffective_29_08_24.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskeffective_29_08_24.data.vacancy.VacancyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import java.lang.reflect.Constructor

class MainViewModel(
    private val vacancyRepository: VacancyRepository,
) : ViewModel(), KoinComponent {
    private val _uiState = MutableStateFlow(MainUiState(emptyList()))
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()
    init {
        getVacancy()
    }
    private fun getVacancy() = viewModelScope.launch {
        vacancyRepository.getVacancies()
            .onSuccess {
                Log.d("TestTag", it.toString())
                val vacancies = it.vacancies.map {
                    VacancyItem(
                        it.lookingNumber.toString(),
                        it.title ?: "",
                        it.salary?.full ?: "",
                        it.address?.town ?: "",
                        it.company ?: "",
                        it.experience?.previewText ?: "",
                        it.publishedDate ?: ""
                    )
                }
            }
            .onFailure {

            }
    }
}