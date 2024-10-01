package com.example.proymenu

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proymenu.databinding.ActivityAgregarLibroBinding


class AgregarLibroActivity : AppCompatActivity() {

    //REVISAR CON CHATGPT

    private lateinit var binding: ActivityAgregarLibroBinding
    private lateinit var db: LibrosDbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAgregarLibroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = LibrosDbHelper(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.ivGuardarNota.setOnClickListener{
            val title = binding.etTitulo.text.toString()
            val autor = binding.etDescripcion.text.toString()
            val pagesText = binding.etPaginas.text.toString()
            val pages = pagesText.toIntOrNull()
            val libros = Libros(0,title, autor, pages)
            db.insertLibro(libros)
            finish()
            Toast.makeText( this,"Libro saved", Toast.LENGTH_SHORT).show()
        }
    }
}