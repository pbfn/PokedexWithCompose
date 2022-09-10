package com.pedro_bruno.pokedexwithcompose.domain.model

import androidx.compose.ui.graphics.Color

data class PokemonDetails(
    var id: Int,
    var name: String,
    var urlImage: String,
    var listTypes: List<String>,
    var primaryColor: Color = Color(0xFF48D0B0)
) {
    fun definesPrimaryColor() {
        this.primaryColor = when (this.listTypes.first()) {
            "Normal" -> {
                Color(0xFF206962)
            }
            "Fighting" -> {
                Color(0xFFFF5500)
            }
            "Flying" -> {
                Color(0xFFFB6C6C)
            }
            "Ground" -> {
                Color(0xFF802B00)
            }
            "Poison" -> {
                Color(0xFFCC00FF)
            }
            "Rock" -> {
                Color(0xFF802B00)
            }
            "Bug" -> {
                Color(0xFFCC9900)
            }
            "Ghost" -> {
                Color(0xFF48D0B0)
            }
            "Steel" -> {
                Color(0xFF48D0B0)
            }
            "Fire" -> {
                Color(0xFFFB6C6C)
            }
            "Water" -> {
                Color(0xFF1AA3FF)
            }
            "Grass" -> {
                Color(0xFF48D0B0)
            }
            "Electric" -> {
                Color(0xFFFFFF66)
            }
            "Psychic" -> {
                Color(0xFF48D0B0)
            }
            "Dragon" -> {
                Color(0xFF48D0B0)
            }
            "Dark" -> {
                Color(0xFF48D0B0)
            }
            "Ice" -> {
                Color(0xFF99CCFF)
            }
            "Fairy" -> {
                Color(0xFF48D0B0)
            }
            "Unknown" -> {
                Color(0xFF48D0B0)
            }
            "Shadow" -> {
                Color(0xFFFB6C6C)
            }
            else -> {
                Color(0xFF48D0B0)
            }
        }
    }

    fun getFormatID(): String {
        return when (id.toString().length) {
            1 -> {
                "#00$id"
            }
            2 -> {
                "#0$id"
            }
            else -> {
                "#$id"
            }
        }
    }
}
