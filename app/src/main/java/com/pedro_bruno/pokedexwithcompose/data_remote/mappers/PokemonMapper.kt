package com.pedro_bruno.pokedexwithcompose.data_remote.mappers

import com.pedro_bruno.pokedexwithcompose.data_remote.model.detail_pokemon.PokemonDetailsResponse
import com.pedro_bruno.pokedexwithcompose.domain.model.PokemonDetails
import com.pedro_bruno.pokedexwithcompose.domain.model.StatPokemon

fun PokemonDetailsResponse.toDomain(): PokemonDetails {

    val listTypes = arrayListOf<String>()
    val listStats = arrayListOf<StatPokemon>()
    this.types.map {
        listTypes.add(it.type.name.replaceFirstChar { firstLatter ->
            firstLatter.uppercaseChar()
        })
    }
    this.stats.map {
        val stat = StatPokemon(
            name = it.stat.name.replaceFirstChar { firstLatter ->
                firstLatter.uppercaseChar()
            },
            base_stat = it.baseStat
        )
        listStats.add(stat)
    }
    val pokemonDetails = PokemonDetails(
        id = id,
        name = name.replaceFirstChar {
            it.uppercaseChar()
        },
        urlImage = "https://cdn.traction.one/pokedex/pokemon/${id}.png",
        listTypes = listTypes,
        stats = listStats.toList()
    )
    return pokemonDetails
}