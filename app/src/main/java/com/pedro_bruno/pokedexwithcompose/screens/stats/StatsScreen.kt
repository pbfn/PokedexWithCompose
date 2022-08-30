package com.pedro_bruno.pokedexwithcompose.screens.stats

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.pedro_bruno.pokedexwithcompose.components.PokedexAppBar

@Composable
fun StatsScreen(navController: NavController) {
    Scaffold(topBar = {
        PokedexAppBar(
            popStack = true,
            showTitle = false,
            onBackClicked = { navController.popBackStack() },
            onFavoriteClicked = {}
        )
    }) {

    }
}