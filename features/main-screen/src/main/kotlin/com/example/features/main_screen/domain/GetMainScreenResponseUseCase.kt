package com.example.features.main_screen.domain

import com.example.core.network.data.rasponse.ResponseRepository
import com.example.core.network.data.VacancyResponse


class GetMainScreenResponseUseCase(private val responseRepository: ResponseRepository) {
    suspend operator fun invoke(): Pair<List<VacancyResponse>, List<Offer>> {
        val response = responseRepository.getVacancies()
        val vacancies = response.getOrNull()?.vacancies ?: emptyList()
        val offers = response.getOrNull()?.offers?.toList()?.map {
            Offer(
                Offer.OfferType.parse(it.id),
                it.title,
                it.button,
                it.link,
            )
        } ?: emptyList()

        return Pair(vacancies, offers)
    }
}