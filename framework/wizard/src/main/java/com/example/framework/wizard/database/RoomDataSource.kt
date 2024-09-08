package com.example.framework.wizard.database

import com.example.domain.wizard.data.LocalWizardsDataSource
import com.example.domain.wizard.entities.WandModel
import com.example.domain.wizard.entities.WizardModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

// TODO: change functions name and parameters
class RoomDataSource @Inject constructor(private val dao: WizardDao)
    :LocalWizardsDataSource {
    override fun fetchWizardsByHouse(house: String): Flow<List<WizardModel>> =
        dao.getWizardsByHouse(house).map { wizardEntities ->
            wizardEntities.map { it.toWizardModel() }
        }

    override fun findWizardById(id: String): Flow<WizardModel?> =
        dao
            .findWizardById(id)
            .map { it?.toWizardModel() }

    override suspend fun saveWizards(wizards: List<WizardModel>) {
        val wizardEntities = wizards.map {it.toWizardEntity()}
        dao.insertWizards(wizardEntities)
    }
}

// TODO: change class name and models
private fun WizardEntity.toWizardModel(): WizardModel =
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
        isFavorite = isFavorite
    )

fun WizardModel.toWizardEntity(): WizardEntity =
    WizardEntity(
        id = id,
        actor = actor,
        house = house,
        image = image,
        name = name,
        patronus = patronus,
        wand = WandEntity(
            core = wand.core,
            length = wand.length,
            wood = wand.wood
        ),
        isFavorite = isFavorite
    )