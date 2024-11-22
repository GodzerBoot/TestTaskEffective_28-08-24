package com.example.features.main_screen.ui

import android.view.View.OnClickListener
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.navigation.Screens
import com.example.core.network.data.VacancyResponse
import com.example.features.main_screen.domain.GetMainScreenResponseUseCase
import com.example.features.main_screen.domain.Offer
import com.example.features.main_screen.ui.adapter.item.ButtonMoreItem
import com.example.features.main_screen.ui.adapter.item.HeaderItem
import com.example.features.main_screen.ui.adapter.item.OfferItem
import com.example.features.main_screen.ui.adapter.item.OffersItem
import com.example.features.main_screen.ui.adapter.item.TitleItem
import com.example.features.main_screen.ui.adapter.item.VacancyItem
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.time.LocalDate

class MainScreenViewModel(
    private val useCase: GetMainScreenResponseUseCase
) : ViewModel(), KoinComponent {
    private val _uiState = MutableStateFlow(MainScreenUiState(emptyList(), emptyList()))
    val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()
    private val cicerone: Cicerone<Router> by inject()
    private val screens: Screens by inject()
//    private val database: AppDatabase by inject()
//    private val vacancyDao: VacancyDao by inject()
    init {
        fetchVacancies()
    }

    private fun fetchVacancies() = viewModelScope.launch {
        val pair = useCase()
        val vacancies = pair.first.map(::mapVacancyToVacancyItem)
        val offers = pair.second.map(::mapOfferToOfferItem)
        val subRecyclerViewItems = mutableListOf<OfferItem>()
        subRecyclerViewItems.addAll(offers)
        val recyclerViewItems = mutableListOf<Any>() // making list of items

        recyclerViewItems.add(OffersItem) // adding offers to recycler
        recyclerViewItems.add(TitleItem) // adding title to recycler
        recyclerViewItems.addAll(vacancies.subList(0, 2)) // adding 2 vacancies to recycler
        recyclerViewItems.add(ButtonMoreItem(vacancies.size - 2)) // adding button to recycler, supplying it with unseen vacancy quantity
        _uiState.emit(MainScreenUiState(recyclerViewItems, subRecyclerViewItems)) // updating _uiState
    }

    fun onShowMoreClick() = viewModelScope.launch {
        val vacancies = useCase().first.map(::mapVacancyToVacancyItem)
        val recyclerViewItems = mutableListOf<Any>() // making list of items

        recyclerViewItems.add(HeaderItem(vacancies.size))
        recyclerViewItems.addAll(vacancies)
        val uiState = uiState.value.copy(vacancies = recyclerViewItems)
        _uiState.emit(uiState)
    }
    private fun mapVacancyToVacancyItem(vacancyResponse: VacancyResponse): VacancyItem {
        val lookingNumber = vacancyResponse.lookingNumber?.let { "Сейчас просматривает $it человек" } ?: ""
        val salary = vacancyResponse.salary?.short?.replace(" до ", "-") ?: ""
        val isVisibleSalary = salary.isNotBlank() && salary.trim().equals("Уровень дохода не указан", true).not()
        val publishedDate = vacancyResponse.publishedDate?.let { "Опубликовано ${LocalDate.parse(it).dayOfMonth} ${getMonth(LocalDate.parse(it).month.value)}" } ?: ""

        val onClickListener = OnClickListener {
            cicerone.router.navigateTo(screens.vacancy(vacancyResponse))
        }
//        val onClickListenerFavorite = fun(t: Any) {
//            val item = t as VacancyItem
//            fun toVacancyEntity(vacancyItem: VacancyItem, isFavourite: Boolean) : VacancyEntity {
//                return VacancyEntity(
//                    id = vacancyItem.id,
//                    lookingNumber = vacancyItem.lookingNumber,
//                    isVisibleLookingNumber = vacancyItem.isVisibleLookingNumber,
//                    title = vacancyItem.title,
//                    isVisibleTitle = vacancyItem.isVisibleTitle,
//                    salary = vacancyItem.salary,
//                    isVisibleSalary = vacancyItem.isVisibleSalary,
//                    town = vacancyItem.town,
//                    isVisibleTown = vacancyItem.isVisibleTown,
//                    company = vacancyItem.company,
//                    isVisibleCompany = vacancyItem.isVisibleCompany,
//                    experience = vacancyItem.experience,
//                    isVisibleExperience = vacancyItem.isVisibleExperience,
//                    publishedDate = vacancyItem.publishedDate,
//                    isVisiblePublishedDate = vacancyItem.isVisiblePublishedDate,
//                    isFavourite = isFavourite,
//                    onClickListenerToVacancy = vacancyItem.onClickListenerToVacancy,
//                    vacancyItem.onClickListenerFavourite,
//                )
//            }
//            if (item.isFavourite){
//                vacancyDao.delete(item.id)
//            } else{
//                vacancyDao.insertAll(toVacancyEntity(item, true))
//            }
//        }

        return VacancyItem(
            id = vacancyResponse.id,
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
            isFavourite = vacancyResponse.isFavorite,
            onClickListenerToVacancy = onClickListener,
//            onClickListenerFavourite = onClickListenerFavorite,
        )
    }
    private fun mapOfferToOfferItem(offer: Offer): OfferItem {
        val buttonText = if (offer.button != null && offer.button.text.isNullOrBlank().not()) {
            offer.button.text!!
        } else ""
        val isVisibleButton = buttonText.isNotBlank()
        val titleLines = if (buttonText.isNotBlank()) 2 else 3

        return OfferItem(
            type = offer.type,
            title = offer.title,
            titleLines = titleLines,
            buttonText = buttonText,
            isVisibleButton = isVisibleButton,
            link = offer.link
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