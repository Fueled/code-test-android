package com.fueled.technicalchallenge.presentation.character_list

import com.fueled.technicalchallenge.data.CharactersApi
import com.fueled.technicalchallenge.data.model.CharacterApiModel
import com.fueled.technicalchallenge.data.model.PageApiModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class CharacterListViewModelTest {
    private val testDispatcher = UnconfinedTestDispatcher()
    private val charactersApi = mockk<CharactersApi>()
    private val viewModel get() = CharacterListViewModel(charactersApi)

    @Before
    fun before() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun after() {
        Dispatchers.resetMain()
    }

    @Test
    fun `characters fetched successfully`() = runTest {
        val character = mockk<CharacterApiModel>()
        val response = mockk<PageApiModel<CharacterApiModel>> {
            every { results } returns listOf(character)
        }
        coEvery { charactersApi.getCharacters(any(), any(), any(), any()) } returns response

        assert(viewModel.state.value.characters.isNotEmpty())
    }
}