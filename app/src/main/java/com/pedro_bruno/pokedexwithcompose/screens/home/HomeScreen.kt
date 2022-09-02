package com.pedro_bruno.pokedexwithcompose.screens.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pedro_bruno.pokedexwithcompose.components.CardPokemon
import com.pedro_bruno.pokedexwithcompose.components.PokedexAppBar
import com.pedro_bruno.pokedexwithcompose.components.SearchInput
import com.pedro_bruno.pokedexwithcompose.utils.Resource
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(navController: NavController) {

    val searchInputState = rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    val viewModel = getViewModel<HomeViewModel>()
    Scaffold(topBar = {
        PokedexAppBar(
            backgroundColor = Color.White,
            icon = Icons.Default.FavoriteBorder,
            onFavoriteClicked = {}
        )
    }) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color(0xFFF6F6F6)
        ) {
            Column {
                Surface(
                    shape = RoundedCornerShape(
                        bottomStartPercent = 20,
                        bottomEndPercent = 20,
                    ),
                    color = Color.White
                ) {
                    SearchInput(
                        valueState = searchInputState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 24.dp),
                        onAction = KeyboardActions {
                            onSearch(searchInputState.value.trim())
                            keyboardController?.hide()
                        }
                    )
                }
                Spacer(modifier = Modifier.padding(20.dp))
                when (viewModel._listPokemon) {
                    is Resource.Loading -> {
                        LinearProgressIndicator()
                        Log.d("TesteResource", "HomeScreen: Loading")
                    }
                    is Resource.Success -> {
                        CardPokemon()
                        Log.d("TesteResource", "HomeScreen: Success")
                    }
                    is Resource.Error -> {
                        Log.d("TesteResource", "HomeScreen: Error")
                    }
                }

            }
        }
    }
}

fun onSearch(query: String) {
    Log.d("onSearch", "onSearch: $query")
}