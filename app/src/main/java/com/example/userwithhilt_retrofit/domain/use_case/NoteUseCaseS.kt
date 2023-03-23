package com.example.userwithhilt_retrofit.domain.use_case

import javax.inject.Inject

data class NoteUseCases
@Inject constructor(
    val getNotes: GetNotesUseCase,
//    val deleteNote: DeleteNote,
//    val addNote: AddNote,
//    val getNote: GetNote
)