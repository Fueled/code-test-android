package com.fueled.technicalchallenge.presentation.character_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fueled.technicalchallenge.di.AppModule
import com.fueled.technicalchallenge.presentation.character_list.components.CharacterCard

@Composable
internal fun CharacterListScreen(
    viewModel: CharacterListViewModel = AppModule.characterListViewModel
) {
    val state by viewModel.state.collectAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            val charactersPerRow = 2
            state.characters.chunked(charactersPerRow).forEach { rowItems ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    rowItems.forEach { item ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(8.dp)
                        ) {
                            CharacterCard(data = item)
                        }
                    }
                    if (rowItems.size < charactersPerRow) {
                        repeat(charactersPerRow - rowItems.size) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}
