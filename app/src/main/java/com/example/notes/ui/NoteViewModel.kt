package com.example.notes.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notes.db.Note
import com.example.notes.db.NoteDatabase
import com.example.notes.model.NoteRepository

class NoteViewModel (application: Application) : AndroidViewModel(application) {

    //    LIve data (getting data from NoteDao
    val allNotes: LiveData<List<Note>>

    init {
//        getting the database
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        val repository = NoteRepository(dao)
//        Intilaization
        allNotes = repository.allNotes
    }
}