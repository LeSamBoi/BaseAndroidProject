package com.example.framework.wizard.network

import com.example.domain.wizard.data.RemoteWizardsDataSource
import com.example.domain.wizard.entities.WandModel
import com.example.domain.wizard.entities.WizardModel
import javax.inject.Inject

// TODO: change functions name and parameters
class RetrofitDataSource @Inject constructor(private val service: WizardService)
    :RemoteWizardsDataSource {
    override suspend fun fetchWizardsSortedByHouse(house: String): List<WizardModel> =
        service
            .getWizardsSortedByHouse(house)
            .map { it.toWizardModel() }

    override suspend fun getWizardById(id: String): WizardModel =
        service
            .getWizardById(id)
            .first()
            .toWizardModel()
}

// TODO: change class name and models
private fun WizardResult.toWizardModel(): WizardModel =
    WizardModel(
        id = id,
        actor = actor,
        house = house,
        image = image,
        name = name,
        patronus = patronus,
        wand = WandModel(
            core = wand.core,
            length = wand.length,
            wood = wand.wood
        ),
        isFavorite = false
    )