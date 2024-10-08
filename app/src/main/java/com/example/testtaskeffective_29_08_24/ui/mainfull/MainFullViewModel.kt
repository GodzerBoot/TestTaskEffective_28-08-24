package com.example.testtaskeffective_29_08_24.ui.mainfull

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskeffective_29_08_24.VacancyResponse
import com.example.testtaskeffective_29_08_24.domain.vacancies.GetMainScreenFullVacancyListUseCase
import com.example.testtaskeffective_29_08_24.ui.mainfull.adapter.items.VacancyItem
import com.example.testtaskeffective_29_08_24.ui.mainfull.adapter.items.HeaderItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class MainFullViewModel(
    private val useCase: GetMainScreenFullVacancyListUseCase
) : ViewModel(), KoinComponent {
    private val _uiState = MutableStateFlow(MainFullUiState(emptyList()))
    val uiState: StateFlow<MainFullUiState> = _uiState.asStateFlow()

    init {
        fetchVacancies()
    }

    private fun fetchVacancies() = viewModelScope.launch {
        val vacancyResponse = useCase()
        val vacancies = vacancyResponse.map(::mapVacancyToVacancyItem)
        val recyclerViewItems = mutableListOf<Any>() // making list of items
        recyclerViewItems.add(HeaderItem(vacancies.size)) // adding title to recycler
        recyclerViewItems.addAll(vacancies) // adding vacancies to recycler
        _uiState.emit(MainFullUiState(recyclerViewItems)) // updating _uiState
    }

    private fun mapVacancyToVacancyItem(vacancyResponse: VacancyResponse): VacancyItem {
        val lookingNumber = vacancyResponse.lookingNumber?.let { "Сейчас просматривает $it человек" } ?: ""
        val salary = vacancyResponse.salary?.short?.replace(" до ", "-") ?: ""
        val isVisibleSalary = salary.isNotBlank() && salary.trim().equals("Уровень дохода не указан", true).not()
        val publishedDate = vacancyResponse.publishedDate?.let { "Опубликовано ${it.slice(listOf(8, 9))} ${getMonth(it.slice(listOf(5, 6)).toInt())}" } ?: ""
        return VacancyItem(
            lookingNumber = lookingNumber,
            isVisibleLookingNumber = lookingNumber.isNotBlank(),
            title = vacancyResponse.title ?: "",
            isVisibleTitle = vacancyResponse.title.isNullOrBlank().not(),
            salary = salary,
            isVisibleSalary = isVisibleSalary,
            town = vacancyResponse.address?.town ?: "",
            isVisibleTown = vacancyResponse.address?.town.isNullOrBlank().not(),
            company = vacancyResponse.company ?: "",
            isVisibleCompany = vacancyResponse.company.isNullOrBlank().not(),
            experience = vacancyResponse.experience?.previewText ?: "",
            isVisibleExperience = vacancyResponse.experience?.previewText.isNullOrBlank().not(),
            publishedDate = publishedDate,
            isVisiblePublishedDate = publishedDate.isNotBlank(),
            isFavorite = vacancyResponse.isFavorite
        )
    }

    private fun getMonth(num: Int): String {
        return when (num) {
            1 -> "Января"
            2 -> "Февраля"
            3 -> "Марта"
            4 -> "Апреля"
            5 -> "Мая"
            6 -> "Июня"
            7 -> "Июля"
            8 -> "Августа"
            9 -> "Сентября"
            10 -> "Октября"
            11 -> "Ноября"
            12 -> "Декабря"
            else -> "ERROR:WRONG_MONTH_INDEX"
        }
    }
}