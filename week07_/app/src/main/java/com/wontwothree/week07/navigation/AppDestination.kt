package com.wontwothree.week07.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppDestination {

    @Serializable
    data object Home : AppDestination

    @Serializable
    data object Shop : AppDestination

    @Serializable
    data object Wishlist : AppDestination

    @Serializable
    data object Cart : AppDestination

    @Serializable
    data object Profile : AppDestination
}