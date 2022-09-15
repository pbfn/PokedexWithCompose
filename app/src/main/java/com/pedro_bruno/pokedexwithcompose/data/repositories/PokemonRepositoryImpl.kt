package com.pedro_bruno.pokedexwithcompose.data.repositories

import com.pedro_bruno.pokedexwithcompose.data.datasource.remote.PokemonRemoteDataSource
import com.pedro_bruno.pokedexwithcompose.domain.model.PokemonDetails
import com.pedro_bruno.pokedexwithcompose.domain.repositories.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonRepositoryImpl(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource
) : PokemonRepository {

    override fun getAllPokemon(limit: Int, offset: Int): Flow<List<PokemonDetails>> = flow {
        pokemonRemoteDataSource.getAllPokemons(limit = limit, offset = offset).collect {
            emit(it)
        }
    }

    override fun getDetailsPokemon(idPokemon: String): Flow<PokemonDetails> = flow {
        pokemonRemoteDataSource.getDetailsPokemon(idPokemon = idPokemon).collect {
            emit(it)
        }
    }
}