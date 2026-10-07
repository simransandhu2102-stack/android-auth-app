package com.practice.createandlogin.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

    @Composable
    fun AppNavigation() {
        val navController = rememberNavController()

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
        }
    }
}