package com.example.userwithhilt_retrofit.domain.repository

import androidx.lifecycle.LiveData
import com.example.userwithhilt_retrofit.domain.model.Note

interface NoteCacheRepository {

    fun getNotes(): LiveData<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}