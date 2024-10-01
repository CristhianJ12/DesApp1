package com.example.proymenu

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class LibrosAdapter(private var libros: List<Libros>, context: Context): RecyclerView.Adapter<LibrosAdapter.LibroViewHolder>(){

    private val db: LibrosDbHelper = LibrosDbHelper(context)

        class LibroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val titleTextView: TextView = itemView.findViewById(R.id.item_titulo)
            val autorTextView: TextView = itemView.findViewById(R.id.item_autor)
            val pagesTextView: TextView = itemView.findViewById(R.id.item_pages)
            val updateButton: ImageView = itemView.findViewById(R.id.ivActualizar)
            val deleteButton: ImageView = itemView.findViewById(R.id.ivEliminar)
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

        holder.updateButton.setOnClickListener{
            val intent = Intent(holder.itemView.context,ActualizarLibroActivity::class.java).apply{
                putExtra("libro_id",libro.id)
            }
            holder.itemView.context.startActivity(intent)
        }

        holder.deleteButton.setOnClickListener{
            db.deleteLibro(libro.id)
            refreshData(db.getAllLibros())
            Toast.makeText(holder.itemView.context, "Libro eliminado", Toast.LENGTH_SHORT).show()
        }
    }

    fun refreshData(newLibros: List<Libros>){
        libros = newLibros
        notifyDataSetChanged()
    }
}