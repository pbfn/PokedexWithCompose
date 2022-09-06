package com.pedro_bruno.pokedexwithcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pedro_bruno.pokedexwithcompose.screens.home.HomeScreen
import com.pedro_bruno.pokedexwithcompose.screens.home.HomeViewModel
import com.pedro_bruno.pokedexwithcompose.screens.stats.StatsScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun PokedexNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = PokedexScreens.HomeScreen.name) {

        composable(PokedexScreens.HomeScreen.name) {
            val viewModel = getViewModel<HomeViewModel>()
            HomeScreen(navController = navController, viewModel = viewModel)
        }

        composable(PokedexScreens.StatsScreen.name) {
            StatsScreen(navController = navController)
        }
    }
}