package com.example.features.main_screen.ui.adapter.item

data class HeaderItem(
    val vacancyNumber: Int,
){
    val vacancyWord = getVacancyWordFromNumber()

    private fun getVacancyWordFromNumber(): String {
        return when(vacancyNumber%10){
            1 -> "вакансия"
            2, 3, 4 -> "вакансии"
            else -> "вакансий"
        }
    }
}