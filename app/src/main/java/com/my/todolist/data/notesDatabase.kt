package com.my.todolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class notesDatabase : RoomDatabase() {

    abstract fun noteDao(): NotesDao

    companion object {
        @Volatile
        private var INSTANCE: notesDatabase? = null

        fun getDatabase(context: Context): notesDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    notesDatabase::class.java,
                    "database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}