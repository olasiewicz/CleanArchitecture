package com.example.userwithhilt_retrofit.domain.repository

import androidx.lifecycle.LiveData
import com.example.userwithhilt_retrofit.data.datasource.cache.model.NoteCacheEntity
import com.example.userwithhilt_retrofit.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNotes(): LiveData<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}