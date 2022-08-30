package com.pedro_bruno.pokedexwithcompose.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pedro_bruno.pokedexwithcompose.components.PokedexAppBar
import com.pedro_bruno.pokedexwithcompose.navigation.PokedexScreens

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        PokedexAppBar(
            backgroundColor = Color.White,
            icon = Icons.Default.FavoriteBorder,
            onFavoriteClicked = {}
        )
    }) {
        Surface(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { navController.navigate(PokedexScreens.StatsScreen.name) }) {

                }
            }

        }

    }
}