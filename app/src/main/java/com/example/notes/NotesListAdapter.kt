package com.example.notes

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesListAdapter: RecyclerView.Adapter<NotesListAdapter> {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesListAdapter {

    }

    override fun onBindViewHolder(holder: NotesListAdapter, position: Int) {
    }

    override fun getItemCount(): Int {
        
    }
}
class NotesListAdapter(itemView: View) : RecyclerView.ViewHolder(itemView){
    val titleView: TextView =itemView.findViewById(R.id.title)

}