package com.example.proymenu.retos

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proymenu.R
import com.google.android.material.button.MaterialButton

class Reto4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reto4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val calificacion1 = findViewById<EditText>(R.id.calificacion1)
        val calificacion2 = findViewById<EditText>(R.id.calificacion2)
        val calificacion3 = findViewById<EditText>(R.id.calificacion3)
        val calificacion4 = findViewById<EditText>(R.id.calificacion4)
        val btnCalcularPromedio = findViewById<MaterialButton>(R.id.btn_calcular_promedio)
        val resultadoText = findViewById<TextView>(R.id.resultado_text)

        // Configuración del botón para calcular el promedio
        btnCalcularPromedio.setOnClickListener {
            // Obtener los valores ingresados
            val calif1 = calificacion1.text.toString()
            val calif2 = calificacion2.text.toString()
            val calif3 = calificacion3.text.toString()
            val calif4 = calificacion4.text.toString()

            // Validar que todos los campos tengan valores
            if (calif1.isEmpty() || calif2.isEmpty() || calif3.isEmpty() || calif4.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa todas las calificaciones.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                // Convertir las calificaciones a enteros
                val nota1 = calif1.toInt()
                val nota2 = calif2.toInt()
                val nota3 = calif3.toInt()
                val nota4 = calif4.toInt()

                // Validar que las calificaciones estén en el rango de 1 a 20
                if (nota1 !in 1..20 || nota2 !in 1..20 || nota3 !in 1..20 || nota4 !in 1..20) {
                    Toast.makeText(this, "Las calificaciones deben estar entre 1 y 20.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Calcular el promedio
                val promedio = (nota1 + nota2 + nota3 + nota4) / 4.0

                // Determinar si está aprobado o desaprobado
                val resultado = if (promedio >= 11.5) {
                    "Usted está aprobado."
                } else {
                    "Usted se encuentra desaprobado."
                }

                // Mostrar el resultado final
                resultadoText.text = "El resultado final es: $promedio\n$resultado"
                resultadoText.visibility = TextView.VISIBLE

            } catch (e: NumberFormatException) {
                // Mostrar un mensaje si alguna calificación no es un número válido
                Toast.makeText(this, "Por favor, ingresa números válidos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}