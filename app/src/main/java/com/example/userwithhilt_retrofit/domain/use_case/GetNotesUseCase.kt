package com.example.userwithhilt_retrofit.domain.use_case

import com.example.userwithhilt_retrofit.domain.model.Note
import com.example.userwithhilt_retrofit.domain.repository.NoteNetworkRepository
import com.example.userwithhilt_retrofit.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesUseCase
@Inject constructor(
    private val repository: NoteNetworkRepository
) {

    fun getNotes(
        token: String,
        page: Int,
        query: String,
        //noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<DataState<List<Note>>> {
        return repository.getNotes(token, page, query)


//            .map { notes ->
//            when(noteOrder.orderType) {
//                is OrderType.Ascending -> {
//                    when(noteOrder) {
//                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
//                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
//                        is NoteOrder.Color -> notes.sortedBy { it.color }
//                    }
//                }
//                is OrderType.Descending -> {
//                    when(noteOrder) {
//                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
//                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
//                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
//                    }
//                }
//            }
//        }
    }
}