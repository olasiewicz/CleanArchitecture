package com.example.userwithhilt_retrofit.data.datasource.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.userwithhilt_retrofit.data.datasource.cache.model.NoteCacheEntity

@Database(
    entities = [NoteCacheEntity::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}