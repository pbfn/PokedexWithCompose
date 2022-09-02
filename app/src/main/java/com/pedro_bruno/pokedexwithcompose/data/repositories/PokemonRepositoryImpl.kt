package com.pedro_bruno.pokedexwithcompose.data.repositories

import com.pedro_bruno.pokedexwithcompose.data.datasource.remote.PokemonRemoteDataSource
import com.pedro_bruno.pokedexwithcompose.data_remote.model.PokemonListResponse
import com.pedro_bruno.pokedexwithcompose.domain.repositories.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class PokemonRepositoryImpl(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource
) : PokemonRepository {

    override fun getAllPokemon(): Flow<PokemonListResponse> = flow {
        pokemonRemoteDataSource.getAllPokemons().collect {
            emit(it)
        }
    }
}