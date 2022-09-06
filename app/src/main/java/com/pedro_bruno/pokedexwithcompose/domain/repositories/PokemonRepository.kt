package com.pedro_bruno.pokedexwithcompose.domain.repositories

import com.pedro_bruno.pokedexwithcompose.data_remote.model.PokemonListResponse
import com.pedro_bruno.pokedexwithcompose.domain.model.PokemonDetails
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getAllPokemon(limit: Int, offset: Int): Flow<List<PokemonDetails>>
}