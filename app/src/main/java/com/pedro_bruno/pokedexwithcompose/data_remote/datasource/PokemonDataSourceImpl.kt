package com.pedro_bruno.pokedexwithcompose.data_remote.datasource

import com.pedro_bruno.pokedexwithcompose.data.datasource.remote.PokemonRemoteDataSource
import com.pedro_bruno.pokedexwithcompose.data_remote.model.PokemonListResponse
import com.pedro_bruno.pokedexwithcompose.data_remote.service.PokemonService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonDataSourceImpl(
    private val pokemonService: PokemonService
) : PokemonRemoteDataSource {

    override fun getAllPokemons(): Flow<PokemonListResponse> = flow {
        val response = pokemonService.getAllPokemons()
        if (response.isSuccessful) {
            response.body()?.let {
                emit(it)
            }
        }
    }
}