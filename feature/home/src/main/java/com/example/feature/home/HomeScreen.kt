package com.example.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.wizard.entities.WizardModel
import com.example.feature.common.Screen
import com.example.feature.common.interfaces.Result

// TODO: New Home Screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onWizardClicked: (WizardModel) -> Unit
) {
    val state by viewModel.state.collectAsState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Screen {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            contentWindowInsets = WindowInsets.safeDrawing,
        ) { padding ->
            when (val result = state) {
                is Result.Error -> {
                    // TODO -> Handle error when fetching wizards
                }
                is Result.Success -> {
                    WizardList(
                        padding = padding,
                        wizards = result.data.wizards,
                        onWizardClicked = onWizardClicked
                    )
                }
            }
        }
    }
}

@Composable
private fun WizardList(
    padding: PaddingValues,
    wizards: List<WizardModel>,
    onWizardClicked: (WizardModel) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier
            .background(Color.White)
            .padding(8.dp)
            .fillMaxSize(),
        columns = GridCells.Adaptive(120.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = padding,
    ) {
        items(wizards, key = { it.id }){ wizard ->
            WizardItem(
                wizard = wizard,
                onWizardClicked = { onWizardClicked(wizard) }
            )
        }
    }
}

@Composable
private fun WizardItem(
    wizard: WizardModel,
    onWizardClicked: () -> Unit
) {
    Column(
        modifier = Modifier.clickable { onWizardClicked() }
    ) {
        Text(
            text = wizard.name,
            color = Color.Black,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}