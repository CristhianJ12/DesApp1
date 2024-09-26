package com.example.proymenu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class LibrosAdapter(private var libros: List<Libros>, context: Context): RecyclerView.Adapter<LibrosAdapter.LibroViewHolder>(){

    class LibroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleTextView: TextView = itemView.findViewById(R.id.item_titulo)
        val autorTextView: TextView = itemView.findViewById(R.id.item_autor)
        val pagesTextView: TextView = itemView.findViewById(R.id.item_pages)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlibro,parent,false)
        return LibroViewHolder(view)
    }

    override fun getItemCount(): Int = libros.size

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libro = libros[position]
        holder.titleTextView.text = libro.title
        holder.autorTextView.text = libro.autor
        holder.pagesTextView.text = libro.pages?.toString() ?: "" //!!le dice a kotlin que esa variable no sera null pero como en este caso si lo es lo haremos eso
    }

    fun refreshData(newLibros: List<Libros>){
        libros = newLibros
        notifyDataSetChanged()
    }
}