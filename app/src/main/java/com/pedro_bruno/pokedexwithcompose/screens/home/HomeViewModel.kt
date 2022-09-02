package com.pedro_bruno.pokedexwithcompose.screens.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedro_bruno.pokedexwithcompose.data_remote.model.PokemonListResponse
import com.pedro_bruno.pokedexwithcompose.domain.repositories.PokemonRepository
import com.pedro_bruno.pokedexwithcompose.domain.usecase.GetAllPokemonsUseCase
import com.pedro_bruno.pokedexwithcompose.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeViewModel(
    private val getAllPokemonsUseCase: GetAllPokemonsUseCase,
    private val repository: PokemonRepository
) : ViewModel() {

    var _listPokemon: Resource<PokemonListResponse> by mutableStateOf(Resource.Loading())
//    val listPokemon = _listPokemon as LiveData<Resource<PokemonListResponse>>

    init {
        getAllPokemons()
    }

    private fun getAllPokemons() {
        viewModelScope.launch(Dispatchers.Default) {
            _listPokemon = Resource.Loading()
            getAllPokemonsUseCase(
                onSuccess = {
                    if (it != null)
                        _listPokemon =Resource.Success(it)
                },
                onError = {
                    Log.d("getAllPokemons", "getAllPokemons: ${it.message.toString()}")
                },
                params = GetAllPokemonsUseCase.Params()
            )
        }

    }

//    private fun teste(){
//        viewModelScope.launch(Dispatchers.Default) {
//            _listPokemon.postValue(Resource.Loading())
//            try {
//               repository.getAllPokemon().collect {
//                    _listPokemon.postValue(Resource.Success(it))
//                }
//            }catch (err:Exception){
//
//            }
//
//        }
//    }

}