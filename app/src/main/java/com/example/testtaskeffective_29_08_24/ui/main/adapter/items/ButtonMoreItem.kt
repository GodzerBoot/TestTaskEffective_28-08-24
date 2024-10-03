package com.example.testtaskeffective_29_08_24.ui.main.adapter.items

data class ButtonMoreItem(
    val quantityOfVacancies: Int,
) {
    val vacancyWord = getVacancyWordFromQuantity()
    private fun getVacancyWordFromQuantity(): String {
        return when(quantityOfVacancies%10) {
            1 -> "вакансия"
            2, 3, 4 -> "вакансии"
            else -> "вакансий"
        }
    }
}