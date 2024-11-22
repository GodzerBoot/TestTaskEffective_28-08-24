package com.example.features.local_database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.features.local_database.dao.VacancyDao
import com.example.features.local_database.entities.VacancyEntity

@Database(entities = [VacancyEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vacancyDao(): VacancyDao
}