package com.pedro_bruno.pokedexwithcompose.data_remote.model.detail_pokemon


import com.google.gson.annotations.SerializedName

data class Species(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)