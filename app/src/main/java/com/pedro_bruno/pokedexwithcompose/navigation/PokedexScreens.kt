package com.pedro_bruno.pokedexwithcompose.navigation

enum class PokedexScreens {
    HomeScreen,
    StatsScreen;

    companion object {
        fun fromRoute(route: String): PokedexScreens = when (route.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            StatsScreen.name -> StatsScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}