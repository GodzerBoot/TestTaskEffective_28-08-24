package com.example.testtaskeffective_29_08_24.ui.main

import android.widget.TextView

data class MainUiState(
    val titleVacancies: TextView?,
    val vacancies: List<VacancyItem>,
    val buttonMore: com.google.android.material.button.MaterialButton?
)