package com.pedro_bruno.pokedexwithcompose.data_remote.model.detail_pokemon


import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: TypeX
)