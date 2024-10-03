package com.example.testtaskeffective_29_08_24.ui.mainfull.adapter.items

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