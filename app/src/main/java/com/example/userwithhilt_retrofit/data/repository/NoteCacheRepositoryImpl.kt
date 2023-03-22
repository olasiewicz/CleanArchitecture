package com.example.userwithhilt_retrofit.data.repository

import com.example.userwithhilt_retrofit.data.datasource.cache.NoteDao
import com.example.userwithhilt_retrofit.data.datasource.cache.model.NoteCacheEntity
import com.example.userwithhilt_retrofit.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteCacheRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<NoteCacheEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getNoteById(id: Int): NoteCacheEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun insertNote(note: NoteCacheEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: NoteCacheEntity) {
        TODO("Not yet implemented")
    }
}