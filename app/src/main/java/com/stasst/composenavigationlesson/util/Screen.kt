package com.stasst.composenavigationlesson.util

sealed class Screen(
    val route: String
) {
    object PushScreen: Screen(route = "Push")
    object ListScreen: Screen(route = "List")
    object SearchScreen: Screen(route = "Search")
    object DetailsScreen: Screen(route = "Details/{name}") {
        fun passName(name: String): String{
            return "Details/$name"
        }
    }
}
