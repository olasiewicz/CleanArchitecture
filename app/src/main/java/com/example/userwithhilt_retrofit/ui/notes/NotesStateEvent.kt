package com.example.userwithhilt_retrofit.ui.notes

import com.example.userwithhilt_retrofit.domain.model.Note

sealed class NotesStateEvent {
    object GetNotesEvent : NotesStateEvent()
    data class GetDetailsEvent(val note: Note) : NotesStateEvent()
    object None : NotesStateEvent()
}