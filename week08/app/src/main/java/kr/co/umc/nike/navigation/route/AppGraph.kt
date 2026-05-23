package kr.co.umc.nike.navigation.route

import kotlinx.serialization.Serializable

sealed interface AppGraph {
    @Serializable
    data object LoginGraph : AppGraph

    @Serializable
    data object MainGraph : AppGraph
}