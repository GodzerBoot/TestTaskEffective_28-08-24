package com.example.testtaskeffective_29_08_24.domain.vacancies

import com.example.testtaskeffective_29_08_24.VacancyResponse
import com.example.core.network.data.rasponse.ResponseRepository

class GetMainScreenPartialResponseUseCase(private val responseRepository: ResponseRepository) {
    suspend operator fun invoke(): Triple<List<VacancyResponse>, List<Offer>, Int> {
        val response = responseRepository.getVacancies()
        val vacancies = response.getOrNull()?.vacancies?.subList(0, 2) ?: emptyList()
        val offers = response.getOrNull()?.offers?.toList()?.map {
            Offer(
                Offer.OfferType.parse(it.id),
                it.title,
                it.button,
                it.link,
            )
        } ?: emptyList()
        val vacanciesQuantity = response.getOrNull()?.vacancies?.size ?: 0
        return Triple(vacancies, offers, vacanciesQuantity)
    }
}