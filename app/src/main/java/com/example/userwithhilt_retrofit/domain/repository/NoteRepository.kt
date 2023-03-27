package com.example.userwithhilt_retrofit.domain.repository

import com.example.userwithhilt_retrofit.domain.model.Note
import com.example.userwithhilt_retrofit.domain.util.DataState
import com.example.userwithhilt_retrofit.ui.notes.NotesViewState
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNotes(
        token: String,
        page: Int,
        query: String,
    ): Flow<DataState<NotesViewState>>

    fun getNoteDetails(
        token: String,
        noteId: Int
    ): Flow<DataState<NotesViewState>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}