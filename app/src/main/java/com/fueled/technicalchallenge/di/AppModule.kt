package com.fueled.technicalchallenge.di

import com.fueled.technicalchallenge.data.ApiConstants
import com.fueled.technicalchallenge.data.CharactersApi
import com.fueled.technicalchallenge.data.UnWrapperFactory
import com.fueled.technicalchallenge.presentation.character_list.CharacterListViewModel
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object AppModule {
    private val moshi = Moshi.Builder()
        .build()
    private val moshiConverterFactory = MoshiConverterFactory.create(moshi)

    private val charactersApi = Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(UnWrapperFactory)
        .addConverterFactory(moshiConverterFactory)
        .build()
        .create(CharactersApi::class.java)

    val characterListViewModel = CharacterListViewModel(charactersApi)
}
