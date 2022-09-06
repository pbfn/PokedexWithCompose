package com.pedro_bruno.pokedexwithcompose.data_remote.datasource

import android.util.Log
import com.pedro_bruno.pokedexwithcompose.data.datasource.remote.PokemonRemoteDataSource
import com.pedro_bruno.pokedexwithcompose.data_remote.mappers.toDomain
import com.pedro_bruno.pokedexwithcompose.data_remote.model.PokemonListResponse
import com.pedro_bruno.pokedexwithcompose.data_remote.service.PokemonService
import com.pedro_bruno.pokedexwithcompose.domain.model.PokemonDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class PokemonDataSourceImpl(
    private val pokemonService: PokemonService
) : PokemonRemoteDataSource {

    override suspend fun getAllPokemons(limit: Int, offset: Int): Flow<List<PokemonDetails>> =
        flow {
            val listPokemonDetails = arrayListOf<PokemonDetails>()
            val listResponse: Response<PokemonListResponse>
            try {
                listResponse = pokemonService.getAllPokemons(limit = limit, offset = offset)
                if (listResponse.isSuccessful) {
                    listResponse.body()?.results?.map { result ->
                        getDetailPokemon(result.name)?.let {
                            listPokemonDetails.add(it)
                        }
                    }
                }
                emit(listPokemonDetails.toList())
            } catch (e: Exception) {
                Log.d("testeReq", "getAllPokemons ${e.message} ")
            }
        }

    private suspend fun getDetailPokemon(name: String): PokemonDetails? {
        val response = pokemonService.getDetailsPokemon(namePokemon = name)
        if (response.isSuccessful) {
            return response.body().let {
                it!!.toDomain()
            }
        }
        return null
    }
}