package com.pedro_bruno.pokedexwithcompose.utils

import androidx.compose.ui.graphics.Color
import com.pedro_bruno.pokedexwithcompose.domain.model.PokemonDetails
import com.pedro_bruno.pokedexwithcompose.domain.model.StatPokemon

object Mocks {
    val mockPokemon = PokemonDetails(
        1,
        "Teste",
        "",
        listOf("Grass", "Poison"),
        primaryColor = Color(0xFF48D0B0),
        stats = listOf<StatPokemon>(
            StatPokemon("HP",45),
            StatPokemon("Attack",80),
            StatPokemon("Defense",15),
            StatPokemon("Special-attack",25),
            StatPokemon("Special-defense",90),
            StatPokemon("Speed",50),
        )
    )
}