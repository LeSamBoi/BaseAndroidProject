package com.example.domain.wizard.usecases

import com.example.domain.wizard.data.WizardRepository
import javax.inject.Inject

// TODO: Change use case
class FindWizardByIdUseCase @Inject constructor(private val repository: WizardRepository) {
    operator fun invoke(id: String) = repository.findWizardById(id)
}