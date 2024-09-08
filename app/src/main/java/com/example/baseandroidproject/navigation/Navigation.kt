package com.example.baseandroidproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feature.home.HomeScreen

// TODO: Change destinations names if necessary
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home
    ){
        composable<Home> {
            HomeScreen(
                onWizardClicked = { wizard ->
                    navController.navigate(Detail(wizard.id))
                }
            )
        }

        composable<Detail> {
            // DestinationScreen(it.arguments.arg)
        }
    }
}