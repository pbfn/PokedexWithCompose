package com.pedro_bruno.pokedexwithcompose.data_remote.service

import com.pedro_bruno.pokedexwithcompose.data_remote.model.PokemonListResponse
import com.pedro_bruno.pokedexwithcompose.data_remote.model.detail_pokemon.PokemonDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    suspend fun getAllPokemons(
        @Query("limit")
        limit: Int = 100000,
        @Query("offset")
        offset: Int = 0
    ): Response<PokemonListResponse>

    @GET("pokemon/{nameOrIdPokemon}")
    suspend fun getDetailsPokemon(
        @Path("nameOrIdPokemon")
        nameOrIdPokemon: String
    ): Response<PokemonDetailsResponse>

}