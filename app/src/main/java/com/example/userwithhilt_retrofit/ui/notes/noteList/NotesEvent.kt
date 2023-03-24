package com.example.userwithhilt_retrofit.ui.notes.noteList

import com.example.userwithhilt_retrofit.domain.model.Note

sealed class NotesEvent {
   // data class Order(val noteOrder: NoteOrder): NotesEvent()
    object GetNotes: NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}