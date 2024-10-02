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

class Reto6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reto6)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val numeroInput = findViewById<EditText>(R.id.numero_input)
        val btnEvaluar = findViewById<MaterialButton>(R.id.btn_evaluar)
        val resultadoText = findViewById<TextView>(R.id.resultado_text)

        // Configuración del botón para evaluar el número
        btnEvaluar.setOnClickListener {
            // Obtener el valor ingresado
            val numeroTexto = numeroInput.text.toString()

            // Validar que el campo no esté vacío
            if (numeroTexto.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa un número.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                // Convertir el valor a un número
                val numero = numeroTexto.toDouble()

                // Evaluar el número
                val resultado = when {
                    numero == 0.0 -> "El número es cero."
                    numero > 0 -> "El número es positivo."
                    else -> "El número es negativo."
                }

                // Mostrar el resultado
                resultadoText.text = resultado
                resultadoText.visibility = TextView.VISIBLE

            } catch (e: NumberFormatException) {
                // Mostrar un mensaje si el valor no es un número válido
                Toast.makeText(this, "Por favor, ingresa un número válido.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}