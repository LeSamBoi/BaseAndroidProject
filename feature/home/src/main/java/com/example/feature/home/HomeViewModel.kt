package com.example.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.wizard.entities.WizardModel
import com.example.domain.wizard.usecases.FetchWizardsByHouseUseCase
import com.example.feature.common.capitalize
import com.example.feature.common.interfaces.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

private const val DEFAULT_HOUSE = "gryffindor"
// TODO: New Home ViewModel
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchWizardsByHouseUseCase: FetchWizardsByHouseUseCase
): ViewModel() {
    val state: StateFlow<Result<UiState>> =
        fetchWizardsByHouseUseCase(DEFAULT_HOUSE)
            .map { wizards ->UiState(wizards = wizards, selectedHouse = DEFAULT_HOUSE)
            }
            .map<UiState, Result<UiState>> { Result.Success(it) }
            .catch { e -> emit(Result.Error(e)) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = Result.Success(UiState(selectedHouse = DEFAULT_HOUSE))
            )

    data class UiState(
        val wizards: List<WizardModel> = emptyList(),
        val selectedHouse: String = DEFAULT_HOUSE,
        val error : String = ""
    )
}