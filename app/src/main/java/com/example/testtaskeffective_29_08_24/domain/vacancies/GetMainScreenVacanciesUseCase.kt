package com.example.testtaskeffective_29_08_24.domain.vacancies

import com.example.testtaskeffective_29_08_24.Vacancy
import com.example.testtaskeffective_29_08_24.data.vacancy.VacancyRepository

class GetMainScreenVacanciesUseCase(private val vacancyRepository: VacancyRepository) {
    suspend operator fun invoke(): List<Vacancy> {
        val response = vacancyRepository.getVacancies()
        return response.getOrNull()?.vacancies?.subList(0, 2) ?: emptyList()
    }
}