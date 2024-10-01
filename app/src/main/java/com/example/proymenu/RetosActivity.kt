package com.example.proymenu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proymenu.Retos.Reto1
import com.example.proymenu.Retos.Reto2

class RetosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_retos)

        val button1=findViewById<AppCompatButton>(R.id.Reto1_btn)
        val button2=findViewById<AppCompatButton>(R.id.Reto2_btn)
        button1.setOnClickListener {toReto1()}
        button2.setOnClickListener {toReto2()}

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun toReto1() {
        Log.d("MenuActivity", "Botón de Librería presionado")
        val lanzar1 = Intent(this, Reto1::class.java)
        startActivity(lanzar1)
    }

    private fun toReto2() {
        val lanzar2 = Intent(this, Reto2::class.java)
        startActivity(lanzar2)
    }
}