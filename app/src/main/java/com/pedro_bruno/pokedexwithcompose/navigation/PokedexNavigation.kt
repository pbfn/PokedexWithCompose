package com.pedro_bruno.pokedexwithcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pedro_bruno.pokedexwithcompose.screens.home.HomeScreen
import com.pedro_bruno.pokedexwithcompose.screens.home.HomeViewModel
import com.pedro_bruno.pokedexwithcompose.screens.stats.StatsScreen
import com.pedro_bruno.pokedexwithcompose.screens.stats.StatsViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun PokedexNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = PokedexScreens.HomeScreen.name) {

        composable(PokedexScreens.HomeScreen.name) {
            val viewModel = getViewModel<HomeViewModel>()
            HomeScreen(navController = navController, viewModel = viewModel)
        }

        val statsName = PokedexScreens.StatsScreen.name
        composable("$statsName/{idPokemon}", arguments = listOf(navArgument("idPokemon") {
            type = NavType.StringType
        })) { backStackEntry ->
            backStackEntry.arguments?.getString("idPokemon").let {
                val viewModel = getViewModel<StatsViewModel>()
                StatsScreen(
                    navController = navController,
                    viewModel = viewModel,
                    idPokemon = it.toString()
                )
            }

        }
    }
}