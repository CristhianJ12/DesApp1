package com.example.proymenu

import android.os.Bundle
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proymenu.databinding.ActivityLibreriaBinding


class LibreriaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLibreriaBinding
    private lateinit var db: LibrosDbHelper
    private lateinit var librosAdapter: LibrosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLibreriaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = LibrosDbHelper(this)
        librosAdapter = LibrosAdapter(db.getAllLibros(),this)

        binding.librosRv.layoutManager = LinearLayoutManager(this)
        binding.librosRv.adapter = librosAdapter

        binding.FABAgregarNota.setOnClickListener{
            val intent = Intent(this, AgregarLibroActivity::class.java)
            startActivity(intent)
        }

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
        librosAdapter.refreshData(db.getAllLibros())
    }
}