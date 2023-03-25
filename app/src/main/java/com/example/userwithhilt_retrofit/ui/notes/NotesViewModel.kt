package com.example.userwithhilt_retrofit.ui.notes.noteList

import android.util.Log
import androidx.lifecycle.*
import com.example.userwithhilt_retrofit.domain.model.Note
import com.example.userwithhilt_retrofit.domain.use_case.NoteUseCases
import com.example.userwithhilt_retrofit.domain.util.AbsentLiveData
import com.example.userwithhilt_retrofit.domain.util.DataState
import com.example.userwithhilt_retrofit.ui.notes.NotesStateEvent
import com.example.userwithhilt_retrofit.ui.notes.NotesViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NotesListViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    private val _stateEvent: MutableLiveData<NotesStateEvent> = MutableLiveData()
    private val _viewState: MutableLiveData<NotesViewState> = MutableLiveData()

    val viewState: LiveData<NotesViewState>
        get() = _viewState

    init {
       // handleStateEvent(NotesStateEvent.GetNotesEvent)
    }


//    val dataState: LiveData<DataState<NotesViewState>> = Transformations
//        .switchMap(_stateEvent){stateEvent ->
//            stateEvent?.let {
//                handleStateEvent(stateEvent)
//            }
//        }

    fun handleStateEvent(stateEvent: NotesStateEvent): LiveData<DataState<List<Note>>>? {
        println("DEBUG: New StateEvent detected: $stateEvent")
        when (stateEvent) {

            is NotesStateEvent.GetNotesEvent -> {
                return _viewState.value.let { state ->
                    noteUseCases.getNotesUseCase.getNotes(
                        "Token 9c8b06d329136da358c2d00e76946b0111ce2c48",
                        1,
                        "chicken"
                    ).onEach { dataState ->

                        dataState.data?.let { list ->
                            _viewState.value = NotesViewState(listOfNotes = list)
                        }
                    }.asLiveData()

                }

            }

            is NotesStateEvent.GetDetailsEvent -> {
                return AbsentLiveData.create()
            }

            is NotesStateEvent.None -> {
                return AbsentLiveData.create()
            }
        }
    }
}


//
//            onEach { dataState ->
//                loading.value = dataState.loading
//
//                dataState.data?.let { list ->
//                    recipes.value = list
//                }
//
//                dataState.error?.let { error ->
//                    Log.e(TAG, "newSearch: ${error}")
//                    dialogQueue.appendErrorMessage("An Error Occurred", error)
//                }
//            }.launchIn(viewModelScope)
//
//
//
//
//
//
//            state.value?.let { state ->
//                searchBlogs.execute(
//                    authToken = sessionManager.state.value?.authToken,
//                    query = state.query,
//                    page = state.page,
//                    filter = state.filter,
//                    order = state.order
//                ).onEach { dataState ->
//                    this.state.value = state.copy(isLoading = dataState.isLoading)
//
//                    dataState.data?.let { list ->
//                        this.state.value = state.copy(blogList = list)
//                    }
//
//                    dataState.stateMessage?.let { stateMessage ->
//                        if(stateMessage.response.message?.contains(ErrorHandling.INVALID_PAGE) == true){
//                            onUpdateQueryExhausted(true)
//                        }else{
//                            appendToMessageQueue(stateMessage)
//                        }
//                    }
//
//                }.launchIn(viewModelScope)
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//            is NotesStateEvent.GetDetailsEvent -> {
//                return AbsentLiveData.create()
//            }
//
//            is NotesStateEvent.None ->{
//                return AbsentLiveData.create()
//            }
//        }
//    }
//
//    fun setNoteListData(notes: List<Note>){
//        val update = getCurrentViewStateOrNew()
//        update.listOfNotes = notes
//        _viewState.value = update
//    }
//
//    fun setNote(note: Note){
//        val update = getCurrentViewStateOrNew()
//        update.note = note
//        _viewState.value = update
//    }
//
//    fun getCurrentViewStateOrNew(): NotesViewState {
//        val value = viewState.value?.let{
//            it
//        }?: NotesViewState()
//        return value
//    }
//
//    fun setStateEvent(event: NotesStateEvent){
//        _stateEvent.value = event
//    }

//}