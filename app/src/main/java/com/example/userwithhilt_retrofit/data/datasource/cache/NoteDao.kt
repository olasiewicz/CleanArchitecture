package com.example.userwithhilt_retrofit.data.datasource.cache

import androidx.room.*
import com.example.userwithhilt_retrofit.data.datasource.cache.model.NoteCacheEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getNotes(): Flow<List<NoteCacheEntity>>

    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteById(id: Int): NoteCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteCacheEntity)

    @Delete
    suspend fun deleteNote(note: NoteCacheEntity)
}