package com.example.proymenu.retos

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proymenu.R
import com.google.android.material.button.MaterialButton

class Reto3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto3)

        // Referencias a los elementos de la interfaz
        val edadInput = findViewById<EditText>(R.id.edad_input)
        val btnVerificar = findViewById<MaterialButton>(R.id.btn_verificar)
        val resultadoText = findViewById<TextView>(R.id.resultado_text)

        // Configuración del botón para verificar la edad
        btnVerificar.setOnClickListener {
            val edadTexto = edadInput.text.toString()

            // Validar que el campo no esté vacío
            if (edadTexto.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa una edad.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validar que sea un número entero
            try {
                val edad = edadTexto.toInt()

                // Mostrar el resultado si es mayor o menor de edad
                if (edad >= 18) {
                    resultadoText.text = "Eres mayor de edad."
                } else {
                    resultadoText.text = "Eres menor de edad."
                }

                // Hacer visible el TextView con el resultado
                resultadoText.visibility = TextView.VISIBLE

            } catch (e: NumberFormatException) {
                // Mostrar un mensaje si no es un número válido
                Toast.makeText(this, "Por favor, ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}