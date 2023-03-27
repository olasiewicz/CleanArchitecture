package com.example.userwithhilt_retrofit.data.datasource.cache

import androidx.room.*
import com.example.userwithhilt_retrofit.data.datasource.cache.model.NoteCacheEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    suspend fun getNotes(): List<NoteCacheEntity>

    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteById(id: Int): NoteCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteCacheEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNotes(notes: List<NoteCacheEntity>): LongArray

    @Delete
    suspend fun deleteNote(note: NoteCacheEntity)

    @Query("UPDATE notes SET publisher = :publisher WHERE id = :id")
    suspend fun updateNote(id: Int, publisher: String)
}