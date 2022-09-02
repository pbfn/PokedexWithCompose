package com.pedro_bruno.pokedexwithcompose.data_remote.datasource

import com.pedro_bruno.pokedexwithcompose.data.datasource.remote.PokemonRemoteDataSource
import com.pedro_bruno.pokedexwithcompose.data_remote.model.PokemonListResponse
import com.pedro_bruno.pokedexwithcompose.data_remote.service.PokemonService

class PokemonDataSourceImpl(
    private val pokemonService: PokemonService
) : PokemonRemoteDataSource {

    override suspend fun getAllPokemons(): PokemonListResponse?{
        val response = pokemonService.getAllPokemons()
        return if (response.isSuccessful) {
            response.body()
        }else{
            null
        }
    }
}