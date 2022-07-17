package com.my.todolist.data

import androidx.lifecycle.LiveData

class NotesRepository(private val NotesDao: NotesDao) {

    val readAllData: LiveData<List<Notes>> = NotesDao.readAllData()

    suspend fun addNotes(notes: Notes){
        NotesDao.addNotes(notes)
    }

    suspend fun updateNotes(notes: Notes){
        NotesDao.updateNotes(notes)
    }

    suspend fun deleteNotes(notes: Notes){
        NotesDao.deleteNotes(notes)
    }

    suspend fun deleteAllNotes(){
        NotesDao.deleteAllNotes()
    }

}