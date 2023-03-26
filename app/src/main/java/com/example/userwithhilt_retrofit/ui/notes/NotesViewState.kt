package com.example.userwithhilt_retrofit.ui.notes

import com.example.userwithhilt_retrofit.domain.model.Note

data class NotesViewState(
    var listOfNotes: List<Note>? = null,
    var note: Note? = null,
    var message: String = ""
)
