package com.practice.happypets.view

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.practice.happypets.viewmodel.HappyPetsViewModel
import kotlinx.serialization.Serializable

class PawsNavHost {
    @Serializable
    object PawsWelcome

    @Serializable
    object PawsMainScreen

    @Serializable
    object PawsLoginScreen

    @Serializable
    object PawsSignUpScreen

    @Serializable
    object HappyPetsListScreen


    @Composable
    fun AppNavigation() {
        val navController = rememberNavController()
        val viewModel: HappyPetsViewModel = viewModel()
        NavHost(
            navController = navController,
            startDestination = PawsWelcome
        ) {
            composable<PawsWelcome> {
                WelcomeScreen(
                    onNavigateToLogin = { navController.navigate(PawsMainScreen) }
                )
            }

            composable<PawsMainScreen> {
                PawsMainScreen(
                    onNavigateToLoginForm = { navController.navigate(route = PawsLoginScreen) },
                    onNavigateToSignUp = { navController.navigate(route = PawsSignUpScreen) }
                )
            }

            composable<PawsLoginScreen> {
                PawsLoginScreen(
                    viewModel = viewModel,
                    onNavigateToList = { navController.navigate(route = HappyPetsListScreen) }
                )
            }
            composable<HappyPetsListScreen> {
                HappyPetsListScreen()
            }
        }
    }
}