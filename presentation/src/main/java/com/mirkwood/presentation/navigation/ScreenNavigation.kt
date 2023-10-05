package com.mirkwood.presentation.navigation

sealed class ScreenNavigation(val route: String){
    object Home: ScreenNavigation("home")
    object Category: ScreenNavigation("category")
    object Detail: ScreenNavigation("detail")
}
