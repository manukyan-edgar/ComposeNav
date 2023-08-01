package com.example.composenav.ui.profile

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenav.ui.navigation.Screen


sealed class ProfileScreen(val route: String) {
    object ProfileDetails : ProfileScreen("profileDetails")
    object Profile : ProfileScreen("profile")
}

@Composable
fun ProfileMainScreen(navController: NavHostController) {
    val activity = (LocalContext.current as? Activity)

    val nestedNavController = rememberNavController()
    NavHost(
        navController = nestedNavController,
        startDestination = ProfileScreen.Profile.route,
        route = "root"
    ) {
        composable(ProfileScreen.Profile.route) {
            ProfileScreen(nestedNavController,
                onHomeBackClick = {
                    navController.navigate(Screen.HomeScreen.route) {
                        popUpTo("root") {
                            inclusive = true
                        }
                    }
                },
                onLogOutClick = {
                    activity?.finish()
                }
            )

        }
        composable(ProfileScreen.ProfileDetails.route) {
            ProfileDetailsScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileMainScreenPreview() {
    ProfileMainScreen(navController = rememberNavController())
}
