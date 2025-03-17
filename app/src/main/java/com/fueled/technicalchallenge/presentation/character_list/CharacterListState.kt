package com.fueled.technicalchallenge.presentation.character_list

import com.fueled.technicalchallenge.data.model.CharacterApiModel

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<CharacterApiModel> = emptyList(),
    var error: String = ""
)
