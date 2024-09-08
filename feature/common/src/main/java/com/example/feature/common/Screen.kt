package com.example.feature.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.feature.common.theme.BaseAndroidProjectTheme


@Composable
fun Screen(content: @Composable () -> Unit) {
    // TODO: Change theme name
    BaseAndroidProjectTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
            content = content
        )
    }
}