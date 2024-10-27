package com.example.myapplication.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RMCharacterRepository {
    private val _httpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        ).build()

    private val _retrofit = Retrofit.Builder()
        .client(_httpClient)
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val _characterService = _retrofit.create(RMCharacterService::class.java)

    suspend fun getAllCharacter(): List<RMCharacter> {
        try {
            val response = _characterService.getAllCharacters()

            return if (response.isSuccessful) {
                response.body()?.results ?: emptyList()
            } else {
                return emptyList()
            }
        } catch (e: Exception) {
            return emptyList()
        }
    }

}