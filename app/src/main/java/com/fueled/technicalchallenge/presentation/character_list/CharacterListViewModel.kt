package com.fueled.technicalchallenge.presentation.character_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fueled.technicalchallenge.data.ApiUtils
import com.fueled.technicalchallenge.data.CharactersApi
import com.fueled.technicalchallenge.data.model.CharacterApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CharacterListViewModel(private val api: CharactersApi) : ViewModel() {

    private val _state = mutableStateOf(CharacterListState())
    val state: State<CharacterListState> = _state

    init {
        getCharacters()
    }

    private fun getCharacters(query: String? = null) {
        fetchCharacters().onEach { result ->
            _state.value =
                CharacterListState(characters = result)
        }.launchIn(viewModelScope)
    }

    private fun fetchCharacters(nameQuery: String? = null): Flow<List<CharacterApiModel>> = flow {
        emit(
            api.getCharacters(
                ts = ApiUtils.currentTimestamp,
                hash = ApiUtils.hash,
                heroNameQuery = nameQuery
            ).results
        )
    }
}