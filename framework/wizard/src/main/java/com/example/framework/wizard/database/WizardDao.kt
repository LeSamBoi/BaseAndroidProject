package com.example.framework.wizard.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// TODO: change queries
@Dao
interface WizardDao {
    @Query("SELECT * FROM wizards WHERE house = :house")
    fun getWizardsByHouse(house: String): Flow<List<WizardEntity>>

    @Query("SELECT * FROM wizards WHERE id = :id")
    fun findWizardById(id: String): Flow<WizardEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWizards(wizards: List<WizardEntity>)
}