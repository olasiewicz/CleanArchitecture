package com.example.userwithhilt_retrofit.di

import android.app.Application
import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.userwithhilt_retrofit.R
import com.example.userwithhilt_retrofit.data.datasource.cache.NoteDao
import com.example.userwithhilt_retrofit.data.datasource.cache.mapers.CacheMapper
import com.example.userwithhilt_retrofit.data.datasource.network.UserApiService
import com.example.userwithhilt_retrofit.data.datasource.network.mappers.NetworkMapper
import com.example.userwithhilt_retrofit.data.repository.NoteRepositoryImpl
import com.example.userwithhilt_retrofit.domain.repository.NoteRepository
import com.example.userwithhilt_retrofit.ui.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }

    @Singleton
    @Provides
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions
            .placeholderOf(R.drawable.default_image)
            .error(R.drawable.default_image)
    }

    @Singleton
    @Provides
    fun provideGlideInstance(application: Application, requestOptions: RequestOptions): RequestManager {
        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }

    @Provides
    @Singleton
    fun provideNoteNetworkRepository(service: UserApiService, dao: NoteDao, networkMapper: NetworkMapper, cacheMapper: CacheMapper): NoteRepository {
        return NoteRepositoryImpl(service, dao, networkMapper, cacheMapper)
    }

}