package com.pedro_bruno.pokedexwithcompose.domain.usecase

import com.pedro_bruno.pokedexwithcompose.domain.model.PokemonDetails
import com.pedro_bruno.pokedexwithcompose.domain.repositories.PokemonRepository
import com.pedro_bruno.pokedexwithcompose.domain.usecase.util.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetDetailPokemonUseCase(
    private val pokemonRepository: PokemonRepository,
    scope: CoroutineScope
) : UseCase<GetDetailPokemonUseCase.Params, PokemonDetails>(scope = scope) {

    data class Params(
        val idPokemon: String
    )

    override fun run(params: Params): Flow<PokemonDetails> {
        return pokemonRepository.getDetailsPokemon(idPokemon = params.idPokemon)
    }
}