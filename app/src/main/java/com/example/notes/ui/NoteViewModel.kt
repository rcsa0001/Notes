package com.example.notes.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.notes.db.Note
import com.example.notes.db.NoteDatabase
import com.example.notes.model.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel (application: Application) : AndroidViewModel(application) {

    //    LIve data (getting data from NoteDao
    val allNotes: LiveData<List<Note>>
    val repository : NoteRepository

    init {
//        getting the database
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
         repository = NoteRepository(dao)
//        Intilaization
        allNotes = repository.allNotes
    }

//    instead of async coroutines is used
//    delete functio call of the Repository using co coroutines
//    this thing will work on the background thread of the coroutines scope
//  Dispatchers specifiy the type of operation
    fun deleteNode(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }
}