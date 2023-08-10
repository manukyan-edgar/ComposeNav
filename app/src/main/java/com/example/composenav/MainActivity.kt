package com.example.composenav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.composenav.model.BottomNavItem
import com.example.composenav.ui.navigation.BottomNavigationBar
import com.example.composenav.ui.navigation.Navigation
import com.example.composenav.ui.navigation.Screen
import com.example.composenav.ui.theme.ComposeNavTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            ComposeNavTheme {

                Scaffold(bottomBar = {
                    BottomNavigationBar(
                        items = listOf(
                            BottomNavItem(
                                name = stringResource(id = R.string.home),
                                route = Screen.HomeScreen.route,
                                icon = painterResource(id = R.drawable.ic_home),
                            ),
                            BottomNavItem(
                                name = stringResource(id = R.string.search),
                                route = Screen.SearchScreen.route,
                                icon = painterResource(id = R.drawable.ic_search),
                            ),
                            BottomNavItem(
                                name = stringResource(id = R.string.profile),
                                route = Screen.ProfileScreen.route,
                                icon = painterResource(id = R.drawable.ic_account),
                            ),
                        ),
                        navController = navController,
                        onItemClick = {
                            navController.navigate(it.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }) {
                    Box(modifier = Modifier.padding(it)) {
                        Navigation(navController = navController)
                    }
                }
            }

        }
    }

    fun test (){

    }

    fun hello (){

    }
}
