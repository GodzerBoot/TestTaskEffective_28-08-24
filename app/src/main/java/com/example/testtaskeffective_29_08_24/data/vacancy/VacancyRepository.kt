package com.example.testtaskeffective_29_08_24.data.vacancy

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VacancyRepository(
    private val vacancyApi: VacancyApi
) {
    suspend fun getVacancies(): Result<VacancyResponce> = withContext(Dispatchers.IO) {
        try {
            Result.success(vacancyApi.getVacancies())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}