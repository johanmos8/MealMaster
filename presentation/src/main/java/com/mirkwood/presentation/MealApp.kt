package com.mirkwood.presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mirkwood.presentation.navigation.ScreenNavigation
import com.mirkwood.presentation.screens.home.HomeScreen
import com.mirkwood.presentation.screens.home.HomeViewModel

@Composable
fun MealApp(
    homeViewModel: HomeViewModel
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenNavigation.Home.route) {
        composable(route = ScreenNavigation.Home.route) {
            HomeScreen(homeViewModel)
        }


    }
}
