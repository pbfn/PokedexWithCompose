package com.pedro_bruno.pokedexwithcompose.screens.stats

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pedro_bruno.pokedexwithcompose.domain.model.PokemonDetails
import com.pedro_bruno.pokedexwithcompose.domain.usecase.GetDetailPokemonUseCase
import com.pedro_bruno.pokedexwithcompose.utils.Resource

class StatsViewModel(private val getDetailPokemonUseCase: GetDetailPokemonUseCase) : ViewModel() {

    var pokemon: Resource<PokemonDetails> by mutableStateOf(Resource.Loading())

    fun getDetailsPokemon(idPokemon: String) {
        getDetailPokemonUseCase(
            onSuccess = { response ->
                pokemon = Resource.Success(response)
            },
            onError = {
                pokemon = Resource.Error(it.message)
            },
            params = GetDetailPokemonUseCase.Params(idPokemon = idPokemon)
        )
    }

}