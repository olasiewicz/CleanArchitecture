package com.example.userwithhilt_retrofit.data.datasource.network

import com.example.userwithhilt_retrofit.data.datasource.network.model.NotesResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface UserApiService {

    @GET("search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): NotesResponse
//
//    @GET("get")
//    suspend fun get(
//        @Header("Authorization") token: String,
//        @Query("id") id: Int
//    ): RecipeDto
}

//https://food2fork.ca/api/recipe/search/?page=2&query=beef