package com.fueled.technicalchallenge.presentation.character_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fueled.technicalchallenge.data.ApiUtils
import com.fueled.technicalchallenge.data.CharactersApi
import com.fueled.technicalchallenge.data.model.CharacterApiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CharacterListViewModel(private val api: CharactersApi) : ViewModel() {

    val state = MutableStateFlow(CharacterListState())

    init {
        getCharacters()
    }

    private fun getCharacters(query: String? = null) {
        viewModelScope.launch {
            val result = fetchCharacters()
            state.value = CharacterListState(characters = result)
        }
    }

    private suspend fun fetchCharacters(nameQuery: String? = null): List<CharacterApiModel> =
        api.getCharacters(
            ts = ApiUtils.currentTimestamp,
            hash = ApiUtils.hash,
            heroNameQuery = nameQuery
        ).results

}