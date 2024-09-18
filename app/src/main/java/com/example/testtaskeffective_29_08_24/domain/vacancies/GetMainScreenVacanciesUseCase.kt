package com.example.testtaskeffective_29_08_24.domain.vacancies

import com.example.testtaskeffective_29_08_24.Offer
import com.example.testtaskeffective_29_08_24.Vacancy
import com.example.testtaskeffective_29_08_24.data.vacancy.VacancyRepository

class GetMainScreenVacanciesUseCase(private val vacancyRepository: VacancyRepository) {
    suspend operator fun invoke(): Pair<List<Vacancy>, List<Offer>> {
        val response = vacancyRepository.getVacancies()
        return Pair(response.getOrNull()?.vacancies?.subList(0, 2) ?: emptyList(), response.getOrNull()?.offers?.toList() ?: emptyList())
    }
}