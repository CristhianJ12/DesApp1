package com.example.proymenu

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proymenu.databinding.ActivityActualizarLibroBinding


class ActualizarLibroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActualizarLibroBinding
    private lateinit var db: LibrosDbHelper
    private var libroId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityActualizarLibroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = LibrosDbHelper(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        libroId = intent.getIntExtra("libro_id", -1)
        if(libroId == -1){
            finish()
            return
        }

        val libro = db.getLibroByID(libroId)
        binding.upTitulo.setText(libro.title)
        binding.upAutor .setText(libro.autor)
        binding.upPaginas.setText(libro.pages?.toString() ?: "")

        binding.ivActualizarNota.setOnClickListener{
            val newTitle = binding.upTitulo.text.toString()
            val newAutor = binding.upAutor.text.toString()
            val newPagesText = binding.upPaginas.text.toString()
            val newPages = newPagesText.toIntOrNull()
            val updatelibro = Libros(libroId,newTitle, newAutor, newPages)
            db.updateLibro(updatelibro)
            finish()
            Toast.makeText( this,"Changes saved", Toast.LENGTH_SHORT).show()
        }
    }
}