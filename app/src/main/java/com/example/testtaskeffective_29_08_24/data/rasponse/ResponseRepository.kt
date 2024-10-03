package com.example.testtaskeffective_29_08_24.data.rasponse

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ResponseRepository(
    private val responseApi: ResponseApi
) {
    suspend fun getVacancies(): Result<Response> = withContext(Dispatchers.IO) {
        try {
            Result.success(responseApi.getVacancies())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}