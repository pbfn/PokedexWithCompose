package com.pedro_bruno.pokedexwithcompose.screens.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pedro_bruno.pokedexwithcompose.domain.model.PokemonDetails
import com.pedro_bruno.pokedexwithcompose.domain.usecase.GetAllPokemonsUseCase
import com.pedro_bruno.pokedexwithcompose.utils.Resource
import kotlinx.coroutines.*


class HomeViewModel(
    private val getAllPokemonsUseCase: GetAllPokemonsUseCase,
) : ViewModel() {

    var listPokemon: Resource<List<PokemonDetails>> by mutableStateOf(Resource.Loading())

    private var limit = 20
    private val offset = 0

    init {
        getAllPokemons()
    }

    fun getAllPokemons() {
        getAllPokemonsUseCase(
            onSuccess = { response ->
                if (response.isNotEmpty()) {
                    listPokemon = Resource.Success(response)
                }
                Log.d("HomeViewModel", "getAllPokemons: ${response.size}")
            },
            onError = {
                Log.d("HomeViewModel", "getAllPokemons: ${it.message.toString()}")
                listPokemon = Resource.Error(it.message)
            },
            params = GetAllPokemonsUseCase.Params(
                limit = limit,
                offset = offset
            )
        )

    }
}