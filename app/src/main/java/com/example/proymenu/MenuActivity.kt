package com.example.proymenu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val button1=findViewById<AppCompatButton>(R.id.retos_btn)
        val button2=findViewById<AppCompatButton>(R.id.applib_btn)
        button1.setOnClickListener {toRetos()}
        button2.setOnClickListener {toAppLib()}

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun toAppLib() {
        Log.d("MenuActivity", "Botón de Librería presionado")
        val lanzar1 = Intent(this, LibreriaActivity::class.java)
        startActivity(lanzar1)
    }

    private fun toRetos() {
        val lanzar2 = Intent(this, RetosActivity::class.java)
        startActivity(lanzar2)
    }
}