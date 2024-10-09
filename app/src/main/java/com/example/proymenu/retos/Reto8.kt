package com.example.proymenu.retos

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proymenu.R

class Reto8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reto8)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val notaInput = findViewById<EditText>(R.id.nota_input)
        val btnEvaluarNota = findViewById<MaterialButton>(R.id.btn_evaluar_nota)
        val resultadoText = findViewById<TextView>(R.id.resultado_text)

        btnEvaluarNota.setOnClickListener {
            val notaTexto = notaInput.text.toString()

            if (notaTexto.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa una nota.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val nota = notaTexto.toDouble()

                if (nota < 1 || nota > 20) {
                    Toast.makeText(this, "La nota debe estar entre 1 y 20.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val calificacion = when {
                    nota <= 5 -> "E"
                    nota <= 10.5 -> "D"
                    nota <= 13 -> "C"
                    nota <= 17 -> "B"
                    else -> "A"
                }

                resultadoText.text = "La nota en letra es: $calificacion"
                resultadoText.visibility = TextView.VISIBLE

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingresa un número válido.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}