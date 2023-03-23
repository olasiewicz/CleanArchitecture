package com.example.userwithhilt_retrofit.data.datasource.network

import androidx.lifecycle.LiveData
import com.example.userwithhilt_retrofit.data.datasource.network.model.NoteNetworkEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface UserApiService {

    @GET("search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): LiveData<List<NoteNetworkEntity>>
//
//    @GET("get")
//    suspend fun get(
//        @Header("Authorization") token: String,
//        @Query("id") id: Int
//    ): RecipeDto
}

//https://food2fork.ca/api/recipe/search/?page=2&query=beef