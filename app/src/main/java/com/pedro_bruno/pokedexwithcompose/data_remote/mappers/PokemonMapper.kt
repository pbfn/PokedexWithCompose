package com.pedro_bruno.pokedexwithcompose.data_remote.mappers

import com.pedro_bruno.pokedexwithcompose.data_remote.model.detail_pokemon.PokemonDetailsResponse
import com.pedro_bruno.pokedexwithcompose.domain.model.PokemonDetails

fun PokemonDetailsResponse.toDomain(): PokemonDetails {

    val listTypes = arrayListOf<String>()
    this.types.map {
        listTypes.add(it.type.name)
    }
    return PokemonDetails(
        id = 0,
        name = name,
        urlImage = "https://cdn.traction.one/pokedex/pokemon/${id}.png",
        listTypes = listTypes
    )
}