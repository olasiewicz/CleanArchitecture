package com.example.userwithhilt_retrofit.ui.noteList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.userwithhilt_retrofit.domain.model.Note
import com.example.userwithhilt_retrofit.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesListViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    private var getNotesJob: Job? = null

    val state: MutableLiveData<NoteListViewState> = MutableLiveData()

    init {
        onEvent(NotesEvent.GetNotes)
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
//            is NotesEvent.Order -> {
//                if (state.value.noteOrder::class == event.noteOrder::class &&
//                    state.value.noteOrder.orderType == event.noteOrder.orderType
//                ) {
//                    return
//                }
//                getNotes(event.noteOrder)
//            }

            is NotesEvent.GetNotes -> {

                viewModelScope.launch {
                    noteUseCases.getNotes
                }

//                viewModelScope.launch {
//                    state.value = state.value?.copy(
//                    notesData = noteUseCases.getNotes.execute()
//                    )
//                }


            }

            is NotesEvent.DeleteNote -> {
//                viewModelScope.launch {
//                    noteUseCases.deleteNote(event.note)
//                    recentlyDeletedNote = event.note
//                }
            }
            is NotesEvent.RestoreNote -> {
//                viewModelScope.launch {
//                    noteUseCases.addNote(recentlyDeletedNote ?: return@launch)
//                    recentlyDeletedNote = null
//                }
            }
            is NotesEvent.ToggleOrderSection -> {
//                _state.value = state.value.copy(
//                    isOrderSectionVisible = !state.value.isOrderSectionVisible
//                )
            }
        }
    }


}