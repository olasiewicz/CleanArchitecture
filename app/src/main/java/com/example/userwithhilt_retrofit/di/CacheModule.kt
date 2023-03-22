package com.example.userwithhilt_retrofit.di

import android.app.Application
import androidx.room.Room
import com.example.userwithhilt_retrofit.data.datasource.cache.NoteDatabase
import com.example.userwithhilt_retrofit.data.repository.NoteCacheRepositoryImpl
import com.example.userwithhilt_retrofit.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteCacheRepositoryImpl(db.noteDao)
    }

//    @Provides
//    @Singleton
//    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
//        return NoteUseCases(
//            getNotes = GetNotes(repository),
//            deleteNote = DeleteNote(repository),
//            addNote = AddNote(repository),
//            getNote = GetNote(repository)
//        )
//    }
}