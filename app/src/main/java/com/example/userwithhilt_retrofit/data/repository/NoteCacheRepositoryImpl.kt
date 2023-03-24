package com.example.userwithhilt_retrofit.data.repository

import androidx.lifecycle.LiveData
import com.example.userwithhilt_retrofit.data.datasource.cache.NoteDao
import com.example.userwithhilt_retrofit.data.datasource.cache.mapers.CacheMapper
import com.example.userwithhilt_retrofit.domain.model.Note
import com.example.userwithhilt_retrofit.domain.repository.NoteCacheRepository

class NoteCacheRepositoryImpl(
    private val dao: NoteDao,
    cacheMapper: CacheMapper
) : NoteCacheRepository {
    override fun getNotes(): LiveData<List<Note>> {
        TODO("Not yet implemented")
    }

    override suspend fun getNoteById(id: Int): Note? {
        TODO("Not yet implemented")
    }

    override suspend fun insertNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: Note) {
        TODO("Not yet implemented")
    }

}