package com.example.userwithhilt_retrofit.di

import com.example.userwithhilt_retrofit.data.datasource.network.UserApiService
import com.example.userwithhilt_retrofit.data.datasource.network.mappers.NetworkMapper
import com.example.userwithhilt_retrofit.data.repository.NoteNetworkRepositoryImpl
import com.example.userwithhilt_retrofit.domain.repository.NoteNetworkRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRecipeService(): UserApiService {
        return Retrofit.Builder()
            .baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(UserApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideAuthToken(): String{
        return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }

    @Singleton
    @Provides
    fun provideNoteNetworkMapper(): NetworkMapper {
        return NetworkMapper()
    }

    @Provides
    @Singleton
    fun provideNoteNetworkRepository(service: UserApiService, token: String, networkMapper: NetworkMapper): NoteNetworkRepository {
        return NoteNetworkRepositoryImpl(service, token, networkMapper)
    }

}