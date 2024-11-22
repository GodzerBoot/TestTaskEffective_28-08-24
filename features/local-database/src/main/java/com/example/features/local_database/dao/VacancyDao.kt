package com.example.features.local_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.features.local_database.entities.VacancyEntity

@Dao
interface VacancyDao {
    @Insert
    fun insertAll(vararg vacancies: VacancyEntity)

    @Query("DELETE FROM vacancy WHERE id=:vacId")
    fun delete(vacId: String)

    @Query("SELECT * FROM vacancy")
    fun getVacancyList(): List<VacancyEntity>
}