package com.example.testtaskeffective_29_08_24.domain.vacancies

import com.example.testtaskeffective_29_08_24.OfferResponse
import com.example.testtaskeffective_29_08_24.VacancyResponse
import com.example.testtaskeffective_29_08_24.data.vacancy.VacancyRepository

class GetMainScreenVacanciesUseCase(private val vacancyRepository: VacancyRepository) {
    suspend operator fun invoke(): Pair<List<VacancyResponse>, List<Offer>> {
        val response = vacancyRepository.getVacancies()
        val vacancies = response.getOrNull()?.vacancies?.subList(0, 2) ?: emptyList()
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