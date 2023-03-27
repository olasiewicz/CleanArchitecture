package com.example.userwithhilt_retrofit.domain.use_case

import javax.inject.Inject

data class NoteUseCases
@Inject constructor(
    val getNotesUseCase: GetNotesUseCase,
    val getNoteDetailsUseCase: GetNoteDetailsUseCase
//    val deleteNote: DeleteNote,
//    val addNote: AddNote,
//    val getNote: GetNote
) {
    fun sayHello() {
        println("Hello")
    }
}