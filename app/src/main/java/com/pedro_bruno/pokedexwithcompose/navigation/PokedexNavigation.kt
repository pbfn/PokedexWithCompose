package com.pedro_bruno.pokedexwithcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pedro_bruno.pokedexwithcompose.screens.home.HomeScreen
import com.pedro_bruno.pokedexwithcompose.screens.stats.StatsScreen

@Composable
fun PokedexNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = PokedexScreens.HomeScreen.name) {

        composable(PokedexScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        composable(PokedexScreens.StatsScreen.name) {
            StatsScreen(navController = navController)
        }
    }
}