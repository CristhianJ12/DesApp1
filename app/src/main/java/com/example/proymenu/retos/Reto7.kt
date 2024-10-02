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

class Reto7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reto7)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val consumoInput = findViewById<EditText>(R.id.consumo_input)
        val btnCalcularImporte = findViewById<MaterialButton>(R.id.btn_calcular_importe)
        val resultadoText = findViewById<TextView>(R.id.resultado_text)

        // Configuración del botón para calcular el importe
        btnCalcularImporte.setOnClickListener {
            // Obtener el valor ingresado
            val consumoTexto = consumoInput.text.toString()

            // Validar que el campo no esté vacío
            if (consumoTexto.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa el consumo.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                // Convertir el valor a un número
                val consumo = consumoTexto.toDouble()

                // Inicializar la variable importe
                var importe: Double

                // Calcular el importe a pagar usando condicionales anidados
                if (consumo < 100) {
                    importe = consumo // Importe igual al consumo
                } else if (consumo <= 500) {
                    importe = consumo * 1.5 // Importe al 150%
                } else {
                    importe = consumo * 2 // Importe al 200%
                }

                // Mostrar el resultado
                resultadoText.text = "El importe a pagar es: $importe"
                resultadoText.visibility = TextView.VISIBLE

            } catch (e: NumberFormatException) {
                // Mostrar un mensaje si el valor no es un número válido
                Toast.makeText(this, "Por favor, ingresa un número válido.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}