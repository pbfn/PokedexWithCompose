package com.pedro_bruno.pokedexwithcompose.domain.usecase

import com.pedro_bruno.pokedexwithcompose.data_remote.model.PokemonListResponse
import com.pedro_bruno.pokedexwithcompose.domain.model.PokemonDetails
import com.pedro_bruno.pokedexwithcompose.domain.repositories.PokemonRepository
import com.pedro_bruno.pokedexwithcompose.domain.usecase.util.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetAllPokemonsUseCase(
    private val pokemonRepository: PokemonRepository,
    scope: CoroutineScope
) : UseCase<GetAllPokemonsUseCase.Params, List<PokemonDetails>>(scope = scope) {


    data class Params(
        val limit: Int,
        val offset: Int
    )

    override fun run(params: Params): Flow<List<PokemonDetails>>  {
        return pokemonRepository.getAllPokemon(limit = params.limit, offset = params.offset)
    }

}
