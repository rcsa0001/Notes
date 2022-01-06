package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notes.db.Note
import com.example.notes.ui.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), INotesRVAdapter {
    lateinit var viewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //        getting recyclerView and adapter call
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NotesRVAdapter (this,this )
        recyclerView.adapter = adapter


//        ViewModelProvider
        viewModel = ViewModelProvider( this,
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNotes.observe( this, Observer{ list ->
//            to eliminate nullable / check nullable
            list?.let{
                adapter.updateList(it)
            }

        })


    }


    override fun onItemClicked(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this,"${note.text} DELETED", Toast.LENGTH_LONG).show()
    }

//    on submit
    fun submitData(view: android.view.View) {
        val noteText = input.text.toString()
        if (noteText.isNotEmpty()){
            viewModel.insertNode(Note(noteText))
            Toast.makeText(this,"$noteText DELETED", Toast.LENGTH_LONG).show()

        }
    }
}

