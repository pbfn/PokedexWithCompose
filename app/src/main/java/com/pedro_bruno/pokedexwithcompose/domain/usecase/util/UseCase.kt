package com.pedro_bruno.pokedexwithcompose.domain.usecase.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class UseCase<in Params,out T>(
    private val scope: CoroutineScope
){
    abstract suspend fun run(params:Params?=null): T

    operator fun invoke(
        params: Params,
        onSuccess:(T) -> Unit = {},
        onError: (Throwable) -> Unit = {}
    ){
        scope.launch(Dispatchers.Default) {

            try {
                onSuccess.invoke(run(params = params))

            }catch (err:Exception){
                withContext(Dispatchers.Main){
                    onError.invoke(err)
                }
            }

        }
    }

}