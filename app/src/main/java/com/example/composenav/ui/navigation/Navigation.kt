package com.example.composenav.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composenav.ui.home.HomeScreen
import com.example.composenav.ui.profile.ProfileMainScreen
import com.example.composenav.ui.search.SearchScreen

sealed class Screen(val route: String) {
    object HomeScreen : Screen("homeScreen")
    object SearchScreen : Screen("searchScreen")
    object ProfileScreen : Screen("profileScreen")
}

@Composable
fun Navigation(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
    ) {
        composable(Screen.HomeScreen.route) {
            HomeScreen()
        }
        composable(Screen.SearchScreen.route) {
            SearchScreen()
        }
        composable(Screen.ProfileScreen.route) {
            ProfileMainScreen(navController)
        }
    }
}