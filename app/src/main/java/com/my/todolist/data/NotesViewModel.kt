package com.my.todolist.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Notes>>
    private val repository: NotesRepository

    init {
        val userDao = notesDatabase.getDatabase(application).noteDao()
        repository = NotesRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addNotes(notes: Notes){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNotes(notes)
        }
    }
    fun updateNotes(notes: Notes){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNotes(notes)
        }
    }

    fun deleteNotes(notes: Notes){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNotes(notes)
        }
    }

    fun deleteAllNotes(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllNotes()
        }
    }
}