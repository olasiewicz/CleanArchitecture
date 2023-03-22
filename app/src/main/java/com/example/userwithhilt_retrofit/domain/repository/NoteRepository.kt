package com.example.userwithhilt_retrofit.domain.repository

import com.example.userwithhilt_retrofit.data.datasource.cache.model.NoteCacheEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNotes(): Flow<List<NoteCacheEntity>>

    suspend fun getNoteById(id: Int): NoteCacheEntity?

    suspend fun insertNote(note: NoteCacheEntity)

    suspend fun deleteNote(note: NoteCacheEntity)
}