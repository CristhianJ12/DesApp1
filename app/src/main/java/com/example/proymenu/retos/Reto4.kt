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

        btnCalcularPromedio.setOnClickListener {
            val calif1 = calificacion1.text.toString()
            val calif2 = calificacion2.text.toString()
            val calif3 = calificacion3.text.toString()
            val calif4 = calificacion4.text.toString()

            if (calif1.isEmpty() || calif2.isEmpty() || calif3.isEmpty() || calif4.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa todas las calificaciones.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                val nota1 = calif1.toInt()
                val nota2 = calif2.toInt()
                val nota3 = calif3.toInt()
                val nota4 = calif4.toInt()

                if (nota1 !in 1..20 || nota2 !in 1..20 || nota3 !in 1..20 || nota4 !in 1..20) {
                    Toast.makeText(this, "Las calificaciones deben estar entre 1 y 20.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val promedio = (nota1 + nota2 + nota3 + nota4) / 4.0

                val resultado = if (promedio >= 11.5) {
                    "Usted está aprobado."
                } else {
                    "Usted se encuentra desaprobado."
                }

                resultadoText.text = "El resultado final es: $promedio\n$resultado"
                resultadoText.visibility = TextView.VISIBLE

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingresa números válidos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}