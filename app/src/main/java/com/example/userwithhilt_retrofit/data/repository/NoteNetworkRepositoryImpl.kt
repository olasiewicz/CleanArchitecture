package com.example.userwithhilt_retrofit.data.repository

import androidx.lifecycle.LiveData
import com.example.userwithhilt_retrofit.data.datasource.network.UserApiService
import com.example.userwithhilt_retrofit.data.datasource.network.mappers.NetworkMapper
import com.example.userwithhilt_retrofit.data.datasource.network.model.NoteNetworkEntity
import com.example.userwithhilt_retrofit.domain.model.Note
import com.example.userwithhilt_retrofit.domain.repository.NoteRepository
import com.example.userwithhilt_retrofit.ui.noteList.NoteListViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NoteNetworkRepositoryImpl(
    private val service: UserApiService,
    private val token: String,
    private val networkMapper: NetworkMapper
) : NoteRepository {
    override fun getNotes(): LiveData<List<NoteNetworkEntity>> {
       return service.search(token, 1, "beef")
    }
//    override fun getNotes(): Flow<List<Note>> = flow {
//        emit(networkMapper.entityListToNoteList(service.search(token, 1, "beef")))
//    }

    override suspend fun getNoteById(id: Int): Note? {
        TODO("Not yet implemented")
    }

    override suspend fun insertNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: Note) {
        TODO("Not yet implemented")
    }
}