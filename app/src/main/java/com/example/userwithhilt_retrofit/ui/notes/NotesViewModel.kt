package com.example.userwithhilt_retrofit.ui.notes

import android.util.Log
import android.view.View
import android.view.View.*
import androidx.lifecycle.*
import com.example.userwithhilt_retrofit.domain.model.Note
import com.example.userwithhilt_retrofit.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesListViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    private val _stateEvent: MutableLiveData<NotesStateEvent> = MutableLiveData()
    private val _viewState: MutableLiveData<NotesViewState> = MutableLiveData()

    val list: MutableLiveData<List<Note>> = MutableLiveData()

    val viewState: LiveData<NotesViewState>
        get() = _viewState

    private val _shouldDisplayProgressBar: MutableLiveData<Boolean> = MutableLiveData()

    val shouldDisplayProgressBar: LiveData<Boolean>
        get() = _shouldDisplayProgressBar

    init {
       // handleStateEvent(NotesStateEvent.GetNotesEvent)
    }


//    val dataState: LiveData<DataState<NotesViewState>> = Transformations
//        .switchMap(_stateEvent){stateEvent ->
//            stateEvent?.let {
//                handleStateEvent(stateEvent)
//            }
//        }

//    fun handleStateEvent(stateEvent: NotesStateEvent): LiveData<DataState<List<Note>>>? {
//        println("DEBUG: New StateEvent detected: $stateEvent")
//        when (stateEvent) {
//
//            is NotesStateEvent.GetNotesEvent -> {
//                return _viewState.value.let { state ->
//                    noteUseCases.getNotesUseCase.getNotes(
//                        "Token 9c8b06d329136da358c2d00e76946b0111ce2c48",
//                        1,
//                        "chicken"
//                    ).onEach { dataState ->
//
//                        dataState.data?.let { list ->
//                            _viewState.value = NotesViewState(listOfNotes = list)
//                        }
//                    }.asLiveData()
//
//                }
//
//            }
//
//            is NotesStateEvent.GetDetailsEvent -> {
//                return AbsentLiveData.create()
//            }
//
//            is NotesStateEvent.None -> {
//                return AbsentLiveData.create()
//            }
//        }
//    }











    fun onTriggerEvent(event: NotesStateEvent){
        viewModelScope.launch {
            try {
                when(event){
                    is NotesStateEvent.GetNotesEvent -> {
                        getNotes()
                    }
                    is NotesStateEvent.GetDetailsEvent -> {
                        //nextPage()
                    }
                    is NotesStateEvent.None -> {
                      //  restoreState()
                    }
                }
            }catch (e: Exception){
                Log.e("wojtas", "launchJob: Exception: ${e}, ${e.cause}")
                e.printStackTrace()
            }
            finally {
                Log.d("wojtas", "launchJob: finally called.")
            }
        }
    }




    private fun getNotes() {
        Log.d("wojtas", "newSearch")
        // New search. Reset the state
        //resetSearchState()

        noteUseCases.getNotesUseCase.getNotes(
            "Token 9c8b06d329136da358c2d00e76946b0111ce2c48",
            1,
            "chicken"
        ).onEach { dataState ->
            _shouldDisplayProgressBar.value = dataState.loading

            dataState.data?.let { viewState ->
                _viewState.postValue(viewState)
            }

            dataState.error?.let { error ->
                Log.e("wojtas", "newSearch: ${error}")
               // dialogQueue.appendErrorMessage("An Error Occurred", error)
            }
        }.launchIn(viewModelScope)
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