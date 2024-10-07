package com.example.features.main_screen.ui.adapter.items

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