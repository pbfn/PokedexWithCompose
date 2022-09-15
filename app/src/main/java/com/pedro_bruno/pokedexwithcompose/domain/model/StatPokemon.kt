package com.pedro_bruno.pokedexwithcompose.domain.model

import androidx.compose.ui.graphics.Color

data class StatPokemon(
    val name: String,
    val base_stat: Int,
    var backgroundColor: Color = when {
        base_stat <= 49 -> {
            Color(0xFFFB6C6C)
        }
        base_stat in 50..79 -> {
            Color(0xFFFBED6C)
        }
        base_stat >= 80 -> {
            Color(0xFF48D0B0)
        }
        else -> {
            Color(0xFFFB6C6C)
        }
    },
) {
}
