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

class Reto9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reto9)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val numeroInput = findViewById<EditText>(R.id.numero_input)
        val btnEvaluarDia = findViewById<MaterialButton>(R.id.btn_evaluar_dia)
        val resultadoText = findViewById<TextView>(R.id.resultado_text)

        btnEvaluarDia.setOnClickListener {
            val numeroTexto = numeroInput.text.toString()

            if (numeroTexto.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa un número.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val numero = numeroTexto.toInt()

                val dia = when (numero) {
                    1 -> "Lunes"
                    2 -> "Martes"
                    3 -> "Miércoles"
                    4 -> "Jueves"
                    5 -> "Viernes"
                    6 -> "Sábado"
                    7 -> "Domingo"
                    else -> "Número inválido. Debe estar entre 1 y 7."
                }

                resultadoText.text = dia
                resultadoText.visibility = TextView.VISIBLE

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingresa un número válido.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}