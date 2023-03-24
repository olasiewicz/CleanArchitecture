package com.example.userwithhilt_retrofit.ui.notes.noteList

import com.example.userwithhilt_retrofit.domain.model.Note

data class NoteListViewState(
    val isLoading: Boolean = false,
    val notesData: List<Note> = emptyList(),
    val message: String = ""
    //val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    //val isOrderSectionVisible: Boolean = false
)