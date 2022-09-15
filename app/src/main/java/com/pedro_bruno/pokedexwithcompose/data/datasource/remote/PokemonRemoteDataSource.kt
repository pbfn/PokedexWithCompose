package com.pedro_bruno.pokedexwithcompose.data.datasource.remote

import com.pedro_bruno.pokedexwithcompose.domain.model.PokemonDetails
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteDataSource {
    suspend fun getAllPokemons(limit: Int, offset: Int): Flow<List<PokemonDetails>>
    suspend fun getDetailsPokemon(idPokemon: String): Flow<PokemonDetails>
}