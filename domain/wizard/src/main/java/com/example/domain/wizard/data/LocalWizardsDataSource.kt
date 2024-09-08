package com.example.domain.wizard.data

import com.example.domain.wizard.entities.WizardModel
import kotlinx.coroutines.flow.Flow

// TODO: change interface name and functions
interface LocalWizardsDataSource {
    fun fetchWizardsByHouse(house: String): Flow<List<WizardModel>>
    fun findWizardById(id: String): Flow<WizardModel?>
    suspend fun saveWizards(wizards: List<WizardModel>)
}