package com.pedro_bruno.pokedexwithcompose.screens.stats

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.pedro_bruno.pokedexwithcompose.components.PokedexAppBar
import com.pedro_bruno.pokedexwithcompose.components.RowStats
import com.pedro_bruno.pokedexwithcompose.components.TypePokemon
import com.pedro_bruno.pokedexwithcompose.domain.model.ListPokemon
import com.pedro_bruno.pokedexwithcompose.domain.model.PokemonDetails
import com.pedro_bruno.pokedexwithcompose.screens.home.ListPokemon
import com.pedro_bruno.pokedexwithcompose.utils.Mocks
import com.pedro_bruno.pokedexwithcompose.utils.Resource

@Preview
@Composable
fun StatsScreen(
    navController: NavController = NavController(context = LocalContext.current),
    idPokemon: String = "1",
    viewModel: StatsViewModel = hiltViewModel()
) {
    val backGroundColor = remember {
        mutableStateOf(Color(0xFF48D0B0))
    }
    Scaffold(topBar = {
        PokedexAppBar(
            popStack = true,
            showTitle = false,
            onBackClicked = { navController.popBackStack() },
            onFavoriteClicked = {},
            backgroundColor = backGroundColor.value
        )
    }) {
        viewModel.getDetailsPokemon(idPokemon)

        when (viewModel.pokemon) {
            is Resource.Loading -> {
                LinearProgressIndicator()
                Log.d("StatsScreen", "HomeScreen: Loading")
            }
            is Resource.Success -> {
                Log.d("StatsScreen", "HomeScreen: Success")
                var pokemon = viewModel.pokemon.data!!
                backGroundColor.value = pokemon.primaryColor
                StatsPokemon(pokemon)
            }
            is Resource.Error -> {
                Log.d("StatsScreen", "HomeScreen: Error")
            }
        }

    }
}


@Preview
@Composable
fun StatsPokemon(pokemon: PokemonDetails = Mocks.mockPokemon) {
    Column() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .background(pokemon.primaryColor),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(data = pokemon.urlImage),
                contentDescription = "Image Pokemon",
                modifier = Modifier.size(260.dp)
            )
            Text(text = pokemon.name, fontSize = 36.sp, color = Color.White)
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (type in pokemon.listTypes) {
                    TypePokemon(type = type)
                }
            }
        }

        Surface(
            Modifier
                .background(pokemon.primaryColor)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(
                topStartPercent = 10,
                topEndPercent = 10,
            ),
            color = Color.White
        ) {

            Column(
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, top = 10.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Status", fontSize = 24.sp)
                Spacer(modifier = Modifier.height(10.dp))
                for (stat in pokemon.stats) {
                    Row(modifier = Modifier.padding(bottom = 10.dp)) {
                        RowStats(stat)
                    }

                }
            }

        }
    }


}