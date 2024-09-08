package com.example.domain.wizard.data

import com.example.domain.wizard.entities.WizardModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

// TODO: change class names, parameters names and functions
class WizardRepository @Inject constructor(
    private val localDataSource: LocalWizardsDataSource,
    private val remoteDataSource: RemoteWizardsDataSource
) {
    fun fetchWizardsByHouse(house: String): Flow<List<WizardModel>> =
        localDataSource.fetchWizardsByHouse(house).transform { localWizards ->
            val wizards = localWizards.takeIf { it.isNotEmpty() }
                ?: remoteDataSource.fetchWizardsSortedByHouse(house).also {
                    localDataSource.saveWizards(it)
                }
            emit(wizards)
        }

    fun findWizardById(id: String): Flow<WizardModel?> =
        localDataSource.findWizardById(id).transform { localWizard ->
            val wizard = localWizard ?: remoteDataSource.getWizardById(id).also {
                localDataSource.saveWizards(listOf(it))
            }
            emit(wizard)
        }
}