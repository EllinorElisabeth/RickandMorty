package com.example.myapplication.data

import retrofit2.http.GET
import retrofit2.Response


interface RMCharacterService {

    @GET ("character")
    suspend fun getAllCharacters(): Response<RMCharacterList>

}