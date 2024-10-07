package com.example.testtaskeffective_29_08_24.domain.vacancies

import com.example.testtaskeffective_29_08_24.VacancyResponse
import com.example.core.network.data.rasponse.ResponseRepository

class GetMainScreenFullVacancyListUseCase(private val responseRepository: ResponseRepository) {
    suspend operator fun invoke(): List<VacancyResponse> {
        val response = responseRepository.getVacancies()
        return response.getOrNull()?.vacancies ?: emptyList()
    }
}