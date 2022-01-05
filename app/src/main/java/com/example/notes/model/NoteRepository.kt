package com.example.notes.model

import androidx.lifecycle.LiveData
import com.example.notes.db.Note
import com.example.notes.db.NoteDao

class NoteRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    suspend fun delete(note: Note){
        noteDao.insert(note)
    }
}