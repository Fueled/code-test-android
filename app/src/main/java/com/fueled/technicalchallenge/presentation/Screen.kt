package com.fueled.technicalchallenge.presentation

sealed class Screen(val route: String) {
    object CharacterListScreen: Screen("character_list_screen")
}
