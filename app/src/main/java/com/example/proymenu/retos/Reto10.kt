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

class Reto10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reto10)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val numeroInput = findViewById<EditText>(R.id.numero_input)
        val btnEvaluarNumero = findViewById<MaterialButton>(R.id.btn_evaluar_numero)
        val resultadoText = findViewById<TextView>(R.id.resultado_text)

        // Configuración del botón para evaluar el número
        btnEvaluarNumero.setOnClickListener {
            // Obtener el valor ingresado
            val numeroTexto = numeroInput.text.toString()

            // Validar que el campo no esté vacío
            if (numeroTexto.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa un número.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                // Convertir el valor a un número
                val numero = numeroTexto.toInt()

                // Evaluar el número y determinar el mensaje
                val mensaje = when (numero) {
                    in 0..3 -> "Correcto, el número se encuentra entre 0 y 3."
                    in 4..7 -> "Correcto, el número se encuentra entre 4 y 7."
                    in 8..10 -> "Correcto, el número se encuentra entre 8 y 10."
                    else -> "Error, ingreso un valor fuera del rango indicado."
                }

                // Mostrar el resultado
                resultadoText.text = mensaje
                resultadoText.visibility = TextView.VISIBLE

            } catch (e: NumberFormatException) {
                // Mostrar un mensaje si el valor no es un número válido
                Toast.makeText(this, "Por favor, ingresa un número válido.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}