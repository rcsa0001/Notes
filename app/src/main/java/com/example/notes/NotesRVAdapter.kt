package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.db.Note

class NotesRVAdapter(private val context: Context, private val listener: INotesRVAdapter) : RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

//    getting the data
    val allNotes = ArrayList<Note>()

    inner class NoteViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.text)
        val deleteButton =  itemView.findViewById<ImageView>(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
//       inflate item by layout inflater get context from adapter and
//        view holder is used for click handler
       val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notes,parent,false))
//        deleteButton on click listener
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textView.text = currentNote.text
    }

    override fun getItemCount(): Int {
       return allNotes.size
    }
}

// for click handler create an interface

interface INotesRVAdapter {
    fun onItemClicked(note: Note)
}