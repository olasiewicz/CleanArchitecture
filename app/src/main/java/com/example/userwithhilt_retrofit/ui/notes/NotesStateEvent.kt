package com.example.userwithhilt_retrofit.ui.notes

sealed class NotesStateEvent {
    object GetNotesEvent: NotesStateEvent()
    class GetDetailsEvent(val noteId: String): NotesStateEvent()
    object None: NotesStateEvent()
}