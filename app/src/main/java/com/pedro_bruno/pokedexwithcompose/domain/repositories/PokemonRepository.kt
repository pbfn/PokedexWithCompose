package com.pedro_bruno.pokedexwithcompose.domain.repositories

import com.pedro_bruno.pokedexwithcompose.data_remote.model.PokemonListResponse
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
   suspend fun getAllPokemon(): PokemonListResponse?
}