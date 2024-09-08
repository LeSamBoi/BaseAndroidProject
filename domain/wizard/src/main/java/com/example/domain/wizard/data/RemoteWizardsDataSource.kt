package com.example.domain.wizard.data

import com.example.domain.wizard.entities.WizardModel

// TODO: change interface name and functions
interface RemoteWizardsDataSource {
    suspend fun fetchWizardsSortedByHouse(house: String): List<WizardModel>
    suspend fun getWizardById(id: String): WizardModel
}