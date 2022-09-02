package com.pedro_bruno.pokedexwithcompose.di

import com.pedro_bruno.pokedexwithcompose.data.datasource.remote.PokemonRemoteDataSource
import com.pedro_bruno.pokedexwithcompose.data.repositories.PokemonRepositoryImpl
import com.pedro_bruno.pokedexwithcompose.data_remote.datasource.PokemonDataSourceImpl
import com.pedro_bruno.pokedexwithcompose.data_remote.service.PokemonService
import com.pedro_bruno.pokedexwithcompose.data_remote.utils.ApiConstants.BASE_URL
import com.pedro_bruno.pokedexwithcompose.data_remote.utils.WebServiceFactory
import com.pedro_bruno.pokedexwithcompose.domain.repositories.PokemonRepository
import com.pedro_bruno.pokedexwithcompose.domain.usecase.GetAllPokemonsUseCase
import com.pedro_bruno.pokedexwithcompose.screens.home.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<PokemonService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = BASE_URL
        )
    }

    single {
        WebServiceFactory.providerOkHttClient()
    }

    single<PokemonRemoteDataSource> {
        PokemonDataSourceImpl(get())
    }

    single<PokemonRepository> {
        PokemonRepositoryImpl(get())
    }

    viewModel {
        HomeViewModel(get(),get())
    }

    single {
        CoroutineScope(Dispatchers.IO)
    }
    factory { GetAllPokemonsUseCase(get(), get()) }
}