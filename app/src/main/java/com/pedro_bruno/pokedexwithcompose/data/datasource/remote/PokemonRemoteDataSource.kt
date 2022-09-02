package com.pedro_bruno.pokedexwithcompose.data.datasource.local

import com.pedro_bruno.pokedexwithcompose.data_remote.model.PokemonListResponse
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteDataSource {
    fun getAllPokemons():Flow<PokemonListResponse>
}