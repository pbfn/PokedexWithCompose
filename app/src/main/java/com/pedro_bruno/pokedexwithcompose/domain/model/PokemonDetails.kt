package com.pedro_bruno.pokedexwithcompose.domain.model

data class PokemonDetails(
    var id: Int,
    var name: String,
    var urlImage: String,
    var listTypes: List<String>
)
